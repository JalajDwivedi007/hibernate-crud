package studentDatabase;

import java.util.List;

import dao.StudentDAOImpl;
import pojo.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAOImpl st = new StudentDAOImpl();
//		st.addStudent("Arun", "Dwivedi","Science", 90);
//		st.addStudent("Sajal", "Dwivedi","Mathematics", 90);
//		st.delete(1);
//		List<Student> ls = st.listRecords();
//		for(Student s:ls) {
//			System.out.println(s.getRoll_no()+" "+s.getFirstName()+" "+s.getLastName()+" "+s.getSubject()+" "+s.getMarks());
//		}
//		st.getStudent(6);
		st.updateStudent(3, "Varun", "Dwivedi", "Science", 10);
		List<Student> ls1 = st.listRecords();
		for(Student s:ls1) {
			System.out.println(s.getRoll_no()+" "+s.getFirstName()+" "+s.getLastName()+" "+s.getSubject()+" "+s.getMarks());
		}
	}

}
