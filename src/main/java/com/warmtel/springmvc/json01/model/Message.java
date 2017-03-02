package com.warmtel.springmvc.json01.model;

import java.util.List;

public class Message {
	private int code;
	private String description;
	private List<Employee> lists;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getLists() {
		return lists;
	}

	public void setLists(List<Employee> lists) {
		this.lists = lists;
	}
}
