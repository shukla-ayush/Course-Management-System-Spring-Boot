package com.example.nativemyapp.models.exam.single;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLE_TRUE_OR_FALSE_QUESTION")
public class TrueOrFalseQuestionSingle
	extends BaseQuestionSingle {
	@Column(name = "IS_TRUE")
	private Boolean isTrue;
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
}
