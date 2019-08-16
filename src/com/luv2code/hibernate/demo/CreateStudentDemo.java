package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		Student s = new Student("nick","Smith","nick@gmail.com");
		
		session.beginTransaction();
		
		session.save(s);
		
		session.getTransaction().commit();
	}catch(Exception e) {
		
	}finally{
		sessionFactory.close();
	}
	}

}
