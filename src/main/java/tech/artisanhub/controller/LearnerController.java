package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.artisanhub.shapeletTrainer.LearnShapelets;

@Controller
@RequestMapping("/learner")
public class LearnerController {

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getProcess(@PathVariable String name, ModelMap model) {

		    LearnShapelets.learnShapelets(name);
			model.addAttribute("test", name);
			return "googleChartsVisualizer";


	}
	
}