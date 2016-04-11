package com.imlabs.model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="COURSE")
//@XmlRootElement
public class CourseMysql implements Serializable {
	
	
	
	private static final long serialVersionUID = -7058624269134097224L;
	@Id
	@GeneratedValue
	long id;
	@NotNull
	String title;
	@NotNull
	String image;
	@NotNull
	String description;
	@NotNull
	int gid;
	

	
	@ManyToOne(fetch=FetchType.LAZY )
    @JoinColumn(name="PID")
	@JsonBackReference
	AreaMysql area;
	






	public CourseMysql(){}
	
	
    public CourseMysql(String title, String image, String description, AreaMysql area) {
		super();
	
		this.title = title;
		this.image = image;
		this.description = description;
		this.area = area;
	}







	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





	public AreaMysql getArea() {
		return area;
	}


	public void setArea(AreaMysql area) {
		this.area = area;
	}


	public int getGid() {
		return gid;
	}


	public void setGid(int gid) {
		this.gid = gid;
	}
	
}
