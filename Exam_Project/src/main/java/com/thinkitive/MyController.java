package com.thinkitive;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	HttpSession session;//=request.getSession();
	
	
	Question q=new Question();
	@Autowired
	UseQuestion uq;//=new UseQuestion();
	
//	Answer a=new Answer();
	@Autowired
	UseAnswer ua;//=new UseAnswer();
	
	//Student s=new Student();
	@Autowired
	UseStudent us;//=new UseStudent();
	@Autowired
	USeExam uex;//=new USeExam();
	@Autowired
	UseTeacher ut;//=new UseTeacher();

	@Autowired
	UseAdmin uad;
	
	
	//for student use
	
	@GetMapping(value="/getQuestion")
	public List getQuestion(@RequestBody Integer i)
	{
		
		String s="9425";
		//System.out.println(s);
		String a=(String) session.getValue("sessionkey");
		
	//	System.out.println("in get question :"+a);
		if(s.equals(a))
		{
			List x=uq.getQuestion(i);
			
			return x;
		}
		else
		{
		return null;
		}
	}
	
	
	//developer use
	@GetMapping(value="/FAnswer")
	public Answer ans()
	{
		
		Answer a=new Answer(2,"hima");
		return a;
		
	}
	
	//for testing
	@PostMapping(value="/addAnswer")
	public Answer ans(@RequestBody Answer a)
	{
		System.out.println(a);
		ua.addAnswer(a);
		
		return a;
		
	}
	
	//for student
	@PostMapping(value="/giveAnswer")
	public String giveAnswer(@RequestBody String s)
	{
		String s1="9425";
		
		String a1=(String) session.getValue("sessionkey");
		
		if(s1.equalsIgnoreCase(a1))
		{
			
	    	s=s.substring(1,s.length()-1);
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
	
	
	@GetMapping(value="/showResult")
	public Integer ShowResult()
	{
        String s1="9425";
		
		String a1=(String) session.getValue("sessionkey");
		if(s1.equalsIgnoreCase(a1))
		{
	     int a=ua.showResult();
	     String z=Integer.toString(a);
	     int w= (int) session.getValue("studentId");
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
	
	@PostMapping(value="/registerStudent") 
	public Student registerStudent(@RequestBody Student s)
	{
		return us.registerStudent(s);
		
	}
	
   @GetMapping(value="/FStudent") 
	public Student formatStudent()
	{
	   
		Student s=new Student(1,"Himanshu");
		return s;
		
	}
   
   @PostMapping(value="/loginStudent") 
   public String loginStudent(@RequestBody Student s)
   {
	    String st="check user";
	    
	   st= us.loginStudent(s);
	   int x=s.getSid();
	   if(st.equalsIgnoreCase("authenticate"))
	   {
		 
		   session.setAttribute("sessionkey","9425");
		   session.setAttribute("studentId", x);
		   
		  String a=(String) session.getValue("sessionkey");
		  System.out.println("in login"+session.getValue("studentId"));
		  System.out.println("in login of student"+a);
	   }
	   
	    return st;
	    
   }
   
   @GetMapping(value="/logoutStudent") 
   public String logoutStudent()
   {
	   session.invalidate();
	   ua.dropTable();
	   return "Student logged out";
   }
   
   
   
   @GetMapping(value="/FTeacher")
   public Teacher formatTeacher()
   {
	   Teacher t=new Teacher(1,"Rakesh");
	   return t;
   }
   
   @GetMapping(value="/registerTeacher")
   public String registerTeacher(@RequestBody Teacher t)
   {
	   return ut.registerTeacher(t);
   }
   
   @PostMapping(value="/loginTeacher")
   public String loginTeacher(@RequestBody Teacher t)
   {
	   String st="check teacher";
	   st=ut.loginTeacher(t);
	   if(st.equalsIgnoreCase("authenticate"))
	   {
		   session.setAttribute("sessionk","1234");
		  
		   
		  String a=(String) session.getValue("sessionk");
		  
		  System.out.println("in login value of a"+a);
		  
		   
		   
		   
		
		 
	   }
	   
	   return st;
   }
   
   @PostMapping(value="/addQuestion")
	public String addQuestion(@RequestBody Question q)
	{
		String b="1234";
		  String a=(String) session.getValue("sessionk");
		  try
		  {
		  if(a.equalsIgnoreCase(b))
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
	
	//developer use
   @PostMapping(value="/FQuestion")
	public Question getFormatForQuestionAdd()
	{
		
		Question q=new Question(1,"Green","parrot color is","yellow","green","blue","sky blue");
		return q;
		
	}
   
	@DeleteMapping(value="/removeQuestion")
   public String removeQuestion(@RequestBody  Question q)
   {
	   System.out.println(q);
	   String b="1234";
	   String a=(String) session.getValue("sessionk");
		  
		 // System.out.println("in login"+session.getValue("Teacherkey"));
		  
		  System.out.println("vakue of a"+a);
		  System.out.println("value 0f b"+b);
		  try {
		  if(a.equalsIgnoreCase(b))
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
		
		  return "not removed";
   }
   
   @GetMapping(value="/allStudentResult")
   public List allStudentResult()
   {
	   String b="1234";
		  String a=(String) session.getValue("sessionk");
		  try
		  {
		  if(a.equalsIgnoreCase(b))
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
   
   @GetMapping(value="/logoutTeacher")
   public String logOutTeacher()
   {
	   session.invalidate();
	   return "logged out successfully"; 
   }
   
   @PostMapping(value="/registerAdmin")
   public Admin registerAdmin(@RequestBody Admin a)
   {
	   uad.addAdmin(a);
	   
	   return a;
	   
   }
   
   @GetMapping(value="/FAdmin")
   public Admin registerin()
   {
	   Admin a=new Admin(10,"parag");
	   
	   return a;
	   
   }
   
   @PostMapping(value="/loginAdmin")
   public Admin loginAdmin(@RequestBody Admin a)
   {
	   String s=uad.loginAdmin(a);
	   if(s.equalsIgnoreCase("authenticate"))
	   {
		   session.setAttribute("sessionk","1234");
		   session.setAttribute("sessionkey","9425");
		   
		  String a1=(String) session.getValue("sessionk");
		  
		 System.out.println("in login value of a1"+a1);
		 
		 String a2=(String) session.getValue("sessionkey");
		  
		 System.out.println("in login value of a1"+a2);
	
		  
	 }
	
	   return a;
   }
  
   @GetMapping(value="/logoutAdmin")
   public String logoutAdmin()
   {
	   session.invalidate();
	   return "admin logged out";
   }
}




