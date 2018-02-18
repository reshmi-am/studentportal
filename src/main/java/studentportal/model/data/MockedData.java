package studentportal.model.data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import studentportal.model.CourseInfo;
import studentportal.model.CourseMode;
import studentportal.model.CourseType;
import studentportal.model.UserInfo;

public class MockedData {

	private MockedData(){	}

	private static final List<CourseInfo> courses = Arrays.asList(
			new CourseInfo("MBA", "Master of Business Adminstration", 24, CourseMode.REGULAR, 16000, CourseType.MASTERS),
			new CourseInfo("MCA", "Master of Computer Application", 36, CourseMode.REGULAR, 36000, CourseType.MASTERS),
			new CourseInfo("MAP", "Master of Psychology", 24, CourseMode.DISTANT, 10000, CourseType.MASTERS),
			new CourseInfo("MAE", "Master of Economics", 24, CourseMode.DISTANT, 6000, CourseType.MASTERS),
			new CourseInfo("MAPO", "Master of Political Science", 24, CourseMode.DISTANT, 5000, CourseType.MASTERS),
			new CourseInfo("MSW", "Master of Social Work", 24, CourseMode.ONLINE, 6000, CourseType.MASTERS),

			new CourseInfo("BBA", "Bachelor of Business Adminstration", 36, CourseMode.REGULAR, 16000, CourseType.BACHELORS),
			new CourseInfo("BCA", "Bachelor of Computer Application", 36, CourseMode.REGULAR, 36000, CourseType.BACHELORS),
			new CourseInfo("BAP", "Bachelor of Psychology", 36, CourseMode.DISTANT, 10000, CourseType.BACHELORS),
			new CourseInfo("BAE", "Bachelor of Economics", 36, CourseMode.DISTANT, 6000, CourseType.BACHELORS),
			new CourseInfo("BAPO", "Bachelor of Political Science", 36, CourseMode.DISTANT, 5000, CourseType.BACHELORS),
			new CourseInfo("BS", "Bachelor of Science", 36, CourseMode.ONLINE, 6000, CourseType.BACHELORS),

			new CourseInfo("DCV", "Diploma in Civil Engineering", 12, CourseMode.REGULAR, 6000, CourseType.DIPLOMA),
			new CourseInfo("DC", "Diploma in Counselling", 12, CourseMode.REGULAR, 6000, CourseType.DIPLOMA),
			new CourseInfo("DTT", "Diploma in Teachers Training", 12, CourseMode.REGULAR, 10000, CourseType.DIPLOMA),
			new CourseInfo("DLT", "Diploma in Lift Technology", 6, CourseMode.REGULAR, 6000, CourseType.DIPLOMA),
			new CourseInfo("DPT", "Diploma in Physiotherapy", 6, CourseMode.REGULAR, 5000, CourseType.DIPLOMA),
			new CourseInfo("DPN", "Diploma in Naturopathy", 6, CourseMode.REGULAR, 6000, CourseType.DIPLOMA),

			new CourseInfo("CNLP", "NLP Practitioning", 1, CourseMode.REGULAR, 6000, CourseType.CERTIFICATE),
			new CourseInfo("CBK", "Art of Baking", 1, CourseMode.REGULAR, 6000, CourseType.CERTIFICATE),
			new CourseInfo("CWA", "Art of Writing", 2, CourseMode.REGULAR, 10000, CourseType.CERTIFICATE),
			new CourseInfo("CPS", "Painting and Sketching", 6, CourseMode.REGULAR, 6000, CourseType.CERTIFICATE),
			new CourseInfo("CMA", "Modern Art", 6, CourseMode.REGULAR, 5000, CourseType.CERTIFICATE),
			new CourseInfo("CDT", "Dance therapy", 4, CourseMode.REGULAR, 6000, CourseType.CERTIFICATE)			
			);
	

	private static final List<UserInfo> users = Arrays.asList(
			new UserInfo(1010, "Tomy", "John", "sayons232@gmail.com", "9879933266", "velvet333" ),
			new UserInfo(1011, "Sonia", "Rachel", "rachel_45@yahoo.com", "7079933290", "purple23" ),
			new UserInfo(1012, "Ravi", "Teja", "teja_ravi@hotmail.com", "8079933223", "indigo89" ),
			new UserInfo(1013, "Mini", "Xavier", "mini3333@gmail.com", "98799377225", "uvarna333" ),
			new UserInfo(1014, "Manu", "Varma", "manu_jan@gmail.com", "9879933286", "volvo333" ),
			new UserInfo(1015, "Vijetha", "Warrier", "sayons232@gmail.com", "9879933266", "velvet333" ),
			new UserInfo(1016, "Sangeeta", "Patel", "rachel_45@yahoo.com", "7079933290", "purple23" ),
			new UserInfo(1017, "Suparna", "Shetty", "teja_ravi@hotmail.com", "8079933223", "indigo89" ),
			new UserInfo(1018, "Anu", "Krishna", "mini3333@gmail.com", "98799377225", "uvarna333" ),
			new UserInfo(1019, "Priya", "Iyer", "manu_jan@gmail.com", "9879933286", "volvo333" )
			);
	

	public static List<CourseInfo> getCourses(){
		return courses;
	}
	
	public static List<UserInfo> getUsers(){
		return users;
	}
}
