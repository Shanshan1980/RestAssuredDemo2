
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import files.ReusableMethos;

public class excelDriven {
	// library API testing
	@Test
	public void postData() throws IOException {
				HashMap<String,Object> map = new HashMap<>();
				map.put("name", "RestAssured");
				map.put("isbn", "abcd");
				map.put("aisle", "5682");
				map.put("author", "Rahul");
				
		        RestAssured.baseURI = "http://216.10.245.166";
				Response resp = given().header("Content-Type","application/json").
				body(map).
				when().
				post("/Library/Addbook.php"). 
				then().assertThat().statusCode(200). 
				extract().response();
				
				JsonPath js = ReusableMethos.rawToJson(resp);
				String id=js.get("ID");
				System.out.println(id);

			
	}
}	
	
