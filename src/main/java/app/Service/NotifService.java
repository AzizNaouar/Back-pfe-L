package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Modele.Notif;
import app.Repository.NotifRepository;

@Service
public class NotifService 
{
	
	     @Autowired
		 NotifRepository notif;
	     
	   public void Insert(Notif n)
	   {
		   notif.insert(n);
	   }
	   
	   public List<Notif> GetNotif(String IdUtili)
	   {
		   return notif.findNotif(IdUtili);
	   }
	   
	   public List<Notif> GetNotifaa()
	   {
		   return notif.findAll();
		}
	   
	   public void Delete(Notif c)
	   {
		  notif.delete(c);
	   }
	   
	   public Notif FindNotifByidcommande(String idcommande)
	   {
		   
		   return(notif.findByidcommande(idcommande));
	   }
	   
	   
	 	    
}