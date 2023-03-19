//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the event controller>
package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Event;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.EventService;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/profile/events")
@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @RequestMapping("/create")
    public String newEventPage(Model model, Authentication authentication){
        String username = authentication.getName();
        model.addAttribute("username", username);
        User user = userService.findByUserName(username);
        model.addAttribute("userId", user.getId());

        Event event = new Event();
        event.setUserid(user.getId());
        model.addAttribute(event);
        return "create_event";
    }

    @RequestMapping("/update/{id}")
    public String updateEventPage(Model model, Authentication authentication, @PathVariable(name="id") Long id){

        Event event = eventService.findById(id);
        model.addAttribute(event);
        return "update_event";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("event") Event event){
        eventService.save(event);
        return "redirect:/profile/events";
    }
    @RequestMapping(value = "/save/{id}", method= RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("event") Event event, @PathVariable(name="id") Long id){
        event.setId(id);
        eventService.save(event);
        return "redirect:/profile/events";
    }

    @RequestMapping(value = "/delete/{did}")
    public String deleteRecipePage(@PathVariable (name="did") Long id){
        eventService.delete(id);
        return "redirect:/profile/events";
    }
}
