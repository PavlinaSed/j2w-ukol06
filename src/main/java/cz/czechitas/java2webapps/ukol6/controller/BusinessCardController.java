package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.BusinessCardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BusinessCardController {
    private final BusinessCardRepository businessCardRepository;

    public BusinessCardController(BusinessCardRepository businessCardRepository) {
        this.businessCardRepository = businessCardRepository;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("seznam", businessCardRepository.findAll());

    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id) {
        Optional<Vizitka> vizitkaOptional = businessCardRepository.findById(id);
        if (vizitkaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ModelAndView("vizitka")
                .addObject("vizitkaOptional", vizitkaOptional.get())
                ;
    }
}
