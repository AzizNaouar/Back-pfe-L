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
import app.Modele.reponsesendcommande;
import app.Repository.VoucherOoredooRepository;

@Service
public class VoucherOoredooService 
{
	@Autowired
	VoucherOoredooRepository voucherrepository;
	@Autowired
	ServiceSms sendsms;
	@Autowired
    CripterVoucher cripter;
	@Autowired
	GrossisteService servicegrossiste;
	@Autowired
	HistoriqueGrossisteService historiquegrossiste;
	@Autowired
	HistoriqueSousAdminService historique;
	@Autowired
	ServiceStatistique servicestatistique;
	@Autowired
	ChiffreAfaireService chifreafaireservice;
	@Autowired
	SousAdminService servicesousadmin;
	
	Response response;
	VoucherOoredoo voucher;
	ArrayList<Voucher> listevoucher;
	ReponseImprimier responseimprime;
	
	
	
	//Ajouter voucher dans la collection de super grossiste
	public Response AddVoucher(VoucherOoredoo v,String montant)
	{
		String message="";
		//get Document from db
		  if(Exist(v.getId()))
		  {
			 
		     if(montant.equals("1000"))
			 {		
		    	 voucher=FindVoucher(v.getId(),"1000");
		    	 
		    	 if(voucher!=null)
			     {
		    		 
				//get the liste of voucher 
				  listevoucher=voucher.getVouchers1ooredoo();
				
			    // if the liste is not null
				  if(listevoucher!=null)
				  {  
					 try
					 {  
						 
					  for(int i=0;i<v.getVouchers1ooredoo().size();i++)
						{
							listevoucher.add(v.getVouchers1ooredoo().get(i));
						}
					    
					  voucher.setVouchers1ooredoo(listevoucher);
					  save(voucher);
					  servicestatistique.updatastock(v.getId(),v.getVouchers1ooredoo().size(),"ooredoo");
					  
					 }
					 catch(Exception e)
					 {
						 System.out.println(e.getMessage());
						 message=e.getMessage();
					 }
					 
					 message="L'importation de "+v.getVouchers1ooredoo().size()+" voucher Ooredoo de montant 1 dinard  est bien faite";
				  }
				  
				//if the liste is null
				  if(listevoucher==null)
				  {    
					   try
					   {
					   voucher.setVouchers1ooredoo(v.getVouchers1ooredoo());
					   save(voucher);
					   servicestatistique.updatastock(v.getId(),v.getVouchers1ooredoo().size(),"ooredoo");
					   }
					   catch(Exception e)
					   {
						   message= e.getMessage();
						   System.out.println(message);
					   }
					   message="L'importation de "+v.getVouchers1ooredoo().size()+" voucher Ooredoo de montant 1 dinard  est bien faite";
				  }
					   
				  		   
			 }
		    	 else if(voucher==null)
		    	 {
		    		 try
		    		 {
		    		 voucher.setVouchers1ooredoo(v.getVouchers1ooredoo());
		    		 save(voucher);
		    		 servicestatistique.updatastock(v.getId(),v.getVouchers1ooredoo().size(),"ooredoo");
		    	     }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(message);
		    		 }
		    		 message="L'importation de "+v.getVouchers1ooredoo().size()+" voucher Ooredoo de montant 1 dinard  est bien faite";
		    		 
		    	 }
		    		 
			 }
			

		    if(montant.equals("5000"))
			{
		    	 voucher=FindVoucher(v.getId(),"5000");
		    	 
		    	 if(voucher!=null)
		    	 {
		    	 //get the liste of voucher 
				  listevoucher=voucher.getVouchers5ooredoo();
				 // if the liste is not null
				  if(listevoucher!=null)
				  {  
					  try
					  { 
					     for(int i=0;i<v.getVouchers5ooredoo().size();i++)
						   {
							listevoucher.add(v.getVouchers5ooredoo().get(i));
						   }
					      voucher.setVouchers5ooredoo(listevoucher);
					      save(voucher);
					      servicestatistique.updatastock(v.getId(),v.getVouchers5ooredoo().size(),"ooredoo");
				      }
					  
					  catch(Exception e)
					  {
					   System.out.println(e.getMessage());
					   message=e.getMessage();
					  }
					  
					  message="L'importation de "+v.getVouchers5ooredoo().size()+" voucher Ooredoo de montant 5 dinard  est bien faite";
				  }
					    
				  
				//if the liste is null
				   if(listevoucher==null)
				   {
					   try
					   {
					  voucher.setVouchers5ooredoo(v.getVouchers5ooredoo());
					  save(voucher);
					  servicestatistique.updatastock(v.getId(),v.getVouchers5ooredoo().size(),"ooredoo");
				       }
					   catch(Exception e)
					   {
						   message=e.getMessage();
						   System.out.println(e.getMessage());
					   }
					   
					   message="L'importation de "+v.getVouchers5ooredoo().size()+" voucher Ooredoo de montant 5 dinard  est bien faite";
				   }
					   
				  
		       }
		    	 else if(voucher==null)
		    	 {
		    		 try
		    		 {
		    		 voucher.setVouchers5ooredoo(v.getVouchers5ooredoo());
		    		 save(voucher);
		    		 servicestatistique.updatastock(v.getId(),v.getVouchers5ooredoo().size(),"ooredoo");
		    	     }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(message);
		    		 }
		    		 message="L'importation de "+v.getVouchers5ooredoo().size()+" voucher Ooredoo de montant 5 dinard  est bien faite";
		    	 }
			}
		    		 

