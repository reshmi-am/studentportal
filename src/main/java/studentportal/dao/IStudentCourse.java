package studentportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import studentportal.model.StudentsCourse;

public interface IStudentCourse extends JpaRepository<StudentsCourse, Integer>{

	List<StudentsCourse> findByStudentId(int student_id);
}
