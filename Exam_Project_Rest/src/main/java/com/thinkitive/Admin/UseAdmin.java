package com.thinkitive.Admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.thinkitive.Student.Student;


@Service
public class UseAdmin {
	
	public void addAdmin(Admin a)
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(a);
		
		tx.commit();
		session.close();

	}

	public String loginAdmin(Admin a)
	{
		String st="check Admin";
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		int val=a.getAid();
		Query query=session.createQuery("From Admin where aid =:aid");
		query.setParameter("aid", val);
		List<Admin> l=query.list();
        List a1=new ArrayList<>();
        
        System.out.println(a.getAdminName());
    	for(Admin s1:l)
		{
			System.out.println(s1.getAdminName());
			if(a.getAdminName().equalsIgnoreCase(s1.getAdminName()))
			{
				st="authenticate";
			}
			else
			{
				st="not authenticate";
			}
			
		}
	
		
		
	System.out.println(l);
		
		tx.commit();
		session.close();

		return st;
		
	}


}
