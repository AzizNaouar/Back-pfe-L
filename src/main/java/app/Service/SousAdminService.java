package app.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.SousAdmin;
import app.Repository.SousAdminRepository;

@Service
public class SousAdminService 
{
	 @Autowired
	 SousAdminRepository sousadminrepository;
     SousAdmin sousadmin;
   
    public void Insert(SousAdmin sousadmin)
    {
    	sousadminrepository.insert(sousadmin);
    }
    
  
    public void Save(SousAdmin sousadmin)
    {
    	sousadminrepository.save(sousadmin);
    }
    
   
    public List<SousAdmin> FindAll()
    {
    	return(sousadminrepository.findAll());
    }
    
    public SousAdmin findSousAdmin(String username , String password)
    {
    	return(sousadminrepository.findSousAdmin(username, password));
    
    }
    public Boolean FindByUsername(String username)
    {
    	SousAdmin sousadmin=sousadminrepository.findByUsername(username);
    	//nexistepas
    	if(sousadmin==null)
    		return true;
    	
    	//existe
    	else
    		return false;
    }
    
    
    public SousAdmin FindById(String Id)
    {
    	SousAdmin sousadmin=null;
    	if(Exist(Id))
    	{
    		sousadmin=sousadminrepository.findById(Id).get();
    	}
    	
    	return(sousadmin);
    }
    
    public void Delete(SousAdmin sousadmin)
    {
    	if(Exist(sousadmin.getId()))
    	{
    	  sousadminrepository.delete(sousadmin);
        }
    }
    
    public void DeleteById(String id)
    {
    	if(Exist(id))
    	{
    		sousadminrepository.deleteById(id);
        }
    	
    }
    
   public Boolean Update( String id,SousAdmin nouvelleSAdmin)
   {
	   Boolean verif=true;
	   if(Exist(id))
	   {
	    SousAdmin SAdminInitiale=FindById(id);
	    if(SAdminInitiale.getUsername().equals(nouvelleSAdmin.getUsername()))
	    {
	    	verif=false;
	    }
	    SAdminInitiale.setAdresse(nouvelleSAdmin.getAdresse());
	    SAdminInitiale.setNom(nouvelleSAdmin.getNom());
	    SAdminInitiale.setNumtel(nouvelleSAdmin.getNumtel());
	    SAdminInitiale.setPrenom(nouvelleSAdmin.getPrenom());
	    SAdminInitiale.setUsername(nouvelleSAdmin.getUsername());
	    SAdminInitiale.setVille(nouvelleSAdmin.getVille());
	    SAdminInitiale.setGouvernourat(nouvelleSAdmin.getGouvernourat());
	    sousadminrepository.save(nouvelleSAdmin);
	   }
	   return verif;
   }
   
   public Boolean Exist(String id)
   {
	   return(sousadminrepository.existsById(id));
   }
   
   
   public SousAdmin FindSousAdmin(String mail)
   {
	   return (sousadminrepository.findByUsername(mail));
   }
   
   public void UpdatePassword(String passwrd,String username)
   {
	   sousadmin=sousadminrepository.findByUsername(username);
	   sousadmin.setPassword(passwrd);
	   sousadminrepository.save(sousadmin);
   }
   
   public void UpdateImage(String url,String username)
   {
	   sousadmin=sousadminrepository.findByUsername(username);
	   sousadmin.setUrlimage(url);
	   sousadminrepository.save(sousadmin);
   }
   
   public List<SousAdmin> Findunder(String IdAdmin)
   {
	   return(sousadminrepository.findunder(IdAdmin));
   }
   
   public void UpdateSousAdmin(SousAdmin sous)
   {
	   this.Save(sous);
   }
   
   
   
   
   
   
   }
   
   
   
   
  
    
    
    



