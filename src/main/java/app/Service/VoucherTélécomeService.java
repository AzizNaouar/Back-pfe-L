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
import app.Modele.VoucherOoredoo;
import app.Modele.VoucherOrange;
import app.Modele.VoucherTélécome;
import app.Modele.reponsesendcommande;
import app.Repository.VoucherTélécomeRepository;


@Service
public class VoucherTélécomeService 
{
	@Autowired
	VoucherTélécomeRepository voucherrepository;
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
		
	ArrayList<Voucher> listevoucher;
	VoucherTélécome voucher;
	ReponseImprimier responseimprime;
	Response response;
	
	
	
	//Ajouter voucher dans la collection de super grossiste
	public Response AddVoucher(VoucherTélécome v,String montant)
	{
		String message ="";
		//get Document from db
		  if(Exist(v.getId()))
		  {
			 
		     if(montant.equals("1000"))
			 {
               voucher=FindVoucher(v.getId(),"1000");
		    	 
		    	 if(voucher!=null)
		    	 {
		    	//get the liste of voucher 
				  listevoucher=voucher.getVouchers1telecome();
				  
				// if the liste is not null
				  if(listevoucher!=null)
				  {  
					  try
					  { 
					     for(int i=0;i<v.getVouchers1telecome().size();i++)
						   {
							listevoucher.add(v.getVouchers1telecome().get(i));
						   }
					      voucher.setVouchers5telecome(listevoucher);
					      save(voucher);
					      servicestatistique.updatastock(v.getId(),v.getVouchers1telecome().size(),"telecom");
				      }
					  
					  catch(Exception e)
					  {
					   System.out.println(e.getMessage());
					   message=e.getMessage();
					  }
					  
					  message="L'importation de "+v.getVouchers1telecome().size()+" voucher Telecome de montant 1 dinard  est bien faite";	 
				  }
					    
				  
				//if the liste is null
				   if(listevoucher==null)
				   {
					   
				   try
				   {
					  voucher.setVouchers1telecome(v.getVouchers1telecome());
					  save(voucher);
					  servicestatistique.updatastock(v.getId(),v.getVouchers1telecome().size(),"telecom");
				   }
				   catch(Exception e)
				   {
					   message=e.getMessage();
					   System.out.println(e.getMessage());
				   }
				   
				   message="L'importation de "+v.getVouchers1telecome().size()+" voucher Telecome de montant 1 dinard  est bien faite";	 
				   
				   }
					   
				   
		       }
		    	 else if(voucher==null)
		    	 {
		    		
		    		 try
		    		 {
		    		 voucher.setVouchers1telecome(v.getVouchers1telecome());
		    		 save(voucher);
		    		 servicestatistique.updatastock(v.getId(),v.getVouchers1telecome().size(),"telecom");
		    	     }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(e.getMessage());
		    		 }
		    		 
		    	 message="L'importation de "+v.getVouchers1telecome().size()+" voucher Telecome de montant 1 dinard  est bien faite";	 
			   }
			 }

		     
		     
		    if(montant.equals("5000"))
			{
		    	 voucher=FindVoucher(v.getId(),"5000");
		    	 
		    	 if(voucher!=null)
		    	 {
		    	//get the liste of voucher 
				  listevoucher=voucher.getVouchers5telecome();
				  
				// if the liste is not null
				  if(listevoucher!=null)
				  {  
					  try
					  { 
					     for(int i=0;i<v.getVouchers5telecome().size();i++)
						   {
							listevoucher.add(v.getVouchers5telecome().get(i));
						   }
					      voucher.setVouchers5telecome(listevoucher);
					      save(voucher);
					      servicestatistique.updatastock(v.getId(),v.getVouchers5telecome().size(),"telecom");
				      }
					  
					  catch(Exception e)
					  {
					   System.out.println(e.getMessage());
					   message=e.getMessage();
					  }
					  
					  message="L'importation de "+v.getVouchers5telecome().size()+" voucher Telecome de montant 5 dinard  est bien faite";	 
				  }
					    
				  
				//if the liste is null
				   if(listevoucher==null)
				   {
					   
				   try
				   {
					  voucher.setVouchers5telecome(v.getVouchers5telecome());
					  save(voucher);
					  servicestatistique.updatastock(v.getId(),v.getVouchers5telecome().size(),"telecom");
				   }
				   catch(Exception e)
				   {
					   message=e.getMessage();
					   System.out.println(e.getMessage());
				   }
				   
				   message="L'importation de "+v.getVouchers5telecome().size()+" voucher Telecome de montant 5 dinard  est bien faite";	 
				   
				   }
					   
				   
		       }
		    	 else if(voucher==null)
		    	 {
		    		
		    		 try
		    		 {
		    		 voucher.setVouchers5telecome(v.getVouchers5telecome());
		    		 save(voucher);
		    		 servicestatistique.updatastock(v.getId(),v.getVouchers5telecome().size(),"telecom");
		    	     }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(e.getMessage());
		    		 }
		    		 
		    	 message="L'importation de "+v.getVouchers5telecome().size()+" voucher Telecome de montant 5 dinard  est bien faite";	 
			   }
		    		 
			}
		    
