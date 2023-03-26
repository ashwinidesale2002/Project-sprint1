package Com.Alumini.Service;

import java.util.List;


import Com.Alumini.DTO.StudentDTO;
import Com.Alumini.Entity.Student;


public interface StudentService {
	
	
	//To get record of all the student
	List<Student>getAllStudent();
	
	//To add a new student
	Student createStudent(StudentDTO studentDTO);
	
	//To update an student  using Id
	Student updateStudent(int id,StudentDTO studentDTO);
	
	//To display an student using id
	Student getAllStudentById(int id);
	
	//To display an Student using its name
	List<Student> findByNameContaining(String name);;
	
	//To display an student using graduration year
	
	List<Student> findByGraduationYear(String grdYear);
	
	//To delete an student by its Id
	String deleteStudent(int id);
	
	
	
	
	

}
