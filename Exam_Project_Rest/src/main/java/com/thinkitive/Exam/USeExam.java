package com.thinkitive.Exam;

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
public class USeExam {
	
	public void storeResult(Exam ex)
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(ex);
		
		tx.commit();
		session.close();
       

		
	}

	public List showAllStudentResult()
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("From Exam");
		List<Exam> l=query.list();
	    List<Object> a=new ArrayList<>();
		
		for(Exam e:l)
		{
		   String s=e.getStudentId();
		   String s2="student id: ";
		   String s1=s2+s;
		   a.add(s1);
		   String p="result is: "+e.getResult();
		   a.add(p);
		    
		}
		
		System.out.println(a);
		
		tx.commit();
		session.close();
		return a;
       

		
	}

}
