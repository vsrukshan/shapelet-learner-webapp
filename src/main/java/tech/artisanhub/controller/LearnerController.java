package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.artisanhub.aSyncTaskManager.AppConfig;
import tech.artisanhub.aSyncTaskManager.AsyncTask;
import tech.artisanhub.shapeletTrainer.LearnShapelets;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Controller
@RequestMapping("/learner")
public class LearnerController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getProcess(@PathVariable String name, ModelMap model) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        AsyncTask task = ctx.getBean(AsyncTask.class);
        task.doAsyncTask(name);


        model.addAttribute("test", name);
        return "googleChartsVisualizer";


    }
}