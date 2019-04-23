package com.love.code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//create sesion factory
		SessionFactory factory = new Configuration()
		                             .configure("hibernate.cfg.xml")
		                             .addAnnotatedClass(Instructor.class)
		                             .addAnnotatedClass(InstructorDetail.class)
		                             .addAnnotatedClass(Course.class)
		                             .addAnnotatedClass(Review.class)
		                             .buildSessionFactory();
		
		//create a session
		Session session= factory.getCurrentSession();
		
		try{
			//create the objects
		
			
			session.beginTransaction();
			
			Course tempCourse= new Course("Hibernate");
			
			tempCourse.addReview(new Review("Great Course"));
			tempCourse.addReview(new Review("Superb Explanation"));
			tempCourse.addReview(new Review("Best TA's"));
			
			System.out.println("Saving the Course...");
			session.save(tempCourse);
			System.out.println("Reviews "+tempCourse.getReview());
			
			session.getTransaction().commit();
			
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("The reviews are ");
			
			List<Review> list=  session.createQuery("from Review").list();
			System.out.println(list);
			System.out.println("Done");
			
			session.getTransaction().commit();
			
		}
		
		finally{
			factory.close();
		}

	}

	private static String getReview() {
		// TODO Auto-generated method stub
		return null;
	}

}
