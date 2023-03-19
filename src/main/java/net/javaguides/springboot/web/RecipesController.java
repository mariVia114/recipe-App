//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the recipe controller>
package net.javaguides.springboot.web;

import java.util.List;

import net.javaguides.springboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Meal;
import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.MealService;
import net.javaguides.springboot.service.RecipeServices;
import net.javaguides.springboot.service.UserService;

@Controller
public class RecipesController {
    
	@Autowired
	UserService userService;
	
	@Autowired
    RecipeServices service;
	
	@Autowired
	MealService mealService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/view")
    public String viewRecipes(Model model, @Param("keyword") String keyword){
        List<Recipe> listRecipe = service.listAll(keyword);
        model.addAttribute("listRecipe",listRecipe);
        model.addAttribute("keyword", keyword);
        return "view_recipe";
    }

    @RequestMapping("/create")
    public String newRecipePage(Model model, Authentication authentication){
        Recipe recipe = new Recipe();
        model.addAttribute(recipe);
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "create_recipe";
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String saveRecipe(@ModelAttribute ("recipe") Recipe recipe){
        service.save(recipe);
        return "redirect:/";
    }

    @RequestMapping("edit/{sid}")
    public ModelAndView showEditRecipePage(@PathVariable (name="sid") Long sid){
        ModelAndView modelAndView = new ModelAndView("edit_recipe");
        Recipe recipe = service.get(sid);
        modelAndView.addObject("recipe", recipe);
        return modelAndView;
    }

//    @RequestMapping("/search")
//    public String doSearchByName(@ModelAttribute ("recipeSearchFormData") Recipe formData, Model model){
//        Recipe recipe = service.get(formData.getId());
//        model.addAttribute("recipe",recipe);
//        return "view_recipe";
//    }

    @RequestMapping("delete/{sid}")
    public String deleteRecipePage(@PathVariable (name="sid") Long sid){
        service.delete(sid);
        return "redirect:/";
    }



    @RequestMapping("/meal")
    public String planMeal(Model model, Authentication authentication) {
    	Meal meal = mealService.findByCreatedBy(authentication.getName());
    	if (meal == null) {
    		meal = new Meal();
    	}
    	model.addAttribute(meal);
    	model.addAttribute("meal", meal);
    	String username = authentication.getName();
    	model.addAttribute("username", username);
    	List<Recipe> recipeList = service.listAll(null);
    	model.addAttribute("recipeList", recipeList);
    	model.addAttribute("username", username);
    	return "plan_meal";
    }
    
    @RequestMapping(value = "/plan", method = RequestMethod.POST)
    public String saveMeal(@ModelAttribute ("meal") Meal meal, Authentication authentication) {
        mealService.save(meal, authentication.getName());
        return "redirect:/meal";
    }

//    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
//    public String viewIngredients(@ModelAttribute ("recipe") Meal meal, Authentication authentication) {
//        mealService.save(meal, authentication.getName());
//        return "redirect:/meal";
//    }

    @GetMapping("/add_fav/{recipeID}")
    public String addToFavourites(Model model, @PathVariable("recipeID") Long rID) {
        cartService.addFavourites(service.get(rID));
        return "redirect:/view";
    }

    @GetMapping("/view_fave")
    public String favesList(Model model) {
        List<Recipe> faveRecipes = cartService.getFavourites();
        model.addAttribute("faveRecipes", faveRecipes);
        return "view_fave";
    }

    @GetMapping("/view_ingr/{recipeID}")
    public String viewIngredients(Model model, @PathVariable("recipeID") Long rID) {
        Recipe recipe = service.get(rID);
        model.addAttribute("recipe", recipe);
        return "view_ingr";
    }

    @GetMapping("/view_instr/{recipeID}")
    public String viewInstr(Model model, @PathVariable("recipeID") Long rID) {
        Recipe recipe = service.get(rID);
        model.addAttribute("recipe", recipe);
        return "view_instr";
    }


}
