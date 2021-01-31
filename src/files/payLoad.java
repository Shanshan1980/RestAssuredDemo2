package files;

public class payLoad {
	
	public static String getPostData() {
	
		String b = "{\r\n" + 
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
				"}\r\n";
		return b;
	}
	
	public static String Addbook() {
		
		String payload="{\r\n" + 
				"\r\n" + 
				"\"name\":\"New Book08\",\r\n" + 
				"\"isbn\":\"bcd\",\r\n" + 
				"\"aisle\":\"228\",\r\n" + 
				"\"author\":\"Shanshan Zhao\"\r\n" + 
				"}\r\n";
	    return payload;
		
	}
	
	

}
