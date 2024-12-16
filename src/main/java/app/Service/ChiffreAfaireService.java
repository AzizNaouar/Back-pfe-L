package app.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.ChiffreAffaire;
import app.Repository.ChiffreAfaireRepository;

@Service
public class ChiffreAfaireService 
{
	
	
	@Autowired 
	ChiffreAfaireRepository chiffreaffairerepository;
    String month=new SimpleDateFormat("MMMM").format(new Date());
	
	
	public void updatechiffreafaire(Double chiffre,String id,String type)
    
	{
		Double montant;
		Double totale;
		ChiffreAffaire chiffree = chiffreaffairerepository.findByid(id);
		if(chiffree!=null)
		{
			switch(month)
			{
			case "janvier":
		    
			montant=Double.parseDouble(chiffree.getJanvier());
	        totale=montant+chiffre;
	        chiffree.setJanvier(totale+"");
	        chiffree.setFévrier("0"); chiffree.setMars("0");chiffree.setAvril("0"); chiffree.setMai("0");
	        chiffree.setJuin("0");chiffree.setJuillet("0"); chiffree.setAoût("0"); chiffree.setSeptembre("0");
	        chiffree.setOctobre("0");chiffree.setNovembre("0");chiffree.setDécembre("0");
	        chiffreaffairerepository.save(chiffree);
			break;
			case "février" :  
			
			montant=Double.parseDouble(chiffree.getFévrier());
            totale=montant+chiffre;
            chiffree.setFévrier(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "mars" :  
			
			montant=Double.parseDouble(chiffree.getMars());
            totale=montant+chiffre;
            chiffree.setMars(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "avril" :
			
			montant=Double.parseDouble(chiffree.getAvril());
            totale=montant+chiffre;
            chiffree.setAvril(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "mai" :   
				
			montant=Double.parseDouble(chiffree.getMai());
            totale=montant+chiffre;
            chiffree.setMai(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "juin" : 
			
			montant=Double.parseDouble(chiffree.getJuin());
			totale=montant+chiffre;
			chiffree.setJuin(totale+"");
			chiffreaffairerepository.save(chiffree);
			break;
			case "juillet" :  
			
			montant=Double.parseDouble(chiffree.getJuillet());
            totale=montant+chiffre;
            chiffree.setJuillet(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "août" :  
			
			montant=Double.parseDouble(chiffree.getAoût());
            totale=montant+chiffre;
            chiffree.setAoût(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "septembre" :  
			
			montant=Double.parseDouble(chiffree.getSeptembre());
            totale=montant+chiffre;
            chiffree.setSeptembre(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "octobre" :  
			
			montant=Double.parseDouble(chiffree.getOctobre());
            totale=montant+chiffre;
            chiffree.setOctobre(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "novembre" :  
			
			montant=Double.parseDouble(chiffree.getNovembre());
            totale=montant+chiffre;
            chiffree.setNovembre(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;
			case "décembre" :  
			
			montant=Double.parseDouble(chiffree.getDécembre());
            totale=montant+chiffre;
            chiffree.setDécembre(totale+"");
            chiffreaffairerepository.save(chiffree);
			break;     
			}
			
		}
		
		if(chiffree==null)
		{
	
			ChiffreAffaire  ciffree=new ChiffreAffaire (id,"0","0","0","0","0","0","0","0","0","0","0","0",type);
			
			switch(month)
			{
			case "janvier": ciffree.setJanvier(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "février" : ciffree.setFévrier(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "mars" : ciffree.setMars(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "avril" :ciffree.setAvril(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "mai" :   ciffree.setMai(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "juin" : ciffree.setJuin(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "juillet" : ciffree.setJuillet(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "août" : ciffree.setAoût(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "septembre" : ciffree.setSeptembre(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "octobre" : ciffree.setOctobre(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;
			case "novembre" : ciffree.setNovembre(chiffre+"");chiffreaffairerepository.save(ciffree);
			case "décembre" : ciffree.setDécembre(chiffre+"");chiffreaffairerepository.save(ciffree);
			break;     
			}
		 		
		}
	}
	
	
	public ChiffreAffaire getchiffre(String id)
	{	
		 return(chiffreaffairerepository.findByid(id));
	}
	
	
	
	
	
	public String getAll(String type)
	{
		double totale = 0;
		List<ChiffreAffaire> list=chiffreaffairerepository.findBytype(type);
		for(int i=0;i<list.size();i++)
		{
		 totale=totale+Double.parseDouble(list.get(i).getJanvier())+Double.parseDouble(list.get(i).getFévrier())+
		 Double.parseDouble(list.get(i).getMars())+Double.parseDouble(list.get(i).getAvril())+Double.parseDouble(list.get(i).getMai())+
		 Double.parseDouble(list.get(i).getJuin())+Double.parseDouble(list.get(i).getJuillet())+Double.parseDouble(list.get(i).getAoût())+
		 Double.parseDouble(list.get(i).getSeptembre())+Double.parseDouble(list.get(i).getOctobre())+Double.parseDouble(list.get(i).getNovembre())+
		 Double.parseDouble(list.get(i).getDécembre());
		}
			return (totale+"");
	}
	
	
	
	

}
