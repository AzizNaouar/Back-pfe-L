package app.Service;

import java.util.ArrayList;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.Grossiste;
import app.Modele.HistoriqueGrossiste;
import app.Modele.ReponseImprimier;
import app.Modele.Response;
import app.Modele.SousAdmin;
import app.Modele.Voucher;
import app.Modele.VoucherOrange;
import app.Modele.reponsesendcommande;
import app.Repository.VoucherOrangeRepository;


@Service
public class VoucherOrangeService 
{
	 @Autowired
	 VoucherOrangeRepository voucherrepository;	
	 @Autowired
	 ServiceSms sendsms;
	 @Autowired
     CripterVoucher cripter;
	 @Autowired
	 HistoriqueGrossisteService historiquegrossiste;
	 @Autowired
	 HistoriqueSousAdminService historique;
	 @Autowired
	 GrossisteService servicegrossiste;
	 @Autowired
	 ServiceStatistique servicestatistique;
	 @Autowired
	 ChiffreAfaireService chifreafaireservice;
	 @Autowired
	 SousAdminService servicesousadmin;
	 
	 ReponseImprimier responseimprime;
	 ArrayList<Voucher> listevoucher;
	 VoucherOrange voucher;
	 Response res;
	
	
	 
	//Ajouter voucher dans la collection de super grossiste
	 public Response AddVoucher(VoucherOrange v,String montant)
		{
			
			String response="";
			//get Document from db
			  if(Exist(v.getId()))
			  {
				 
			     if(montant.equals("1000"))
				 {		
			    	 voucher=FindVoucher(v.getId(),"1000");
			    	 
			    	 if(voucher!=null)
				     {
			    		 
					//get the liste of voucher 
					  listevoucher=voucher.getVouchers1orange();
					
				    // if the liste is not null
					  if(listevoucher!=null)
					  {  
						 try
						 {  
						  for(int i=0;i<v.getVouchers1orange().size();i++)
							{
								listevoucher.add(v.getVouchers1orange().get(i));
							}
						    
					
						  voucher.setVouchers1orange(listevoucher);
						  save(voucher);
						  servicestatistique.updatastock(v.getId(),v.getVouchers1orange().size(),"orange");
						 }
						 catch(Exception e)
						 {
							 System.out.println(e.getMessage());
							 response=e.getMessage();
						 }
						 response="L'importation de "+ v.getVouchers1orange().size()+" voucher Orange de montant 1 dinard  est bien faite";
					  }
					  
					//if the liste is null
					  if(listevoucher==null)
					  {
						  try
						  {
						   voucher.setVouchers1orange(v.getVouchers1orange());
						   save(voucher);
						   servicestatistique.updatastock(v.getId(),v.getVouchers1orange().size(),"orange");
					      }
						  catch(Exception e)
						  {
							  response=e.getMessage();
						  }
						  
						  response="L'importation de " + v.getVouchers1orange().size()+ " voucher  Orange de montant 1 dinard  est bien faite";
					  }
						   
					  	   
				 }
			    	 else if(voucher==null)
			    	 {
			    		 try
			    		 {
			    		 voucher.setVouchers1orange(v.getVouchers1orange());
			    		 save(voucher);
			    		 servicestatistique.updatastock(v.getId(),v.getVouchers1orange().size(),"orange");
			    	     }
			    		 catch(Exception e)
			    		 {
			    			 response=e.getMessage();
			    		 }
			    		 response="L'importation de "+ v.getVouchers1orange().size()+" voucher  Orange de montant 1 dinard  est bien faite";
			    		 
			    	 }
			    		 
				 }
				

			    if(montant.equals("5000"))
				{
			    	 voucher=FindVoucher(v.getId(),"5000");
			    	 
			    	 if(voucher!=null)
			    	 {
			    	//get the liste of voucher 
					  listevoucher=voucher.getVouchers5orange();
					  
					// if the liste is not null
					  if(listevoucher!=null)
					  {  
						  try
						  { 
						     for(int i=0;i<v.getVouchers5orange().size();i++)
							   {
								listevoucher.add(v.getVouchers5orange().get(i));
							   }
						      voucher.setVouchers5orange(listevoucher);
						      save(voucher);	
						      servicestatistique.updatastock(v.getId(),v.getVouchers5orange().size(),"orange");
					      }
						  
						  catch(Exception e)
						  {
						   System.out.println(e.getMessage());
						   response=e.getMessage();
						  }
						  response="L'importation de "+ v.getVouchers5orange().size()+" voucher Orange de montant 5 dinard  est bien faite";
					  }
						    
					  
					//if the liste is null
					   if(listevoucher==null)
					   {
						   try
						   {
						  voucher.setVouchers5orange(v.getVouchers5orange());
						  save(voucher);	
						  servicestatistique.updatastock(v.getId(),v.getVouchers5orange().size(),"orange");
					       }
						   catch(Exception e)
						   {
							   response=e.getMessage();
						   }
						   response="L'importation de "+ v.getVouchers5orange().size()+" voucher Orange de montant 5 dinard  est bien faite";
					   }
						   
					
			       }
			    	 else if(voucher==null)
			    	 {
			    		 try
						   {
			    		 voucher.setVouchers5orange(v.getVouchers5orange());
			    		 save(voucher);
			    		 servicestatistique.updatastock(v.getId(),v.getVouchers5orange().size(),"orange");
			    	      }
			    		 catch(Exception e)
			    		 {
			    			 response=e.getMessage();
			    		 }
			    		 response="L'importation de "+ v.getVouchers5orange().size()+" voucher Orange de montant 5 dinard  est bien faite";
			    		 
			    	 }
				}
			    		 

			     if(montant.equals("10000"))
				 {
			    	 voucher=FindVoucher(v.getId(),"10000");
			    	 
			    	 if(voucher!=null)
			    	 {
			    	 
			    	//get the liste of voucher 
					  listevoucher=voucher.getVouchers10orange();
					  
					// if the liste is not null
					  if(listevoucher!=null)
					  {    
						  try
						  { 
						  for(int i=0;i<v.getVouchers10orange().size();i++)
							{
							   
								listevoucher.add(v.getVouchers10orange().get(i));
							}
						      voucher.setVouchers10orange(listevoucher);
						      save(voucher);
						      servicestatistique.updatastock(v.getId(),v.getVouchers10orange().size(),"orange");
					      }
						  catch(Exception e)
						  {
							  System.out.println(e.getMessage());
							  response=e.getMessage();
						  }
						  response="L'importation de "+ v.getVouchers10orange().size()+" voucher Orange de montant 10 dinard  est bien faite";
					  }
					  
					// if the liste is null
					   if(listevoucher==null)
					   {
						   try
						   {
						   voucher.setVouchers10orange(v.getVouchers10orange());
						   save(voucher);
						   servicestatistique.updatastock(v.getId(),v.getVouchers10orange().size(),"orange");
						   }
						   catch(Exception e)
						   {
							   response=e.getMessage();
						   }
						   response="L'importation de "+ v.getVouchers10orange().size()+" voucher Orange de montant 10 dinard  est bien faite";
					   }
						   
					   	
				      }
			    	 else if(voucher==null)
			    	 {
			    		 try 
			    		 {
			    		 voucher.setVouchers10orange(v.getVouchers10orange());
			    		 save(voucher);
			    		 servicestatistique.updatastock(v.getId(),v.getVouchers10orange().size(),"orange");
			    	     }
			    		 catch(Exception e)
			    		 {
			    			 response=e.getMessage();
			    		 }
			    		 response="L'importation de "+ v.getVouchers10orange().size()+" voucher Orange de montant 10 dinard  est bien faite";
			    	 }
			    		 
					
		          }
				
					 
			  }
			
			if(Exist(v.getId())==false)
			{
				voucherrepository.insert(v);
				if(v.getVouchers10orange()!=null)
				{
			    servicestatistique.updatastock(v.getId(),v.getVouchers10orange().size(),"orange");
				}
				if(v.getVouchers1orange()!=null)
				{
				servicestatistique.updatastock(v.getId(),v.getVouchers1orange().size(),"orange");
				}
				if(v.getVouchers5orange()!=null)
				{
				servicestatistique.updatastock(v.getId(),v.getVouchers5orange().size(),"orange");
				}
				response="L'importation de voucher Orange de montant "+ montant+" est bien faite";
			}
			
			res=new Response(response);
			System.out.println(res.getResponse());
			return(res);
		
		}
	 
	 
	 
