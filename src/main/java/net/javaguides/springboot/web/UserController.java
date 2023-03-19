//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the user controller>
package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Event;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.model.User;

import net.javaguides.springboot.repository.EventRepository;
import net.javaguides.springboot.repository.RecipesRepository;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

//    @Autowired
//    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userImpl;

    @Autowired
    private RecipesRepository recipesRepository;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/profile")
    public String profile(Model model, Authentication authentication) {

        String username = authentication.getName();

//        User user = userRepository.findByUserName(username);
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);

        List<Recipe> listRecipe = recipesRepository.findByAuthor(username);
        model.addAttribute("recipes", listRecipe);

        List<Event> listEvent = eventRepository.findByUserid(user.getId());
        model.addAttribute("events", listEvent);

        return "view_profile";
    }

    @RequestMapping("/profile/events")
    public String profileEvents(Model model, Authentication authentication) {

        String username = authentication.getName();

//        User user = userRepository.findByUserName(username);
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);

        List<Recipe> listRecipe = recipesRepository.findByAuthor(username);
        model.addAttribute("recipes", listRecipe);

        List<Event> listEvent = eventRepository.findByUserid(user.getId());
        model.addAttribute("events", listEvent);

        return "event_list";
    }

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    public String editProfilePage(Model model, Authentication authentication) {

        String username = authentication.getName();

//        User user = userRepository.findByUserName(username);
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);

        return "edit_profile";
    }

    @RequestMapping(value = "/profile/edit/{id}", method = RequestMethod.POST)
    public String editProfile(@PathVariable Long id, @ModelAttribute("user") User user, Authentication authentication) {
        user.setId(id);
        userImpl.save(user);
        return "view_profile";
    }
}
