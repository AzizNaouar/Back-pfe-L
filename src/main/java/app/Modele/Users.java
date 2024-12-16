package app.Modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class Users 
{
	
	@Id
	public String id;
	public String username;
	public String password;
	public String type;
	
	
	public Users() {}
    public Users(String id,String username, String password, String type) {
		this.id=id;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
}
