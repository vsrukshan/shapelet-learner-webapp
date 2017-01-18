package tech.artisanhub.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tech.artisanhub.fileHandler.FileOperations;
import tech.artisanhub.fileHandler.UploadFile;

import java.io.File;

@Controller
public class DashBoardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String index() {
        return "dashboard";
    }

    @RequestMapping(value = "/graph_visualizer", method = RequestMethod.GET)
    public String redirect() {
        return "graph_visualizer";
    }

    @RequestMapping(value = "/datasets", method = RequestMethod.GET)
    public
    @ResponseBody
    JSONObject uploadFileHandler() {
        String rootPath = System.getProperty("catalina.home");
        return FileOperations.filesInDir(rootPath + File.separator + "uploads");
    }

}