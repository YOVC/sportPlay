package com.jr.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.jr.sportplay.bean.MainMenu;
import com.jr.sportplay.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    //导航栏信息
    @GetMapping("/menus")
    public String getMenus(){
        HashMap<String,Object> datas=new HashMap<>();
        List<MainMenu> menus =menuDao.getMenus();
        if(menus!=null){
            datas.put("menus",menus);
            datas.put("status","200");
        }else{
            datas.put("status",404);
        }
        return JSON.toJSONString(datas);
    }
}
