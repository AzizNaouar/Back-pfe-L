package app.Modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admin")
public class Admin 
{
     @Id
    private String id;
	private String numtel;
    private String nom;
    private String prenom;        
    private String username;
    private  String password;
    private  String ville;
    private  String adresse;
    public String urlimage;
    public String gouvernourat;
    
    

	public Admin () {}
    
	public Admin (String id, String numtel, String nom, String prenom, String username, String password,
			String ville, String adresse, String urlimage,String gouvernourat) 
	{
		
		this.id = id;
		this.numtel = numtel;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.ville = ville;
		this.adresse = adresse;
		this.urlimage = urlimage;
		this.gouvernourat=gouvernourat;
	}
	
	@Override
	public String toString() 
	{
		return "SousAdmin [id=" + id + ", numtel=" + numtel + ", nom=" + nom + ", prenom=" + prenom
				+ ", username=" + username + ", password=" + password + ", ville=" + ville + ", adresse=" + adresse
				+ ", urlimage=" + urlimage + "]";
	}
	
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getNumtel() 
	{
		return numtel;
	}
	public void setNumtel(String numtel) 
	{
		this.numtel = numtel;
	}
	public String getNom() 
	{
		return nom;
	}
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public String getPrenom() 
	{
		return prenom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getVille() 
	{
		return ville;
	}
	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	public String getAdresse()
	{
		return adresse;
	}
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	public String getUrlimage()
	{
		return urlimage;
	}
	public void setUrlimage(String urlimage) 
	{
		this.urlimage = urlimage;
	}
    
	public String getGouvernourat() 
	{
			return gouvernourat;
	}

    public void setGouvernourat(String gouvernourat) 
    {
         this.gouvernourat = gouvernourat;
	}
    
   

}
