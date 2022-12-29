package com.cruds.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sf;

	public User authenticate(String userId, String password) {
		
		Session session = sf.openSession();
		String hql = "from User u where u.userId = ? and u.password = ? ";
		
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery(hql).setString(0, userId).setString(1, password).list();
		System.out.println(list);
		
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

		
}


