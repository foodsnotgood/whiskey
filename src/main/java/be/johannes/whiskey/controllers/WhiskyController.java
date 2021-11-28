package be.johannes.whiskey.controllers;

import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class WhiskyController {

    private WebscraperWhiskyShop webscraper = new WebscraperWhiskyShop();
    private Logger logger = LoggerFactory.getLogger(WhiskyController.class);
}
