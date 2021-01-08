import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";

		String ans=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract()
				.response().asString();

		System.out.println(ans);
		JsonPath js=new JsonPath(ans);
		String pl_id=js.getString("place_id");
		System.out.println(pl_id);

		// Update Place
		String nAddrss="11 Winter V Street, CBE";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.UpdatePlace(pl_id, nAddrss)).when().put("maps/api/place/update/json").then().assertThat()
				.log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

		// Get Place

		String getPlaceResp=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", pl_id).when()
				.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		JsonPath js2=new JsonPath(getPlaceResp);
		String actAddrss=js2.getString("address");
		System.out.println(actAddrss);

	}

}
