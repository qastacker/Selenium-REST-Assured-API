package demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Locations;


public class SerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setName("trial name");
		p.setPhone_number("91 7739379379");
		p.setAddress("29, side layout, cohen 09");
		p.setWebsite("http://rahulshettyacademy.com");
		p.setLanguage("French-IN");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		Locations l=new Locations();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		Response res=given().queryParam("key", "qaclick123")
				.body(p)
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		String resStr=res.asString();
		
		System.out.println(resStr);
		
	}

}
