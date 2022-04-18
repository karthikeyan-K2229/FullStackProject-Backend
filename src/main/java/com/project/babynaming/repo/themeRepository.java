package com.project.babynaming.repo;

import com.project.babynaming.Entity.themeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface themeRepository extends JpaRepository<themeModel,Long> {


    themeModel findByThemeName(String currtheme);
    themeModel findBythemeid(long themeid);


}
