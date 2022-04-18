package com.project.babynaming.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.project.babynaming.Entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;


import com.project.babynaming.Entity.Message;
import com.project.babynaming.Services.FoodService;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.FoodRepository;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class FoodController {

    @Autowired
    FoodService foodServices;
    @Autowired
    private FoodRepository foodRepository;
    @PostMapping("/addAddon")
    public ResponseEntity<Message> addNewFood(@RequestBody Food food) {
        try {
            Food returnedFood = foodServices.saveFood(food);

            return new ResponseEntity<Message>(new Message("Upload Successfully!",
                    Arrays.asList(returnedFood), ""), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Fail to post a new Customer!",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/retrieveinfos")

    public ResponseEntity<Message> retrieveFoodInfo() {

        try {
            List<Food> foodInfos = foodServices.getFoodInfos();

            return new ResponseEntity<Message>(new Message("Get Food' Infos!",
                    foodInfos, ""), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Fail!",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAddon")
    public List<Food> getAllEmployees(){
        return foodRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Food> getEmployeeById(@PathVariable Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Employee not exist with id :" + id));
        return ResponseEntity.ok(food);
    }

    @GetMapping("/findone/{id}")
    public ResponseEntity<Message> getFoodById(@PathVariable long id) {
        try {
            Optional<Food> optFood = foodServices.getFoodById(id);

            if(optFood.isPresent()) {
                return new ResponseEntity<Message>(new Message("Successfully! Retrieve a food by id = " + id,
                        Arrays.asList(optFood.get()), ""), HttpStatus.OK);
            } else {
                return new ResponseEntity<Message>(new Message("Failure -> NOT Found a food by id = " + id,
                        null, ""), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Failure",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteAddon/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        foodRepository.delete(food);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Message> deleteFoodById(@PathVariable long id) {
        try {
            // checking the existed of a Customer with id
            if(foodServices.checkExistedFood(id)) {
                foodServices.deleteFoodById(id);

                return new ResponseEntity<Message> (new Message("Successfully! Delete a Food with id = " + id,
                        null, ""), HttpStatus.OK);
            }else {
                return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Customer "
                        + "with id = " + id, null, ""), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Failure",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editAddon/{id}")
    public ResponseEntity<Message> updateCustomerById(@RequestBody Food _food,
                                                      @PathVariable long id) {
        try {
            if(foodServices.checkExistedFood(id)) {
                Food food = foodServices.getFoodById(id).get();

                //set new values for customer

                food.setName(_food.getName());
                food.setPrice(_food.getPrice());
                food.setImage(_food.getImage());


                // save the change to database
                foodServices.updateFood(food);

                return new ResponseEntity<Message>(new Message("Successfully! Updated a Add_on "
                        + "with id = " + id,
                        Arrays.asList(food), ""), HttpStatus.OK);
            }else {
                return new ResponseEntity<Message>(new Message("Failer! Can NOT Found a Customer "
                        + "with id = " + id,
                        null, ""), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            return new ResponseEntity<Message>(new Message("Failure",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
