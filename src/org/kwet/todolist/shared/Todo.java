package org.kwet.todolist.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Todo implements Serializable{

	private String name;
	
	private int priority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
}
