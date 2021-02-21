package com.thinkitive.Question;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.thinkitive.Question.Question;

@Service
public class UseQuestion {
	
	
	public void addQuestion(Question q)
	{
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(q);
		
		tx.commit();
		session.close();

	}

	public List getQuestion(Integer id)
	{
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		
        Query query2 = session.createQuery("From Question");
		List<Query> l=query2.list();
		List a=new ArrayList<>();
		for(int i=0;i<l.size();i++)
		{
			
			Question q=(Question) l.get(i);
			
			
				if(q.getQid() ==id)
			{
				a.add(q.getQuestions());
				a.add(q.getOption1());
				a.add(q.getOption2());
				a.add(q.getOption3());
				a.add(q.getOption4());
				
				
			}
				
		}
		
	
		tx.commit();
		session.close();
	
		
		return a;

	}
	
	public void removeQuestion(Question q)
	{
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.remove(q);
		
		tx.commit();
		session.close();

	}

}
