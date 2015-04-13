package edu.neu.cs5200.msn.orm.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {
	@Id
	private Integer id;
	private String name;
	private String latitude;
	private String longitude;
	
	@OneToMany(mappedBy="site")
	private List<Tower> towers;
	
	
	
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Site(Integer id, String name, String latitude, String longitude,
			List<Tower> towers) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.towers = towers;
	}
	public Site() {
		super();
	}
	
	

}
