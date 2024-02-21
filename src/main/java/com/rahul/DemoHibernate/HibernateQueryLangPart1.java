package com.rahul.DemoHibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// we are using hibernate query language (hql) 
public class HibernateQueryLangPart1 {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class);
	    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    Query q = session.createQuery("from Student1 where  rollno=7");
	    
	    
	    Student1 student = (Student1) q.uniqueResult();
	    
	    System.out.println(student);
	    
//	    for(Student1 s : lst) {
//	    	System.out.println(s);
//	    }
	    
	    
	    session.getTransaction().commit();
	}

}
