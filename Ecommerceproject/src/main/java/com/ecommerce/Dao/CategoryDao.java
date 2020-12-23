package com.ecommerce.Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.entities.Category;

public class CategoryDao {

	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		this.factory= factory;	
	}
	
	//saving category to database
	public int saveCategory(Category cat) {
		
		Session session = this.factory.openSession();
		Transaction tx = session.beginTransaction();
		
		int id = (int)session.save(cat);
		tx.commit();
		session.close();
		return id;
	}
	
	//getting all categories from database
	public List<Category> getAll(){
		Session session = this.factory.openSession();
		Query query = session.createQuery("from Category");
		
		List<Category> catogories = query.list();
		return catogories;
		
	}
	
	//getting one category By Id
	public Category getCategoryById(int cid) {
		Category cat = null;
		try {
		Session session = this.factory.openSession();
		cat = session.get(Category.class, cid);
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cat;
	}
	
	 //delete Category by id
	  public boolean deleteCategoryByid(int cId) {
		  ProductDao pd = new ProductDao(factory);
		  boolean productDeleted = pd.deleteProductByCid(cId);
		  System.out.println("productdeleted "+productDeleted);
		  if(productDeleted) {
		  Session s =this.factory.openSession(); 
		  Transaction tx = s.beginTransaction();
		  try {
			Query query = s.createQuery("delete from Category as c where c.categoryid =: cId");
			  query.setParameter("cId", cId);
			  System.out.println(query.executeUpdate());
			  
			  tx.commit();
			  return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			 return false;
		}
		  }else {
			  return false;
		  }
	  }
	  
	  //update category by id 
	  public boolean updateCategory(Category cat) {
		  Session session = this.factory.openSession();
		  Transaction tx = session.beginTransaction();
		  try {
				Query q=session.createQuery("update Category set categoryTitle=:t ,categoryDescription=:d    where id=:i");  
				q.setParameter("t", cat.getCategoryTitle());
				q.setParameter("d", cat.getCategoryDescription());
				q.setParameter("i", cat.getCategoryid());
				  
				int status=q.executeUpdate();  
				System.out.println(status);  
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	  }
}
