package app.Modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Notification")
public class Notif {
	
	
	    @Id
	    private String id;
		private String IdUtili;
	    private String text;
	    private String date;
		private String idcommande;
	    
	    public Notif(String idUtili, String text, String date,String idcommande) 
	    {
			super();
			this.IdUtili = idUtili;
			this.text = text;
			this.date = date;
			this.idcommande=idcommande;
		}
	    
	    public Notif()
	    {
	    	
	    }
	    
	    public String getId() 
	    {
			return id;
		}
		public void setId(String id) 
		{
			this.id = id;
		}
		public String getIdUtili() 
		{
			return IdUtili;
		}
		public void setIdUtili(String idUtili) 
		{
			IdUtili = idUtili;
		}
		public String getText() 
		{
			return text;
		}
		public void setText(String text) 
		{
			this.text = text;
		}
		public String getDate() 
		{
			return date;
		}
		public void setDate(String date) 
		{
			this.date = date;
		}
		public String getIdcommande() 
		{
				return idcommande;
		}

		public void setIdcommande(String idcommande) 
		{
				this.idcommande = idcommande;
		}
		
	 
}
