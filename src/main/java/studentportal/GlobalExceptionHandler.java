package studentportal;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import studentportal.exceptions.AuthException;

@ControllerAdvice(assignableTypes = PortalController.class)
public class GlobalExceptionHandler {

	@ExceptionHandler(SQLException.class)
    protected ResponseEntity<Object> handleDBError(RuntimeException ex, WebRequest request) {
		 return new ResponseEntity<Object>(
		          "Data error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler({ AuthException.class })
    protected ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		 return new ResponseEntity<Object>(
		          "Invalid input", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllError(RuntimeException ex, WebRequest request) {
		 return new ResponseEntity<Object>(
		          "Internal Server Error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
