package com.rahul.DemoHibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class FetchingDataTechnique {
	public static void main(String[] args) {
		

		
		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
	    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	    Session session = sf.openSession();
	        
	    session.beginTransaction();
	    
	    Alien a1 = (Alien) session.get(Alien.class, 1);
	    
	    System.out.println(a1.getAname());
	    
//	    Collection<Laptop> laps = a1.getLaps();
//	    for(Laptop l : laps) {
//	    	System.out.println(l);
//	    }
	
	    
	  
	    session.getTransaction().commit();
		
	}

}
