package com.rahul.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    
    public static void main( String[] args )
    {
    	
    	AlienName an = new AlienName();
    	an.setFname("Rahul");
    	an.setLname("Shelke");
    	an.setMname("Laxman");
    	
        Alien telusko = new Alien();
        telusko.setAid(101);
   //     telusko.setColor("Green");
     //   telusko.setAname(an);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg); 
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        // fetch data from database using get method in hibernate
        //telusko = (Alien) session.get(Alien.class, 102);
        
        session.save(telusko);
        
        tx.commit();
        
        System.out.println(telusko);
        
        
           
    } 
}
