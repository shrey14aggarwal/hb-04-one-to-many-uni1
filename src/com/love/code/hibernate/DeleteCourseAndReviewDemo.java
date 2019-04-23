package com.love.code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewDemo {

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
			
			session.beginTransaction();
			
			//get the id
			int id=10;
			
			//get the course from the id
			Course tempCourse= session.get(Course.class, id);
			
			//print the course
			System.out.println("The course details are "+tempCourse);
			
			//print the corresponding reviews
			System.out.println("The reviews of course are ");
			
			List<Review> review= tempCourse.getReview();
			System.out.println("The reviews are "+review);
			
			//delete the course
			session.delete(tempCourse);
			
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
