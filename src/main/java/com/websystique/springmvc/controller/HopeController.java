package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Hope;
import com.websystique.springmvc.service.HopeService;
 
@Controller
@RequestMapping("/HopeController")
public class HopeController {//action
 
    @Autowired
    HopeService hopeService;
     
 
    /*
     * 这个方法将会显示所有存在的员工
     */
    @RequestMapping(value = { "/","/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
    	int level = 2;
    	
        List<Hope> hopes = hopeService.findByLevel(level);
        model.addAttribute("hopes", hopes);//把数据放到页面
        return "/hope/things";//指定返回到那个页面
    }
 
    
}
