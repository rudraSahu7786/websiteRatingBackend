package com.subforsale.abhi.controller;

import com.subforsale.abhi.dao.UserDao;
import com.subforsale.abhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;
    /// API to get all User list
    @GetMapping
    public List<String> getAllUsers(){
        System.out.println("getAllUsers from userController called");
        System.out.println(userDao.getAllUserNames().size());
        List<String> listOfUsers= new ArrayList<>();
        for(OneString item: userDao.getAllUserNames()){
            System.out.println(item.getColumn1());
            listOfUsers.add(item.getColumn1());
        }
        return listOfUsers;
    }
    /// REST API to login feature
    /// Access REST API USING URL: http://localhost:8080/users/login/user1?password=hashed_password1
    @GetMapping("login/{username}")
    public Boolean userSignInRequest(@PathVariable String username, @RequestParam String password){
        System.out.println("userSignInRequest called from controller with username : "+username);
        System.out.println(username+" "+password);
        List<OneString> out=userDao.verifyLoginInfo(username);
        for(OneString item : out){
            if(item.getColumn1().equals(password)){
                System.out.println("Password is correct");
                return true;
            }else {
                System.out.println("password is incorrect");
            }
        }
        return false;
    }
    ///REST API to sign up feature
    /// URL: http://localhost:8080/users/signup
    @PostMapping("signup")
    public ResponseEntity<Integer> userSignUpRequest(@RequestBody FourString fourString){
        System.out.println("userSignUpRequest called : "+fourString);
        int out=userDao.addUserBySignUp(fourString);
        return new ResponseEntity<>(out, HttpStatus.CREATED);
    }

    /// REST API for forgot password feature
    @PostMapping("reset")
    public ResponseEntity<Integer> userPasswordResetRequest(@RequestBody FourString fourString){
        System.out.println("userSignUpRequest called : "+fourString);
        if(fourString.getColumn3().equals(fourString.getColumn4())){
            // password and confirm password matches
            int out=userDao.passwordReset(fourString);
            return new ResponseEntity<>(out, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(0, HttpStatus.NOT_ACCEPTABLE);
        }

    }
    /// REST API for get user details
    @GetMapping("userDetails/{userId}")
    public ResponseEntity<List<TenString>> getUserDetails( @PathVariable String userId){
        System.out.println("getUserDetails called for user with user_id : ");
        List<TenString> userDetails=userDao.getUserDetails(userId);
        return new ResponseEntity<>(userDetails,HttpStatus.OK);
    }


}
