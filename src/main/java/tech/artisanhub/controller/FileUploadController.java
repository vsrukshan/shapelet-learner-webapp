package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tech.artisanhub.fileHandler.UploadFile;

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
}