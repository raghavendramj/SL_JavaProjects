package com.simplilearn.modal;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Product {

	private long id;
	private String name;
	private String price;
	private Date date_added;

	private List<Color> colors;
	private Set<OS> OS;
	

	public Product() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public Set<OS> getOS() {
		return OS;
	}

	public void setOS(Set<OS> oS) {
		OS = oS;
	}
}
