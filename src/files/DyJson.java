package files;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DyJson {

	@Test(dataProvider="BookData")
	public void addBuk(String ais,String isbn) {
		
		RestAssured.baseURI="http://216.10.245.166";

		String response=given().log().all().header("Content-Type","application/json")
				.body(payload.AddBuk(ais,isbn))
				.when()
				.post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		
		JsonPath js= ReUseMethod.rawToJson(response);
		String id=js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData(){
		
		return new Object[][]  {{"stir","478"},{"prj","247"},{"fwr","534"}};
	}
}
