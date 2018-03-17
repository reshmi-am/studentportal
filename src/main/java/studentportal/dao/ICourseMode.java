package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentportal.model.CourseMode;

@Repository
public interface ICourseMode extends JpaRepository<CourseMode, Integer>{

}
