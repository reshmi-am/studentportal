package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentportal.model.Course;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Integer>{

}
