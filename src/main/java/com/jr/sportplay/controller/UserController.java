package com.jr.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jr.sportplay.bean.Query;
import com.jr.sportplay.bean.User;
import com.jr.sportplay.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    //根据条件查询用户
    @GetMapping("allUser")
    public String getUserList(Query query){
        //获取查询到的最大用户数量
        int number=userDao.getCount(query.getUsername());
        //获取当前编号
        int pageStart= query.getPageSize()*(query.getPageStart()-1);
        List<User> userList=userDao.getAllUsers(query.getUsername(), pageStart, query.getPageSize());
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("number",number);
        hashMap.put("data",userList);
        return JSON.toJSONString(hashMap);
    }

    //修改用户状态
    @PutMapping("userState")
    public String updateUserState(@RequestParam("id") int id,@RequestParam("state") boolean state){
        int i=userDao.updateState(id,state);
        return i>0 ? "success":"error";
    }

    //添加用户
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i=userDao.addUser(user);
        return i>0 ? "success":"error";
    }

    //删除用户
    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        int i=userDao.deleteUser(id);
        return i>0 ? "success":"error";
    }

    //获取修改用户
    @GetMapping("getUpdateUser")
    public String getUpdateUser(@RequestParam("id")int id){
        User user=userDao.getUpdateUser(id);
        return JSON.toJSONString(user);
    }

    //修改用户信息
    @PutMapping("editUser")
    public String editUser(@RequestBody User user){
        int i=userDao.editUser(user);
        return i>0 ?"success":"error";
    }

}
