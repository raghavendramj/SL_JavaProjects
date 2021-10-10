package com.simplilearn.modal;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

	private long id;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	private ProductParts parts;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public ProductParts getParts() {
		return parts;
	}

	public void setParts(ProductParts parts) {
		this.parts = parts;
	}
}
