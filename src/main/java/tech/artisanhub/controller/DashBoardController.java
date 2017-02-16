package tech.artisanhub.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.artisanhub.fileHandler.FileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;

@Controller
public class DashBoardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String index() {
        return "dashboard";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(@RequestParam("dataset") String datasetname, ModelMap model) {
        model.addAttribute("dataset", datasetname);
        return "redirect:graph_visualizer";
    }

    @RequestMapping(value = "/graph_visualizer", method = RequestMethod.GET)
    public String graph() {
        return "graph_visualizer";
    }

    @RequestMapping(value = "/datasets", method = RequestMethod.GET)
    public
    @ResponseBody
    JSONObject uploadFileHandler() {
        String rootPath = System.getProperty("catalina.home");
        return FileOperations.filesInDir(rootPath + File.separator + "uploads");
    }

    @RequestMapping(value = "/download.do" ,method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        int BUFFER_SIZE = 4096;
        String rootPath = System.getProperty("catalina.home");
        String filePath = rootPath + File.separator + "out.log";


        // get absolute path of the application
        ServletContext context = request.getServletContext();

        File downloadFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }
}