	//return the document by id
	public VoucherOrange FindVoucher(String id,String montant)
	{
		VoucherOrange voucherorange=null;
		
		if(this.Exist(id))
		{
		if(montant.equals("1000"))
		{
			voucherorange=voucherrepository.findList1(id);
	    }
		if(montant.equals("5000"))
		{
			voucherorange=voucherrepository.findListe5(id);
		}
		if(montant.equals("10000"))
		{
			voucherorange=voucherrepository.findListe10(id);
		}
		}
		return voucherorange;
		
	}
	
	
	public void DeleteVoucher(VoucherOrange v)
	{
		voucherrepository.delete(v);
		
	}
	
	
	public Boolean Exist(String id)
	{
		return(voucherrepository.existsById(id));
	}
	
	public void save(VoucherOrange v)
	{
		voucherrepository.save(v);
	}
	
	//ajouter voucher dans la collection de grossiste
	public reponsesendcommande sendvoucher(String montant,String quantite,String idSGrossiste,String idGrossiste)
	{

		 String message="";
		 reponsesendcommande respons;
		 Boolean verif=false;
		 
		 //Qunatité of the commande
		 int Quantité=Integer.parseInt(quantite);
		 
		 //declaration liste voucher grossiste
		 ArrayList<Voucher> ListvoucherG=new ArrayList<Voucher>();
		    
		 //Get Document from Db
	     VoucherOrange vouche=this.FindVoucher(idSGrossiste,montant);
		  if(vouche!=null)
		  {
	
		 if(montant.equals("1000"))
		 {			
			 
		//get List voucher SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers1orange();
		    
		  //List voucher supergrossiste is not nulle
		    if(ListVoucherSG!=null)
		    {
		    
		    if(ListVoucherSG.size()>=Quantité)
		    {
		 //add voucher to liste grossiste and remouve voucher from list supergrossiste
		    try
		    {	
			for(int j=0;j<Quantité;j++)
			{
				ListvoucherG.add(ListVoucherSG.get(j));
				ListVoucherSG.remove(ListVoucherSG.get(j));
		    }
		
		    //add the voucher to grossiste
			VoucherOrange voucheroore=new VoucherOrange(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Orange",nom,prenom,new Date().toString());
			
			//update the liste of voucher of SGrossistec
			vouche.setVouchers1orange(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"orange");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"orange");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Orange de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
			verif=true;
		    }
		    
		    catch(Exception e)
		    {
		       System.out.println(e.getMessage());
		       message=e.getMessage();
		    }
		    	
		    }
		    else  if(ListVoucherSG.size()<Quantité)
		    {
		    	message="Vous n'avez pas "+Quantité+" voucher Orange de montant "+montant;
		    }
		    	
		    }
		    //list voucher supergrossiste is null
		    else if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Orange de montant "+montant;
		    }
		 }
		
		 if(montant.equals("5000"))
		 {			 
			//get the List voucher of SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers5orange();
		    
		    //List voucher supergrossiste is not null
		    if(ListVoucherSG!=null)
		    {
		    
		    if(ListVoucherSG.size()>=Quantité)
		    {
		    
		    try
		    {
			for(int j=0;j<Quantité;j++)
			{
				ListvoucherG.add(ListVoucherSG.get(j));
				ListVoucherSG.remove(ListVoucherSG.get(j));
		    }
		
		    //add the voucher to grossiste
			VoucherOrange voucheroore=new VoucherOrange(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Orange",nom,prenom,new Date().toString());
			
			//update the liste of voucher of SGrossistec
			vouche.setVouchers5orange(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"orange");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"orange");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((5490*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((5490*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Orange de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
			verif=true;
			}
		    
		    catch(Exception e)
		    {
		    	message=e.getMessage();
		    	System.out.println(e.getMessage());
		    }
		    }
		    else if(ListVoucherSG.size()<Quantité)
		    {
		    	message="Vous n'avez pas "+Quantité+" voucher Orange de montant "+montant;
		    }
		    }
		    
		    //list voucher supergrossiste is null
		    if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Orange de montant "+montant;
		    }
	     }
		
		 if(montant.equals("10000"))
		 {		
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers10orange();
			    
			  //List voucher supergrossiste is not nulle
			    if(ListVoucherSG!=null)
			    {

			    if(ListVoucherSG.size()>=Quantité)
			    {
			    
			    try
			    {
			 //add voucher to liste grossiste and remouve voucher from list supergrossiste
				for(int j=0;j<Quantité;j++)
				{
					ListvoucherG.add(ListVoucherSG.get(j));
					ListVoucherSG.remove(ListVoucherSG.get(j));
			    }
			
			    //add the voucher to grossiste
				VoucherOrange voucheroore=new VoucherOrange(idGrossiste,ListvoucherG);
				this.AddVoucher(voucheroore,montant);
				Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
				String nom=grossiste.getNom();
				String prenom=grossiste.getPrenom();
				SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
				historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Orange",nom,prenom,new Date().toString());
				
				//update the liste of voucher of SGrossistec
				vouche.setVouchers10orange(ListVoucherSG);
				save(vouche);
				servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"orange");
				servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"orange");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
				message="Vous avez envoyer "+ListvoucherG.size()+" voucher Orange de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
				verif=true;
			    }
			    catch(Exception e)
			    {
			    	
			    }
			    }
			    if(ListVoucherSG.size()<Quantité)
			    {
			    	message="Vous n'avez pas "+Quantité+" voucher Orange de montant "+montant;
			    }
			    }
			    
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherSG==null)
			    {
			    	message="Vous n'avez pas de voucher Orange de montant "+montant;
			    }
		    
		       }
		       
		  }
		  else if(vouche==null)
		  {
			  message="Vous n'avez pas de voucher Orange";
		  }
		  
