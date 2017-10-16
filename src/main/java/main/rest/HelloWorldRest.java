package main.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import database.HelloWorldDAO;
import main.Application;
import main.model.HelloWorld;

@Named
@Path("/")
public class HelloWorldRest {
	private HelloWorld helloWorld;
	private static List<HelloWorld> helloWorldList = new ArrayList<HelloWorld>();
	
	private ApplicationContext ctx = Application.database.getContext();
	private HelloWorldDAO helloWorldDAO = ctx.getBean("helloWorldDAO", HelloWorldDAO.class);
	
	@GET
	@Path("helloByID/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello(@PathParam("id") String id){
		System.out.println("GET Request – /hello/"+id);
		helloWorld = helloWorldDAO.getOneById(id);
		return "Hello, "+helloWorld.getName()+"!";
	}
	
	@GET
	@Path("hellos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HelloWorld> helloToAll(){
		System.out.println("GET Request – /hello/all");
		helloWorldList = helloWorldDAO.getAll();
		return helloWorldList;
	}
	
	@GET
	@Path("helloByName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HelloWorld> helloToAllByName(@PathParam("name") String name){
		System.out.println("GET Request – /hello/"+name);
		helloWorldList = helloWorldDAO.getManybyName(name);
		return helloWorldList;
	}
	
	@POST
	@Path("hello/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String newName(@FormParam("name") String name ){
		System.out.println("POST Request – /new/hello");
		helloWorld = new HelloWorld();
		helloWorld.setName(name);
		helloWorldDAO.create(helloWorld);
		return "added new name: "+name;
	}
	
	@PUT
	@Path("hello/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String changeNameById(@FormParam("id") String id,
			@FormParam("name") String changedName){
		System.out.println("PUT Request – /edit/hello");
		String temp = "";
		helloWorld = helloWorldDAO.getOneById(id);
		temp +="Changed name from "+helloWorld.getName();
		helloWorldDAO.update(id, changedName);
		helloWorld = helloWorldDAO.getOneById(id);
		temp+=" to "+helloWorld.getName();
		return temp;
	}
	
	
	@DELETE
	@Path("hello/{id}/remove")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeById(@PathParam("id") String id){
		System.out.println("DELETE Request – /hello/"+id+"/remove");
		helloWorldDAO.removeById(id);
		return "removed: "+id;
	}

}