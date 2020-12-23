package com.ecommerce.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.entities.Product;

public class ProductDao {
	
	private SessionFactory factory;
	
	public ProductDao(SessionFactory factory) {
		this.factory=factory;
	}
	
	//storing product details into database
		public boolean addProduct(Product product) {
			boolean added=true;
			try {
				Session session = this.factory.openSession();
				Transaction tx = session.beginTransaction();
				 session.save(product);
				 tx.commit();
				 session.close();
				 return added=true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return added=false;
			}
		}
	
	
	  //get all Products
	  public List<Product> getAllProducts(){ 
		  Session s =this.factory.openSession(); 
		  Query query =s.createQuery("from Product");
		  List<Product> product123 = query.list();
	  return product123; 
	  }
	  
	//get all Products
	  public List<Product> getProductsByCid(int cid){ 
		  Session s =this.factory.openSession(); 
		  Query query =s.createQuery("from Product as p where p.category.categoryid =: id");
		  query.setParameter("id", cid);
		  List<Product> product123 = query.list();
	  return product123; 
	  }
	  
	  //delete Product by product Id
	  public boolean deleteProductByid(int pId) {
	
		  Session s =this.factory.openSession(); 
		  Transaction tx = s.beginTransaction();
		  try {
			Query query = s.createQuery("delete from Product as p where p.pId =: pId");
			  query.setParameter("pId", pId);
			  System.out.println(query.executeUpdate());
			  
			  tx.commit();
			  return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			 return false;
		}
		 
	  }
	  
	  //delete Product by category Id
	  public boolean deleteProductByCid(int cId) {
	
		  Session s =this.factory.openSession(); 
		  Transaction tx = s.beginTransaction();
		  try {
			Query query = s.createQuery("delete from Product as p where p.category.categoryid =: cId");
			  query.setParameter("cId", cId);
			  System.out.println(query.executeUpdate());  
			  tx.commit();
			  return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			 return false;
		}
		 
	  }
	 


}
