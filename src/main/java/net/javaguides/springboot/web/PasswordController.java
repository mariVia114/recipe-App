//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the password controller>
package net.javaguides.springboot.web;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class PasswordController {

    @Autowired
    UserService service;

    @Autowired
    UserServiceImpl userService;

    public PasswordController(UserService service) {
        super();
        this.service = service;
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email, @RequestParam String password) {


        String response = userService.forgotPassword(email, password);

        if (!response.startsWith("Invalid")) {
            return "redirect:login";
        }
        return "redirect:/forgot-password/failed";
    }

    @PostMapping("/forgot-password/failed")
    public String forgotPasswordFail(@RequestParam String email) {
        return "reset_failed";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage(@RequestParam String email) {
        return "forget_password";
    }


    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password) {

        if(Objects.equals(userService.resetPassword(token, password), "Your password successfully updated.")) {
            return "redirect:login.html";
        }
        else {
            return "redirect:reset_failed.html";
        }
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String resetPasswordPage() {
        return "reset_password";
    }


}
