package com.jr.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jr.sportplay.bean.User;
import com.jr.sportplay.dao.UserDao;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;


    @PostMapping("/login")
    public String userLogin(@RequestBody User user){
        String flag="error";
        User us=userDao.getUserByMessage(user.getUsername(),user.getPassword());
        HashMap<String,Object> LoginReturnMessage=new HashMap<>();
        if(us!=null){
            flag="ok";
        }
        LoginReturnMessage.put("flag",flag);
        LoginReturnMessage.put("user",us);

        return JSON.toJSONString(LoginReturnMessage);
    }
}
