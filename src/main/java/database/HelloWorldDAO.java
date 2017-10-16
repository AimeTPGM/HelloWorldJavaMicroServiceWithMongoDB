package database;

import java.util.List;

import main.model.HelloWorld;

public interface HelloWorldDAO {
	
	public void create(HelloWorld helloWorld);
	
	public void removeById(String id);
	
	public List<HelloWorld> getAll();
	
	public HelloWorld getOneById(String id);
	
	public List<HelloWorld> getManybyName(String name);
	
	public void update(String id, String changedName);
}
