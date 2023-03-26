package Com.Alumini.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Alumini.DTO.StudentDTO;
import Com.Alumini.Entity.Student;
import Com.Alumini.Repository.StudentRepository;
import Com.Alumini.Service.StudentService;
import Com.Alumini.exception.UserNotFoundException;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(StudentDTO studentDTO) {
		Student student=Student.builder().name(studentDTO.getName()).email(studentDTO.getEmail()).phone(studentDTO.getPhone())
				.grdYear(studentDTO.getGrdYear()).build();
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(int id, StudentDTO studentDTO) {
		Optional<Student> adata = studentRepository.findById(id);
		if (adata.isPresent())
		{
			Student _student = studentRepository.findById(id).get();
			_student.setName(studentDTO.getName());
			_student.setPhone(studentDTO.getPhone());
			_student.setEmail(studentDTO.getEmail());
			_student.setGrdYear(studentDTO.getGrdYear());
			
			return studentRepository.save(_student);
			
		}
		else throw new UserNotFoundException("No user bearing "+id+"can be found ");
}

	@Override
	public Student getAllStudentById(int id) {
	
		return  studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user bearing id "+id+"can be found"));
	}

	@Override
	public List<Student> findByNameContaining(String name) throws UserNotFoundException
	{
		if(studentRepository.findByNameContaining(name).isEmpty())
			throw new UserNotFoundException("No User bearing id "+name+" can be found");
		else
		return studentRepository.findByNameContaining(name);
	}


	@Override
	public List<Student> findByGraduationYear(String grdYear)
	{
		if (studentRepository.findByGrdYear(grdYear).isEmpty()) 
			
		throw new UserNotFoundException("No student with graduation year"+grdYear+" can be found");
		
		else
			
		return studentRepository.findByGrdYear(grdYear);
	}

	@Override
	public String deleteStudent(int id)
	{
		studentRepository.deleteById(id);
		return "student bearing id"+id+"has been deleted successful!";
	}
	
	
}