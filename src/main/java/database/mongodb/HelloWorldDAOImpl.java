package database.mongodb;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import database.HelloWorldDAO;
import main.model.HelloWorld;

public class HelloWorldDAOImpl implements HelloWorldDAO{
	private MongoOperations mongoOps;
	private static final String COLLECTION = MongoDBMain.getCollection();
	public static final MongoClient mongo = MongoDBMain.getMongoClient();
	
	public HelloWorldDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
    }
	
	public void create(HelloWorld helloWorld) {
		System.out.println("DAO: Adding new data");
		this.mongoOps.insert(helloWorld, COLLECTION);
		System.out.println("DAO: Added!");
		
	}

	public void removeById(String id) {
		System.out.println("DAO: Querying data id:"+id);
		Query query = new Query(Criteria.where("_id").is(id));
		System.out.println("DAO: Deleting data id:"+id);
        WriteResult result = this.mongoOps.remove(query, HelloWorld.class, COLLECTION);
        System.out.println("DAO: Deleted!");
		
	}

	public List<HelloWorld> getAll() {
		System.out.println("DAO: Return all data in "+COLLECTION+" collection");
		return this.mongoOps.findAll(HelloWorld.class, COLLECTION);
	}

	public HelloWorld getOneById(String id) {
		System.out.println("DAO: Querying data id:"+id);
		Query query = new Query(Criteria.where("_id").is(id));
		System.out.println("DAO: Return data id:"+id);
        return this.mongoOps.findOne(query, HelloWorld.class, COLLECTION);
	}

	public List<HelloWorld> getManybyName(String name) {
		System.out.println("DAO: Querying all data name:"+name);
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		System.out.println("DAO: Return data");
		return mongoOps.find(query, HelloWorld.class, COLLECTION);
	}

	public void update(String id, String changedName) {
		System.out.println("DAO: Querying data id :"+id);
		Query query = new Query(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("name", changedName);
		System.out.println("DAO: Updating data id: "+id);
		System.out.println("DAO: Changing name to "+changedName);
		this.mongoOps.findAndModify(query, update, HelloWorld.class, COLLECTION);
		
	}



}
