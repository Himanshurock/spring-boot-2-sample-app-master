package sample.actuator;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


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
	
	@Autowired
	//MongoTemplate mongoTemplate = new MongoTemplate(null);
	

	
	
	@Test
	public void mongoTest() {
		System.out.println("=============MongTestIT===========");
		System.out.println("=============MONGO_PORT============="+System.getProperty("MONGO_PORT"));
		System.out.println("=============server.port============="+System.getProperty("server.host"));
		System.out.println("=============All============="+System.getProperties());
		System.out.println("=============All Env============="+System.getenv());
		System.out.println("=============MONGO_PORT Env============="+System.getenv("MONGO_PORT"));
		System.out.println("=============Hostname Env============="+System.getenv("HOSTNAME"));
		
		//Mongo mongo =  new Mongo(LOCALHOST, MONGO_TEST_PORT);
		
		String LOCALHOST = System.getenv("HOSTNAME");
		int MONGO_TEST_PORT = Integer.parseInt(System.getenv("MONGO_PORT"));
		
		//MongoClient mongoClient = new MongoClient();
		
		MongoDbFactory db= new MongoDbFactory() {
			
			@Override
			public DB getLegacyDb() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public PersistenceExceptionTranslator getExceptionTranslator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MongoDatabase getDb(String dbName) throws DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MongoDatabase getDb() throws DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		MongoTemplate mongoTemplate = new MongoTemplate(db);

		Student stud = new Student();
		stud.setFirstName("Test");
		stud.setLastName("Mongo");
		mongoTemplate.save(stud);
		//mongoClient.setReadPreference(readPreference);
	//	System.out.println("=============MongTestIT==========="+mongoClient+mongoClient.getConnectPoint()+mongoClient.getCredentialsList()+mongoClient.getAddress()+mongoClient.getAddress()+mongoClient.getDatabaseNames()+mongoClient.toString());

		
		Query query = Query.query(Criteria.where(stud.getFirstName()).is("Test"));
		List<Student> lst =  mongoTemplate.find(query, Student.class);
		
		System.out.println("=========size==========="+lst.size());
		//Assert.assertEquals(1,lst.size());
	}
}
