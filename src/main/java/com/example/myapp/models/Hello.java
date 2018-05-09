package com.example.myapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hello {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String msg){
		this.message = msg;
	}
}

