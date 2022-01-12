package be.johannes.whiskey.controllers;

import be.johannes.whiskey.dto.UserDto;
import be.johannes.whiskey.model.User;
import be.johannes.whiskey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            BindingResult bindingResult,
                                            Errors errors) {
        ModelAndView mav = new ModelAndView("registration");
        if (errors.hasErrors()) {
            mav.addObject("errors", errors.getAllErrors());
        }
        if (bindingResult.hasErrors()) {
            return mav;
        }
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (Exception e) {
            return mav.addObject("message", e.getMessage());
        }

        return new ModelAndView("login", "user", userDto);
    }
}
