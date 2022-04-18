package com.project.babynaming.Services;

import com.project.babynaming.repo.loginRegisterRepository;
import com.project.babynaming.Entity.loginRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginRegisterService {

    @Autowired
    private loginRegisterRepository carRepository;
    //Register
    public loginRegisterModel saveUser(loginRegisterModel car)throws  Exception
    {
        String currentMail=car.getEmail();
        String currPhone=car.getPhone();
        loginRegisterModel userObj = carRepository.findByEmail(currentMail);
        loginRegisterModel UserPhn=carRepository.findByPhone(currPhone);

        if(userObj != null && UserPhn !=null)
        {
            throw new Exception("Email and phone number already exists !!!");
        }
        if(userObj != null)
        {
            throw new Exception("Email id already exists !!!");
        }
        if(UserPhn != null)
        {
            throw new Exception("Phone number already exists !!!");
        }
        return carRepository.save(car);
    }

    //Login
    public loginRegisterModel fetchByEmail(loginRegisterModel car)throws Exception
    {
        String currEmail=car.getEmail();
        String currPassword=car.getPassword();
        loginRegisterModel userObj = carRepository.findByEmailAndPassword(currEmail,currPassword);
//        if(userObj == null)
//        {
//            //throw new Exception("User does not exists!!!");
//            System.out.println("user does not exists");
//        }
        return userObj;
    }






}