package com.thinkitive.Exam;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.thinkitive.Question.Question;

@Service
public class UseAnswer {
	
	public void addAnswer(Answer a)
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Answer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
		session.save(a);
		
		tx.commit();
		session.close();

	}

	public Integer showResult()
	{
		int result=0;
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Answer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
	    
		 Query query1 = session.createQuery("From Answer");
			List<Query> result1=query1.list();
			
			Query query2 = session.createQuery("From Question");
			List<Query> result2=query2.list();
		
			for(int i=0;i<result1.size();i++)
			{
				Answer a=(Answer) result1.get(i);
				
				for(int j=0;j<result2.size();j++)
				{
					Question q=(Question) result2.get(j);
					if(a.getAnsId()==q.getQid() && a.getAns().equalsIgnoreCase(q.getCorrectAnswer()))
					{
						result++;
					}
				}
			} 
		
		
		tx.commit();
		session.close();
		return result;

	}
	
	public void dropTable()
	{
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Answer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession(); 

		Transaction tx = session.beginTransaction();
		
	
		//Query query=session.createQuery("drop table Answer");
	//	SQLQuery query = session.createSQLQuery("drop table xyz"); 
		session.createQuery("delete com.thinkitive.Exam.Answer").executeUpdate();
		tx.commit();
		session.close();

	}

}
