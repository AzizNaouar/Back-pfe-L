package app.Modele;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Statistique")
public class Statistique 
{
	
	

	@Id
	private String iduser;
	private String stockooredoo;
	private String stockorange;
	private String stocktelecome;
	private String venteooredoo;
	private String venteTelecome;
	private String venteorange;
	private String pointfidalite;
	
	public Statistique(String iduser, String stockooredoo, String stockorange, String stocktelecome,
			String venteooredoo, String venteTelecome, String venteorange,String pointfidalite) 
	{
	
		
		this.iduser = iduser;
		this.stockooredoo = stockooredoo;
		this.stockorange = stockorange;
		this.stocktelecome = stocktelecome;
		this.venteooredoo = venteooredoo;
		this.venteTelecome = venteTelecome;
		this.venteorange = venteorange;
		this.pointfidalite=pointfidalite;
		
	
	}
	
	public Statistique() 
	{
		
	}
	
	public String getIduser() 
	{
		return iduser;
	}
	public void setIduser(String iduser) 
	{
		this.iduser = iduser;
	}
	public String getStockooredoo() 
	{
		return stockooredoo;
	}
	public void setStockooredoo(String stockooredoo) 
	{
		this.stockooredoo = stockooredoo;
	}
	public String getStockorange() 
	{
		return stockorange;
	}
	public void setStockorange(String stockorange) 
	{
		this.stockorange = stockorange;
	}
	public String getStocktelecome() 
	{
		return stocktelecome;
	}
	public void setStocktelecome(String stocktelecome) 
	{
		this.stocktelecome = stocktelecome;
	}
	public String getVenteooredoo() {
		return venteooredoo;
	}
	public void setVenteooredoo(String venteooredoo) {
		this.venteooredoo = venteooredoo;
	}
	public String getVenteTelecome() 
	{
		return venteTelecome;
	}
	public void setVenteTelecome(String venteTelecome) 
	{
		this.venteTelecome = venteTelecome;
	}
	public String getVenteorange() 
	{
		return venteorange;
	}
	public void setVenteorange(String venteorange) 
	{
		this.venteorange = venteorange;
	}
	public String getPointfidalite() 
	{
		return pointfidalite;
	}

	public void setPointfidalite(String pointfidalite) 
	{
		this.pointfidalite = pointfidalite;
	}

	
	
	

}
