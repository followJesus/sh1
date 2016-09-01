package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.StudentInfoDao;
import com.websystique.springmvc.model.StudentInfo;
 
@Service("studentInfoService")
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {
 
    @Autowired
    private StudentInfoDao dao;
     
    public StudentInfo findById(int id) {
        return dao.findById(id);
    }
 
    public void saveStudentInfo(StudentInfo studentInfo) {
		dao.saveStudentInfo(studentInfo);
	}
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateStudentInfo(StudentInfo studentInfo) {
		StudentInfo entity = dao.findById(studentInfo.getId());
        if(entity!=null){
            entity.setName(studentInfo.getName());
            entity.setJoiningDate(studentInfo.getJoiningDate());
            entity.setAge(studentInfo.getAge());
            entity.setSex(studentInfo.getSex());
        }
	}

	public void deleteStudentInfoById(int id) {
		dao.deleteStudentInfoById(id);
	}

	public List<StudentInfo> findAllStudentInfo() {
		return dao.findAllStudentInfo();
	}

	public StudentInfo findStudentInfoById(int id) {
		return dao.findStudentInfoById(id);
	}


	/* (non-Javadoc)检查学生姓名是否重复
	 * @see com.websystique.springmvc.service.StudentInfoService#isStudentInfoIdUnique(java.lang.String)
	 */
	public boolean isStudentInfoIdUnique(String name) {
		StudentInfo studentInfo = dao.findStudentInfoByName(name);
		return studentInfo == null;
	}
 
}