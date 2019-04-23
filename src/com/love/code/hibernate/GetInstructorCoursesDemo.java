package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		//create sesion factory
		SessionFactory factory = new Configuration()
		                             .configure("hibernate.cfg.xml")
		                             .addAnnotatedClass(Instructor.class)
		                             .addAnnotatedClass(InstructorDetail.class)
		                             .addAnnotatedClass(Course.class)
		                             .buildSessionFactory();
		
		//create a session
		Session session= factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			
			//get the Instructor data 
			int id=1;
			Instructor tempInstructor= session.get(Instructor.class, id);
			System.out.println("Instructor details "+tempInstructor);
			
			//get courses for instructor
			System.out.println("Courses : "+tempInstructor.getCourse());
			
			System.out.println("Done");
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
