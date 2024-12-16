package app.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Modele.Statistique;
import app.Repository.StatistiqueRepository;

@Service
public class ServiceStatistique 
{
	@Autowired
	StatistiqueRepository statistiquerepository;
	
	
	public void Insert(Statistique statistique)
	{
		statistiquerepository.insert(statistique);
	}
	
	public void delete(Statistique statistique)
    {
		statistiquerepository.delete(statistique);
	}
	
	public void save(Statistique s)
	
	 {
		statistiquerepository.save(s);
	 }
	
	public Statistique findbyiduser(String id)
	{
		return(statistiquerepository.findByiduser(id));
	}
	
	
	public void updatastock(String iduser,int stocko,String type)
	{
		int stock=0;
		if(statistiquerepository.existsById(iduser))
		{
		Statistique sta=statistiquerepository.findByiduser(iduser);
		if(type.equals("ooredoo"))
		{
			 stock=((Integer.parseInt(sta.getStockooredoo()))+stocko);
			 sta.setStockooredoo(stock+"");
		}
		if(type.equals("orange"))
		{
			stock=((Integer.parseInt(sta.getStockorange()))+stocko);
			sta.setStockorange(stock+"");
		}
		if(type.equals("telecom"))
		{
			stock=((Integer.parseInt(sta.getStocktelecome()))+stocko);
			sta.setStocktelecome(stock+"");
		}
		
		
		save(sta);
		}
		else if(statistiquerepository.existsById(iduser)==false)
		{
			if(type.equals("ooredoo"))
			{
				Statistique sta=new Statistique(iduser,stocko+"","0","0","0","0","0","0");
			    this.Insert(sta);
			}
			if(type.equals("orange"))
			{
				Statistique sta=new Statistique(iduser,"0",stocko+"","0","0","0","0","0");
			    this.Insert(sta);
			}
			if(type.equals("telecom"))
			{
				Statistique sta=new Statistique(iduser,"0","0",stocko+"","0","0","0","0");
			       this.Insert(sta);
			}
				
  		}
			
	}
	
	
	public void deleteupdatestat(String iduser,int stocko,String type)
	{

		int stock=0;
		if(statistiquerepository.existsById(iduser))
		{
		Statistique sta=statistiquerepository.findByiduser(iduser);
		if(type.equals("ooredoo"))
		{
			 stock=((Integer.parseInt(sta.getStockooredoo()))-stocko);
			 sta.setStockooredoo(stock+"");
		}
		if(type.equals("orange"))
		{
			stock=((Integer.parseInt(sta.getStockorange()))-stocko);
			sta.setStockorange(stock+"");
		}
		if(type.equals("telecom"))
		{
			stock=((Integer.parseInt(sta.getStocktelecome()))-stocko);
			sta.setStocktelecome(stock+"");
		}
		
		
		save(sta);
		}
		
	}
	
	public void UpdatePointFidélité(String iduser,int nbrpoint,String type)
	{
		

		int stock=0;
		if(statistiquerepository.existsById(iduser))
		{
		Statistique sta=statistiquerepository.findByiduser(iduser);
		if(type.equals("ooredoo"))
		{
			 stock=((Integer.parseInt(sta.getPointfidalite()))+nbrpoint);
			 sta.setPointfidalite(stock+"");
		}
		if(type.equals("orange"))
		{
			stock=((Integer.parseInt(sta.getPointfidalite()))+nbrpoint);
			sta.setPointfidalite(stock+"");
		}
		if(type.equals("telecom"))
		{
			stock=((Integer.parseInt(sta.getPointfidalite()))+nbrpoint);
			sta.setPointfidalite(stock+"");
		}
		
		
		save(sta);
		}
		
	}
	
	
	public String getnbrpoint(String id)
	{
		String nbrpoint="";
		if(statistiquerepository.existsById(id))
		{
		nbrpoint=statistiquerepository.findByiduser(id).getPointfidalite();
		}
		return nbrpoint;
	}
	
	
	
	
	
	
	
	
	public void updateventestat(String iduser,int stocko,String type)
	{
		int stock=0;
		if(statistiquerepository.existsById(iduser))
		{
		Statistique sta=statistiquerepository.findByiduser(iduser);
		if(type.equals("ooredoo"))
		{
			 stock=((Integer.parseInt(sta.getVenteooredoo()))+stocko);
			 sta.setVenteooredoo(stock+"");
		}
		if(type.equals("orange"))
		{
			stock=((Integer.parseInt(sta.getVenteorange()))+stocko);
			sta.setVenteorange(stock+"");
		}
		if(type.equals("telecom"))
		{
			stock=((Integer.parseInt(sta.getVenteTelecome()))+stocko);
			sta.setVenteTelecome(stock+"");
		}
		
		save(sta);
		}
		
	}
	
	//get the pourcentage of data les plus vendu
	public ArrayList<Integer> getporcent(String id)
    {
		
		ArrayList<Integer>list=new ArrayList<Integer>();
		if(statistiquerepository.existsById(id))
		{
			Statistique sta=statistiquerepository.findByiduser(id);
			int totale=(Integer.parseInt(sta.getVenteooredoo())+Integer.parseInt(sta.getVenteorange())+Integer.parseInt(sta.getVenteTelecome()));

			int smooredoo=Integer.parseInt(sta.getVenteooredoo());
			int smorange=Integer.parseInt(sta.getVenteorange());
			int smtelecome=Integer.parseInt(sta.getVenteTelecome());
		
			list.add((totale));
			list.add((smooredoo));
			list.add((smorange));
			list.add((smtelecome));
	    }
		
		return (list);
		
	}
	
	

	
	
	
	
	
	}
	
	
	


