package api.endpoints;


/* 
 * Swagger URI -- > https://petstore.swagger.io
 * 
 * Create User (post) --> https://petstore.swagger.io/v2/user
 * Get User (get) --> https://petstore.swagger.io/v2/user/{userName}
 * Update User (put) --> https://petstore.swagger.io/v2/user/{userName}
 * Delete User (delete) --> https://petstore.swagger.io/v2/user/{userName}
 */
public class Routes {

	public static String base_Url = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_User_Url = base_Url+"/user";
	public static String get_User_Url = base_Url+"/user/{username}";
	public static String put_User_Url = base_Url+"/user/{username}";
	public static String delete_User_Url = base_Url+"/user/{username}";
	
	//Store Module
	
	//Pet Module
	
}