		     if(montant.equals("10000"))
			 {
		    	 voucher=FindVoucher(v.getId(),"10000");
		    	 
		    	 if(voucher!=null)
		    	 {
		    	 
		    	//get the liste of voucher 
				  listevoucher=voucher.getVouchers10ooredoo();
				  
				// if the liste is not null
				  if(listevoucher!=null)
				  {    
					  try
					  { 
					  for(int i=0;i<v.getVouchers10ooredoo().size();i++)
						{
						   
							listevoucher.add(v.getVouchers10ooredoo().get(i));
						}
					      voucher.setVouchers10ooredoo(listevoucher);
					      save(voucher);	
					      servicestatistique.updatastock(v.getId(),v.getVouchers10ooredoo().size(),"ooredoo");
				      }
					  catch(Exception e)
					  {
						  System.out.println(e.getMessage());
						  message=e.getMessage();
					  }
					  message="L'importation de "+v.getVouchers10ooredoo().size()+" voucher Ooredoo de montant 10 dinard  est bien faite";
				  }
				  
				// if the liste is null
				   if(listevoucher==null)
				   {
					   try
					   {
					   voucher.setVouchers10ooredoo(v.getVouchers10ooredoo());
					   save(voucher);
					   servicestatistique.updatastock(v.getId(),v.getVouchers10ooredoo().size(),"ooredoo");
				       }
					   catch(Exception e)
					   {
						   message=e.getMessage();
						   System.out.println(message);
					   }
					   message="L'importation de "+v.getVouchers10ooredoo().size()+" voucher Ooredoo de montant 10 dinard  est bien faite";
					   
				   }
					   
				 	
			      }
		    	 else if(voucher==null)
		    	 {
		    		 try
		    		 {
		    		 voucher.setVouchers10ooredoo(v.getVouchers10ooredoo());
		    		 save(voucher);
		    		 servicestatistique.updatastock(v.getId(),v.getVouchers10ooredoo().size(),"ooredoo");
		    	     }
		    		 catch(Exception e)
		    		 {
		    			 message=e.getMessage();
		    			 System.out.println(message);
		    		 }
		    		 message="L'importation de "+v.getVouchers10ooredoo().size()+" voucher Ooredoo de montant 10 dinard  est bien faite";
		    	 }
		    		 
				
	          }
			
				 
		  }
		
		if(Exist(v.getId())==false)
		{
			voucherrepository.insert(v);
			if(v.getVouchers10ooredoo()!=null)
			{
		    servicestatistique.updatastock(v.getId(),v.getVouchers10ooredoo().size(),"ooredoo");
			}
			if(v.getVouchers1ooredoo()!=null)
			{
			servicestatistique.updatastock(v.getId(),v.getVouchers1ooredoo().size(),"ooredoo");
			}
			if(v.getVouchers5ooredoo()!=null)
			{
			servicestatistique.updatastock(v.getId(),v.getVouchers5ooredoo().size(),"ooredoo");
			}
				
			message="L'importation de voucher Ooredoo de montant "+ montant+" est bien faite";
		}
		
        response=new Response(message);
		return(response);
		 
	}
	
	
	
	public void save(VoucherOoredoo v)
	{
		voucherrepository.save(v);
	}
	
	
	public void DeleteVoucher(VoucherOoredoo v)
	{
		voucherrepository.delete(v);
	}
	
	public Boolean Exist(String id)
	{	
		return(voucherrepository.existsById(id));
	}
	
	
	//return the collection by id
	public VoucherOoredoo FindVoucher(String id,String montant)
	{
		VoucherOoredoo voucherooredoo=null;
		
		if(this.Exist(id))
		{
		if(montant.equals("1000"))
		{
			voucherooredoo=voucherrepository.findList1(id);
	    }
		if(montant.equals("5000"))
		{
			voucherooredoo=voucherrepository.findListe5(id);
		}
		if(montant.equals("10000"))
		{
			voucherooredoo=voucherrepository.findListe10(id);
		}
		}
		
		return voucherooredoo;
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
	     VoucherOoredoo vouche=this.FindVoucher(idSGrossiste,montant);
		  if(vouche!=null)
		  {
	
		 if(montant.equals("1000"))
		 {			
			 
		   //get List voucher SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers1ooredoo();
		    
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
			VoucherOoredoo voucheroore=new VoucherOoredoo(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			//add tronsaction in collection historique
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Ooredoo",nom,prenom,new Date().toString());
			 
			//update the liste of voucher of SGrossistec
			vouche.setVouchers1ooredoo(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
			this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((1090*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Ooredoo de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
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
		    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant "+montant;
		    }
		    	
		    }
		    //list voucher supergrossiste is null
		    else if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Ooredoo de montant "+montant;
		    }
		 }
		
		 if(montant.equals("5000"))
		 {			 
			//get the List voucher of SuperGrossiste
		    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers5ooredoo();
		    
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
			VoucherOoredoo voucheroore=new VoucherOoredoo(idGrossiste,ListvoucherG);
			this.AddVoucher(voucheroore,montant);
			Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
			String nom=grossiste.getNom();
			String prenom=grossiste.getPrenom();
			SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
			historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Ooredoo",nom,prenom,new Date().toString());
			//update the liste of voucher of SGrossistec
			vouche.setVouchers5ooredoo(ListVoucherSG);
			save(vouche);
			servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
			servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
			chifreafaireservice.updatechiffreafaire(Double.parseDouble((5490*Integer.parseInt(quantite))+""),idSGrossiste,"supergrossiste");
			chifreafaireservice.updatechiffreafaire(Double.parseDouble((5490*Integer.parseInt(quantite))+""),sousadmin.getIdAdmin(),"admin");
			message="Vous avez envoyer "+ListvoucherG.size()+" voucher Ooredoo de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
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
		    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant "+montant;
		    }
		    }
		    
		    //list voucher supergrossiste is null
		    if(ListVoucherSG==null)
		    {
		    	message="Vous n'avez pas de voucher Ooredoo de montant "+montant;
		    }
	     }
		
		 if(montant.equals("10000"))
		 {		
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherSG=vouche.getVouchers10ooredoo();
			    
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
				VoucherOoredoo voucheroore=new VoucherOoredoo(idGrossiste,ListvoucherG);
				this.AddVoucher(voucheroore,montant);
				Grossiste grossiste=servicegrossiste.FindById(idGrossiste);
				String nom=grossiste.getNom();
				String prenom=grossiste.getPrenom();
				SousAdmin sousadmin=this.servicesousadmin.FindById(idSGrossiste);
				historique.insert(new Date().toInstant(),idSGrossiste,montant,quantite,"Ooredoo",nom,prenom,new Date().toString());
				//update the liste of voucher of SGrossistec
				vouche.setVouchers10ooredoo(ListVoucherSG);
				save(vouche);
				servicestatistique.deleteupdatestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
				servicestatistique.updateventestat(idSGrossiste,Integer.parseInt(quantite),"ooredoo");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),idSGrossiste,"supergrossiste");
				this.chifreafaireservice.updatechiffreafaire((Double.parseDouble((10980*Integer.parseInt(quantite))+"")),sousadmin.getIdAdmin(),"admin");
				message="Vous avez envoyer "+ListvoucherG.size()+" voucher Ooredoo de montant "+montant+" au "+nom+" "+prenom+" avec suceés";
			    verif=true;
			    }
			    catch(Exception e)
			    {
			    	
			    }
			    }
			    if(ListVoucherSG.size()<Quantité)
			    {
			    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant "+montant;
			    }
			    }
			    
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherSG==null)
			    {
			    	message="Vous n'avez pas de voucher Ooredoo de montant "+montant;
			    }
		    
		       }
		       
		  }
		  else if(vouche==null)
		  {
			  message="Vous n'avez pas de voucher Ooredoo";
		  }
		  
		 
		  respons=new reponsesendcommande(message,verif);
		  System.out.println(message);
		  return(respons);
	}
	
	
	
	
	
	//send sms to client
	public String  getvoucher(String montant,String Idgrossiste,String numtel,String quantite)
	{
		String text="";
		String response="";
		VoucherOoredoo voucher=this.FindVoucher(Idgrossiste,montant);
		if(voucher!=null)
		{
		if(montant.equals("1000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers1ooredoo();
			
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
			 text="Code Voucher Ooredoo n° "+(i+1)+": *101*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Ooredoo",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,5,"ooredoo");
			}
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*1250+""),Idgrossiste,"grossiste");
		     this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"ooredoo");	
		     this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "ooredoo");
			voucher.setVouchers1ooredoo(ListVoucher);
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Ooredoo de montant 1 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  vouche Ooredoo de montant 1DT";
				
			}
				
	      }
			
			
		if(montant.equals("5000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers5ooredoo();
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
			 text="Code Voucher Ooredoo n° "+(i+1)+": *101*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Ooredoo",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,10,"ooredoo");
			}
			chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*5700+""),Idgrossiste,"grossiste");
			this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"ooredoo");
			this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "ooredoo");
			voucher.setVouchers5ooredoo(ListVoucher);
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Ooredoo de montant 5 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher Ooredoo de montant 5 DT";
				
			}
		    
			}
			
		
		
		if(montant.equals("10000"))
		{
			
			ArrayList<Voucher> ListVoucher=voucher.getVouchers10ooredoo();
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
			 text="Code Voucher Ooredoo n° "+(i+1)+": *101*"+code+"#";
			 ListVoucher.remove(vouche);
			 this.sendsms.sendsms(numtel,text);
			 this.historiquegrossiste.Insert(new HistoriqueGrossiste(new Date().toInstant(),Idgrossiste,montant,code,"Ooredoo",numtel,new Date().toString()));
			 this.servicestatistique.UpdatePointFidélité(Idgrossiste,15,"ooredoo");
			}
			chifreafaireservice.updatechiffreafaire(Double.parseDouble(Integer.parseInt(quantite)*11400+""),Idgrossiste,"grossiste");
			this.servicestatistique.deleteupdatestat(Idgrossiste,Integer.parseInt(quantite),"ooredoo");	
			this.servicestatistique.updateventestat(Idgrossiste, Integer.parseInt(quantite), "ooredoo");
			voucher.setVouchers10ooredoo(ListVoucher);
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
				response="vous n'avez pas "+Integer.parseInt(quantite)+" voucher Ooredoo de montant 10 DT " + "vous  avez que "+ListVoucher.size();
			}
			}
			else if(ListVoucher==null)
			{
				response="vous n'avez pas de  voucher Ooredoo de montant 10 DT";
			}
			
		    }
		}
		else if(voucher==null)
		{
			response="vous n'avez pas de  voucher Ooredoo";
		}
			
			
		System.out.println(response);
		
		return(response);	
	}
	
	
	
	
	
	
	//Get the voucher to imprimer
	public ReponseImprimier GetVouchers(String montant,String operateure,String quantite,String id)
	{
         
		ArrayList<Voucher> listVouchers=new ArrayList<Voucher>();

		 String message="";
		 
		 //Qunatité of the commande
		 int Quantité=Integer.parseInt(quantite);
		
		 //Get Document from Db
	     VoucherOoredoo vouche=this.FindVoucher(id,montant);
	     
		  if(vouche!=null)
		  {
	
		 if(montant.equals("1000"))
		 {			
			 
		//get List voucher SuperGrossiste
		    ArrayList<Voucher> ListVoucherG=vouche.getVouchers1ooredoo();
		    
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
		    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant 1 dinard";
		    }
		    	
		    }
		    //list voucher supergrossiste is null
		    else if(ListVoucherG==null)
		    {
		    	message="vous n'avez pas de voucher Ooredoo de montant 1 dinar";
		    }
		 }
		
		 if(montant.equals("5000"))
		 {			 
			//get the List voucher of SuperGrossiste
		    ArrayList<Voucher> ListVoucherG=vouche.getVouchers5ooredoo();
		    
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
		    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant 5 dinard";
		    }
		    }
		    
		    //list voucher supergrossiste is null
		    if(ListVoucherG==null)
		    {
		    	message="vous n'avez pas de voucher Ooredoo de montant 5 dinar";
		    }
	     }
		
		 if(montant.equals("10000"))
		 {		
			//get List voucher SuperGrossiste
			    ArrayList<Voucher> ListVoucherG=vouche.getVouchers10ooredoo();
			      
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
			    	message="Vous n'avez pas "+Quantité+" voucher Ooredoo de montant 10 dinard";
			    }
			    }
			    
			    
			    //list voucher supergrossiste is null
			    if(ListVoucherG==null)
			    {
			    	message="vous n'avez pas de voucher Ooredoo de montant 10 dinar";
			    }
		    
		       }
		       
		  }
		  else if(vouche==null)
		  {
			  message="vous n'avez pas de voucher Ooredoo";
		  }
			 
		 System.out.println(message);
		 responseimprime=new ReponseImprimier (message,listVouchers);
		 return responseimprime;
	}
	
	public VoucherOoredoo getVoucher(String id)
	{
		VoucherOoredoo voucherooredoo=null;
		if(this.Exist(id))
		{
			voucherooredoo= voucherrepository.findById(id).get();
	    }
		return voucherooredoo;
	}
	
	public ArrayList<Voucher> getallvoucher(String id,String montant)
	 {
		  	VoucherOoredoo vo=this.getVoucher(id);
		  	ArrayList<Voucher> listvoucher=null;
		  	if(vo!=null)
		  	{
		  	if(montant.equals("1000"))
		  	 {
		  		listvoucher=vo.getVouchers1ooredoo();
		  	 }
		  	
		  	if(montant.equals("5000"))
		  	 {
		  		listvoucher=vo.getVouchers5ooredoo();
		  	 }
		  	
		  	if(montant.equals("10000"))
		  	 {
		  		listvoucher=vo.getVouchers10ooredoo();
		  	 }
		  		  		
		  	}
		  	return listvoucher;
		
	 }
	
	public void RemouveVoucher(ArrayList<Voucher> listvoucher,String id,String montant)
	{
  
		VoucherOoredoo vouche=this.FindVoucher(id,montant);
		ArrayList<Voucher> listvouchergrossiste;
		
		if(montant.equals("1000"))
		{
			listvouchergrossiste=vouche.getVouchers1ooredoo();
			for(int i=0;i<listvoucher.size();i++)
			{
				
				this.servicestatistique.UpdatePointFidélité(id,5,"ooredoo");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			 
			 vouche.setVouchers1ooredoo(listvouchergrossiste);
			 save(vouche);
			
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*1250+""),id,"grossiste");
			 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"ooredoo");	
			 this.servicestatistique.updateventestat(id, listvoucher.size(),"ooredoo");
		}
		
		if(montant.equals("5000"))
		{
		
			listvouchergrossiste=vouche.getVouchers5ooredoo();	
			for(int i=0;i<listvoucher.size();i++)
			{
				 this.servicestatistique.UpdatePointFidélité(id,10,"ooredoo");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			 vouche.setVouchers5ooredoo(listvouchergrossiste);
			 save(vouche);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*5700+""),id,"grossiste");
			 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"ooredoo");	
			 this.servicestatistique.updateventestat(id, listvoucher.size(),"ooredoo");
			
		}
		
		if(montant.equals("10000"))
		{
			listvouchergrossiste=vouche.getVouchers10ooredoo();
			for(int i=0;i<listvoucher.size();i++)
			{
				this.servicestatistique.UpdatePointFidélité(id,15,"ooredoo");
				String code=cripter.encrypt(listvoucher.get(i).getCode());    
                listvouchergrossiste.remove(this.getvoucher(listvouchergrossiste,code));
			}
			
			 vouche.setVouchers10ooredoo(listvouchergrossiste);
			 save(vouche);
			 chifreafaireservice.updatechiffreafaire(Double.parseDouble(listvoucher.size()*11400+""),id,"grossiste");
			 this.servicestatistique.deleteupdatestat(id,listvoucher.size(),"ooredoo");	
			 this.servicestatistique.updateventestat(id, listvoucher.size(),"ooredoo");
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
