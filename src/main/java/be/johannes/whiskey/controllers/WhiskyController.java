package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import be.johannes.whiskey.service.ImageService;
import be.johannes.whiskey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class WhiskyController {


    @Autowired
    private WhiskyRepository whiskyRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

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
                            @RequestParam(name = "regionString", required = false) String regionString,
                            Authentication authentication) throws Exception {
        Region region;
        if (regionRepository.findByName(regionString).isPresent()) {
            region = regionRepository.findByName(regionString).get();
        } else {
            region = new Region(regionString);
            regionRepository.save(region);
        }
        User user = userService.getUser(authentication);
        whisky.setRegion(region);
        whisky.setDateAdded(getDate());
        user.getWhiskies().add(whisky);
        String imgDirectory = imageService.saveImageFromUrl(whisky.getImageUrl());
        if (!imgDirectory.equals("error")) {
            String[] arr = imgDirectory.split("/");
            String relativeDirectory = arr[arr.length - 2] + "/" + arr[arr.length - 1];
            whisky.setImageUrl(relativeDirectory);
        }
        whiskyRepository.save(whisky);
        return "redirect:mywhisky";
    }

    @GetMapping("/whiskydetail/db/{id}")
    public String whiskyDetails() {
        return "whiskydetail";
    }

    private LocalDate getDate() {
        return LocalDate.now();
    }
}
