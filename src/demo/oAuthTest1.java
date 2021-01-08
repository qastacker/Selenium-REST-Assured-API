package demo;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

public class oAuthTest1 {
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		/*
		 * String url=
		 * "https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2F0wFFEdapr9sNZf357kpIdTqBcuUSLaqXLIRaNDkXa42DEiAWDb779KVXSD4zHJ2k9tj_IovhXh2LJXyj1TxJJRA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
		 * 
		 * String partialcode=url.split("code=")[1]; String
		 * code=partialcode.split("&scope")[0];
		 */
		String[] courseTitles= { "Selenium Webdriver Java","Cypress","Protractor"};
		String code="4%2F2QGvho6ciHLjEioMkevR0eWmzXAdV-Zucar1YHrIh2urAgZB73vzelltD-hYFr6LtPpijmXi2TNhTjtT_taQWj8";
		System.out.println(code);

		String response=given().urlEncodingEnabled(false) 
						.queryParams("code", code)
						.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
						.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
						.queryParams("grant_type", "authorization_code")
						.queryParams("state", "verifyfjdse")
						.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
						// .queryParam("scope",
						// "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
						.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
						.when().log().all()
						.post("https://www.googleapis.com/oauth2/v4/token").asString();
		 //System.out.println(response);

		JsonPath jsonPath=new JsonPath(response);
		String accessToken=jsonPath.getString("access_token");
		//System.out.println(accessToken);
		/*
		 * String r2=given().contentType("application/json").
		 * queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
		 * .when() .get("https://rahulshettyacademy.com/getCourse.php") .asString();
		 * System.out.println(r2);
		 */
		String resp=given().queryParam("access_token",accessToken) 
				 .when()
				 .get("https://rahulshettyacademy.com/getCourse.php")
				 .asString();
		System.out.println(resp);
		  
		GetCourse gc=given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		List<Api> apiCours=gc.getCourses().getApi();
		for(int i=0;i<apiCours.size();i++) {
			
			if(apiCours.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apiCours.get(i).getPrice());
			}

		}
		ArrayList<String> a= new ArrayList<String>();
		
		 List<WebAutomation> WebAutomatn=gc.getCourses().getWebAutomation();
		for(int j=0;j<WebAutomatn.size();j++) {
			
				//System.out.println(WebAutomatn.get(j).getCourseTitle());
			a.add(WebAutomatn.get(j).getCourseTitle());

		}
		
		List<String> xpectdList=Arrays.asList(courseTitles);
		Assert.assertTrue(a.equals(xpectdList));
	}
}
