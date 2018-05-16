package org.learning.springmvc;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Message {

	private String greeting = "Hello";
	
	@JsonProperty("detailGreeting")
	private String detail = "Hello World";

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
