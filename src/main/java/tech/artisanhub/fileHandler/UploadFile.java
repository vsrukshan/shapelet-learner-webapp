package tech.artisanhub.fileHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import tech.artisanhub.controller.FileUploadController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


public class UploadFile {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private static String allowedfileExtentions = ".csv,.arff";

    public static String uploadSingleFile(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                int lastIndex = fileName.lastIndexOf('.');
                String currFileExtension = fileName.substring(lastIndex, fileName.length());
                if (!allowedfileExtentions.contains(currFileExtension)) {
                    return "Uploading failed. Please upload a CSV file or an ARFF file";
                }
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "uploads");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload because the file was empty.";
        }
    }

    public static String uploadMultipleFiles(MultipartFile files[]) {

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = files[i].getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "uploads");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                message = message + "You successfully uploaded file=" + name
                        + " ";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }
}
