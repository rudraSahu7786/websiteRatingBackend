package com.subforsale.abhi.controller;

import com.subforsale.abhi.dao.*;
import com.subforsale.abhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardDao dashboardDao;

    //// REST API to get all the URL of the websites
    @GetMapping("urls")
    public ResponseEntity<List<FourString>> getWebsiteDetailsWithUrl(){
        System.out.println("getWebsiteDetailsWithUrl called from Dashboard Controller");
        List<FourString> listOfUrls = dashboardDao.getAllUrlDetails();
        return new ResponseEntity<>(listOfUrls, HttpStatus.OK);
    }
    /// REST API for get user's profile details
    @GetMapping("profile/{id}")
    public ResponseEntity<List<SixString>> getProfileDetails(@PathVariable String id){
        System.out.println("getProfileDetails called from Dashboard Controller");
        List<SixString> userDetailsList = dashboardDao.getProfileDetails(id);
        return new ResponseEntity<>(userDetailsList, HttpStatus.OK);
    }
}
