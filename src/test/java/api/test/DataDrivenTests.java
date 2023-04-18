package api.test;

import org.testng.Assert;
import api.payload.UserPOJO;
import org.testng.annotations.Test;
import api.utilities.DataProviders;
import api.endpoints.UserEndpoints;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String firstName, String lastName, String userEmail, String userPassword, String userPhone) {
		
		UserPOJO xlData = new UserPOJO();
		System.out.println("entering");
		xlData.setId(Integer.parseInt(userId));
		xlData.setUsername(userName);
		xlData.setFirstName(firstName);
		xlData.setLastName(lastName);
		xlData.setEmail(userEmail);
		xlData.setPassword(userPassword);
		xlData.setPhone(userPhone);
		System.out.println("user excelData:"+xlData.getUsername());
		Response createRes = UserEndpoints.createUser(xlData);
		Assert.assertEquals(createRes.getStatusCode(),200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByUserName(String userName) {
		
				
		Response createRes = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(createRes.getStatusCode(),200);
	}
}
