package be.johannes.whiskey.controllers;

import be.johannes.whiskey.repositories.WhiskyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyWhiskeyController {

    @Autowired
    private WhiskyRepository whiskyRepository;

    private Logger logger = LoggerFactory.getLogger(MyWhiskeyController.class);

    @GetMapping("/mywhisky")
    public String myWhiskey(Model model) {
        return "mywhisky";
    }


}
