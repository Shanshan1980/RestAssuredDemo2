import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import files.ReusableMethos;

public class basics {

	@Test
	public void Test() {
		// TODO Auto-generated method stub

		// BaseURL or Host
		RestAssured.baseURI = "https://maps.googleapis.com";

		given().
		param("location", "-33.8670522,151.1957362").
		param("key", "AIzaSyBAKQcxYuOgL5rSbSIFDtdMjZvjjhMgoT0").
		param("radius", "500").
		
		when().get("/maps/api/place/nearbysearch/json")
		.then()
		.assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().body("results[0].name", equalTo("Sydney"))
		.and().body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
		.and().header("server","scaffolding on HTTPServer2");
		
		
		

	}

}
