package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import studentportal.model.StudentCourseDocument;

public interface IStudentCourseDocument extends JpaRepository<StudentCourseDocument, Integer>{

}
