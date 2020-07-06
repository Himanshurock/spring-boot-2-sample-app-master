package sample.actuator;

import java.util.List;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoURI;


class Student {
	String firstName;
	String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

public class MongTestIT {
	
	//@Autowired
	private MongoTemplate mongoTemplate;
	

	/*
	 * @Bean public MongoDbFactory mongoDbFactory() throws Exception { String
	 * LOCALHOST = System.getenv("HOSTNAME"); int MONGO_TEST_PORT =
	 * Integer.parseInt(System.getenv("MONGO_PORT"));
	 * 
	 * MongoClient mongoClient = new MongoClient(LOCALHOST, MONGO_TEST_PORT); //
	 * UserCredentials userCredentials = new UserCredentials("", ""); MongoDbFactory
	 * return new ; }
	 * 
	 * @Bean public MongoTemplate mongoTemplate() throws Exception { MongoTemplate
	 * mongoTemplate = new MongoTemplate(mongoDbFactory()); return mongoTemplate; }
	 */
	
	@Test
	public void mongoTest() {
		System.out.println("=============MongTestIT===========");
		System.out.println("=============MONGO_PORT============="+System.getProperty("MONGO_PORT"));
		System.out.println("=============server.port============="+System.getProperty("server.host"));
		System.out.println("=============All============="+System.getProperties());
		System.out.println("=============All Env============="+System.getenv());
		System.out.println("=============MONGO_PORT Env============="+System.getenv("MONGO_PORT"));
		System.out.println("=============Hostname Env============="+System.getenv("HOSTNAME"));
		
		
	//	String LOCALHOST = System.getenv("HOSTNAME");
		int MONGO_TEST_PORT =  Integer.parseInt(System.getenv("MONGO_PORT"));
		
		String LOCALHOST = System.getenv("CF_HOST_NAME");
		
		//MongoURI url = new MongoURI("mongodb://mongo:%s/test");
	//	url.
		//MongoClient mongoClient = new MongoClient(LOCALHOST, MONGO_TEST_PORT);
		
		MongoClient mongoClient = new MongoClient("mongodb://mongo:%s/demo",MONGO_TEST_PORT);
		
		mongoTemplate = new MongoTemplate(mongoClient, "test");
		
		
		
		//Mongo mongo =  new Mongo(LOCALHOST, MONGO_TEST_PORT);
		
	//	String LOCALHOST = System.getenv("HOSTNAME");
		//int MONGO_TEST_PORT = Integer.parseInt(System.getenv("MONGO_PORT"));
		
		//MongoClient mongoClient = new MongoClient("1234", MONGO_TEST_PORT);
		//mongoClient.
		
		/*
		 * MongoDbFactory db= new MongoDbFactory() {
		 * 
		 * @Override public DB getLegacyDb() { // TODO Auto-generated method stub return
		 * null; }
		 * 
		 * @Override public PersistenceExceptionTranslator getExceptionTranslator() { //
		 * TODO Auto-generated method stub return null; }
		 * 
		 * @Override public MongoDatabase getDb(String dbName) throws
		 * DataAccessException { // TODO Auto-generated method stub return null; }
		 * 
		 * @Override public MongoDatabase getDb() throws DataAccessException { // TODO
		 * Auto-generated method stub return null; } }; MongoTemplate mongoTemplate =
		 * new MongoTemplate(db); mongoTemplate.
		 */

		Student stud = new Student();
		stud.setFirstName("Test");
		stud.setLastName("Mongo");
		
		System.out.println("=============mongoTemplate===="+mongoTemplate.toString());
		
		mongoTemplate.save(stud);
		
		//mongoClient.setReadPreference(readPreference);
	//	System.out.println("=============MongTestIT==========="+mongoClient+mongoClient.getConnectPoint()+mongoClient.getCredentialsList()+mongoClient.getAddress()+mongoClient.getAddress()+mongoClient.getDatabaseNames()+mongoClient.toString());

		
		Query query = Query.query(Criteria.where(stud.getFirstName()).is("Test"));
		List<Student> lst =  mongoTemplate.find(query, Student.class);
		
		System.out.println("=========size==========="+lst.size());
		//Assert.assertEquals(1,lst.size());
	}
}
