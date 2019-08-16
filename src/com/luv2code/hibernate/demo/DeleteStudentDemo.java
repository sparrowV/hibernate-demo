package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		int studentId  = 1;
		
		session.beginTransaction();
		
		Student s = session.get(Student.class, studentId);
		s.setFirstName("scuby");
		session.delete(s);	
		session.getTransaction().commit();
		

		
		
	}catch(Exception e) {
		
	}finally{
		session.close();
		sessionFactory.close();
	}
	}

}
