package com.simplilearn.modal;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private long id;
	private String name;
	private BigDecimal price;
	private Date date_added;
	
	public Product() {
	}
	
	public Product(long id, String name, BigDecimal price, Date date_added) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.date_added = date_added;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	
	
	
	
}
