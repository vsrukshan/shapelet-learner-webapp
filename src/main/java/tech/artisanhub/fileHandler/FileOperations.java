package tech.artisanhub.fileHandler;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public static boolean saveImportantShapelets(JSONObject finalJsonObject, String datasetName) {
        String rootPath = System.getProperty("catalina.home");
        BufferedWriter output = null;

        File dir = new File(rootPath + File.separator + "generatedShapelets");
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
}
