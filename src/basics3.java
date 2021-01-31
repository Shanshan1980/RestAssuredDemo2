import static io.restassured.RestAssured.given;
import files.ReusableMethos;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoad;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basics3 {
	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shanshan Zhao\\eclipse-workspace\\DemoProject\\src\\files\\env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void AddAndDeletePlace() {
		
		// BaseURL or Host
		//Tast 1- Grab the response
		RestAssured.baseURI = prop.getProperty("HOST");

		Response res = given().
		queryParam("key", prop.getProperty("KEY")).
		body(payLoad.getPostData()).
		  when().
		  post(resources.placePostData()). 
		  then().assertThat().statusCode(200).contentType(ContentType.JSON).and().
		  body("status", equalTo("OK")).
		  extract().response();
		
		// Task 2- Grab the Place ID from the response 
		JsonPath js = ReusableMethos.rawToJson(res);
		String placeid = js.get("place_id");
		System.out.println(placeid);
		
		// Task 3- place this placeid in the delete request
		given().
		queryParam("key", prop.getProperty("KEY")).
		body("{\r\n" + 
				"\"place_id\":\""+placeid+"\" \r\n" + 
				"}").
		when().
		post("/maps/api/place/delete/json"). 
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
	}

}
