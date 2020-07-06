package sample.actuator;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.MongoClient;


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
	MongoTemplate mongoTemplate;
	
	//MongoClient mongoClient = new MongoClient();
	
	
	@Test
	public void mongoTest() {
		System.out.println("=============MongTestIT===========");
		System.out.println("=============server.port============="+System.getProperty("server.port"));
		System.out.println("=============server.port============="+System.getProperty("server.host"));
		System.out.println("=============Allt============="+System.getProperties());


		Student stud = new Student();
		stud.setFirstName("Test");
		stud.setLastName("Mongo");
	//	mongoTemplate.save(stud);
		//mongoClient.setReadPreference(readPreference);
	//	System.out.println("=============MongTestIT==========="+mongoClient+mongoClient.getConnectPoint()+mongoClient.getCredentialsList()+mongoClient.getAddress()+mongoClient.getAddress()+mongoClient.getDatabaseNames()+mongoClient.toString());

		
		Query query = Query.query(Criteria.where(stud.getFirstName()).is("Test"));
		List<Student> lst =  mongoTemplate.find(query, Student.class);
		
		System.out.println("===================="+lst.size());
		//Assert.assertEquals(1,lst.size());
	}
}
