package app.Modele;

public class reponsesendcommande 
{
	private String response;
	private Boolean verif;
	
	public reponsesendcommande(String response, Boolean verif) 
	{
		super();
		this.response = response;
		this.verif = verif;
	}
	public String getResponse() 
	{
		return response;
	}
	public void setResponse(String response) 
	{
		this.response = response;
	}
	public Boolean getVerif() 
	{
		return verif;
	}
	public void setVerif(Boolean verif) 
	{
		this.verif = verif;
	}

}
