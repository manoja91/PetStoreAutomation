package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java file -- create for to perform CRUD operations (Create, Read, Update and Delete)
public class UserEndpoints2 {

	
	//get end point URL from properties file
	public static ResourceBundle get_URL(){
		ResourceBundle resouceBundle = ResourceBundle.getBundle("routesEndpoints");
		return resouceBundle;
	}
	
	//Create User
	public static Response createUser(UserPOJO payload) {
		String post_User_Url = get_URL().getString("post_User_Url");
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(post_User_Url);
		return response;
	}
	
	//Get User
	public static Response getUser(String username) {
		String get_User_Url = get_URL().getString("get_User_Url");
		Response response = given()
								.pathParam("username", username)
							.when()
								.get(get_User_Url);
		return response;
	}
	
	//Update User
	public static Response updateUser(UserPOJO payload,String username) {
		String put_User_Url = get_URL().getString("put_User_Url");
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", username)
								.body(payload)
							.when()
								.put(put_User_Url);
		return response;
	}
	
	//Delete User
	public static Response deleteUser(String username) {
		String delete_User_Url = get_URL().getString("delete_User_Url");
		Response response = given()
								.pathParam("username", username)
							.when()
								.delete(delete_User_Url);
		return response;
	}
	
}
