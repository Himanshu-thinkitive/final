package com.thinkitive.Student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.Exam.Answer;
@Service
public class UseStudent {
	
	
	
	public Student registerStudent(Student s)
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(s);
		
		tx.commit();
		session.close();
       return s;
	}
	
	public String loginStudent(Student s)
	{
		String st="check student";
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		int val=s.getSid();
		Query query=session.createQuery("From Student where sid =:sid");
		query.setParameter("sid", val);
		List<Student> l=query.list();
        List a=new ArrayList<>();
		System.out.println(l);
		System.out.println(s.getName());
	
		for(Student s1:l)
		{
			System.out.println(s1.getName());
			if(s.getName().equalsIgnoreCase(s1.getName()))
			{
				st="authenticate";
			}
			else
			{
				st="not authenticate";
			}
			
		}
		
		
		
		System.out.println(st);
		tx.commit();
		session.close();
		return st;
		
	}
	
	

}
