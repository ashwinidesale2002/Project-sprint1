package Com.Alumini.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {
	
	@NotBlank(message = "Invalid name:Empty name")
	@NotNull(message = "Invalid name:Name is NULL")
	@Size(min = 3,max = 30,message = "Invalid Name: Must be of 3-25 characters")
	private String name;
	
	@NotBlank(message = "Invalid phone Number:Empty Number")
	@NotNull(message = "Invalid phone Number:Number is NULL")
	@Pattern(regexp = "\\d{10}$", message = "Invalid phone Number !")
	private String phone;
	
	@Email(message = "Invalid email")
	private String email;
	

	@NotBlank(message = "Invalid name:Empty name")
	@NotNull(message = "Invalid name:Name is NULL")
	
	private String grdYear;
		
	

}
