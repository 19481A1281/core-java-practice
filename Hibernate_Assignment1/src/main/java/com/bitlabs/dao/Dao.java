package com.bitlabs.dao;

import java.util.List;

import com.bitlabs.entity.Product;

public interface Dao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(int pid);
	public List<Product> getProductByName(String pname);
	public List<Product> getAll();
}
