package com.simplilearn.entity;

public class Hobby {

	private int id;
	private String hobbyName;

	public Hobby(int id, String hobbyName) {
		super();
		this.id = id;
		this.hobbyName = hobbyName;
	}

	public Hobby() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
}

