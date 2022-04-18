package com.project.babynaming.Services;



import java.util.List;
import java.util.Optional;

import com.project.babynaming.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.babynaming.repo.FoodRepository;




@Service
public class FoodService {

    @Autowired FoodRepository repository;

    public Food saveFood(Food food) throws Exception {
        String currentfood = food.getName();
        Food userfood=repository.findByName(currentfood);
        if(userfood!=null)
        {
            throw new Exception("Add_on alreay exist");
        }
        return repository.save(food);
    }

    public List<Food> getFoodInfos(){
        return repository.findAll();
    }

    public Optional<Food> getFoodById(long id) {
        return repository.findById(id);
    }

    public boolean checkExistedFood(long id) {
        if(repository.existsById((long) id)) {
            return true;
        }
        return false;
    }

    public Food updateFood(Food food) throws  Exception{
        String currname=food.getName();
        Food userObj = repository.findByName(currname);
        if(userObj!=null)
        {
            throw new Exception("Already exists !!!");
        }
        return repository.save(food);
    }

    public void deleteFoodById(long id) {
        repository.deleteById(id);
    }

    public Food updateStudent(Food food,long id) {

        long id1= id;
        Food fd = repository.findById(id1).get();
        fd.setName(fd.getName());
        fd.setPrice(fd.getPrice());
        fd.setImage(fd.getImage());
        return repository.save(fd);
    }


}