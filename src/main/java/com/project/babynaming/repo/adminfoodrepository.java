package com.project.babynaming.repo;

import com.project.babynaming.Entity.adminfood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminfoodrepository  extends JpaRepository<adminfood,Long> {
    adminfood findByFoodname(String currentfood);
}
