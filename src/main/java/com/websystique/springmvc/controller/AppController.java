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

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.service.EmployeeService;
 
@Controller
@RequestMapping("/AppController")
public class AppController {//action
 
    @Autowired
    EmployeeService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * 这个方法将会显示所有存在的员工
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<Employee> employees = service.findAllEmployees();//获取员工列表
        model.addAttribute("employees", employees);//把数据放到页面
        return "allemployees";//指定返回到那个页面
    }
 
    /*
     * 去 添加新员工 页面
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * 验证用户输入后，并用post方式提交员工信息到数据库。（保存数据到数据库）
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {//验证接收到的信息是否有误
            return "registration";
        }
 
       //验证身份证号码是否重复?
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){//存在 false,不存在 true
//        	如果身份证号码已存在，提示错误信息
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
         
        service.saveEmployee(employee);//保存信息到数据库
 
        model.addAttribute("success", "员工 " + employee.getName() + " 登记成功");
        return "success";
    }
 
 
    /*
     * 去 更新员工页面
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);//根据SSN号码查询该员工信息
        model.addAttribute("employee", employee);//把查询到的员工信息放到页面
        model.addAttribute("edit", true);//指定页面显示 修改  按钮
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {//验证用户数的信息
            return "registration";
        }
 
//        检查身份证号码是否重复？
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
 
        service.updateEmployee(employee);//执行员工的数据更新
        
 
        model.addAttribute("success", "员工 " + employee.getName()  + " 信息更新成功");
        return "success";
    }
 
     
    /*
     * 这个方法将会根据员工的SSN号码，删除这条员工信息
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";//重定向
    }
 
}
