package app.Modele;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Grossiste")
public class Grossiste {
	
	
	    @Id
	    private String id;
		private String numtel;
	    private String nom;
	    private String prenom;        
	    private String username;
	    private String password;
	    private String ville;
	    private String adresse;
	    public  String urlimage;
	    public  String gouvernourat;
	    public  String IdUser;
	   
	    
	    
	 
	    
		public Grossiste(String id, String numtel, String nom, String prenom, String username, String password,
				String ville, String adresse, String urlimage,String gouvernourat,String IdUser) 
		
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
			this.IdUser=IdUser;
			
		}
		   public Grossiste() {}
		
		@Override
		public String toString() 
		{
			return "Grossiste [id=" + id + ", numtel=" + numtel + ", nom=" + nom + ", prenom=" + prenom
					+ ", username=" + username + ", password=" + password + ", ville=" + ville + ", adresse=" + adresse
					+ ", urlimage=" + urlimage + "]";
		}
		
		public String getid() 
		{
			return id;
		}
		public void setid(String id) 
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
		
		 public String getIdUser() 
		 {
				return IdUser;
		 }
		 
		 public void setIdSousAdmin(String iduser) 
		 {
				IdUser = iduser;
		 }
	     
		 

}
