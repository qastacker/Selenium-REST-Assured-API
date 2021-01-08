package files;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StJson {
	
	@Test
	public void addDBuk() throws IOException {
		
		RestAssured.baseURI="http://216.10.245.166";

		Response resp=given().header("Content-Type","application/json")
				.body(GenerateStringFromResource("C:\\Users\\Adol-sys-410\\Downloads\\addbuk.json"))
				.when()
				.post("/Library/Addbook.php")
				.then().assertThat().statusCode(200)
				.extract().response();
		
		JsonPath js= ReUseMethod.rawToJsonR(resp);
		//System.out.println(js);
		String id=js.get("ID");
		System.out.println(id);

	}

	public static String GenerateStringFromResource(String path) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
