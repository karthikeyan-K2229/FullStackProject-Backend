package com.project.babynaming.Controller;

import com.project.babynaming.Services.loginRegisterService;
import com.project.babynaming.repo.loginRegisterRepository;
import com.project.babynaming.Entity.loginRegisterModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class loginRegisterController {
@Autowired
private loginRegisterRepository loginregiterrepo;
    @Autowired
    private loginRegisterService carService;
    //register
    @PostMapping("/userregister")
    public ResponseEntity<loginRegisterModel> register(@RequestBody loginRegisterModel car)throws Exception
    {
        try {
            loginRegisterModel userObj = null;
            userObj = carService.saveUser(car);
            return new ResponseEntity<loginRegisterModel>(userObj, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //login
    @PostMapping("/userlogin")
    public ResponseEntity<loginRegisterModel> login(@RequestBody loginRegisterModel car)throws Exception
    {
        loginRegisterModel userObj=null;
        userObj = carService.fetchByEmail(car);
        if(userObj==null){
            System.out.println("no login id");
            return new ResponseEntity("Not found",HttpStatus.OK);
        }else{
            System.out.println("in else");
        }

        return new ResponseEntity<loginRegisterModel>(userObj, HttpStatus.OK);
    }
    //get all users
    @GetMapping("/getAllUsers")
    @CrossOrigin(origins="http://localhost:4200")
    public List<loginRegisterModel> getAllUsers(){
        return loginregiterrepo.findAll();
    }

    //delete user rest api
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
        loginRegisterModel user=loginregiterrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +id ));
        loginregiterrepo.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

