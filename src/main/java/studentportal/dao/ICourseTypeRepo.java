package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentportal.model.CourseMode;
import studentportal.model.CourseType;

@Repository
public interface ICourseTypeRepo  extends JpaRepository<CourseType, Integer>{

}
