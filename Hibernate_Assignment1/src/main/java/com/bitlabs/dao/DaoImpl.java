package com.bitlabs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bitlabs.entity.Product;

public class DaoImpl implements Dao{

	SessionFactory sf=null;
	public DaoImpl() {

		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	 }
	
	@Override
	public boolean addProduct(Product product) {
		Session session=sf.openSession();
		Transaction txn=session.beginTransaction();
		session.save(product);
		txn.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteProduct(int pid) {
	Session session=sf.openSession();
	Transaction txn=session.beginTransaction();
	
	   Product p=session.get(Product.class, pid);
	   session.delete(p);
	
	txn.commit();
		session.close();
		return true;
	}

	@Override
	public List<Product> getProductByName(String pname) {
	Session session=sf.openSession();
	List<Product> list=new ArrayList<Product>();	
	Query query=session.createQuery("from Product where product_name='"+pname+"'");
		list=query.list();
	session.close();
		return list;
	}

	@Override
	public List<Product> getAll() {
		Session session=sf.openSession();
		List<Product> list=new ArrayList<Product>();	
		Query query=session.createQuery("from Product");
			list=query.list();
		session.close();
			return list;
	}
	

}
