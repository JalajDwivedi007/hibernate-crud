package dao;

import java.util.List;

import pojo.Student;

public interface StudentDAO {
	public void addStudent(String firstName,String lastName,String Subject,int marks);
	public void delete(int roll_no);
	public void updateStudent(int roll_no,String firstName,String lastName,String Subject,int marks);
	public List<Student> listRecords();
	public void getStudent(int roll_no);
}
