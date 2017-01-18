package tech.artisanhub.shapeletTrainer;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import org.json.simple.JSONObject;
import tech.artisanhub.visualizer.XYLineChart_AWT;
import weka.core.Instances;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class LearnShapelets {
    public static JSONObject learnShapelets(String datasetName) {
        long startTime = System.currentTimeMillis();
        JSONObject jsonObject = null;
        try {

            String rootPath = System.getProperty("catalina.home");
            String ARFFName = rootPath + File.separator + "uploads" + File.separator + datasetName + ".arff";
            Instances data = ShapeletFilter.loadData(ARFFName);

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
//            displayShapeletStats(finalOutputShapelets,data.get(1).numValues()-1);
            jsonObject = new JSONObject();
            jsonObject.put("name", "mkyong.com");
            jsonObject.put("age", new Integer(100));


        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nExecution time in milli seconds: " + totalTime);
        return jsonObject;
    }

    private static void displayShapeletStats(ArrayList<Shapelet> shapelets, int noOfColumns) throws IOException {
        int size = 0;
        int startPos = 0;
        int shapeletVal = 0;
        int sizeOfTheShapelet = 0;
        int eventCount = 0;
        BufferedWriter output = null;
        String json = null;
        for (Shapelet val : shapelets) {
            eventCount++;
            json = "[";
            if (val != null) {
                sizeOfTheShapelet = val.contentInMergedShapelets.size();

                for (int i = 0; i < sizeOfTheShapelet; i++) {
                    size = val.contentInMergedShapelets.get(i).size() - 4;
                    startPos = val.contentInMergedShapelets.get(i).get(size + 2).intValue();
                    shapeletVal = 0;
                    XYSeries series = new XYSeries(i);
                    json = json + " [";
                    for (int j = 0; j < noOfColumns; j++) {
                        if (startPos > j) {
                            shapeletVal++;
                        } else if (startPos + size < j) {
                            shapeletVal++;
                        } else {
                            series.add(j, val.contentInMergedShapelets.get(i).get(j - shapeletVal));
                            json = json + val.contentInMergedShapelets.get(i).get(j - shapeletVal);
                            if (j < noOfColumns - 2) {
                                json = json + ",";
                            }
                        }
                    }
                    json = json + " ],\n";
                }
                json = json + " ]";
                String rootPath = System.getProperty("catalina.home");
                File file = new File(rootPath + File.separator + "uploads" + File.separator + "importantShapelets" + File.separator + "event" + eventCount + ".json");
                output = new BufferedWriter(new FileWriter(file));
                output.write(json);
                output.close();
            }
        }
    }
}