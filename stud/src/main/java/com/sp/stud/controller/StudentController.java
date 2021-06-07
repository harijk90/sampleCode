package com.sp.stud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.stud.model.*;
import com.sp.stud.util.MapperUtil;
import com.sp.stud.dao.StudentRepositary;

@RestController(value="/Student")
public class StudentController {

	@Autowired
	StudentRepositary studentrepo; 
	
	@RequestMapping(value = "/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentModel> getAllStudents() {
		List<StudentModel> studentList=MapperUtil.getStudentModelFromEntity(studentrepo.findAll());
		return studentList;
	}

	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public StudentModel addStudent(StudentModel request) {
		  studentrepo.save(MapperUtil.getEntityBean(request));	
	return request;
	}

}