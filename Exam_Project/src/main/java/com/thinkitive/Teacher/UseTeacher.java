package com.thinkitive.Teacher;

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
public class UseTeacher {
	
	public String registerTeacher(Teacher t)
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(t);
		
		tx.commit();
		session.close();

		return "teacher registered";
	}
	
	public String loginTeacher(Teacher t)
	{
		String st="check teacher";
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		String str ="from Teacher where tid = :tid";
		Query q=session.createQuery(str);
		int id=t.getTid();
		q.setParameter("tid",id);
		
		List l=q.list();
		List a=new ArrayList<>();
		
		if(l.equals(a))
		{
		
			st="not authenticate teacher";
			
		}
		else
		{
			st="authenticate";
		}
		System.out.println(l);
		System.out.println(a);
		
		tx.commit();
		session.close();

		
		return st;
		
	}
	


}
