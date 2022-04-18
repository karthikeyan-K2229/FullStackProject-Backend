package com.project.babynaming.Services;

import com.project.babynaming.Entity.adminfood;
import com.project.babynaming.repo.adminfoodrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminfoodservice {

    @Autowired
    adminfoodrepository adminrepo;

    public adminfood saveUser(adminfood food)throws Exception
    {String currentfood = food.getFoodname();
        adminfood userfooD=adminrepo.findByFoodname(currentfood);
        if(userfooD!=null)
        {
            throw new Exception(" alreay exist");
        }
        return adminrepo.save(food);

    }


    public adminfood saveuser(adminfood user)throws Exception {
        String curr= user.getFoodname();
        adminfood updatedfood=adminrepo.findByFoodname(curr);
        if(updatedfood!=null)
        {
            throw new Exception("already exist");
        }
        return adminrepo.save(user);
    }
}
