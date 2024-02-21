package com.rahul.DemoHibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



// we use sql query to fetch data 
public class HibernateQueryLangPart3 {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class);
	    ServiceRegistry 
	    reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    // Native Queries
	    // we are fetching entire row 
	    SQLQuery query = session.createSQLQuery("select * from student where marks > 60");
	    query.addEntity(Student1.class);
	    List<Student1> students = query.list();
	    
	    for(Student1 o : students) {
	    	System.out.println(o);
	    }
	    
	    // Not fetching entire row only few entries 
	    SQLQuery query2 = session.createSQLQuery("select name,marks from student where marks > 60");
	    query2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List stud =  query2.list();
	    
	    for(Object o : stud) {
	    	
	    	//System.out.println(o);
	    	Map m = (Map) o;
	    	System.out.println(m.get("name")+" : "+m.get("marks"));
	    }
	    
	    
	    
	    session.getTransaction().commit();
		
	}

}
