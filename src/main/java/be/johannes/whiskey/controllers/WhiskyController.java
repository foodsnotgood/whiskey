package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.scraper.WebscraperWhiskyShop;
import be.johannes.whiskey.service.ImageSaveService;
import be.johannes.whiskey.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class WhiskyController {


    @Autowired
    private WhiskyRepository whiskyRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UserService userService;

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
        whisky.setImageUrl(ImageSaveService.saveImageFromUrl(whisky.getImageUrl()));
        whiskyRepository.save(whisky);
        return "redirect:mywhisky";
    }

    private LocalDate getDate() {
        return LocalDate.now();
    }
}
