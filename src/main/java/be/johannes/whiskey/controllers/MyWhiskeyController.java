package be.johannes.whiskey.controllers;

import be.johannes.whiskey.model.User;
import be.johannes.whiskey.model.Whisky;
import be.johannes.whiskey.repositories.RegionRepository;
import be.johannes.whiskey.repositories.UserRepository;
import be.johannes.whiskey.repositories.WhiskyRepository;
import be.johannes.whiskey.service.ImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Controller
public class MyWhiskeyController {

    @Autowired
    private WhiskyRepository whiskyRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imageService;

    private Logger logger = LoggerFactory.getLogger(MyWhiskeyController.class);

    @GetMapping("/mywhisky")
    public String myWhisky(Model model, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        model.addAttribute("whiskies", whiskyRepository.findAllByUsers(user));
        model.addAttribute("regions", regionRepository.findAll());
        return "mywhisky";
    }

    @GetMapping("/whiskydetail/my/{id}")
    public String myWhiskyDetails(Model model, @PathVariable Integer id) {
        model.addAttribute("mine", true);
        Whisky whisky = whiskyRepository.findById(id).isPresent() ? whiskyRepository.findById(id).get() : null;
        model.addAttribute("whisky", whisky);
        model.addAttribute("whiskyImagePath", whisky.getImageUrl());
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

    @GetMapping("whisky/image/{id}")
    public void showWhiskyImage(@PathVariable Integer id,
                                HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");
        Whisky whisky = whiskyRepository.findById(id).isPresent() ? whiskyRepository.findById(id).get() : null;

        InputStream is = new ByteArrayInputStream(imageService.convertImageToByteArray(whisky.getImageUrl()));
        IOUtils.copy(is, response.getOutputStream());
    }
}
