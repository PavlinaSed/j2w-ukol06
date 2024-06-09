package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.repository.BusinessCardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusinessCardController {
    private final BusinessCardRepository businessCardRepository;

    public BusinessCardController(BusinessCardRepository businessCardRepository) {
        this.businessCardRepository = businessCardRepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", businessCardRepository.findAll());
        return result;
    }
}
