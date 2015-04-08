package iva.cruddwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Admin on 01.04.15.
 */
@Controller
public class LinkController {
    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }
}
