package app.Service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.Admin;
import app.Repository.AdminRepository;

@Service
public class AdminService 
{
	@Autowired
	AdminRepository adminrepository ;
	Admin admin;
	
	public Admin getAdmin(String username,String password)
	{
		return (adminrepository.findAdmin(username, password));
		
	}
	
	  public Boolean UpdateById(String id,Admin nouvelleAdmin)
	   {
		  
		  Boolean verif=true; 
		   if(Exist(id))
		   {
			   
		   Admin adminInitiale=adminrepository.findById(id).get();
		   if(adminInitiale.getUsername().equals(adminInitiale.getUsername()))
		   {
			   verif =false;
		   }
		   adminInitiale.setAdresse(nouvelleAdmin.getAdresse());
		   adminInitiale.setNom(nouvelleAdmin.getNom());
		   adminInitiale.setNumtel(nouvelleAdmin.getNumtel());
		   adminInitiale.setPrenom(nouvelleAdmin.getPrenom());
		   adminInitiale.setUsername(nouvelleAdmin.getUsername());
		   adminInitiale.setVille(nouvelleAdmin.getVille());
		   adminInitiale.setGouvernourat(nouvelleAdmin.getGouvernourat());
		   adminrepository.save(adminInitiale);
		   
		   }
		   return verif;
	   }
	   
	   public Boolean Exist(String id)
	   {
		   return(adminrepository.existsById(id));
	   }
	   
	   public Admin FindAdmin(String mail)
	   {
		   return (adminrepository.findByUsername(mail));
	   }
	   
	   
	   public void UpdatePassword(String password, String username  )
	   {
		   
		admin=adminrepository.findByUsername(username);
		admin.setPassword(password);
		adminrepository.save(admin);
	   
	   }
	   
	   public void UpdateImage(String url,String username)
	   {
		   
		   admin=adminrepository.findByUsername(username);
		   admin.setUrlimage(url);
		   adminrepository.save(admin);
	   }
	   
	   
	   public void UpdateAdmine(Admin admin)
	   {
		   adminrepository.save(admin);
	   }
	   
	   
	   
	
		
	   
	 
	

}
