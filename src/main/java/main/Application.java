package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import database.DatabaseModel;
import database.mongodb.MongoDBMain;

@SpringBootApplication
public class Application {
	public static DatabaseModel database;

	public static void main(String[] args) {
		database = new MongoDBMain();
		System.out.println("Starting Hello World Service ...");
		database.run();
		System.out.println("Starting Spring Application...");
		SpringApplication.run(Application.class, args);
	}
}