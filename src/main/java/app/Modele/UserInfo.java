package app.Modele;

public class UserInfo {

	
	private String name;
    private String email;
    private String password;
    
    
	public UserInfo( String name, String email,String password) 
    {
		super();
		
		this.name = name;
		this.email = email;
		this.password=password;
	}
	
    public UserInfo()
    {
    	
    }
    
    public String getPassword() 
    {
		return password;
	}
    
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
    
}
