package tech.artisanhub.fileHandler;


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
        JSONObject jsonObject = new JSONObject();
        for(File f: files){
            jsonObject.put(f.getName(),convertTime(f.lastModified()));

        }
        return jsonObject;
    }

    public static String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
