package Com.Alumini.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Com.Alumini.DTO.StudentDTO;
import Com.Alumini.Entity.Student;
import Com.Alumini.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController{
	//Construction Injection
	@Autowired
	private StudentService studentService;
	
	//Adds a new Students
	@PostMapping("/Students")
	public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO s)
	{
		  Student s1=studentService.createStudent(s);
		  return new ResponseEntity<>(s1,HttpStatus.CREATED);		  
	}
	
	//update an student based on their Id
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO)
	{
		studentService.updateStudent(id, studentDTO);
		return ResponseEntity.ok().body(studentService.updateStudent(id, studentDTO));
		
	}
	
	//display Student
		@GetMapping("/studentname")
		public ResponseEntity<List<Student>> getStudentByStd_Name(@RequestParam(required = false) String name)
		{
			List<Student> alumini = studentService.findByNameContaining(name);
			return ResponseEntity.ok(alumini);
		}
	
	//Display an student based on their graduation year
	@GetMapping("studentsyear")
	public ResponseEntity<List<Student>> getStudentByGraduationYear(@RequestParam(required = false)String grdyear)
	{
		List<Student> students=studentService.findByGraduationYear(grdyear);
		return ResponseEntity.ok(students);
	}
	//Display an student based on their Id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getAllStudentById(@PathVariable int id)
	{
		return ResponseEntity.ok().body(studentService.getAllStudentById(id));
	}

	
	
}
	


