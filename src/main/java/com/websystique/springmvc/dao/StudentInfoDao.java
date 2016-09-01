package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.StudentInfo;
 
public interface StudentInfoDao {
 
    StudentInfo findById(int id);
 
    void saveStudentInfo(StudentInfo studentInfo);
     
    void deleteStudentInfoById(int id);
     
    List<StudentInfo> findAllStudentInfo();
 
    StudentInfo findStudentInfoById(int id);
    
    StudentInfo findStudentInfoByName(String name);
 
}
