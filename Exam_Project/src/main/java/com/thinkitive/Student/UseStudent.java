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
		List l=query.list();
        List a=new ArrayList<>();
		
		if(l.equals(a))
		{
		
			st="not authenticate";
			
		}
		else
		{
			st="authenticate";
		}
		/*Query query=session.createQuery("From Student");
		List l=query.list();
		
		for(int i=0;i<l.size();i++)
		{
			
			Student s1=(Student) l.get(i);
			if(s1.getSid()==s.getSid() )
			{
				
				if(s1.getName().equalsIgnoreCase(s.getName() ) )
				{
					System.out.println("in neste if");
				st="authenticate";
				}
				//session=request.getSession();
				
			}
			else
			{
				st="not authenticate";
			}*/
	
		
		tx.commit();
		session.close();

		return st;
		
	}
	
	

}
