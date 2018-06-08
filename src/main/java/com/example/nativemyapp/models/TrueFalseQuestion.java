package com.example.nativemyapp.models;

import javax.persistence.Entity;

@Entity
public class TrueFalseQuestion extends Question {
	private boolean isTrue;
	private String description;
	private int points;
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}
