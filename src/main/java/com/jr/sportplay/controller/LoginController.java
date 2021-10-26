package com.jr.sportplay.controller;

import com.jr.sportplay.bean.User;
import com.jr.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @PostMapping("/login")
    public String userLogin(@RequestBody User user){
        User us=userDao.getUserByMassage(user.getUsername(),user.getPassword());
        System.out.println("user:"+us);
        return "ok";
    }
}
