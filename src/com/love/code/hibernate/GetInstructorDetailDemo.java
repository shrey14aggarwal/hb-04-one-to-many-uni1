package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			session.beginTransaction();
			
			int id=1;
			
			InstructorDetail tempInstructorDetail= session.get(InstructorDetail.class, id);
			System.out.println("INstructor details are "+tempInstructorDetail);
			System.out.println("Associated Instructor "+tempInstructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
		}
		catch(Exception exc )
		{
			exc.printStackTrace();
		}
		
		finally{
			session.close();
			factory.close();
		}

	}

}
