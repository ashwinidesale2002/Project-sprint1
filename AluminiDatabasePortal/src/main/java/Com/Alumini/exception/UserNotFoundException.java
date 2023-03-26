package Com.Alumini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.bytebuddy.implementation.bind.annotation.Super;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message ,Throwable cause) {
		super(message,cause);
	
	}
	public UserNotFoundException(String message) {
		super(message);
		
	
	}
	
	
}
