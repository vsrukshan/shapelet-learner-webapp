package tech.artisanhub.fileHandler;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOperations {
    private static String shapeletsDirName = "generatedShapelets";

    public static JSONObject filesInDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        for (File f : files) {
            jsonObject = new JSONObject();

            jsonObject.put("Last_Modified",convertTime(f.lastModified()));
            jsonObject.put("File_Name",f.getName());
            jsonArray.add(jsonObject);
        }
        JSONObject mainObj = new JSONObject();
        mainObj.put("Files",jsonArray);

        return mainObj;
    }

    public static String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static boolean saveImportantShapelets(JSONObject finalJsonObject, String datasetName) {
        String rootPath = System.getProperty("catalina.home");
        BufferedWriter output = null;

        File dir = new File(rootPath + File.separator + shapeletsDirName);
        if (!dir.exists())
            dir.mkdirs();

        File file = new File(dir.getAbsolutePath() + File.separator + datasetName + ".json");

        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(finalJsonObject.toJSONString());
            output.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static JSONObject getGeneratedResults(String datasetName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        String rootPath = System.getProperty("catalina.home");
        FileReader fileReader = new FileReader(rootPath + File.separator + shapeletsDirName + File.separator + datasetName + ".json");
        return (JSONObject) parser.parse(fileReader);
    }
}
