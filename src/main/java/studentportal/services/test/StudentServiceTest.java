package studentportal.services.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import studentportal.model.data.MockedData;
import studentportal.services.StudentService;

public class StudentServiceTest {

	StudentService service = new StudentService();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCoursesReturnAllCourses() {
		assertSame(service.getAllCourses(), MockedData.getCourses());
	}
	
	@Test
	public void testStudentCoursesReturns3Objects() {
		assertEquals(service.getCourseForStudent(1010).size() , 3 );
	}
	
}
