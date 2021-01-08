import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidatn {

	@Test
	public void CostOfBooks() {
		
		int tot=0;
		JsonPath js=new JsonPath(payload.BookPrice());		
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++) {
			//js.get("courses["+i+"].title");
			int c=js.getInt("courses["+i+"].copies");
			int p=js.getInt("courses["+i+"].price");
			int amt=c*p;
			System.out.println(amt);
			tot=tot+amt;
		}
		System.out.println(tot);
		int pAmt=js.getInt("dashboard.purchaseAmount"); 
		Assert.assertEquals(pAmt, tot);
		
	}
}
