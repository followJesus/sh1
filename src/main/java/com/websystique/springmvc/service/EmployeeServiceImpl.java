package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.EmployeeDao;
import com.websystique.springmvc.model.Employee;
 
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired 
    private EmployeeDao dao;
     
    public Employee findById(int id) {
        return dao.findById(id);
    }
 
    /* (non-Javadoc)保存信息到数据库
     * @see com.websystique.springmvc.service.EmployeeService#saveEmployee(com.websystique.springmvc.model.Employee)
     */
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
 
    /*
     * 更新实体类后，数据库中也会更新
     */
    public void updateEmployee(Employee employee) {
        Employee entity = dao.findById(employee.getId());//根据员工id获取员工信息
        if(entity!=null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setSsn(employee.getSsn());
        }
    }
 
    /* (non-Javadoc)删除这条员工信息
     * @see com.websystique.springmvc.service.EmployeeService#deleteEmployeeBySsn(java.lang.String)
     */
    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }
     
    /* (non-Javadoc)这个方法将会显示所有存在的员工
     * @see com.websystique.springmvc.service.EmployeeService#findAllEmployees()
     */
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }
 
    /* (non-Javadoc)根据SSN号码查询该员工信息
     * @see com.websystique.springmvc.service.EmployeeService#findEmployeeBySsn(java.lang.String)
     */
    public Employee findEmployeeBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }
 
    /* (non-Javadoc)验证身份证号码是否重复?
     * @see com.websystique.springmvc.service.EmployeeService#isEmployeeSsnUnique(java.lang.Integer, java.lang.String)
     */
    public boolean isEmployeeSsnUnique(Integer id, String ssn) {//存在 false,不存在 true
        Employee employee = findEmployeeBySsn(ssn);//根据身份证号码查询该员工信息
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }
     
}