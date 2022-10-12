package practice;
import java.util.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {




	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		// pass the class name
		Query query=session.createQuery("from Student");
		List<Student>students = query.list();
		for(Student student:students) {
			System.out.println("City="+student.getCity());
			System.out.println("Mobile="+student.getMobile());
			System.out.println("Name="+student.getName());
			
		}
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record retrived successfull");
		
	}
}
