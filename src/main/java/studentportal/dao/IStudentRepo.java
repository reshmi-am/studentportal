package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import studentportal.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer>{

}
