package com.websystique.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Animal;
import com.websystique.springmvc.service.AnimalService;
 
@Controller
@RequestMapping("/AnimalController")
public class AnimalController {//action
 
    @Autowired
    AnimalService animalService;
     
    @Autowired
    MessageSource messageSource;
    
    /*
     * 这个方法将会根据动物的id，删除这个动物信息
     */
    @RequestMapping(value = { "/delete-{id}-animal" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id) {
    	animalService.deleteAnimalById(id);
        return "redirect:/AnimalController/listAnimals";//重定向
    }
    
    /*
     * 去 更新动物页面
     */
    @RequestMapping(value = { "/edit-{id}-animal" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable int id, ModelMap model) {
    	
    	Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("edit", true);//指定页面显示 修改  按钮
        return "/animal/registration";
    }
     
    /*
     *执行更新动物信息
     */
    @RequestMapping(value = { "/edit-{id}-animal" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Animal animal, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {//验证用户数的信息
            return "/animal/registration";
        }
 
        animalService.updateAnimal(animal);
        
        model.addAttribute("success", "动物 " + animal.getKind()  + " 信息更新成功");
        return "/animal/success";
    }
 
    /*
     * 验证用户输入后，并用post方式提交员工信息到数据库。（保存数据到数据库）
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Animal animal, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {//验证接收到的信息是否有误
            return "/animal/registration";
        }
         
        animalService.saveAnimal(animal);//保存信息到数据库
 
        model.addAttribute("success", "动物 " + animal.getKind() + " 登记成功");
        return "/animal/success";
    }
    
    /*
     * 去 添加动物 页面
     */
    @RequestMapping(value = { "/new2" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("edit", false);
        return "/animal/registration";
    }
 
    /*
     * 这个方法将会显示所有存在的员工
     */
    @RequestMapping(value = {"/listAnimals" }, method = RequestMethod.GET)
    public String listAnimals(ModelMap model) {
 
        List<Animal> animals = animalService.findAllAnimals();
        model.addAttribute("animals", animals);//把数据放到页面
        return "/animal/allanimals";//指定返回到那个页面
    }
 
   
 
}
