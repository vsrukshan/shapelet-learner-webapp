package tech.artisanhub.shapeletTrainer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.xml.sax.SAXException;
import tech.artisanhub.controller.Greeting;
import tech.artisanhub.fileHandler.FileOperations;
import weka.core.Instances;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class LearnShapelets {


    public static void learnShapelets(String datasetName,SimpMessagingTemplate template) throws Exception {
        long startTime = System.currentTimeMillis();


        String rootPath = System.getProperty("catalina.home");
        String datasetPath = rootPath + File.separator + "uploads" + File.separator + datasetName;

        Instances data = ShapeletFilter.loadData(datasetPath);

        int size = data.size();
        for (int i = 0; i < size; i++) {
            if (i > 4000) {
                data.remove(0);
            }
        }

        System.out.print(data.size());
        int k = Integer.MAX_VALUE; // number of shapelets
        int minLength = 2;
        int maxLength = data.get(1).numValues() - 1;

        String outPutFile = rootPath + File.separator + "uploads" + File.separator + "generatedShapelets.txt";
        ShapeletFilter sf = new ShapeletFilter(k, minLength, maxLength);
        sf.setLogOutputFile(outPutFile); // log file stores shapelet output
        ArrayList<Shapelet> generatedShapelets = sf.process(data);


        Map<Double, Integer> classDist = ShapeletFilter.getClassDistributions(data);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (double val : classDist.keySet()) {
            arr.add((int) val);
        }

        int shapeletClusterSize = (int) Math.sqrt(generatedShapelets.size()); //this defines the threshold. Put a larger number to detect all the events
        ArrayList<Shapelet> mergedShapelets = new MergeShapelets().mergeShapelets(generatedShapelets, shapeletClusterSize); //meerging shapelets
        ArrayList<Shapelet> finalOutputShapelets = new ImportantShapelets().GetImportantShapelets(mergedShapelets, data, arr); //find important shapelets
        saveShapeleteStats(finalOutputShapelets, data.get(1).numValues() - 1, datasetName,template);


        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nExecution time in milli seconds: " + totalTime);
    }

    private static void saveShapeleteStats(ArrayList<Shapelet> shapelets, int noOfColumns, String datasetname,SimpMessagingTemplate template) throws IOException, ParserConfigurationException, SAXException {
        int size = 0;
        int startPos = 0;
        int shapeletVal = 0;
        int sizeOfTheShapelet = 0;
        int eventCount = 0;
        int contentSize = 0;

        JSONArray currRow;
        JSONObject currRowObj;
        JSONArray allRows;
        JSONObject finalJsonObject = new JSONObject();
        JSONArray jsonArraytMainEvent = new JSONArray();
        JSONObject jsonObjectPerEvent;


        for (Shapelet val : shapelets) {
            jsonObjectPerEvent = new JSONObject();
            allRows = new JSONArray();
            eventCount++;
            if (val != null) {
                sizeOfTheShapelet = val.contentInMergedShapelets.size();
                for (int i = 0; i < sizeOfTheShapelet; i++) {
                    contentSize = val.contentInMergedShapelets.get(i).size();
                    size = val.contentInMergedShapelets.get(i).size() - 4;
                    startPos = val.contentInMergedShapelets.get(i).get(size + 2).intValue();
                    shapeletVal = 0;
                    currRow = new JSONArray();
                    currRowObj = new JSONObject();
                    for (int j = 0; j < noOfColumns; j++) {
                        if (startPos > j) {
                            currRow.add(null);
                            shapeletVal++;
                        } else if (startPos + size < j) {
                            currRow.add(null);
                            shapeletVal++;
                        } else {
                            currRow.add(val.contentInMergedShapelets.get(i).get(j - shapeletVal));
                        }
                    }
                    currRowObj.put("EventType", val.contentInMergedShapelets.get(i).get(contentSize - 1).intValue()); //add the correct val
                    currRowObj.put("Values", currRow);
                    allRows.add(currRowObj);

                }
                jsonObjectPerEvent.put("Data", allRows);
                jsonObjectPerEvent.put("MainEvent", eventCount);
                jsonArraytMainEvent.add(jsonObjectPerEvent);
            }


        }
        finalJsonObject.put("Data", jsonArraytMainEvent);
        finalJsonObject.put("DatasetName", "iris");
        finalJsonObject.put("EventCount", eventCount);
        System.out.println(finalJsonObject);
        datasetname = datasetname.replace(".csv", "");
        datasetname = datasetname.replace(".arff", "");
        FileOperations.saveImportantShapelets(finalJsonObject, datasetname);
        System.out.println("Fire");
        template.convertAndSend("/topic/greetings", new Greeting("Fire"));

    }
}