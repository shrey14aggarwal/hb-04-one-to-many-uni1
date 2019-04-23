package com.love.code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			//delete by using the id 
			int id=2;
			
			//fetch record with id 2
			Instructor tempInstructor=session.get(Instructor.class, id);
			
			System.out.println("The details of the instructor with id 2 are "+tempInstructor);
			
			//delete the instructor
			if(tempInstructor!=null)
			{
				System.out.println("Deleting...");
				
				//also delete the record from instructor_detail table
				session.delete(tempInstructor);
			}
		
			
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

}
