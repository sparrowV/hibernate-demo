package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
		session.getTransaction().commit();
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("update Student set email='213@mail.ru").executeUpdate();
		
		session.getTransaction().commit();
		
		
	}catch(Exception e) {
		
	}finally{
		session.close();
		sessionFactory.close();
	}
	}

}
