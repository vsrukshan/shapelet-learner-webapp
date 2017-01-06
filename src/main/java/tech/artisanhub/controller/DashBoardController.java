package tech.artisanhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}