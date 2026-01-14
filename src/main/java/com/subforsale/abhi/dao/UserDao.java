package com.subforsale.abhi.dao;

import com.subforsale.abhi.entity.FourString;
import com.subforsale.abhi.entity.OneString;
import com.subforsale.abhi.entity.TenString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<OneString> getAllUserNames(){
        System.out.println("getAllUserNames from userDao called");
        List<OneString> userList= new ArrayList<>();


        String sql = "SELECT FirstName FROM User";
        return jdbcTemplate.query ( sql,rs -> {
            while(rs.next()){
                OneString oneString= new OneString();
                oneString.setColumn1(rs.getString("FirstName"));
                userList.add(oneString);
            }
            return userList;
        });
    }


    public List<OneString> verifyLoginInfo(String userid){
        List<OneString> output= new ArrayList<>();
        System.out.println("verifyLoginInfo called from dao with username: "+userid );
        String sql="SELECT Password from user where Email='"+userid+"'";
        return jdbcTemplate.query ( sql,rs -> {
            while(rs.next()){
                OneString oneString= new OneString();
                oneString.setColumn1(rs.getString("Password"));
                output.add(oneString);
            }
            return output;
        });
    }

    public int addUserBySignUp(FourString fourString){//new Object[]{location}
        System.out.println("addUserBySignIn called from dto with username: "+fourString.getColumn1());
        String sql="INSERT INTO user (UserId,FirstName, MobileNumber, Email, Password) values(?,?,?,?,?)";
        System.out.println(sql);// name , mob , email, pass, last add userId
        return jdbcTemplate.update(sql,generateRandomNumber(),fourString.getColumn1(),fourString.getColumn2(),
                fourString.getColumn3(),fourString.getColumn4());
    }

    public List<TenString> getUserDetails(String userId){
        System.out.println("getUserDetails called from dao layer : with userId : "+userId);
        String sql="SELECT * from user where userId='"+userId+"'";/// total 10 column are present
        System.out.println(sql);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TenString.class));
    }

    public int passwordReset(FourString fourString) {
        System.out.println("password reset feature called from DTO");
        String sql="UPDATE user set Password='"+fourString.getColumn3()+"' where email='"+fourString.getColumn1()+"' and UserID='"+fourString.getColumn2()+"'";
        System.out.println(sql);
        return jdbcTemplate.update(sql);

    }
    public static int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a 6-digit number
        return randomNumber;
    }
}
