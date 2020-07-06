package sample.actuator;

import org.junit.Test;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class HealthIT {

  @BeforeClass
  public static void setup() {
	System.out.println("=======================System.getProperty port===================="+System.getProperty("server.port"));
	System.out.println("=======================System.getProperty host===================="+System.getProperty("server.host"));
      String port = System.getProperty("server.port");
      if (port == null) {
          RestAssured.port = Integer.valueOf(8080);
      }
      else{
          RestAssured.port = Integer.valueOf(port);
      }

      String baseHost = System.getProperty("server.host");
      if(baseHost==null){
          baseHost = "http://localhost";
      }
      RestAssured.baseURI = baseHost;

  }
	
	@Test
    public void running() {
	    System.out.println("========running=======");
	//	given().when().get("/")
         //   .then().statusCode(200);
    }
	
	@Test
    public void message() {
	    System.out.println("========message=======");
	//	given().when().get("/")
         //   .then().body(containsString("Spring boot"));
    }
	
	@Test
    public void fullMessage() {
	    System.out.println("========fullMessage=======");
	//	given().when().get("/")
         //   .then().body("message",equalTo("Spring boot says hello from a Docker container"));
    }
	
	@Test
    public void health() {
	    System.out.println("========health=======");
	//	given().when().get("/actuator/health")
        //    .then().body("status",equalTo("UP"));
    }


}
