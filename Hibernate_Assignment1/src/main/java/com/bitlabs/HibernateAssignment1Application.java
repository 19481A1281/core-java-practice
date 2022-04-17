package com.bitlabs;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bitlabs.dao.Dao;
import com.bitlabs.dao.DaoImpl;
import com.bitlabs.entity.Product;

@SpringBootApplication
public class HibernateAssignment1Application {

	Product p=new Product();
	Dao dao=new DaoImpl();
	
	Scanner s=new Scanner(System.in);
	public void addProduct() {
		System.out.println("Enter product name, pprice and product qty");
		p.setProduct_name(s.next());
		p.setProduct_price(s.nextDouble());
		p.setProduct_qty(s.nextInt());
		boolean b=dao.addProduct(p);
		if(b) {
			System.out.println("Product details added sucessfully");
		}
		else {
			System.out.println("Failed in adding product details");
		}
	}
	public void deleteProduct() {
		System.out.println("Enter product id");
		int pid=s.nextInt();
		boolean b=dao.deleteProduct(pid);
		if(b) {
			System.out.println("Product details deleted sucessfully");
		}
		else {
			System.out.println("Failed in product deletion");
		}
	}
	public void getProductByPname() {
		System.out.println("Enter Product name");
		String pname=s.next();
		List<Product> list=dao.getProductByName(pname);
		
		for(Product p:list) {
			System.out.println("Pid :"+p.getProduct_id());
			System.out.println("Pname :"+p.getProduct_name());
			System.out.println("Pprice :"+p.getProduct_price());
			System.out.println("Pqty :"+p.getProduct_qty());
			
		}
		
	}
    public void getAllProducts() {
         List<Product> list=dao.getAll();
		
		for(Product p:list) {
			System.out.println("Pid :"+p.getProduct_id());
			System.out.println("Pname :"+p.getProduct_name());
			System.out.println("Pprice :"+p.getProduct_price());
			System.out.println("Pqty :"+p.getProduct_qty());
			
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateAssignment1Application.class, args);
	
		HibernateAssignment1Application obj=new HibernateAssignment1Application();
		Scanner s=new Scanner(System.in);
		System.out.println("1. Add product");
		System.out.println("2. Delete product");
		System.out.println("3. Search product by Product name");
		System.out.println("4. Result all products");
		System.out.println("Choose your option");
		int option=s.nextInt();
		
		if(option==1) {
			obj.addProduct();
		}
		else if(option==2) {
			obj.deleteProduct();
		}
        else if(option==3) {
			obj.getProductByPname();
		}
       else if(option==4) {
	         obj.getAllProducts();
        }
       else {
    	   System.out.println("Invalid option");
       }
	
	}

}
