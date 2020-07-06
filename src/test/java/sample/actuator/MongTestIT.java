package sample.actuator;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


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
	
	
	@Test
	public void mongoTest() {
		System.out.println("=============MongTestIT===========");
		Student stud = new Student();
		stud.setFirstName("Test");
		stud.setLastName("Mongo");
		mongoTemplate.save(stud);
		
		Query query = Query.query(Criteria.where(stud.getFirstName()).is("Test"));
		List<Student> lst =  mongoTemplate.find(query, Student.class);
		
		System.out.println("===================="+lst.size());
		//Assert.assertEquals(1,lst.size());
	}
}
