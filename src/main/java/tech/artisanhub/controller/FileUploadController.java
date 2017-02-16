package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tech.artisanhub.fileHandler.UploadFile;
import tech.artisanhub.shapeletTrainer.ShapeletFilter;
import weka.core.Instances;

import java.io.File;
import java.io.IOException;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFileHandler(@RequestParam("file") MultipartFile file) {

        return UploadFile.uploadSingleFile(file);
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {

       return UploadFile.uploadMultipleFiles(files);
    }

    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ResponseBody
    public String redirect(@RequestParam("dataset") String datasetname) {
        String rootPath = System.getProperty("catalina.home");
        String datasetPath = rootPath + File.separator + "uploads" + File.separator + datasetname;
        String out = "";
        try {
            Instances data = ShapeletFilter.loadData(datasetPath);
            out += "Number of instances : " + data.numInstances();
            out += "  Number of attributes : " + data.numAttributes();
        } catch (IOException e) {
            e.printStackTrace();
            out += "Error processing the dataset";
        }
        return out;
    }
}