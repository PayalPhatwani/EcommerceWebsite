package com.ecommerce.Dao;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.entities.User;

public class UserDao {
private SessionFactory factory;

public UserDao(SessionFactory factory) {
	this.factory= factory;	
}

//get user email and password
public User getUserByEmailAndPassword(String email,String Password) {
	User user = null;
	String query = "from User where userEmail =: e and userPassword =: p";
	Session session = this.factory.openSession();
	Query q = session.createQuery(query);
	q.setParameter("e", email);
	q.setParameter("p", Password);
	user = (User)(q).uniqueResult();
	
	session.close();
	return user;
}

//get user details by userId
public User getUserByUserId(int userId) {
	User user = null;
	String query = "from User where userId =: uId ";
	Session session = this.factory.openSession();
	Query q = session.createQuery(query);
	q.setParameter("uId", userId);
	user = (User)(q).uniqueResult();
	
	session.close();
	return user;
}

//Update User Details
public boolean updateProfile(User user) {
	Session session = this.factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
		Query q=session.createQuery("update User set userName=:n , userEmail=:e , userPhone=:p , userAddress=:a   where id=:i");  
		q.setParameter("n",user.getUserName()); 
		q.setParameter("e", user.getUserEmail());
		q.setParameter("p", user.getUserPhone());
		q.setParameter("a", user.getUserAddress());
		q.setParameter("i",user.getUserId());  
		  
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

//get all users 
public List<User> getAllUsers(){
	Session session = this.factory.openSession();
	List<User> userList=null;
	try {
		Query query = session.createQuery("from User");
		userList = query.list();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return userList;
}
}
