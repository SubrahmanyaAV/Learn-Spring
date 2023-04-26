package com.cruds.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.Student;

@Repository   // if annotation is not used here autowired(bean) will not be recognized
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sf;

	public void create(Student s) {

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();

	}

	public List<Student> getAll() {

		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) session.createQuery("from Student").list();
		return list;
	}

	public Student edit(int rollno) {

		Session session = sf.openSession();
		String hql = "from Student b where rollno = ? ";

		List<Student> list = session.createQuery(hql).setInteger(0, rollno).list();

		session.close();

		if(list.size() > 0)
		{
			return list.get(0);
		}
		else 
		{
			return null;
		}
	}

	public void update(Student b) {

		Session session = sf.openSession();
		session.beginTransaction();
		session.update(b);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(int rollno) {
		
		Session session = sf.openSession();
		session.getTransaction().begin();
		Student b = (Student) session.load(Student.class, rollno);
		
		session.delete(b);
		session.getTransaction().commit();
		session.close();
	}

}
