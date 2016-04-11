package com.imlabs.services;
import java.util.*;

import com.imlabs.model.*;

public interface CourseService {
     void insertCourse(CourseMysql course);
     List<CourseMysql> findAllCourses();
     void deleteCourse(long id);
     void updateCourse(CourseMysql course);
     CourseMysql getCourseById(long id);
     List<CourseMysql> findCoursesForArea(long id);
}
