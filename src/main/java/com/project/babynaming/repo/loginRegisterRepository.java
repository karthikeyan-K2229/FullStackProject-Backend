package com.project.babynaming.repo;

import com.project.babynaming.Entity.loginRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface loginRegisterRepository extends JpaRepository<loginRegisterModel,Long>
{

    loginRegisterModel findByPhone(String currPhone) ;


    loginRegisterModel findByEmail(String email);


    loginRegisterModel findByEmailAndPassword(String currEmail, String currPassword);


}
