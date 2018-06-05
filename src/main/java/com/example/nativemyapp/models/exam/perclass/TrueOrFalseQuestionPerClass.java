package com.example.nativemyapp.models.exam.perclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CLASS_TRUE_OR_FALSE_QUESTION")
public class TrueOrFalseQuestionPerClass
	extends BaseQuestionPerClass {
	@Column(name = "IS_TRUE", nullable = false)
	private Boolean isTrue;
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
}