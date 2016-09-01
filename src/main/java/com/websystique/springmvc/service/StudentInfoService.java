package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.StudentInfo;


public interface StudentInfoService {

	StudentInfo findById(int id);

	void saveStudentInfo(StudentInfo studentInfo);

	void deleteStudentInfoById(int id);

	List<StudentInfo> findAllStudentInfo();

	StudentInfo findStudentInfoById(int id);

	void updateStudentInfo(StudentInfo studentInfo);

	boolean isStudentInfoIdUnique(String name);

	}
