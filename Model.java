package com;

public class Model {
	
	public int id;
	public String task;
	public String input;
	public String output;
	public Model(int id, String task, String input, String output) {
		super();
		this.id = id;
		this.task = task;
		this.input = input;
		this.output = output;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", task=" + task + ", input=" + input
				+ ", output=" + output + "]";
	}
	
	
	
	

}
