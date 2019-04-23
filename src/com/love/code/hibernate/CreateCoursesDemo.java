package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			//create the objects
		
			
			session.beginTransaction();
			
			//get the instructor from db
			int id1=1;
			
			Instructor tempInstructor1= session.get(Instructor.class, id1);
			
			//create some courses
			Course tempCourse1= new Course("python");
			Course tempCourse2= new Course("Java");
			
			//Add course to instructor
			tempInstructor1.add(tempCourse1);
			tempInstructor1.add(tempCourse2);
			
			//save the courses to db
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
