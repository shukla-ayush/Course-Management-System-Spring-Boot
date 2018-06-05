package com.example.nativemyapp.models.exam.single;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_FILL_IN_THE_BLANK_QUESTION")
public class FillInTheBlankQuestionSingle
	extends BaseQuestionSingle {
	@Column(name = "VARIABLES")
	private String variables;
	public String getVariables() {
		return variables;
	}
	public void setVariables(String variables) {
		this.variables = variables;
	}
}
