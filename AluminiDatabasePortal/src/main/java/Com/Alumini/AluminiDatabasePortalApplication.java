package Com.Alumini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Com.Alumini.Entity.Student;
import Com.Alumini.Repository.StudentRepository;


@SpringBootApplication
public class AluminiDatabasePortalApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AluminiDatabasePortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Student a1 = Student.builder().name("Ashwini").phone("8997921050").email("sw@gmail.com").grdYear("2022").build();
		Student a2 = Student.builder().name("Nikhil").phone("7697661050").email("mo@gmail.com").grdYear("2022").build();
		Student a3 = Student.builder().name("Akshata").phone("6797221050").email("ra@gmail.com").grdYear("2020").build();
		Student a4 = Student.builder().name("Uday").phone("9997221050").email("sa@gmail.com").grdYear("2021").build();
	
		
		studentRepository.save(a1);
		studentRepository.save(a2);
		studentRepository.save(a3);
		studentRepository.save(a4);
	
		System.out.println("--------------------------All saved-------------------------");

	}
		
	}


