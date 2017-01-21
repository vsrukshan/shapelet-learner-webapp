package tech.artisanhub.fileHandler;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOperations {


    public static JSONObject filesInDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        for (File f : files) {
            jsonObject = new JSONObject();
            jsonObject.put("Last Modified", convertTime(f.lastModified()));
            jsonObject.put("File Name", f.getName());
            jsonArray.add(jsonObject);
        }
        JSONObject mainObj = new JSONObject();
        mainObj.put("Files on Server", jsonArray);
        return mainObj;
    }

    public static String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static boolean saveImportantShapelets(JSONObject finalJsonObject, String datasetName,SimpMessagingTemplate template) throws ParserConfigurationException, SAXException, IOException {
        String rootPath = System.getProperty("catalina.home");
        BufferedWriter output = null;

        File dir = new File(rootPath + File.separator + XMLParser.getShapeletDirName());
        if (!dir.exists())
            dir.mkdirs();

        File file = new File(dir.getAbsolutePath() + File.separator + datasetName + ".json");

        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(finalJsonObject.toJSONString());
            output.close();
            System.out.println(datasetName + ".json successdully saved");
            template.convertAndSend("/topic/greetings", new GenerateRespond(datasetName+".json"));
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static JSONObject getGeneratedResults(String datasetName) throws IOException, ParseException, ParserConfigurationException, SAXException {
        JSONParser parser = new JSONParser();
        String rootPath = System.getProperty("catalina.home");
        FileReader fileReader = new FileReader(rootPath + File.separator + XMLParser.getShapeletDirName() + File.separator + datasetName + ".json");
        return (JSONObject) parser.parse(fileReader);
    }
}
