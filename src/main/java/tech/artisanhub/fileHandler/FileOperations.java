package tech.artisanhub.fileHandler;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOperations {
    public static JSONObject filesInDir(String path)
    {
        File file = new File(path);
        File[] files = file.listFiles();
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        for(File f: files){
            jsonObject = new JSONObject();
            jsonObject.put("Last_Modified",convertTime(f.lastModified()));
            jsonObject.put("File_Name",f.getName());
            jsonArray.add(jsonObject);
        }
        JSONObject mainObj = new JSONObject();
        mainObj.put("Files",jsonArray);
        return mainObj;
    }

    public static String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
