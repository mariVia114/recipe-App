package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Recipe;

import java.util.List;

public interface CartService {

    void addFavourites(Recipe recipe);
    List<Recipe> getFavourites();
}
