package com.cruds.db;

import com.cruds.entity.User;

public interface UserDAO {
	
	public User authenticate(String userId,String password);

}
