package app.Modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ChiffreAffaire")

public class ChiffreAffaire 
{
	
	
	
	   @Id
	   private String id;
	   private String type;
	   private String janvier;
	   private String février;
	   private String mars;
	   private String avril;
	   private String mai;
	   private String juin;
	   private String juillet;
	   private String août;
	   private String septembre;
	   private String octobre;
	   private String novembre;
	   private String décembre;
	   
	  
	   	   public ChiffreAffaire(String id, String janvier, String février, String mars, String avril, String mai, String juin,
	   			String juillet, String août, String septembre, String octobre, String novembre, String décembre,String type) {
	   		super();
	   		this.id = id;
	   		this.janvier = janvier;
	   		this.février = février;
	   		this.mars = mars;
	   		this.avril = avril;
	   		this.mai = mai;
	   		this.juin = juin;
	   		this.juillet = juillet;
	   		this.août = août;
	   		this.septembre = septembre;
	   		this.octobre = octobre;
	   		this.novembre = novembre;
	   		this.décembre = décembre;
	   		this.type=type;
	   	}
	 
	   
	
   public ChiffreAffaire() 
   {
			super();
   }



   public String getId() 
   {
		return id;
   }
	public void setId(String id) 
     {
		this.id = id;
	}
	
	public String getType() 
	 {
			return type;
	 }

	public void setType(String type) 
		{
			this.type = type;
		}
		
	public String getJanvier() {
		return janvier;
	}
	public void setJanvier(String janvier) {
		this.janvier = janvier;
	}
	public String getFévrier() {
		return février;
	}
	public void setFévrier(String février) {
		this.février = février;
	}
	public String getMars() {
		return mars;
	}
	public void setMars(String mars) {
		this.mars = mars;
	}
	public String getAvril() {
		return avril;
	}
	public void setAvril(String avril) {
		this.avril = avril;
	}
	public String getMai() {
		return mai;
	}
	public void setMai(String mai) {
		this.mai = mai;
	}
	public String getJuin() {
		return juin;
	}
	public void setJuin(String juin) {
		this.juin = juin;
	}
	public String getJuillet() {
		return juillet;
	}
	public void setJuillet(String juillet) {
		this.juillet = juillet;
	}
	public String getAoût() {
		return août;
	}
	public void setAoût(String août) {
		this.août = août;
	}
	public String getSeptembre() {
		return septembre;
	}
	public void setSeptembre(String septembre) {
		this.septembre = septembre;
	}
	public String getOctobre() {
		return octobre;
	}
	public void setOctobre(String octobre) {
		this.octobre = octobre;
	}
	public String getNovembre() {
		return novembre;
	}
	public void setNovembre(String novembre) {
		this.novembre = novembre;
	}
	public String getDécembre() {
		return décembre;
	}
	public void setDécembre(String décembre) {
		this.décembre = décembre;
	}

  
}
