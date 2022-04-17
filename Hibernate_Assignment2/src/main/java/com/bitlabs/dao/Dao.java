package com.bitlabs.dao;

import com.bitlabs.entity.Users;

public interface Dao {

	public boolean addUser(Users user);
	public boolean login(String uname, String pwd);
	
}
