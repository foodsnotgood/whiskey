package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class WhiskyController {


    @Autowired
    private WhiskyRepository whiskyRepository;

    @Autowired
    private RegionRepository regionRepository;

    private WebscraperWhiskyShop webscraper = new WebscraperWhiskyShop();
    private Logger logger = LoggerFactory.getLogger(WhiskyController.class);


    @ModelAttribute("whisky")
    public Whisky newWhisky(@PathVariable(required = false) Integer id) {
        if (id != null) {
            return whiskyRepository.findById(id).isPresent() ? whiskyRepository.findById(id).get() : null;
        }
        return new Whisky();
    }

    @PostMapping("/whiskydetail")
    public String addWhisky(@ModelAttribute("whisky") Whisky whisky,
                            @RequestParam(name = "regionString", required = false) String regionString) {
        logger.info(" Ingevoerde whisky : --------------- " + whisky.getName());
        logger.info(" Ingevoerde region string : --------------- " + regionString);
        Region region;
        if (regionRepository.findByName(regionString).isPresent()) {
            region = regionRepository.findByName(regionString).get();
        } else {
            region = new Region(regionString);
            regionRepository.save(region);
        }
        logger.info("REGION : --- " + region.getName());
        whisky.setRegion(region);
        whisky.setDateAdded(getDate());
        whiskyRepository.save(whisky);
        return "redirect:mywhisky";
    }

    private Date getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return new Date(dtf.format(now));
    }
}
