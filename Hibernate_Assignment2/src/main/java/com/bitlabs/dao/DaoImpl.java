package com.bitlabs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bitlabs.entity.Users;

public class DaoImpl implements Dao {

	SessionFactory sf=null;
	
	public DaoImpl() {
	
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	
	@Override
	public boolean addUser(Users user) {
		Session session=sf.openSession();
		Transaction txn=session.beginTransaction();
		session.save(user);
		
		txn.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean login(String uname, String pwd) {
        Session session=sf.openSession();
		List<Users> users=new ArrayList<Users>();
        Query query=session.createQuery("from Users where uname='"+uname+"' and password='"+pwd+"'");
               users=query.list();
               boolean b=false;
               if(users.size()!=0) {
            	   b=true;
               }
        
		session.close();
		
		
		return b;
	}

}
