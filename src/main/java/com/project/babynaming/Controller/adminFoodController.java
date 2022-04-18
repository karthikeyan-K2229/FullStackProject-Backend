package com.project.babynaming.Controller;

import com.project.babynaming.Entity.adminfood;
import com.project.babynaming.Services.adminfoodservice;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.adminfoodrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200/")

public class adminFoodController {

    @Autowired
    private adminfoodservice adminservice;
    @Autowired

   private  adminfoodrepository adminrepo;
    @PostMapping("/admin/addfood")
    public adminfood userbookevent(@RequestBody adminfood food)throws Exception
    {
        adminfood userObj = null;
        userObj = adminservice.saveUser(food);
        return userObj;
    }
    @GetMapping("/admin/getfood")
    public List<adminfood> getAllUsers(){
        return adminrepo.findAll();
    }
    @DeleteMapping("/admin/deletefood/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
        adminfood user=adminrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +id ));
        adminrepo.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/admin/getfoodbyid/{id}")
    public ResponseEntity<adminfood> getUserById(@PathVariable Long id){
        adminfood user=adminrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +id ));
        return ResponseEntity.ok(user);
    }
    @PutMapping("/admin/updatefood/{id}")
    public ResponseEntity<adminfood> updateUser(@PathVariable Long id,@RequestBody adminfood userDetails) throws Exception {
        adminfood user=adminrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +id ));
        user.setFoodname(userDetails.getFoodname());
        user.setImageurl(userDetails.getImageurl());
        user.setCategory(userDetails.getCategory());
        user.setPrice(userDetails.getPrice());


        adminfood updatedUser=adminservice.saveuser(user);
        return ResponseEntity.ok(updatedUser);
    }
}
