package be.johannes.whiskey.controllers;

import be.johannes.whiskey.scraper.Webscraper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WhiskyController {

    private Webscraper webscraper = new Webscraper();

    @GetMapping("/whiskydetail/{urlMoreInfo}")
    public String whiskydetail(Model model,
                               @PathVariable(required = false) String urlMoreInfo){
        return "whiskydetail";
    }
}
