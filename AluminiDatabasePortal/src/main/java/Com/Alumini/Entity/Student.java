package Com.Alumini.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private int id;
	
	@Column(name = "sName")
	private String name;
	
	@Column(name = "sGraduationYear")
	private String grdYear;
	
	@Column(name = "sEmail")
	private String email;
	
	@Column(name = "sPhoneNo",length = 60)
	private String phone;

	public Student(String name, String grdYear, String email, String phone) {
		super();
		this.name = name;
		this.grdYear = grdYear;
		this.email = email;
		this.phone = phone;
	}
	
	

}
