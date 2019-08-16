package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadtudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		Student s = new Student("Joes","Joe","joe@gmail.com");
		
		session.beginTransaction();
		
		session.save(s);
		
		session.getTransaction().commit();
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Student saved  = session.get(Student.class,s.getId());
		System.out.println(saved);
		session.getTransaction().commit();
		
		
	}catch(Exception e) {
		
	}finally{
		sessionFactory.close();
	}
	}

}
