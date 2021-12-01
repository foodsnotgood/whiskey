package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WhiskyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    private WebscraperWhiskyShop webscraper = new WebscraperWhiskyShop();
    private Logger logger = LoggerFactory.getLogger(WhiskyController.class);

    @RequestMapping(value = "/whiskydetail", method = RequestMethod.POST)
    public String addWhisky(@ModelAttribute("whisky") Whisky whisky) {
        logger.info(" Ingevoerde whisky : --------------- " + whisky.getName());
        whiskyRepository.save(whisky);
        return "whiskydetail";
    }
}
