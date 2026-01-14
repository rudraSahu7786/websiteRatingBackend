package com.subforsale.abhi.dao;

import com.subforsale.abhi.entity.FourString;
import com.subforsale.abhi.entity.SixString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DashboardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<SixString> getProfileDetails(String userId) {
        System.out.println("getUserDetails called from dao layer : with userId : "+userId);
        String sql="Select * from user where userID="+userId+"";
        System.out.println(sql);
        List<SixString> listOfProfileDtls= new ArrayList<>();
        return jdbcTemplate.query ( sql,rs -> {
            while(rs.next()){
                SixString sixString= new SixString();
                sixString.setColumn1(rs.getString("UserID"));
                sixString.setColumn2(rs.getString("FirstName"));
                sixString.setColumn3(rs.getString("LastName"));
                sixString.setColumn4(rs.getString("Email"));
                sixString.setColumn5(rs.getString("Location"));
                sixString.setColumn6(rs.getString("MobileNumber"));
                listOfProfileDtls.add(sixString);
            }
            return listOfProfileDtls;

        });

    }
    public List<FourString> getAllUrlDetails() {
        String sql = "select WebsiteId ,url ,addedDate , companyName from website";
        List<FourString> out= new ArrayList<>();
        return jdbcTemplate.query ( sql,rs -> {
            while(rs.next()){
                FourString fourString= new FourString();
                fourString.setColumn1(rs.getString("WebsiteId"));
                fourString.setColumn2(rs.getString("url"));
                fourString.setColumn3(rs.getString("addedDate"));
                fourString.setColumn4(rs.getString("companyName"));

                out.add(fourString);
            }
            return out;
        });
    }
}
