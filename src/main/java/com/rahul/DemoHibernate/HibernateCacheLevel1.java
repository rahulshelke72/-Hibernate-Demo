package com.rahul.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// first level cache within the same session
// second level cache within different session
// in second level cache if one session already fired query then if second session
// want to fire same query then it gets data from first session not fires separate query
public class HibernateCacheLevel1 {
	public static void main(String[] args) {
		
		AlienTable a= null;
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(AlienTable.class);
	    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session1 = sf.openSession();
	    session1.beginTransaction();
	    
	    a = (AlienTable) session1.get(AlienTable.class, 101);
	    System.out.println(a);
	    
	    session1.getTransaction().commit();
        session1.close();
	    
	    Session session2 = sf.openSession();
	    session2.beginTransaction();
	    
	    a = (AlienTable) session2.get(AlienTable.class, 101);
	    System.out.println(a);
	    
	    session2.getTransaction().commit();
        session2.close();
	    
        
	    
	    
	    
	}

}
