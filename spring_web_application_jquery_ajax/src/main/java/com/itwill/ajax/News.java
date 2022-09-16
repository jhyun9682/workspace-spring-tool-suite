package com.itwill.ajax;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
@JacksonXmlRootElement(localName = "news")
public class News {
	
	private String title;
	private String company;
	private String date;
	public News() {
		// TODO Auto-generated constructor stub
	}
	
	public News(String title, String company, String date) {
		super();
		this.title = title;
		this.company = company;
		this.date = date;
	}
	@JsonProperty(value = "newsTitle")
	@JacksonXmlProperty(localName = "newsTitle")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}