package com.cruds.db;

import java.util.List;
import java.util.Date;

import com.cruds.entity.Student;

public interface StudentDAO {
	
	public void create(Student s);
	
	public List<Student> getAll();
	
	public Student edit(int rollno);
	
	public void update(Student s );
	
	public void delete(int rollno);

}
