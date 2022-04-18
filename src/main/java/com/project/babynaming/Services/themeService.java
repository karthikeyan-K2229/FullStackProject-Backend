package com.project.babynaming.Services;

import java.util.List;

import com.project.babynaming.Entity.themeModel;
import com.project.babynaming.repo.themeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class themeService {
    @Autowired
    themeRepository themerepository;

    public themeModel saveUser(themeModel theme) throws  Exception{

        String currtheme=theme.getThemeName();
        themeModel userobj=themerepository.findByThemeName(currtheme);
        if(userobj !=null)
        {
            throw new Exception("Already exixts");
        }
        return themerepository.save(theme);
    }

    public List<themeModel> getAllTheme() {
        return  (List<themeModel>)themerepository.findAll();
    }

    public themeModel fetchByThemeId(Long themeid) {

        return (themeModel)themerepository.findBythemeid(themeid);
    }
}
