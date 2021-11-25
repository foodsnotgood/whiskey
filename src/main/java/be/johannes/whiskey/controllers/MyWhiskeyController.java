package be.johannes.whiskey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyWhiskeyController {

    @GetMapping("/mywhisky")
    public String myWhiskey(Model model){
        return "mywhisky";
    }
}
