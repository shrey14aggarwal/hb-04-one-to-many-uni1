package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create sesion factory
		SessionFactory factory = new Configuration()
		                             .configure("hibernate.cfg.xml")
		                             .addAnnotatedClass(Instructor.class)
		                             .addAnnotatedClass(InstructorDetail.class)
		                             .buildSessionFactory();
		
		//create a session
		Session session= factory.getCurrentSession();
		
		try{
			//create the objects
		//	Instructor tempInstructor= new Instructor("Shrey", "Aggarwal","abc@gmail.com");
		//	InstructorDetail tempInstructorDetail= new InstructorDetail("shrey@travel","swimming");
			
			Instructor tempInstructor= new Instructor("Yash", "Garg","xyz@gmail.com");
			InstructorDetail tempInstructorDetail= new InstructorDetail("yash@travel","football");
				
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			
			//it will also save tempInstructorDetail because of cascade all
			System.out.println("Saving the instructor"+tempInstructor);
			session.save(tempInstructor);
			
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
