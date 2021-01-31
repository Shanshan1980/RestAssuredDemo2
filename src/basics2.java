import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class basics2 {
	
	@Test
	public void postData() {
		
		        // BaseURL or Host
				RestAssured.baseURI = "http://216.10.245.166";

				given().
				
				queryParam("key", "qaclick123").
				body("{\r\n" + 
						"\r\n" + 
						"    \"location\":{\r\n" + 
						"\r\n" + 
						"        \"lat\" : -38.383494,\r\n" + 
						"\r\n" + 
						"        \"lng\" : 33.427362\r\n" + 
						"\r\n" + 
						"    },\r\n" + 
						"\r\n" + 
						"    \"accuracy\":50,\r\n" + 
						"\r\n" + 
						"    \"name\":\"Frontline house\",\r\n" + 
						"\r\n" + 
						"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
						"\r\n" + 
						"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
						"\r\n" + 
						"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
						"\r\n" + 
						"    \"website\" : \"http://google.com\",\r\n" + 
						"\r\n" + 
						"    \"language\" : \"French-IN\"\r\n" + 
						"\r\n" + 
						"}\r\n" + 
						"").
				  when().post("/maps/api/place/add/json"). 
				  then().assertThat().statusCode(200).contentType(ContentType.JSON)
				  .and().body("status", equalTo("OK"));
				
		}

}
