package studentportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentportal.dao.ICourseMode;
import studentportal.dao.ICourseRepo;
import studentportal.dao.ICourseTypeRepo;
import studentportal.dao.ICredentialRepo;
import studentportal.dao.IStudentRepo;
import studentportal.model.Course;
import studentportal.model.CourseInfo;
import studentportal.model.CourseMode;
import studentportal.model.CourseType;
import studentportal.model.Credential;
import studentportal.model.Student;
import studentportal.model.StudentsCourse;
import studentportal.model.UserInfo;

@Service
public class StudentService {

	@Autowired
	private ICourseRepo courseDAO;
	
	@Autowired
	private ICourseMode modeTypeDAO;
	
	@Autowired
	private  ICourseTypeRepo courseTypeDAO;
	
	@Autowired
	private IStudentRepo studentDAO;
	
	@Autowired
	private ICredentialRepo credentialDAO;
	
	public List<CourseInfo> getAllCourses(){
		
		List<Course> courses = courseDAO.findAll();
		
		return this.mapCourseDetails(courses);
		
	}
	
	private List<CourseInfo> mapCourseDetails(List<Course> courses){
		
		List<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
		
		List<CourseMode> modes = modeTypeDAO.findAll();
		List<CourseType> types = courseTypeDAO.findAll();
		
		for(Course course : courses){
			
			CourseInfo info = new CourseInfo();
			info.setDegree(course.getDegree());
			info.setName(course.getName());
			info.setDurationInMonths(course.getDuration());
			info.setFee(course.getFee());
			info.setMode(this.getModeString(course.getMode(), modes));
			info.setType(this.getTypeString(course.getType(), types));
			
			courseInfoList.add(info);
		}
		
		return courseInfoList;
	}
	
	private String getModeString(int id, List<CourseMode> modes){
		
		for(CourseMode mode: modes){
			if(mode.getId() == id){
				return mode.getMode();
			}
		}
		
		return "";
	}
	
	private String getTypeString(int id, List<CourseType> types){
		
		for(CourseType type: types){
			if(type.getId() == id){
				return type.getType();
			}
		}
		
		return "";
	}

	public List<StudentsCourse> getCourseForStudent(int studentId){
		
		return null;
	}

	public void signUpUser(UserInfo user) {
		
		Student student = new Student();
		student.setFirstName(user.getFirstName());
		student.setLastName(user.getLastName());
		student.setEmail(user.getEmail());
		student.setPhone(user.getPhone());
		
		Credential crd = new Credential();
		crd.setUserid(user.getEmail());
		crd.setPwd(user.getPwd());
		
		studentDAO.save(student);
		credentialDAO.save(crd);
	}
}
