package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.db.StudentDAO;
import com.cruds.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO dao;
	
	public void create(Student s)
	{
		dao.create(s);
	}
	
	public List<Student> getAll()
	{
		return dao.getAll();
	}
	
	public Student edit(int rollno)
	{
		return dao.edit(rollno);
	}
	
	public void update(Student s)
	{
		 dao.update(s);
	}

	public void delete(int rollno)
	{
		dao.delete(rollno);
	}

}
