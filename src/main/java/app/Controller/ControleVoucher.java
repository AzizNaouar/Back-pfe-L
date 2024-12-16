package app.Controller;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.Commande;
import app.Modele.ReponseImprimier;
import app.Modele.Response;
import app.Modele.Voucher;
import app.Modele.reponsesendcommande;
import app.Service.VoucherOoredooService;
import app.Service.VoucherOrangeService;
import app.Service.VoucherTélécomeService;

@RestController
public class ControleVoucher 
{
	
	
	@Autowired
	VoucherOoredooService  ooredooservice;
	@Autowired
	VoucherOrangeService orangeservice;
	@Autowired
	VoucherTélécomeService télécomeservice;
	
	Response response;
	
	
	
	
	 @CrossOrigin
     @PostMapping("/sendvoucher")
	 public reponsesendcommande Sendvoucher(@RequestBody Commande c)
	 {
		 reponsesendcommande response=null;
		
		 if(c.getOperateure().equals("ooredoo"))
		 {
			response=ooredooservice.sendvoucher(c.getMontant(),c.getQuantite(),c.getIdsgrossiste(),c.getIdgrossiste());
		 }
		
		 if(c.getOperateure().equals("orange"))
		 {
			 response=orangeservice.sendvoucher(c.getMontant(),c.getQuantite(),c.getIdsgrossiste(),c.getIdgrossiste());
		 }
		 
		 if(c.getOperateure().equals("télécome"))
		 {
			 response=télécomeservice.sendvoucher(c.getMontant(),c.getQuantite(),c.getIdsgrossiste(),c.getIdgrossiste());
		 }
		  return response;
		 
	 }
	 
	 
	 //pour get the voucher pour envoyer sms to client
	 @CrossOrigin
     @PostMapping("/getvoucher/{operateur}/{montant}/{numtel}/{quantite}")
	 public Response GetVoucher(@PathVariable String operateur,@PathVariable String montant,@PathVariable String numtel,@PathVariable String quantite,@RequestBody String Idgrossiste)
	 {
		 String message = null;
		 if(operateur.equals("ooredoo"))
		 {
			  message=ooredooservice.getvoucher(montant,Idgrossiste,numtel,quantite);
		 }
		
		 if(operateur.equals("orange"))
		 {
			  message=orangeservice.getvoucher(montant,Idgrossiste,numtel,quantite);
		 }
		 
		 if(operateur.equals("télécome"))
		 {
			  message=télécomeservice.getvoucher(montant,Idgrossiste,numtel,quantite);
		 }
		 
		 System.out.println(message);
		 response=new Response(message);
		 return response;
	 }
	 
	 
	 //pour get the voucher pour imprimer
	 @CrossOrigin
     @GetMapping("/getvouchers/{montant}/{operateur}/{quantite}/{id}")
	 public ReponseImprimier GetVoucher(@PathVariable String montant,@PathVariable String operateur,@PathVariable String quantite,@PathVariable String id)
	 {
		  ReponseImprimier response=null;
		 if(operateur.equals("ooredoo"))
		 {
			response=ooredooservice.GetVouchers(montant,operateur,quantite,id);
		 }
		
		 if(operateur.equals("orange"))
		 {
			 response=orangeservice.GetVouchers(montant, operateur, quantite, id);
		 }
		 
		 if(operateur.equals("télécome"))
		 {
			 response=télécomeservice.GetVouchers(montant, operateur, quantite, id);
		 }
		 return(response);
	 }
	 
	 
	 @CrossOrigin
     @GetMapping("/getAllvoucher/{id}/{type}/{montant}")
	 public ArrayList<Voucher> GetAllVoucher(@PathVariable String id,@PathVariable String type,@PathVariable String montant)
	 {
		 System.out.println(type+" "+montant);
		 ArrayList<Voucher> list=null;
		 if(type.equals("Ooredoo"))
		 {
			 list=ooredooservice.getallvoucher(id,montant);	
		 }
		 
		 if(type.equals("Orange"))
		 {
			 list=orangeservice.getallvoucher(id,montant);
		 }
		 if(type.equals("Tunisie Telecom"))
		 {
			 list=télécomeservice.getallvoucher(id,montant);
		 }
			
		 return list;
	 }
	 
	 @CrossOrigin
     @PostMapping("/RemouveVouchers/{id}/{montant}/{operateur}")
	 public void DeleteVouchers(@PathVariable String id,@PathVariable String montant,@PathVariable String operateur,@RequestBody ArrayList<Voucher> listvoucher)
	 {
		 
		 if(operateur.equals("ooredoo"))
		 {
			ooredooservice.RemouveVoucher(listvoucher, id, montant);
		 }
		 
		 if(operateur.equals("orange"))
		 {
			 orangeservice.RemouveVoucher(listvoucher, id, montant);
		 }
		 
		 if(operateur.equals("télécome"))
		 {
               télécomeservice.RemouveVoucher(listvoucher, id, montant);
		 }
			 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

