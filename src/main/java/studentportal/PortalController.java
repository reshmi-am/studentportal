package studentportal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import studentportal.model.CourseInfo;
import studentportal.model.StudentsCourse;
import studentportal.model.UserInfo;
import studentportal.services.AuthService;
import studentportal.services.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PortalController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private AuthService authservice;
	
    @RequestMapping("/courses")
    public @ResponseBody List<CourseInfo> getCourses() {
        return service.getAllCourses();
    }
    
    @RequestMapping("/courses/{id}")
    public @ResponseBody List<StudentsCourse> getCoursesForStudent(@PathVariable("id") int studentid) {
    	logger.info("In getCoursesForStudent : " + studentid);
        return service.getCourseForStudent(studentid);
    }
    
    @RequestMapping(value="/auth", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody UserInfo authenticateUser(@RequestBody UserInfo user) {
    	
        return authservice.getUserInfo(user.getEmail(), user.getPwd());
    }
}
	