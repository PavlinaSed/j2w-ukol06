package cz.czechitas.java2webapps.ukol6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusinessCardController {

    @GetMapping("/")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("list");
        return result;
    }
}
