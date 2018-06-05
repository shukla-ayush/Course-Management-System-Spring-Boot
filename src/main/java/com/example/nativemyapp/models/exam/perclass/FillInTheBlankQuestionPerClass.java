package com.example.nativemyapp.models.exam.perclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CLASS_FILL_IN_THE_BLANK_QUESTION")
public class FillInTheBlankQuestionPerClass
	extends BaseQuestionPerClass {
	@Column(name = "VARIABLES", nullable = false)
	private String variables;
	public String getVariables() {
		return variables;
	}
	public void setVariables(String variables) {
		this.variables = variables;
	}
}