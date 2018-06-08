package com.example.nativemyapp.models;

import javax.persistence.Entity;

@Entity
public class EssayQuestion extends Question{

	private String description;
	private int points;
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
