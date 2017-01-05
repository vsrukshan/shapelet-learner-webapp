package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashBoardController {
    @RequestMapping(value="/{processID}", method = RequestMethod.GET)
    public String getDashboard(@PathVariable String processID, ModelMap model) {

        model.addAttribute("processID", processID);
        return "dashboard";

    }
}
