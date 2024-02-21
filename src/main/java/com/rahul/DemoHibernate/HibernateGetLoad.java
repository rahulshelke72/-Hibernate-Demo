package com.rahul.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateGetLoad {
       public static void main(String[] args) {
    	   
   		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop1.class);
	    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    // get gives actual Object
	    // get gives null if certain record not found
	    Laptop1 lap = (Laptop1) session.get(Laptop1.class,201);
	    System.out.println(lap);
	    
	    // load will give you Proxy Object 
	    // load throws exception if record not found 
	    Laptop1 lap1 = (Laptop1) session.load(Laptop1.class,201); 
	    System.out.println(lap1);
	    
	    
	    
	    session.getTransaction().commit();
	}
}
