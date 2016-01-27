package main.model;

import org.springframework.data.annotation.Id;

public class HelloWorld {
	@Id
	private String id;
	
	private String name;
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
