package files;

public class payload {

	public static String AddPlace() {
		// TODO Auto-generated method stub
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"rahulshettyacademy house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"https://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" +
				"";
	}

	public static String UpdatePlace(String pl_id,String nAddrss) {
		// TODO Auto-generated method stub
		
		String placeID="{\r\n" + 
				"\"place_id\":\""+pl_id+"\",\r\n" + 
				"\"address\":\""+nAddrss+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"";
		
		return placeID;
	}
	
	public static String BookPrice() {
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 910,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"OTT\",\r\n" + 
				"      \"price\": 25,\r\n" + 
				"      \"copies\": 15\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
	}
	
	public static String AddBuk(String ais,String isbn) {
		String addbuk= "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Adv Sel Automation with Java\",\r\n" + 
				"\"isbn\":\""+ais+"\",\r\n" + 
				"\"aisle\":\""+isbn+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
		return addbuk;
		
	}
}
