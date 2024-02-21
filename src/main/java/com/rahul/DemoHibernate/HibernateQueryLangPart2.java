package com.rahul.DemoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//we are using hibernate query language (hql) 
public class HibernateQueryLangPart2 {
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class);
	    ServiceRegistry 
	    reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    SessionFactory sf = con.buildSessionFactory(reg); 
	   
	    Session session = sf.openSession();
	    session.beginTransaction();
	    int b = 60;
	    
	    Query q = session.createQuery("select rollno ,name,marks from Student1 s where s.marks>60");
	    List<Object[]> students = (List<Object[]>)q.list();
	    
	    
	    for(Object[] student : students) {
	    	System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
	    }
	    
	    Query q1 = session.createQuery("select sum(marks) from Student1 s where s.marks> :b");
	    q1.setParameter("b", b);
	    
	    Long marks = (Long) q1.uniqueResult();
	    
	    System.out.println(marks);
	    
//	    for(Object o : student) {
//	    	System.out.println(o);
//	    }
//	    
	    
	    session.getTransaction().commit();
	}
	

}
