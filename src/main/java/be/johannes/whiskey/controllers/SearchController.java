package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.scraper.ScrapedWhiskyInList;
import be.johannes.whiskey.scraper.ScraperListHolder;
import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private WhiskyRepository whiskyRepository;

    private WebscraperWhiskyShop webscraper = new WebscraperWhiskyShop();
    private ScraperListHolder listHolder = new ScraperListHolder();

    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @ModelAttribute("whisky")
    public Whisky findWhisky(@PathVariable(required = false) Integer id) {
        if (id != null) {
            return whiskyRepository.findById(id).isPresent() ? whiskyRepository.findById(id).get() : null;
        }
        return new Whisky();
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(required = false) String queryText) throws IOException {
        logger.info("query text: " + queryText);
        if (queryText != null) {
            listHolder.setWhiskies(webscraper.getListElements(queryText));
        }

        model.addAttribute("listHolder", listHolder.getWhiskies());
        return "search";
    }


    @GetMapping("/whiskydetail/{index}")
    public String whiskydetail(Model model,
                               @PathVariable Integer index) {
        ScrapedWhiskyInList whisky = listHolder.getWhiskies().get(index);
        model.addAttribute("whisky", whisky);
        model.addAttribute("fallBackindex", index);
        return "whiskydetail";
    }

}
