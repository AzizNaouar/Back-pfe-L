package app.Service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.Grossiste;
import app.Repository.GrossisteRepository;


@Service
public class GrossisteService {
	
	     @Autowired
		  GrossisteRepository grossisterepository;
	     
	      Grossiste grossiste;
	    // private BCryptPasswordEncoder bcrypte;
	      String passwordbcrypt;
	      Boolean verif=true;
	    
	  
	    public void Insert(Grossiste grossiste)
	    {
	    	// this.bcrypte=new BCryptPasswordEncoder();
	    	 //this.bcrypte.
	    	 //passwordbcrypt= this.bcrypte.encode(grossiste.getPassword());
	    	 //grossiste.setPassword(passwordbcrypt);
	    	 
	    	 grossisterepository.insert(grossiste);
	    }
	    
	    
   
	    
	    public Boolean findbyUsername(String username)
	    {
	    	Grossiste grossiste= grossisterepository.findByUsername(username);
	    	if(grossiste==null)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    
	    public Grossiste findgrossiste(String Username,String password)
	    {
	    	return(grossisterepository.findGrossiste(Username, password));
	    }
	   
	    public void Save(Grossiste grossiste)
	    {
	    	grossisterepository.save(grossiste);
	    }
	    
	
	    public List<Grossiste> FindAll()
	    {
	    	return(grossisterepository.findAll());
	    }
	    
	    
	    public Grossiste FindById(String Id)
	    {
	    	Grossiste grossiste=null;
	    	if(Exist(Id))
	    	{
	    	   grossiste=grossisterepository.findById(Id).get();
	        }
	    	return grossiste;
	    }
	    
	    
	    public void Delete(Grossiste grossiste)
	    {
	    	if(Exist(grossiste.getid()))
	    	{
	    	
	    	grossisterepository.delete(grossiste);
	  
	    	}
	    }
	    
	  
	    public void DeleteById(String id)
	    {
	    	if(Exist(id))
	    	{
	    		grossisterepository.deleteById(id);
	        }
	    	
	    }
	    
	    
	   
	   public Boolean UpdateById(String id,Grossiste nouvellegrossiste)
	   {
		   if(Exist(id))
		   {
		   Grossiste grossisteInitiale=FindById(id);
		   if(grossisteInitiale.getUsername().equals(nouvellegrossiste.getUsername()))
		   {
			verif=false;   
		   }
		   grossisteInitiale.setAdresse(nouvellegrossiste.getAdresse());
		   grossisteInitiale.setNom(nouvellegrossiste.getNom());
		   grossisteInitiale.setNumtel(nouvellegrossiste.getNumtel());
		   grossisteInitiale.setPrenom(nouvellegrossiste.getPrenom());
		   grossisteInitiale.setUsername(nouvellegrossiste.getUsername());
		   grossisteInitiale.setVille(nouvellegrossiste.getVille());
		   grossisteInitiale.setGouvernourat(nouvellegrossiste.getGouvernourat());
		   grossisterepository.save(grossisteInitiale);
		   }
		   return verif;
	   }
	   
	   public Boolean Exist(String id)
	   {
		   return(grossisterepository.existsById(id));
	   }
	   
	   public Grossiste FindGrossiste(String mail)
	   {
		   return grossisterepository.findByUsername(mail);
	   }
	   
	 
	   public void UpdatePassword(String passwrd,String username)
	   {
		   
		grossiste=grossisterepository.findByUsername(username);
		grossiste.setPassword(passwrd);
		grossisterepository.save(grossiste);
	   
	    }
	   
	   public void UpdateImage(String url,String username)
	   {
		   grossiste=grossisterepository.findByUsername(username);
		   grossiste.setUrlimage(url);
		   grossisterepository.save(grossiste);
	   }
	   
	   public List<Grossiste> FindGunder(String IdUser)
	   {
		   return(grossisterepository.findGunder(IdUser));
	   }
	   
	   public void UpdateGrossiste(Grossiste g)
	   {
		   this.Save(g);
	   }
	   
	   
	   
	   
	   
	   
	 
	    
}