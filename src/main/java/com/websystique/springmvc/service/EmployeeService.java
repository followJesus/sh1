package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Employee;
 
public interface EmployeeService {
 
    Employee findById(int id);
     
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    /**
     * @param ssn 删除这条员工信息
     */ 
    void deleteEmployeeBySsn(String ssn);
 
    /**
     * @return 这个方法将会显示所有存在的员工
     */
    List<Employee> findAllEmployees();
     
    /**
     * @param ssn
     * @return 根据SSN号码查询该员工信息
     */
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);
     
}
