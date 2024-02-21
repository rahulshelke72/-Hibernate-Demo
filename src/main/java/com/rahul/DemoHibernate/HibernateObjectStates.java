package com.rahul.DemoHibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// Hibernate Object States / Persistence Life Cycle Practical 
public class HibernateObjectStates {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop1.class);
	    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session = sf.openSession();
	    session.beginTransaction();
	    Random r= new Random();
	    
	   
		    Laptop1 lap = new Laptop1();
		    lap.setLid(52);
		    lap.setBrand("Lenovo");
		    lap.setPrice(800);
		    
		    session.save(lap); // persistent state
	        lap.setPrice(750);
	        
	        session.delete(lap); 
	      
	    
	        session.getTransaction().commit();
	        
	        session.evict(lap);
	        lap.setPrice(600);
	    
	}

}