		  respons=new reponsesendcommande(message,verif);
		  System.out.println(message);
		  return(respons);
	}
	
	//send code voucher to client
	public String  getvoucher(String montant,String Idgrossiste,String numtel,String quantite)
	{
		String text="";
		String response="";
		VoucherOrange voucher=this.FindVoucher(Idgrossiste,montant);
		if(voucher!=null)
		{
		if(montant.equals("1000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers1orange();
			if(ListVoucher!=null)
			{
				
			if(ListVoucher.size()>=Integer.parseInt(quantite))
			{
			try
			{
				
			for(int i=0;i<Integer.parseInt(quantite);i++)
			{
			 Voucher vouche=ListVoucher.get(i);
			 String code=cripter.decrypt(vouche.getCode());
			 text="Code Voucher Orange n° "+(i+1)+": *100*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Orange",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,5,"orange");
			}
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*1250+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"orange");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "orange");
			voucher.setVouchers1orange(ListVoucher);
			save(voucher);
			response="Message envoyeé avec succeé";
			}
			catch(Exception e)
			{
				response=e.getMessage();
				System.out.println(e.getMessage());	
			}	
		    }
			else if(ListVoucher.size()<Integer.parseInt(quantite))
			{
				
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher de montant 1 DT " + "vous  avez que "+ListVoucher.size();

			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher de montant 1 DT";	
			}
				
	      }
			
			
		if(montant.equals("5000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers5orange();
			if(ListVoucher!=null)
			{
				
			if(ListVoucher.size()>=Integer.parseInt(quantite))
			{
			try
			{
				
			for(int i=0;i<Integer.parseInt(quantite);i++)
			{
			 Voucher vouche=ListVoucher.get(i);
			 String code=cripter.decrypt(vouche.getCode());
			 text="Code Voucher Orange n° "+(i+1)+": *100*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Orange",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,10,"orange");
			}
			voucher.setVouchers5orange(ListVoucher);
			save(voucher);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*5700+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"orange");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "orange");
			response="Message envoyeé avec succeé";
			}
			catch(Exception e)
			{
				response=e.getMessage();
				System.out.println(e.getMessage());	
			}	
		    }
			else if(ListVoucher.size()<Integer.parseInt(quantite))
			{
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher de montant 5 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher de montant 5 DT";	
			}
		    
			}
			
		
		
		if(montant.equals("10000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers10orange();
			if(ListVoucher!=null)
			{
				
			if(ListVoucher.size()>=Integer.parseInt(quantite))
			{
			try
			{
			for(int i=0;i<Integer.parseInt(quantite);i++)
			{
			 Voucher vouche=ListVoucher.get(i);
			 String code=cripter.decrypt(vouche.getCode());
			 text="Code Voucher Orange n° "+(i+1)+": *100*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Orange",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,15,"orange");
			}
			voucher.setVouchers10orange(ListVoucher);
			save(voucher);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*11400+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"orange");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "orange");
			response="Message envoyeé avec succeé";
			}
			catch(Exception e)
			{
				response=e.getMessage();
				System.out.println(e.getMessage());	
			}	
		    }
			else if(ListVoucher.size()<Integer.parseInt(quantite))
			{
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher de montant 10 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher de montant 10 DT";	
			}
			
		    }
		}
		else if(voucher==null)
		{
			response="vous n'avez pas de  voucher orange";
		}
			
			
		System.out.println(response);
		
		return(response);	
		
	}
	
	
	//get the voucher to imprimer
	public ReponseImprimier GetVouchers(String montant,String operateure,String quantite,String id)
	{
        	 
		ArrayList<Voucher> listVouchers=new ArrayList<Voucher>();

		 String message="";
		 
		 //Qunatité of the commande
		 int Quantité=Integer.parseInt(quantite);
		
		 //Get Document from Db
	     VoucherOrange vouche=this.FindVoucher(id,montant);
	     
		  if(vouche!=null)
		  {
		
		 if(montant.equals("1000"))
		 {			
			 
		//get List voucher SuperGrossiste
		    ArrayList<Voucher> ListVoucherG=vouche.getVouchers1orange();
		    
		  //List voucher supergrossiste is not nulle
		    if(ListVoucherG!=null)
		    {
		    
		    if(ListVoucherG.size()>=Quantité)
		    {
		 //add voucher to liste grossiste and remouve voucher from list supergrossiste
		    try
		    {	
			for(int j=0;j<Quantité;j++)
			{
				String code=cripter.decrypt(ListVoucherG.get(j).getCode());
				Voucher vouchern=new Voucher(code,ListVoucherG.get(j).getSerialnum(),ListVoucherG.get(j).getMontant(),ListVoucherG.get(j).getValidity());
				listVouchers.add(vouchern);
		    }
            }
		    catch(Exception e)
		    {
		       System.out.println(e.getMessage());
		       message=e.getMessage();
		    }
		    	
		    }
		    else  if(ListVoucherG.size()<Quantité)
		    {
		    	message="Vous n'avez pas "+Quantité+" voucher orange de montant 1 dinard";
		    }
		    	
		    }
		    //list voucher supergrossiste is null
		    else if(ListVoucherG==null)
		    {
		    	message="vous n'avez pas de voucher orange de montant 1 dinar";
		    }
		 }
		
		 if(montant.equals("5000"))
		 {			 
			//get the List voucher of SuperGrossiste
		    ArrayList<Voucher> ListVoucherG=vouche.getVouchers5orange();
		    
		    //List voucher supergrossiste is not null
		    if(ListVoucherG!=null)
		    {
		    
		    if(ListVoucherG.size()>=Quantité)
		    {
		    
		    try
		    {
			for(int j=0;j<Quantité;j++)
			{
				String code=cripter.decrypt(ListVoucherG.get(j).getCode());
				Voucher vouchern=new Voucher(code,ListVoucherG.get(j).getSerialnum(),ListVoucherG.get(j).getMontant(),ListVoucherG.get(j).getValidity());
				listVouchers.add(vouchern);
		    }
		
			}
		    
		    catch(Exception e)
		    {
		    	message=e.getMessage();
		    	System.out.println(e.getMessage());
		    }
		    
		    }
		    else if(ListVoucherG.size()<Quantité)
		    {
		    	message="Vous n'avez pas "+Quantité+" voucher orange de montant 5 dinard";
		    }
		    
		    }
		    
		    //list voucher supergrossiste is null
		    if(ListVoucherG==null)
		    {
		    	message="vous n'avez pas de voucher orange de montant 5 dinar";
		    }
	     }
		
		 if(montant.equals("10000"))
		 {		
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherG=vouche.getVouchers10orange();
			      
			  //List voucher supergrossiste is not nulle
			    if(ListVoucherG!=null)
			    {

			    if(ListVoucherG.size()>=Quantité)
			    {
			    
			    try
			    {
			 //add voucher to liste grossiste and remouve voucher from list supergrossiste
				for(int j=0;j<Quantité;j++)
				{
					String code=cripter.decrypt(ListVoucherG.get(j).getCode());
					Voucher vouchern=new Voucher(code,ListVoucherG.get(j).getSerialnum(),ListVoucherG.get(j).getMontant(),ListVoucherG.get(j).getValidity());
					listVouchers.add(vouchern);
			    }
			
			    }
			    catch(Exception e)
			    {
			       System.out.println(e.getMessage());
			       message=e.getMessage();
			    }
			    }
			    if(ListVoucherG.size()<Quantité)
			    {
			    	message="Vous n'avez pas "+Quantité+" voucher orange de montant 10 dinard";
			    }
			    }
			    
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherG==null)
			    {
			    	message="vous n'avez pas de voucher orange de montant 10 dinar";
			    }
		    
		       }
		       
		  }
		  
		  if(vouche==null)
		  {
			  message="vous n'avez pas de voucher Orange";
		  }
			 
		 System.out.println(message);
		 responseimprime=new ReponseImprimier (message,listVouchers);
		 return responseimprime;
	}
	
	
	
	public void RemouveVoucher(ArrayList<Voucher> listvoucher,String id,String montant)
	{
  
		VoucherOrange vouche=this.FindVoucher(id,montant);
		ArrayList<Voucher> listvouchergrossiste;
		
		if(montant.equals("1000"))
		{
			listvouchergrossiste=vouche.getVouchers1orange();
			for(int i=0;i<listvoucher.size();i++)
			{
				this.servicestatistique.UpdatePointFidélité(id,5,"orange");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			vouche.setVouchers1orange(listvouchergrossiste);
			save(vouche);
			chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*1250+""),id,"grossiste");
			this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"orange");	
			this.servicestatistique.updateventestat(id, listvoucher.size(),"orange");
		}
		
		if(montant.equals("5000"))
		{
		
			listvouchergrossiste=vouche.getVouchers5orange();
			
			for(int i=0;i<listvoucher.size();i++)
			{
				this.servicestatistique.UpdatePointFidélité(id,10,"orange");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			 vouche.setVouchers5orange(listvouchergrossiste);
			 save(vouche);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*5700+""),id,"grossiste");
			 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"orange");	
			 this.servicestatistique.updateventestat(id, listvoucher.size(),"orange");
		}
		
		if(montant.equals("10000"))
		{
			listvouchergrossiste=vouche.getVouchers10orange();
			for(int i=0;i<listvoucher.size();i++)
			{
				this.servicestatistique.UpdatePointFidélité(id,15,"orange");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			 vouche.setVouchers10orange(listvouchergrossiste);
			 save(vouche);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*11400+""),id,"grossiste");
			 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"orange");	
			 this.servicestatistique.updateventestat(id, listvoucher.size(),"orange");
		}
	
	}
	
	public Voucher getvoucher(ArrayList<Voucher> list,String code)
	{
		Boolean verif=false;
		int i=0;
		Voucher v=null;
		while(verif==false &&i<=list.size())
		{
			if(list.get(i).getCode().equals(code))
			{
				v=list.get(i);
				verif=true;
			}
	    }
		return v;	
	}
	
	public VoucherOrange getDocument(String id)
	{
		VoucherOrange vouherorangee=null;
		
		if(this.Exist(id))
		{
		 vouherorangee=voucherrepository.findById(id).get();
	    }
		
		return vouherorangee;
	}
	
	//get the stock of vouhcher
	public ArrayList<Voucher> getallvoucher(String id,String montant)
	 {
		  	VoucherOrange vo=this.getDocument(id);
		  	ArrayList<Voucher> listvoucher=null;
			if(vo!=null)
		  	{
		  	if(montant.equals("1000"))
		  	 {
		  		listvoucher=vo.getVouchers1orange();
		  	 }
		  	
		  	if(montant.equals("5000"))
		  	 {
		  		listvoucher=vo.getVouchers5orange();
		  	 }
		  	
		  	if(montant.equals("10000"))
		  	 {
		  		listvoucher=vo.getVouchers10orange();
		  	 }
		  	}	
		  	return listvoucher;
		
	 }
	
	
	
}
