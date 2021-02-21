package com.thinkitive;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.Admin.Admin;
import com.thinkitive.Admin.UseAdmin;
import com.thinkitive.Exam.Answer;
import com.thinkitive.Exam.Exam;
import com.thinkitive.Exam.USeExam;
import com.thinkitive.Exam.UseAnswer;
import com.thinkitive.Question.UseQuestion;
import com.thinkitive.Student.Student;
import com.thinkitive.Student.UseStudent;
import com.thinkitive.Teacher.Teacher;
import com.thinkitive.Teacher.UseTeacher;
import com.thinkitive.Question.Question;


@RestController
public class MyController {
	
	
	
	Question q=new Question();
	@Autowired
	UseQuestion uq;
	
	@Autowired
	UseAnswer ua;
	
	
	@Autowired
	UseStudent us;
	@Autowired
	USeExam uex;
	@Autowired
	UseTeacher ut;

	@Autowired
	UseAdmin uad;
	
	
	String sq;
	//for student use
	//1
	@CrossOrigin(origins="http://localhost:8087")
	@GetMapping(value="/getQuestion/{i}")
	public List getQuestion(@PathVariable("i") Integer i)
	{
	
		String s="9425";
		System.out.println(s);
		
		if(s.equals(sq))
		{
			System.out.println("question no"+i);
			
			List x=uq.getQuestion(i);
			System.out.println(x.toString());
			
			return x;
		}
		else
		{
	return null;
		}
	}
	
	//2
	//developer use
	@CrossOrigin(origins="http://localhost:8087")
	@GetMapping(value="/FAnswer")
	public Answer ans()
	{
		
		Answer a=new Answer(2,"hima");
		return a;
		
	}
	
	//3
	//for testing
	@CrossOrigin(origins="http://localhost:8087")
	@PostMapping(value="/addAnswer")
	public Answer ans(@RequestBody Answer a)
	{
		System.out.println(a);
		ua.addAnswer(a);
		
		return a;
		
	}
	
	//4
	//for student
	@CrossOrigin(origins="http://localhost:8087")
	@PostMapping(value="/giveAnswer")
	public String giveAnswer(@RequestBody String s)
	{
		String s1="9425";
		
		System.out.println(s);
	
		
		if(s1.equalsIgnoreCase(sq))
		{
			
	    
		   char c=s.charAt(0);
		   int i=c;
		   i=i-48;
		   s=s.substring(2);
		   Answer a=new Answer(i,s);
	    	ua.addAnswer(a);
		//System.out.println("character is:"+i+"remaining string is :"+s);
		return s;
		}
		else
		{
			return null;
		}
		
	}
	
	int w=1;
	//5
	@CrossOrigin(origins="http://localhost:8087")
	@GetMapping(value="/showResult")
	public Integer ShowResult()
	{
        String s1="9425";
		

		if(s1.equalsIgnoreCase(sq))
	{
	     int a=ua.showResult();
	     String z=Integer.toString(a);
	   
	     String z1=Integer.toString(w);
	     
	     Exam ex=new Exam(a,z1,z);
	     
	     
	     uex.storeResult(ex);
		
		return a;
		}
		else
		{
			return null;
		} 
	}
	
	//6
	@CrossOrigin(origins="http://localhost:8087")
	@PostMapping(value="/registerStudent") 
	public Student registerStudent(@RequestBody Student s)
	{
		return us.registerStudent(s);
		
	}
	
	//7
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/FStudent") 
	public Student formatStudent()
	{
	   
		Student s=new Student(1,"Himanshu");
		return s;
		
	}
   
	//8
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/loginStudent") 
   public String loginStudent(@RequestBody Student s)
   {
	    String st="check user";
	    System.out.println(s);
	   st= us.loginStudent(s);
	   int x=s.getSid();
	   if(st.equalsIgnoreCase("authenticate"))
	   {
		   sq="9425";
		   w=x;
		   System.out.println(x);
	   }
	   
	   System.out.println( st);
	    return st;
	    
   }
   
