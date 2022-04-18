package com.project.babynaming.Controller;



import com.project.babynaming.Entity.themeModel;
import com.project.babynaming.exception.ResourceNotFoundException;
import com.project.babynaming.repo.themeRepository;
import com.project.babynaming.Services.themeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class adminController {

    @Autowired  themeService themeservice;
    @Autowired
    themeRepository themerepo;
    @PostMapping("/admin/addtheme")
    public ResponseEntity<themeModel> register(@RequestBody themeModel theme)throws Exception
    {
        themeModel userObj = null;
        userObj=themeservice.saveUser(theme);
        return new ResponseEntity<themeModel>(userObj, HttpStatus.OK);
    }

    @GetMapping("/user/getAllThemes")
    public ResponseEntity<List<themeModel>> getAllThemes() throws Exception
    {
        List<themeModel> theme=themeservice.getAllTheme();
        return new ResponseEntity<List<themeModel>>(theme, HttpStatus.OK);
    }

    @GetMapping("/user/getTheme/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<themeModel> getTheme(@PathVariable Long id) throws Exception
    {
        System.out.println(id+" "+id);
        themeModel themeModel1 = themeservice.fetchByThemeId(id);
        return new ResponseEntity<themeModel>(themeModel1, HttpStatus.OK);
    }

    @DeleteMapping("/admin/deletetheme/{themeid}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long themeid){
        themeModel user=themerepo.findById(themeid).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +themeid ));
        themerepo.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/admin/updatetheme/{themeid}")
    public ResponseEntity<themeModel> updateUser(@PathVariable Long themeid, @RequestBody themeModel userDetails) throws Exception {
        themeModel user=themerepo.findById(themeid).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +themeid ));
        user.setPhotographerDetails(userDetails.getPhotographerDetails());
        user.setVideographerDetails(userDetails.getVideographerDetails());
        user.setReturnGift(userDetails.getReturnGift());
        user.setThemeCost(userDetails.getThemeCost());


        themeModel updatedUser=themerepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/admin/getthemebyid/{themeid}")
    public ResponseEntity<themeModel> getUserById(@PathVariable Long themeid){
        themeModel user=themerepo.findById(themeid).orElseThrow(()->new ResourceNotFoundException("User does not exist with id :" +themeid ));
        return ResponseEntity.ok(user);
    }
}
