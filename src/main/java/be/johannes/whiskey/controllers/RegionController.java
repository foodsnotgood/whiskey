package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.Region;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.UserRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping("/regions")
    public String regions(Model model) {
        model.addAttribute("regions", regionRepository.findAll());
        return "regions";
    }

    @GetMapping({"/regiondetails/{id}", "/regiondetails"})
    public String regiondetails(Model model,
                                @PathVariable(required = false) Integer id,
                                Authentication authentication) {
        Region region = id != null && id <= regionRepository.count() ? regionRepository.findById(id).get() : null;
        User user = userRepository.findByEmail(authentication.getName());
        model.addAttribute("regionalWhiskies", whiskyRepository.findAllByUsersAndRegion(user, region));
        model.addAttribute("region", region);
        return "regiondetails";
    }
}