	//9
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/logoutStudent") 
   public String logoutStudent()
   {
	 
		sq="0";
	   ua.dropTable();
	   return "Student logged out";
   }
   
   //10
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/FTeacher")
   public Teacher formatTeacher()
   {
	   Teacher t=new Teacher(1,"Rakesh");
	   return t;
   }
   
	//11
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/registerTeacher")
   public String registerTeacher(@RequestBody Teacher t)
   {
	   return ut.registerTeacher(t);
   }
   
	String sw;
	
	//12
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/loginTeacher")
   public String loginTeacher(@RequestBody Teacher t)
   {
	   String st="check teacher";
	   System.out.println(st);
	   System.out.println("in my controller");
	   System.out.println("in my controller");
	   System.out.println("in my controller");
	   System.out.println("in my controller");
	   
	   System.out.println("value of in mycontroller:  "+t);
	   st=ut.loginTeacher(t);
	   if(st.equalsIgnoreCase("authenticate"))
	   {
		  
		   sw="1234";
		   
		   
		
		 
	   }
	   
	   return st;
   }
   
	//13
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/addQuestion")
	public String addQuestion(@RequestBody Question q)
	{
		String b="1234";
		  try
		  {
		  if(b.equalsIgnoreCase(sw))
		  {
		uq.addQuestion(q);
		return "question added successfully";
		  }  
		  } 
		  catch(NullPointerException e)
		  {
			  return "not added successfully";
		  }
		  return "not added successfully";
		
	}
	
   //14
	//developer use
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/FQuestion")
	public Question getFormatForQuestionAdd()
	{
		
		Question q=new Question(1,"Green","parrot color is","yellow","green","blue","sky blue");
		return q;
		
	}
   
   //15
	@CrossOrigin(origins="http://localhost:8087")
	@PostMapping(value="/removeQuestion")
   public String removeQuestion(@RequestBody  Question q)
   {
	   System.out.println(q);
	   String b="1234";
		  System.out.println("value 0f b"+b);
		  try {
		  if(sw.equalsIgnoreCase(b))
		  {
			  System.out.println("in if");
			  uq.removeQuestion(q);
			   return "question removed";
		}
		  }
		  catch(NullPointerException e)
		  {
		  
		  return "not removed";
		  }
		
		  return "check question";
   }
   
	//16
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/allStudentResult")
   public List allStudentResult()
   {
	   String b="1234";
		  try
		  {
		  if(sw.equalsIgnoreCase(b))
		  {
			  uq.removeQuestion(q);
			  return uex.showAllStudentResult();
			  
		}
		  }
		  catch(NullPointerException r)
		  {
			  return null;
		  }
		return null;
		  
		 
		
	   
	   
	  
   }
   
   //17
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/logoutTeacher")
   public String logOutTeacher()
   {
		sw="0";
	   return "logged out successfully"; 
   }
   
   //18
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/registerAdmin")
   public Admin registerAdmin(@RequestBody Admin a)
   {
	   uad.addAdmin(a);
	   
	   return a;
	   
   }
   
   //19
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/FAdmin")
   public Admin registerin()
   {
	   Admin a=new Admin(10,"parag");
	   
	   return a;
	   
   }
   
	//20
	@CrossOrigin(origins="http://localhost:8087")
   @PostMapping(value="/loginAdmin")
   public String loginAdmin(@RequestBody Admin a)
   {
	   String s=uad.loginAdmin(a);
	   if(s.equalsIgnoreCase("authenticate"))
	   {
		   sq="9425";
		   sw="1234";
	
		  
	 }
	
	   return s;
   }
  
	//21
	@CrossOrigin(origins="http://localhost:8087")
   @GetMapping(value="/logoutAdmin")
   public String logoutAdmin()
   {
		
		 sq="0";
		   sw="0";
	   return "admin logged out";
   }
}




