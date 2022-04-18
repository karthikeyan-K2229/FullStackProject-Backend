package com.project.babynaming.repo;

import com.project.babynaming.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
    Food findByName(String currentfood);

}
