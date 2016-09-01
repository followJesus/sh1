package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Employee;
 
public interface EmployeeDao {
 
    Employee findById(int id);
 
    void saveEmployee(Employee employee);
     
    /**
     * @param ssn 删除这条员工信息
     */
    void deleteEmployeeBySsn(String ssn);
     
    List<Employee> findAllEmployees();
 
    /**
     * @param ssn
     * @return 根据SSN号码查询该员工信息
     */
    Employee findEmployeeBySsn(String ssn);
 
}
