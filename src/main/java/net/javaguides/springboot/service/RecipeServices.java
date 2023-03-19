package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServices {
    @Autowired
    private RecipesRepository repo;
    public List<Recipe> listAll(String keyword){
        if(keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }
    public void save(Recipe recipe){
        repo.save(recipe);
    }
    public Recipe get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public List<Recipe> findByAuthor(String author) {
    	return repo.findByAuthor(author);
    }
}
