package com.rahul.DemoHibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="alien_table")
public class Alien {
	@Id
	private int aid;
	private String aname;
	//@Column(name="alien_color")
//	private String color;
	@OneToMany(mappedBy ="alien",fetch = FetchType.EAGER)
	private Collection<Laptop> laps = new ArrayList<Laptop>(); 
	
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public Collection<Laptop> getLaps() {
		return laps;
	}

	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}

	
//	public String getColor() {
//		return color;
//	}
//	public void setColor(String color) {
//		this.color = color;
//	}
	
	
	

}
