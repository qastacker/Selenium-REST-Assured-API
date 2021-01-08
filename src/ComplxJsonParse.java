import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplxJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js=new JsonPath(payload.BookPrice());		
		int count=js.getInt("courses.size()");
		
		System.out.println(count);
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		System.out.println(js.get("courses[0].title").toString());
		System.out.println("/***********************************/");
		for(int i=0;i<count;i++) {
			//js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		System.out.println(js.get("courses[2].copies").toString());
		System.out.println(js.getInt("courses[2].copies"));
	}

}
