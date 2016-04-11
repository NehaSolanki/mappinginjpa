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


import javax.validation.Valid;



@RestController
@EnableAutoConfiguration
public class AreaController {
	
	@Autowired
	AreaService areaService;
	    //method to list all areas
	    @RequestMapping(value = "/area", method = RequestMethod.GET)
	    public ResponseEntity<List<AreaMysql>> listAllAreas() {
	        List<AreaMysql> areas = areaService.findAllAreas();
	        //if list  of selected areas is empty
	        if(areas.isEmpty()){
	            return new ResponseEntity<List<AreaMysql>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<AreaMysql>>(areas, HttpStatus.OK);
	    }
	    
	    
	    //method to fetch an area with specific id
	    @RequestMapping(value = "/area/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<AreaMysql> getArea(@PathVariable("id") long id) {
	        System.out.println("Fetching Area with id " + id);
	        AreaMysql area = areaService.getAreaById(id);
	        if (area == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<AreaMysql>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<AreaMysql>(area, HttpStatus.OK);
	    }
	    
	    
	    //method to create an area
	    @RequestMapping(value = "/area", method = RequestMethod.POST , consumes={"application/json"})
	    public ResponseEntity<Void> createArea(@Valid @RequestBody Map area,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Area " + area.get("title"));
	        
	        
	        
	 

	        
	        AreaMysql areaMysql = new AreaMysql(area.get("title").toString(),area.get("description").toString(),area.get("image").toString());
	        areaService.insertArea(areaMysql);
	        
	    	
	 
	        HttpHeaders headers = new HttpHeaders();
	       // headers.setLocation(ucBuilder.path("/area/{id}").buildAndExpand(area.get("id").toString()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    	
	    	
	    }
	    
	    
	    //method to update an area
	    @RequestMapping(value = "/area/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<AreaMysql> updateArea(@PathVariable("id") long id, @RequestBody Map area) {
	        System.out.println("Updating Area " + id);
	         
	        AreaMysql currentArea = areaService.getAreaById(id);
	         
	        if (currentArea==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<AreaMysql>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentArea.setDescription(area.get("description").toString());
	        currentArea.setImage(area.get("image").toString());
	        currentArea.setTitle(area.get("title").toString());
	        
            areaService.updateArea(currentArea); 	        
	        return new ResponseEntity<AreaMysql>(currentArea, HttpStatus.OK);
	    }
	    
	    
	    //method to delete a area
	    @RequestMapping(value = "/area/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<AreaMysql> deleteArea(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Area with id " + id);
	 
	        AreaMysql area = areaService.getAreaById(id);
	        if (area == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<AreaMysql>(HttpStatus.NOT_FOUND);
	        }
	 
	        areaService.deleteArea(id);
	        return new ResponseEntity<AreaMysql>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    
	    
	 
	   

}
