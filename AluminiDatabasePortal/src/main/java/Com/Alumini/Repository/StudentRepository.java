package Com.Alumini.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import Com.Alumini.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// custom  spring boot search methods
	List<Student> findByNameContaining(String name);;
	List<Student> findByGrdYear(String grdYear);

}
