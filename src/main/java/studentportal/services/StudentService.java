package studentportal.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import studentportal.model.CourseInfo;
import studentportal.model.CourseMode;
import studentportal.model.CourseStatus;
import studentportal.model.CourseType;
import studentportal.model.StudentsCourse;
import studentportal.model.UserInfo;
import studentportal.model.data.MockedData;

@Service
public class StudentService {

	public List<CourseInfo> getAllCourses(){
		return MockedData.getCourses();
	}
	
	public List<StudentsCourse> getCourseForStudent(int studentId){
		
		List<StudentsCourse> result = new ArrayList<StudentsCourse>();
		List<CourseInfo> allCourse = MockedData.getCourses();
		Random random = new Random();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		UserInfo student = MockedData.getUsers().get(studentId-1010);
		
		while (true){
			CourseInfo course = allCourse.get(random.nextInt(10));
			try {
				StudentsCourse studentcourse = new StudentsCourse(student.getId(), CourseStatus.APPROVAL_PENDING,  dateformat.parse("07/17/2016"), course.getDegree(), course.getName(), course.getDurationInMonths(), course.getMode(), course.getFee(), course.getType());
				
				switch(course.getType()){
				case MASTERS:
					studentcourse.setStatus(CourseStatus.APPROVAL_PENDING);
					break;
				case BACHELORS:
					studentcourse.setStatus(CourseStatus.REGISTERED);
					break;
				case DIPLOMA:
					studentcourse.setStatus(CourseStatus.FAILED);
					break;
				case CERTIFICATE:
					studentcourse.setStatus(CourseStatus.PASSED);
					break;
					default:
						studentcourse.setStatus(CourseStatus.APPLICATION_REJECTED);
				}
				result.add(studentcourse);
				if(result.size() >= 3){
					break;
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}	
		return result;
	}
}
