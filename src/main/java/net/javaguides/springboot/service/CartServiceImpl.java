package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RecipesRepository recipesRepo;
    List<Recipe> favs = new ArrayList<Recipe>();
    public CartServiceImpl(RecipesRepository recipesRepo) {
        this.recipesRepo = recipesRepo;
    }

   
    @Override
     public void addFavourites(Recipe recipe) {

        favs.add(recipe);
    }

    @Override
    public List<Recipe> getFavourites() {
        return favs;
    }

}
