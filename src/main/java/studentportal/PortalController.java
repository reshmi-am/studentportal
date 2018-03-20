package studentportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import studentportal.model.CourseInfo;
import studentportal.model.Student;
import studentportal.model.StudentsCourse;
import studentportal.model.UserInfo;
import studentportal.services.AuthService;
import studentportal.services.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PortalController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private AuthService authservice;
	
    @RequestMapping("/courses")
    public @ResponseBody List<CourseInfo> getCourses() {
   
        return service.getAllCourses();
    }
    
    @RequestMapping(value="/student", method = RequestMethod.POST, consumes = "application/json")
    public void signUp(@RequestBody UserInfo user) {
    	
    	service.signUpUser(user);
    }
    
    @RequestMapping("/courses/{id}")
    public @ResponseBody List<CourseInfo> getCoursesForStudent(@PathVariable("id") int studentid) {
    	
        return service.getCourseForStudent(studentid);
    }
    
    @RequestMapping(value="/auth", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody Student authenticateUser(@RequestBody UserInfo user) throws Exception {
    	
        return authservice.authenticate(user.getEmail(), user.getPwd());
    }
    
    @RequestMapping(value="/registration", method = RequestMethod.POST, consumes = "application/json")
    public void authenticateUser(@RequestBody StudentsCourse sc) throws Exception {
    	
        service.registercourse(sc.getStudentId(), sc.getCourseId());
    }
}
	