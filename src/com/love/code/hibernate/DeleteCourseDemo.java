package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			//get the course from db with id 10
			int id=10;
			Course tempCourse= session.get(Course.class, id);
			
			//delete the course
			session.delete(tempCourse);
			
			
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
