package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, Long> {


    //query for search bar inside the view recipe. Search if either title, author, ingredients
    @Query("SELECT r FROM Recipe r WHERE r.title LIKE %?1%"
            + " OR r.author LIKE %?1% "
            + " OR r.ingredients LIKE %?1%")
    public List<Recipe> findAll(String keyword);
    
    public List<Recipe> findByAuthor(String author);

}
