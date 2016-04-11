package com.imlabs.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imlabs.model.CourseMysql;


@Repository
public interface CourseRepositoryMysqlPublisher extends JpaRepository<CourseMysql, Long> {
	
	/*@Query("select c.id , c.title , c.image , c.description from CourseMysql c where c.area.id=?1")
	List<CourseMysql> findCoursesForArea(String id);*/
	
	@Query(value="select * from course c where c.PID=?1" ,nativeQuery=true)
	List<CourseMysql> findCoursesForArea(String id);
	
	

}