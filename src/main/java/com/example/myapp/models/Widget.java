package com.example.myapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int widgetOrder;
	private String text;
	private String widgetType;
	private String listType;
	private int size;
	private String linkName;
	private String src;
	private String listItemsText;
	private String linkUrl;
	private String headingText;
	private String widgetName;
	@ManyToOne
	@JsonIgnore
	private Topic topic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getWidgetOrder() {
		return widgetOrder;
	}
	public void setWidgetOrder(int widgetOrder) {
		this.widgetOrder = widgetOrder;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getListItemsText() {
		return listItemsText;
	}
	public void setListItemsText(String listItemsText) {
		this.listItemsText = listItemsText;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getHeadingText() {
		return headingText;
	}
	public void setHeadingText(String headingText) {
		this.headingText = headingText;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
}
