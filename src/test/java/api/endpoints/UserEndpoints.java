package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java file -- create for to perform CRUD operations (Create, Read, Update and Delete)
public class UserEndpoints {

	//Create User
	public static Response createUser(UserPOJO payload) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.post_User_Url);
		return response;
	}
	
	//Get User
	public static Response getUser(String username) {
		
		Response response = given()
								.pathParam("username", username)
							.when()
								.get(Routes.get_User_Url);
		return response;
	}
	
	//Update User
	public static Response updateUser(UserPOJO payload,String username) {
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", username)
								.body(payload)
							.when()
								.put(Routes.put_User_Url);
		return response;
	}
	
	//Delete User
	public static Response deleteUser(String username) {
		
		Response response = given()
								.pathParam("username", username)
							.when()
								.delete(Routes.delete_User_Url);
		return response;
	}
	
}
