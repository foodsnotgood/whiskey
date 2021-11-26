package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.scraper.Webscraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    private RegionRepository regionRepository;

    private Webscraper webscraper = new Webscraper();

    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(required = false) String queryText) throws IOException {
        model.addAttribute("regions", regionRepository.findAll());
        logger.info("query Text : -------- " + queryText);
        if (queryText != null) model.addAttribute("whiskies", webscraper.getElements(queryText));
        return "search";
    }

    @GetMapping({"/regiondetails/{id}", "/regiondetails"})
    public String regiondetails(Model model, @PathVariable(required = false) Integer id){
        Region region = id != null && id <= regionRepository.count() ? regionRepository.findById(id).get() : null;
        model.addAttribute("region", region);
        return "regiondetails";
    }
}
