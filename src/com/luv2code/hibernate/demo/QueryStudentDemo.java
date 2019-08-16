package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

	
	Session session = sessionFactory.getCurrentSession();
	
	try {
		Student s = new Student("nick","Smith","nick@gmail.com");
		
		session.beginTransaction();
		
		List<Student> studs = session.createQuery("from Student").getResultList();
		for(Student st : studs) {
			System.out.println(st);
		}
		
		List<Student> theStuds = session.createQuery("from Student s where s.lastName = 'Smith'").getResultList();
		for(Student st : theStuds) {
			System.out.println(st);
		}
		
		
		
		session.getTransaction().commit();
	}catch(Exception e) {
		
	}finally{
		sessionFactory.close();
	}
}

}
