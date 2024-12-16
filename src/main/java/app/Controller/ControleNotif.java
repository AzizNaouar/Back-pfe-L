package app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.Commande;
import app.Modele.Notif;
import app.Service.CommandeService;
import app.Service.NotifService;

@RestController
public class ControleNotif 
{
	
	 //injection de dépondence
	 @Autowired
	 NotifService notif;
	 
	 @Autowired
	 CommandeService  commandeservice;
	
     
     @PostMapping("/insertNotif")
     public void Insert(@RequestBody Notif n)
	    {
		 notif.Insert(n);
        }
     
     
     @CrossOrigin
     @GetMapping("/GetNotif/{IdUtili}")
     public List<Notif> GetNotif(@PathVariable String IdUtili)
     {
     	return notif.GetNotif(IdUtili);
     }
     
     
     @CrossOrigin
     @PostMapping("/delete")
     public void deleteNotif(@RequestBody Commande c)
     {
    	 Notif notife=notif.FindNotifByidcommande(c.getId());
    	 notif.Delete(notife);
     }
     
     @CrossOrigin
     @PostMapping("/insertNotification")
     public void InsertNotif(@RequestBody Commande c)
	    {
    	 String  msg=" Votre commande de "+c.getQuantite()+" voucher "+c.getOperateure()+" a eté valider";
    	 Notif n=new Notif(c.getIdgrossiste(),msg,c.getDatee(),c.getId());
		 notif.Insert(n);
        }
 
     
     @CrossOrigin
     @PostMapping("/deleteNotification")
     public void deleteNotification(@RequestBody Notif n)
     {
    	 notif.Delete(n);
     }
   
    

}