		     if(montant.equals("10000"))
			 {
		    	 voucher=FindVoucher(v.getId(),"10000");
		    	 
		    	 if(voucher!=null)
		    	 {
		    	 
		    	//get the liste of voucher 
				  listevoucher=voucher.getVouchers10telecome();
				  
				// if the liste is not null
				  if(listevoucher!=null)
				  {    
					  try
					  { 
					  for(int i=0;i<v.getVouchers10telecome().size();i++)
						{
						   
							listevoucher.add(v.getVouchers10telecome().get(i));
						}
					      voucher.setVouchers10telecome(listevoucher);
					      save(voucher);	
					      servicestatistique.updatastock(v.getId(),v.getVouchers10telecome().size(),"telecom");
				      }
					  catch(Exception e)
					  {
						  System.out.println(e.getMessage());
						  message=e.getMessage();
					  }
				  }
				  
				// if the liste is null
				   if(listevoucher==null)
				   {
					   try
					   {
					   voucher.setVouchers10telecome(v.getVouchers10telecome());
					   save(voucher);	
					   servicestatistique.updatastock(v.getId(),v.getVouchers10telecome().size(),"telecom");
				       }
					   catch(Exception e)
					   {
						   message=e.getMessage();
						   System.out.println(message);
					   }
					   
				   }
				   
		    	 else if(voucher==null)
		    	 {   
		    		 try
		    		 { 
		    		 voucher.setVouchers10telecome(v.getVouchers10telecome());
		    		 save(voucher);
		    		  servicestatistique.updatastock(v.getId(),v.getVouchers10telecome().size(),"telecom");
		    		 }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(message);
		    		 }
		    		 
		    	 }
		    	 
		    	 message="L'importation de "+v.getVouchers10telecome().size()+" voucher Telecome de montant 10 dinard  est bien faite";	 
				
	          }
			
		  }
		  }
		  
		if(Exist(v.getId())==false)
		{
			voucherrepository.insert(v);
			if(v.getVouchers10telecome()!=null)
			{
		    servicestatistique.updatastock(v.getId(),v.getVouchers10telecome().size(),"telecom");
			}
			if(v.getVouchers1telecome()!=null)
			{
			servicestatistique.updatastock(v.getId(),v.getVouchers1telecome().size(),"telecom");
			}
			if(v.getVouchers5telecome()!=null)
			{
			servicestatistique.updatastock(v.getId(),v.getVouchers5telecome().size(),"telecom");
			}
			message="L'importation de voucher Telecome de montant "+ montant+" est bien faite";
		}
		  
		System.out.println(message);
		response=new Response(message);
		return(response);
			
	}
	
	public void DeleteVoucher(VoucherTélécome v)
	{
		voucherrepository.delete(v);
	}
	
	
	//return the collection by id
	public VoucherTélécome FindVoucher(String id,String montant)
	{
		VoucherTélécome vouchertelecom=null;
		
		if(this.Exist(id))
		{
		if(montant.equals("1000"))
		{
			vouchertelecom=voucherrepository.findList1(id);
	    }
		if(montant.equals("5000"))
		{
			vouchertelecom=voucherrepository.findListe5(id);
		}
		if(montant.equals("10000"))
		{
			vouchertelecom=voucherrepository.findListe10(id);
		}
		}
		return vouchertelecom;
	}
	
	public Boolean Exist(String id)
	{
		return(voucherrepository.existsById(id));
	}
	
	public void save(VoucherTélécome v)
	{
		voucherrepository.save(v);
	}
	
	
	//send voucher to grossiste
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
	     VoucherTélécome vouche=this.FindVoucher(idSGrossiste,montant);
		  if(vouche!=null)
		  {
	
		 if(montant.equals("1000"))
		 {			
			 
		//get List voucher SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers1telecome();
		    
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
			VoucherTélécome voucheroore=new VoucherTélécome(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Télécome",nom,prenom,new Date().toString());
			
			//update the liste of voucher of SGrossistec
			vouche.setVouchers1telecome(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Télécome de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
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
		    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant "+montant;
		    }
		    	
		    }
		    //list voucher supergrossiste is null
		    else if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Télécome de montant "+montant;
		    }
		 }
		
		 if(montant.equals("5000"))
		 {			 
			//get the List voucher of SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers5telecome();
		    
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
			VoucherTélécome voucheroore=new VoucherTélécome(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Télécome",nom,prenom,new Date().toString());
			//update the liste of voucher of SGrossistec
			vouche.setVouchers5telecome(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((5490*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((5490*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Télécome de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
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
		    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant "+montant;
		    }
		    }
		    
		    //list voucher supergrossiste is null
		    if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Télécome de montant "+montant;
		    }
	     }
		
		 if(montant.equals("10000"))
		 {		
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers10telecome();
			    
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
				VoucherTélécome voucheroore=new VoucherTélécome(idGrossiste,ListvoucherG);
				this.AddVoucher(voucheroore,montant);
				Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
				String nom=grossiste.getNom();
				String prenom=grossiste.getPrenom();
				SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
				historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Télécome",nom,prenom,new Date().toString());
				
				//update the liste of voucher of SGrossistec
				vouche.setVouchers10telecome(ListVoucherSG);
				save(vouche);
				servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
				servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"telecom");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
				message="Vous avez envoyer "+ListvoucherG.size()+" voucher Télécome de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
				verif=true;
	           
			    }
			    catch(Exception e)
			    {
			    	
			    }
			    }
			    if(ListVoucherSG.size()<Quantité)
			    {
			    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant "+montant;
			    }
			    }
			    
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherSG==null)
			    {
			    	message="Vous n'avez pas de voucher Télécome de montant "+montant;
			    }
		    
		       }
		       
		  }
		  else if(vouche==null)
		  {
			  message="Vous n'avez pas de voucher Télécome";
		  }
			 System.out.println(message);
			 respons=new reponsesendcommande(message,verif);
			  System.out.println(message);
			  return(respons);
	}
	
	
	//send sms to client
	public String getvoucher(String montant,String Idgrossiste,String numtel,String quantite)
	{
		String text="";
		String response="";
		VoucherTélécome voucher=this.FindVoucher(Idgrossiste,montant);
		if(voucher!=null)
		{
		if(montant.equals("1000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers1telecome();
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
			 text="Code Voucher Télécome n° "+(i+1)+": *123*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Tunisie Telecom",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,5,"telecom");
			}
			voucher.setVouchers1telecome(ListVoucher);
			save(voucher);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*1250+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"telecom");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "telecom");
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Tunisie Telecom de montant 1 DT " + "vous avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher Tunisie Telecom de montant 1 DT";
				
			}
				
	      }
			
			
		if(montant.equals("5000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers5telecome();
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
			 text="Code Voucher Télécome n° "+(i+1)+": *123*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Tunisie Telecom",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,10,"telecom");
			}
			voucher.setVouchers5telecome(ListVoucher);
			save(voucher);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*5700+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"telecom");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "telecom");
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Tunisie Telecom de montant 5 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher Tunisie Telecom de montant 5 DT";
				
			}
		    
			}
			
		
		
		if(montant.equals("10000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers10telecome();
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
			 text="Code Voucher Télécome n° "+(i+1)+": *123*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Tunisie Telecom",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,15,"telecom");
			}
			voucher.setVouchers10telecome(ListVoucher);
			save(voucher);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*11400+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"telecom");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "telecom");
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Tunisie Telecom de montant 10 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher Tunisie Telecom de montant 10 DT";
			}
			
		    }
		}
		else if(voucher==null)
		{
			response="vous n'avez pas de  voucher Tunisie Telecom";
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
		     VoucherTélécome vouche=this.FindVoucher(id,montant);
		     
			  if(vouche!=null)
			  {
		
			 if(montant.equals("1000"))
			 {			
				 
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherG=vouche.getVouchers1telecome();
			    
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
			    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant 1 dinard";
			    }
			    	
			    }
			    //list voucher supergrossiste is null
			    else if(ListVoucherG==null)
			    {
			    	message="vous n'avez pas de voucher Télécome de montant 1 dinar";
			    }
			 }
			
			 if(montant.equals("5000"))
			 {			 
				//get the List voucher of SuperGrossiste
			    ArrayList<Voucher> ListVoucherG=vouche.getVouchers5telecome();
			    
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
			    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant 5 dinard";
			    }
			    }
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherG==null)
			    {
			    	message="vous n'avez pas de voucher Télécome de montant 5 dinar";
			    }
		     }
			
			 if(montant.equals("10000"))
			 {		
				//get List voucher SuperGrossiste
				    ArrayList<Voucher> ListVoucherG=vouche.getVouchers10telecome();
				      
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
				    	
				    }
				    }
				    if(ListVoucherG.size()<Quantité)
				    {
				    	message="Vous n'avez pas "+Quantité+" voucher Télécome de montant 10 dinard";
				    }
				    }
				    
				    
				    //list voucher supergrossiste is null
				    if(ListVoucherG==null)
				    {
				    	message="vous n'avez pas de voucher Télécome de montant 10 dinar";
				    }
			    
			       }
			       
			  }
			  else if(vouche==null)
			  {
				  message="vous n'avez pas de voucher Télécome";
			  }
				 
			 System.out.println(message);
			 responseimprime=new ReponseImprimier (message,listVouchers);
			 return responseimprime;
			 
		}
		
		public VoucherTélécome getVoucher(String id)
		{
			VoucherTélécome vouchertelecom=null;
			
			if(this.Exist(id))
			{
			vouchertelecom= voucherrepository.findById(id).get();
			}
			
			return vouchertelecom;
		}
		
		public ArrayList<Voucher> getallvoucher(String id,String montant)
		 {
			  	VoucherTélécome vo=this.getVoucher(id);
			  	ArrayList<Voucher> listvoucher=null;
				if(vo!=null)
			  	{
			  	if(montant.equals("1000"))
			  	 {
			  		listvoucher=vo.getVouchers1telecome();
			  	 }
			  	
			  	if(montant.equals("5000"))
			  	 {
			  		listvoucher=vo.getVouchers5telecome();
			  	 }
			  	
			  	if(montant.equals("10000"))
			  	 {
			  		listvoucher=vo.getVouchers10telecome();
			  	 }
			  	}  		
			  	return listvoucher;
			
		 }
		
		public void RemouveVoucher(ArrayList<Voucher> listvoucher,String id,String montant)
		{
	  
			VoucherTélécome vouche=this.FindVoucher(id,montant);
			ArrayList<Voucher> listvouchergrossiste;
			
			if(montant.equals("1000"))
			{
				listvouchergrossiste=vouche.getVouchers1telecome();
				for(int i=0;i<listvoucher.size();i++)
				{
					this.servicestatistique.UpdatePointFidélité(id,5,"telecom");
					String code=cripter.encrypt(listvoucher.get(i).getCode());    
	                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
				}
				
				 vouche.setVouchers1telecome(listvouchergrossiste);
				 save(vouche);
				 
				 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*1250+""),id,"grossiste");
				 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"telecom");	
				 this.servicestatistique.updateventestat(id, listvoucher.size(),"telecom");
			}
			
			if(montant.equals("5000"))
			{
			
				listvouchergrossiste=vouche.getVouchers5telecome();
				
				for(int i=0;i<listvoucher.size();i++)
				{
					this.servicestatistique.UpdatePointFidélité(id,10,"telecom");
					String code=cripter.encrypt(listvoucher.get(i).getCode());    
	                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
				}
				 vouche.setVouchers5telecome(listvouchergrossiste);
				 save(vouche);
				 
				 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*5700+""),id,"grossiste");
				 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"telecom");	
				 this.servicestatistique.updateventestat(id, listvoucher.size(),"telecom");
			}
			
			if(montant.equals("10000"))
			{
				listvouchergrossiste=vouche.getVouchers10telecome();
				for(int i=0;i<listvoucher.size();i++)
				{
					this.servicestatistique.UpdatePointFidélité(id,15,"telecom");
					String code=cripter.encrypt(listvoucher.get(i).getCode());    
	                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
				}
				 vouche.setVouchers10telecome(listvouchergrossiste);
				 save(vouche);
				 
				 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*11400+""),id,"grossiste");
				 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"telecom");	
				 this.servicestatistique.updateventestat(id, listvoucher.size(),"telecom");
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
		

}
