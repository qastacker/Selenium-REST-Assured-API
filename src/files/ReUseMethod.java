package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUseMethod {

	public static JsonPath rawToJson(String resp)
	{
		JsonPath str =new JsonPath(resp);
		return str;
	}
	
	public static JsonPath rawToJsonR(Response r)
	{
		JsonPath resp=r.jsonPath();
		return resp;
	}
}
