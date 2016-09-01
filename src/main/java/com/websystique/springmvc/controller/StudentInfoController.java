package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.StudentInfo;
import com.websystique.springmvc.service.StudentInfoService;
 
@Controller
@RequestMapping("/stc")
public class StudentInfoController {
	
    @Autowired
    StudentInfoService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<StudentInfo> studentInfos = service.findAllStudentInfo();
        model.addAttribute("studentInfos", studentInfos);
        return "/student/allstudentInfos";
    }
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
    	StudentInfo studentInfo = new StudentInfo();
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("edit", false);
        return "/student/registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid StudentInfo studentInfo, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "/student/registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isStudentInfoIdUnique(studentInfo.getName())){
            FieldError ssnError =new FieldError("studentInfo","name",messageSource.getMessage("non.unique.name", new String[]{studentInfo.getName()}, Locale.getDefault()));
            result.addError(ssnError);
            return "/student/registration";
        }
         
        service.saveStudentInfo(studentInfo);
 
        model.addAttribute("success", "学生 " + studentInfo.getName() + " 登记成功");
        return "/student/success";
    }
 
 
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{id}-studentInfo" }, method = RequestMethod.GET)
    public String editStudentInfo(@PathVariable int id, ModelMap model) {
        StudentInfo studentInfo = service.findStudentInfoById(id);
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("edit", true);
        return "/student/registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-studentInfo" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid StudentInfo studentInfo, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "/student/registration";
        }
 
     if(!service.isStudentInfoIdUnique(studentInfo.getName())){
        FieldError ssnError =new FieldError("studentInfo","name",messageSource.getMessage("non.unique.name", new String[]{studentInfo.getName()}, Locale.getDefault()));
        result.addError(ssnError);
        return "/student/registration";
    }
 
        service.updateStudentInfo(studentInfo);
 
        model.addAttribute("success", "员工 " + studentInfo.getName()  + " 信息更新成功");
        return "/student/success";
    }
 
     
    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{id}-studentInfo" }, method = RequestMethod.GET)
    public String deleteStudentInfo(@PathVariable int id) {
        service.deleteStudentInfoById(id);
        return "redirect:/stc/list";
    }
 
}
