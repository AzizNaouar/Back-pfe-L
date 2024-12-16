package app.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.Commande;
import app.Modele.Grossiste;
import app.Modele.Notif;
import app.Modele.Response;
import app.Service.CommandeService;
import app.Service.GrossisteService;
import app.Service.NotifService;

@RestController
public class ControleCommande 
{
	
	@Autowired
	CommandeService commandeservice;
	@Autowired
	 NotifService notifservice;
	@Autowired
	GrossisteService grossisteservice;
	
	
     Response response;
     Date aujourdhui = new Date();
	 String message="";
	 String date=aujourdhui.toString();
	 String[] list=date.split(" ");
	 String dateActuelle=list[2]+" "+list[1]+" "+list[5];
	 String texte=list[3];
	  
	  
	 @CrossOrigin
     @PostMapping("/InsertCommande")
	 public Response InsertCommande(@RequestBody Commande c)
	 {
		 
	
		 Grossiste grossiste=grossisteservice.FindById(c.getIdgrossiste());
		
		try
		{
			c.setNomgrossiste(grossiste.getNom()+" "+grossiste.getPrenom());
			commandeservice.AddCommande(c,dateActuelle);
		
	        List<Commande> lisft=commandeservice.Find("false",grossiste.getid());
		    message=lisft.size()+"";
		}
		catch(Exception s)
		{
			message=s.getMessage();
		}
		
	   response=new Response(message);
	   return response;
		
	 }
	 
	 
	 @CrossOrigin
     @PostMapping("/DeleteCommande")
	 public void deletecommande( @RequestBody Commande c)
	 {
		commandeservice.deleteCommande(c);
	 }
	
	 @CrossOrigin
     @PostMapping("/UpdateCommande")
	 public void updatecommande(Commande c,String op)
	 {
		commandeservice.UpdateCommande(c,op);
	 }
	 
	@CrossOrigin
    @GetMapping("/FindAllCommande/{id}/{payer}")
	public List<Commande> FindAllCommandesg(@PathVariable String id,@PathVariable String payer)
	{
		return (commandeservice.FindAllCommandessg(id,payer));
	}
	 
	 @CrossOrigin
     @GetMapping("/FindAllCommandeg/{id}/{payer}")
   	 public List<Commande> FindAllCommandeg(@PathVariable String id,@PathVariable String payer)
	 {
		return (commandeservice.FindAllCommandeg(id,payer));
	 }
	 
	 
	 @CrossOrigin
     @DeleteMapping("/deleteCommande/{id}")
	 public void DeleteCommande(@PathVariable String id)
	 {
		commandeservice.Delete(id);
		
	 }
	 
	 @CrossOrigin
	 @GetMapping("/GetCommandNoPayer/{payer}")
	 public List<Commande> FindCommande(@PathVariable String payer)
	 {
		 return(commandeservice.FindCommandeByPayer(payer));
	 }
	 
	 @CrossOrigin
	 @PostMapping("/deletecommande")
	 public void  deleteCommande(@RequestBody Commande comm)
	 {
		commandeservice.deletecommande(comm);
	 }
	 
	 @CrossOrigin
     @PostMapping("/update/{id}")
	 public void update(@RequestBody ArrayList<Commande> listc,@PathVariable String id)
	 {
		 Grossiste grossiste=grossisteservice.FindById(id);
		 for(int i=0;i<listc.size();i++)
		 {
			 listc.get(i).setPayer("true");
			Notif notif=new Notif(grossiste.IdUser,grossiste.getNom()+" "+grossiste.getPrenom()+" passer une commande de "+listc.get(i).getQuantite()+" voucher "+listc.get(i).getOperateure(),listc.get(i).getDatee()+" "+texte,listc.get(i).getId());
		       notifservice.Insert(notif);
			 commandeservice.updatecommande(listc.get(i));
		 }	 

	 }
}
