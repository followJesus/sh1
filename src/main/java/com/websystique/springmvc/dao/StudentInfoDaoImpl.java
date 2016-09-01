package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.StudentInfo;

@Repository("studentInfoDao")
public class StudentInfoDaoImpl extends AbstractDao<Integer, StudentInfo> implements StudentInfoDao {

	public StudentInfo findById(int id) {
		return getByKey(id);
	}

	public void saveStudentInfo(StudentInfo studentInfo) {
		persist(studentInfo);

	}

	/* (non-Javadoc)
	 * @see com.websystique.springmvc.dao.StudentInfoDao#deleteStudentInfoById(int)
	 */
	public void deleteStudentInfoById(int id) {
		Query query = getSession().createSQLQuery("delete from student_info where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	/* (non-Javadoc)查看所有学生
	 * @see com.websystique.springmvc.dao.StudentInfoDao#findAllStudentInfo()
	 */
	@SuppressWarnings("unchecked")
	public List<StudentInfo> findAllStudentInfo() {
		Criteria criteria = createEntityCriteria();
		return (List<StudentInfo>) criteria.list();
	}

	/* (non-Javadoc)根据学生id查询学生信息
	 * @see com.websystique.springmvc.dao.StudentInfoDao#findStudentInfoById(int)
	 */
	public StudentInfo findStudentInfoById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (StudentInfo) criteria.uniqueResult();
	}

	/* (non-Javadoc) 查看用户名是否重复
	 * @see com.websystique.springmvc.dao.StudentInfoDao#findStudentInfoByName(java.lang.String)
	 */
	public StudentInfo findStudentInfoByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (StudentInfo) criteria.uniqueResult();
	}

}
