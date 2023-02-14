package dao;

import org.hibernate.Transaction;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojo.Student;

//Using HQL for operations here the queries used have the class name instead of table name
public class StudentDAOImpl implements StudentDAO{

	static SessionFactory sf;
	@Override
	public void addStudent(String firstName, String lastName, String Subject, int marks) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		
		Student s = new Student();
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setSubject(Subject);
		s.setMarks(marks);
		
		se.save(s);
		tx.commit();
		System.out.println("Student Record has been added successfully!");
		sf.close();
		se.close();
	}

	@Override
	public void delete(int roll_no) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		
		Query query=se.createQuery("delete from Student where roll_no="+roll_no+"");  
//		query.setParameter("a",roll_no);  
		int n = query.executeUpdate();
//		System.out.println(n);
		if(n<1) {
			System.out.println("Record does not exist!");
		}
		else {
			System.out.println("Record deleted successfully!");
		}
		tx.commit();
		sf.close();
		se.close();
	}

	@Override
	public void updateStudent(int roll_no, String firstName, String lastName, String Subject, int marks) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		
		Query q = se.createQuery("update Student set First_name='"+firstName+"',Last_name='"+lastName+"',Subject='"+Subject+"',Marks="+marks+" where roll_no="+roll_no+"");
		int n = q.executeUpdate();
		
		if(n<1) {
			System.out.println("Record does not exist!");
		}
		else {
			System.out.println("Record updated successfully!");
		}
		tx.commit();
		sf.close();
		se.close();
	}

	@Override
	public List<Student> listRecords() {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		
		Query q = se.createQuery("from Student");  //Student is the persistent class name
		List ls = q.list();
		
		tx.commit();
		sf.close();
		se.close();
		
		return ls;
	}

	@Override
	public void getStudent(int roll_no) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		
		Query q = se.createQuery("from Student where roll_no="+roll_no+"");
		List<Student> ls = q.list();
		if(ls.isEmpty()) {
			System.out.println("Record does not exist!");
		}else {
			for(Student s:ls) {
				System.out.println(s.getRoll_no()+" "+s.getFirstName()+" "+s.getLastName()+" "+s.getSubject()+" "+s.getMarks());
			}
		}
		
		
		tx.commit();
		sf.close();
		se.close();
	}

}
