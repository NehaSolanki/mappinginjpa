package com.imlabs.model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="AREA")

public class AreaMysql implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1028664980836539080L;
	@Id
	@GeneratedValue
	long id;
	@NotNull
	String title;
	@NotNull
	String description;
	@NotNull
	String image;
	@NotNull
	int gid;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="area") 
	@JsonManagedReference
	@JsonIgnore
	Set<CourseMysql> acourses=new HashSet<CourseMysql>();
	
	
	public AreaMysql(){}
	
	
	public AreaMysql( String title, String description , String image) {
		super();
		
		this.title = title;
		this.description = description;
		this.image=image;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Set<CourseMysql> getAcourses() {
		return acourses;
	}


	public void setAcourses(Set<CourseMysql> acourses) {
		this.acourses = acourses;
	}


	public int getGid() {
		return gid;
	}


	public void setGid(int gid) {
		this.gid = gid;
	}
	
	



	
	
	
 }
