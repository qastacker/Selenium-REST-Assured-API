package demo;

import static io.restassured.RestAssured.given;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

public class OauthTest2 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
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
		 
		JsonPath js=new JsonPath(response);
		String accessToken=js.getString("access_token");
		System.out.println(accessToken);
		
		
		 String resp=given().queryParam("access_token",accessToken) 
				 .when()
				 .get("https://rahulshettyacademy.com/getCourse.php")
				 .asString();
		  System.out.println(resp);
		  
		  GetCourse gc=given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
					.when()
					.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		  System.out.println(gc);
		  System.out.println(gc.getInstructor());
			System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	}

}
