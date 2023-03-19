package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

	Meal findTopByCreatedByOrderByCreatedAtDesc(String createdBy);

}
