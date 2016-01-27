package main.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.model.HelloWorld;
import mongodb.dao.HelloWorldDAO;

@Named
@Path("/")
public class HelloWorldRest {
	private HelloWorld helloWorld;
	private static List<HelloWorld> helloWorldList = new ArrayList<HelloWorld>();
	
	
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private HelloWorldDAO helloWorldDAO = ctx.getBean("helloWorldDAO", HelloWorldDAO.class);
	
	@GET
	@Path("newName")
	@Produces(MediaType.APPLICATION_JSON)
	public String newName(@QueryParam("name") String name ){
		helloWorld = new HelloWorld();
		helloWorld.setName(name);
		helloWorldDAO.create(helloWorld);
		return "added new name: "+name;
	}
	
	@GET
	@Path("hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello(@QueryParam("id") String id){
		helloWorld = helloWorldDAO.getOneById(id);
		return "Hello, "+helloWorld.getName()+"!";
	}
	
	@GET
	@Path("helloToAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloToAll(){
		helloWorldList = helloWorldDAO.getAll();
		String temp = helloWorldList.size()+" people(s)";
		for (int i = 0; i < helloWorldList.size(); i++) {
			temp += "\nHello, "+helloWorldList.get(i).getName()+"!";
		}
		return temp;
	}
	
	@GET
	@Path("helloToAllByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloToAllByName(@QueryParam("name") String name){
		helloWorldList = helloWorldDAO.getManybyName(name);
		String temp = helloWorldList.size()+" people(s) named "+name;
		for (int i = 0; i < helloWorldList.size(); i++) {
			temp += "\nHello, "+helloWorldList.get(i).getName()+"!";
		}
		return temp;
	}
	
	@GET
	@Path("getAllData")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HelloWorld> getAllData(){
		helloWorldList = helloWorldDAO.getAll();
		
		return helloWorldList;
	}
	
	@GET
	@Path("removeById")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeById(@QueryParam("id") String id){
		helloWorldDAO.removeById(id);
		return "removed: "+id;
	}
	
	@GET
	@Path("changeNameById")
	@Produces(MediaType.APPLICATION_JSON)
	public String changeNameById(@QueryParam("id") String id,
			@QueryParam("changedName") String changedName){
		String temp = "";
		helloWorld = helloWorldDAO.getOneById(id);
		temp +="Changed name from "+helloWorld.getName();
		helloWorldDAO.update(id, changedName);
		helloWorld = helloWorldDAO.getOneById(id);
		temp+=" to "+helloWorld.getName();
		return temp;
	}

}