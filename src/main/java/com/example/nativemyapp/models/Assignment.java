package com.example.nativemyapp.models;

import javax.persistence.Entity;

@Entity
public class Assignment extends Widget{
	
	private String title;
	private String description;
	private int points;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
