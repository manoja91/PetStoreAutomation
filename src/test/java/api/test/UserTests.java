package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;
import api.payload.UserPOJO;
import api.endpoints.UserEndpoints;
import io.restassured.response.*;

public class UserTests {
	String userName;
	Faker faker;
	UserPOJO userPayload;
	
	public Logger logger;
	@BeforeClass
	public void setUpData() {
		 userPayload =new UserPOJO();
		 faker = new Faker();
		 
			
			  userPayload.setId(faker.idNumber().hashCode());
			  userPayload.setUsername(faker.name().username());
			  userPayload.setFirstName(faker.name().firstName());
			  userPayload.setLastName(faker.name().lastName());
			  userPayload.setEmail(faker.internet().emailAddress());
			  userPayload.setPassword(faker.internet().password());
			  userPayload.setPhone(faker.phoneNumber().cellPhone());
			 
			  
			  //logs
				logger = LogManager.getLogger(this.getClass()); 
		 }
	
	@Test(priority = 1)
	public void testPostUser(ITestContext context) {
		
		logger.info("------------------testPostUser-----------------");
		Response createRes = UserEndpoints.createUser(userPayload);
		createRes.then().log().all();
		Assert.assertEquals(createRes.getStatusCode(),200);
		
		//userName = createRes.jsonPath().getString("userName");
		//context.getSuite().setAttribute("userName", userName);
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		System.out.println(userPayload.getUsername()+":User Name in testGetUser Method:"+ this.userPayload.getUsername());
		Response getRes= UserEndpoints.getUser(this.userPayload.getUsername());
		getRes.then().log().all();
		Assert.assertEquals(getRes.getStatusCode(),200);
	
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		//update data using pay load
		 userPayload.setFirstName(faker.name().firstName());
		 userPayload.setLastName(faker.name().lastName());
		 userPayload.setEmail(faker.internet().emailAddress());
		 
		Response updateRes = UserEndpoints.updateUser(userPayload, this.userPayload.getUsername());
		updateRes.then().log().all();
		
		Assert.assertEquals(updateRes.getStatusCode(), 200);
		
		//checking data for update
		Response resAfterUpdate= UserEndpoints.getUser(this.userPayload.getUsername());
		//resAfterUpdate.then().log().all();
		Assert.assertEquals(resAfterUpdate.getStatusCode(),200);
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		Response deleteRes = UserEndpoints.deleteUser(this.userPayload.getUsername());
		deleteRes.then().log().all();
		
		Assert.assertEquals(deleteRes.getStatusCode(), 200);
	}
}
