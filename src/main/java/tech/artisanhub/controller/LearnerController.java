package tech.artisanhub.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.artisanhub.aSyncTaskManager.AppConfig;
import tech.artisanhub.aSyncTaskManager.AsyncTask;
import tech.artisanhub.fileHandler.FileOperations;
import tech.artisanhub.shapeletTrainer.LearnShapelets;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@Controller
@RequestMapping("/learner")
public class LearnerController {


    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startProcess(@RequestParam("dataset") String name, ModelMap model) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        AsyncTask task = ctx.getBean(AsyncTask.class);
        try {
            task.doAsyncTask(name);
        } catch (Exception e) {
            System.out.println(name + "Leaning has been interrupted");
            //Send an email
        }

        model.addAttribute("test", name);
        return "googleChartsVisualizer";


    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public
    @ResponseBody
    String getResult(@RequestParam("dataset") String datasetName) {

        try {
            return FileOperations.getGeneratedResults(datasetName).toJSONString();
        } catch (IOException e) {
            return "Error while reading the file";
        } catch (ParseException e) {
            return "Error file parsing the json string";
        }

    }

}