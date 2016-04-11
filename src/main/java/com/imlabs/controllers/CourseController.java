package com.imlabs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.imlabs.model.*;
import com.imlabs.services.*;
import java.util.*;


@RestController
@EnableAutoConfiguration
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	AreaService areaService;
	

	    
	
	    //method to list all courses
	    @RequestMapping(value = "/course", method = RequestMethod.GET)
	    public ResponseEntity<List<CourseMysql>> listAllCourses() {
	        List<CourseMysql> courses = courseService.findAllCourses(); 
	        if(courses.isEmpty()){
	            return new ResponseEntity<List<CourseMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<CourseMysql>>(courses, HttpStatus.OK);
	    }
	    
	    
	    //method to list a course with specific id
	    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<CourseMysql> getCourseById(@PathVariable("id") long id) {
	        System.out.println("Fetching Course with id " + id);
	        CourseMysql course = courseService.getCourseById(id);
	        if (course == null) {
	            System.out.println("Course with id " + id + " not found");
	            return new ResponseEntity<CourseMysql>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<CourseMysql>(course, HttpStatus.OK);
	    }
	    		
	    //method to create a new course
	    @RequestMapping(value = "/area/{id}/course", method = RequestMethod.POST , consumes={"application/json"})
	    public ResponseEntity<Void> createCourse(@PathVariable("id") long id ,@RequestBody Map course,    UriComponentsBuilder ucBuilder) {
	    	System.out.println("sello");
	        System.out.println("Creating Course " + course.get("title").toString());
	        AreaMysql area=areaService.getAreaById(id);

	        
	 
	        CourseMysql courseMysql =  new CourseMysql(course.get("title").toString() ,course.get("image").toString() ,course.get("description").toString()  , area);
	       
	        courseService.insertCourse(courseMysql);
	 
	        HttpHeaders headers = new HttpHeaders();
	       // headers.setLocation(ucBuilder.path("/course/{id}").buildAndExpand(course.get("id").toString()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    //method to update a course
	    @RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<CourseMysql> updateCourse(@PathVariable("id") long id, @RequestBody Map course) {
	        System.out.println("Updating Course " + id);
	         
	        CourseMysql currentCourse = courseService.getCourseById(id);
	         
	        if (currentCourse==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<CourseMysql>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentCourse.setDescription(course.get("description").toString());
	        currentCourse.setImage(course.get("image").toString());
	        currentCourse.setTitle(course.get("title").toString());
	        
            courseService.updateCourse(currentCourse); 	        
	        return new ResponseEntity<CourseMysql>(currentCourse, HttpStatus.OK);
	    }
	    
	    
	    //method to delete a course
	    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<CourseMysql> deleteCourse(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Course with id " + id);
	 
	        CourseMysql course = courseService.getCourseById(id);
	        if (course == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<CourseMysql>(HttpStatus.NOT_FOUND);
	        }
	 
	        courseService.deleteCourse(id);
	        return new ResponseEntity<CourseMysql>(HttpStatus.NO_CONTENT);
	    }
	    
	    @RequestMapping(value = "/area/course/{id}", method = RequestMethod.GET)
	    public ResponseEntity<List<CourseMysql>> listAllCoursesForArea(@PathVariable("id") long id) {
	        List<CourseMysql> courses = courseService.findCoursesForArea(id);
	        if(courses.isEmpty()){
	            return new ResponseEntity<List<CourseMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<CourseMysql>>(courses, HttpStatus.OK);
	    }
	 
	    
	    
	 
	
	

}
