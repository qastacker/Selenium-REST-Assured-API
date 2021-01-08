package demo;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import files.test1;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;


public class oAuthTest{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adol-sys-410\\Downloads\\ujars\\chromedriver.exe"); 
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--incognito");
		  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		  WebDriver driver = new ChromeDriver(capabilities);
		  
		  driver.get("https://accounts.google.com/signin/oauth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email"
		  +"&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com"
		  +"&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&state=verifyfjdss&o2v=2&as=U_oeMUvffAvsKqlCe7LCEw&flowName=GeneralOAuthFlow"); 
		  driver.findElement(By.cssSelector("input[type='email']")).sendKeys("azharhot04");
		  driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Azharhot1994@");
		  driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER); 
		  Thread.sleep(5000); 
		  String url=driver.getCurrentUrl(); 
		  String partial=url.split("code=")[1]; 
		  String code=partial.split("&scope=")[0];
		  System.out.println(code);
		 
		
		//String code="4%2F0wHgU701MQZJrVai4RfdUtRnS57RZbcIqixI46_QJssczRA-QEozv-e2u_4EYS56_xqsyfd6NaJOxXcIpb4hyoE";

		
		String accessTokenResp=given().urlEncodingEnabled(false)
				.queryParam("code",code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grand_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(accessTokenResp);
		String accessToken=js.getString("access_token");
		System.out.println(accessToken);
		
		
		 String resp=given().queryParam("access_token",accessToken) 
				 .when()
				 .get("https://rahulshettyacademy.com/getCourse.php")
				 .asString();
		  System.out.println(resp);
		 
		
		
	}

}
