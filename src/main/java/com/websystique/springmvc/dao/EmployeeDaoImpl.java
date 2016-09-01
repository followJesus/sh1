package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.websystique.springmvc.model.Employee;
 
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
    /* (non-Javadoc) 根据员工id获取员工信息
     * @see com.websystique.springmvc.dao.EmployeeDao#findById(int)
     */
    public Employee findById(int id) {
        return getByKey(id);
    }
 
    /* (non-Javadoc)保存信息到数据库
     * @see com.websystique.springmvc.dao.EmployeeDao#saveEmployee(com.websystique.springmvc.model.Employee)
     */
    public void saveEmployee(Employee employee) {
        persist(employee);
    }
 
    /* (non-Javadoc)删除这条员工信息
     * @see com.websystique.springmvc.dao.EmployeeDao#deleteEmployeeBySsn(java.lang.String)
     */
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    /* (non-Javadoc)这个方法将会显示所有存在的员工
     * @see com.websystique.springmvc.dao.EmployeeDao#findAllEmployees()
     */
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();//存放客户提交的信息
        return (List<Employee>) criteria.list();//指定格式获取信息
    }
 
    /* (non-Javadoc)根据SSN号码查询该员工信息
     * @see com.websystique.springmvc.dao.EmployeeDao#findEmployeeBySsn(java.lang.String)
     */
    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();//存放客户提交的信息
        criteria.add(Restrictions.eq("ssn", ssn));//添加查询条件
        return (Employee) criteria.uniqueResult();//查询符合上面条件的相关信息
    }
}
