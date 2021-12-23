package be.johannes.whiskey.controllers;

import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyWhiskeyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    @Autowired
    private RegionRepository regionRepository;

    private Logger logger = LoggerFactory.getLogger(MyWhiskeyController.class);

    @GetMapping("/mywhisky")
    public String myWhisky(Model model) {
        model.addAttribute("whiskies", whiskyRepository.findAll());
        model.addAttribute("regions", regionRepository.findAll());
        return "mywhisky";
    }

    @GetMapping("/whiskydetail/my/{id}")
    public String myWhiskyDetails(Model model, @PathVariable Integer id) {
        model.addAttribute("mine", true);
        model.addAttribute("whisky", whiskyRepository.findById(id).isPresent() ? whiskyRepository.findById(id).get() : null);
        return "whiskydetail";
    }

    @GetMapping("search/mywhisky")
    public String searchMyWhisky(@RequestParam("search") String query,
                                 Model model) {
        model.addAttribute("whiskies", whiskyRepository.findByQuery(query));
        model.addAttribute("regions", regionRepository.findAll());
        return "mywhisky";
    }

    @GetMapping("searchbyregion/{id}")
    public String searchByRegion(@PathVariable("id") Integer id,
                                 Model model) {
        model.addAttribute("whiskies", whiskyRepository.findByRegionId(id));
        model.addAttribute("regions", regionRepository.findAll());
        return "mywhisky";
    }
}
