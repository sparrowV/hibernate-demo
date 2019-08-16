package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();


			Session session = sessionFactory.getCurrentSession();
			
			try {
				
			Student s = new Student("nick","Smith","nick@gmail.com");
			Student s2 = new Student("john","Smith","john@gmail.com");
			Student s3 = new Student("sam","Smith","sam@gmail.com");
			session.beginTransaction();
			
			session.save(s);
			session.save(s2);
			session.save(s3);
			
			session.getTransaction().commit();
			}catch(Exception e) {
			
			}finally{
			sessionFactory.close();
			}

	}

}
