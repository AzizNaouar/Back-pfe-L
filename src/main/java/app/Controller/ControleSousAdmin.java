package app.Controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.Modele.Response;
import app.Modele.SousAdmin;
import app.Modele.UserInfo;
import app.Modele.Users;
import app.Service.EmailService;
import app.Service.SousAdminService;
import app.Service.UsersService;
import freemarker.template.TemplateException;

@RestController
public class ControleSousAdmin 
{
	
	//injection de dépendence
	 @Autowired
	 SousAdminService servicesousadmin;
	 
	 @Autowired
     UsersService userservice;
	 
	 @Autowired
	 EmailService mailservice;
	 
	 Boolean verif;
	 
	 
	@CrossOrigin
    @PostMapping("/InsertSAdmin")
    public Response Insert(@RequestBody SousAdmin sousadmin)
    {

		String response="";
		Response respons;
    
		if(!servicesousadmin.Exist(sousadmin.getId()))
		{
			if(!userservice.Exist(sousadmin.getId()))
    		 {
		if(VerifUserName(sousadmin.getUsername()))
		{
    	try 
    	{
    		servicesousadmin.Insert(sousadmin);
        	userservice.Insert(new Users(sousadmin.getId(),sousadmin.getUsername(),sousadmin.getPassword(),"SousAdmin"));
			mailservice.sendEmail(new UserInfo(sousadmin.getNom(),sousadmin.getUsername(),sousadmin.getPassword()),"your account is created");
			response= "l'utilisateur est ajouté avec succès";
    	}
    	catch (MessagingException | IOException | TemplateException e) 
    	{
			e.printStackTrace();
			response=e.getMessage();
		}
        }
		else if(!VerifUserName(sousadmin.getUsername()))
		{
			response="l'email existe déjà";
        }
		}
		else if(userservice.Exist(sousadmin.getId()))
		{
			response="Vous avez ajouté un utilisateur avec le même identifiant";
		}
		} 
		else if(servicesousadmin.Exist(sousadmin.getId()))
		{
			response="L'identifiant existe déjà";
		}
		System.out.println(response);
		respons=new Response(response);
		return respons;
    }
	
	
	@CrossOrigin
    @PostMapping("/SaveSAdmin")
    public void Save(@RequestBody SousAdmin sousadmin)
    {
    	servicesousadmin.Save(sousadmin);
    }
    
	
    @CrossOrigin
    @GetMapping("/GetAllSAdmin")
    public List<SousAdmin> FindAll()
    {
    	return(servicesousadmin.FindAll());
    }
	 
    
    @CrossOrigin
    @GetMapping("/GetSAdminById/{Id}")
    public SousAdmin FindById(@PathVariable String Id)
    {
    	return(servicesousadmin.FindById(Id));
    }
	 
	@CrossOrigin
	@GetMapping("/GetSAdmin/{username}/{password}")
	public SousAdmin FindSousAdmin(@PathVariable String username,@PathVariable String password)
	{
		 return (servicesousadmin.findSousAdmin(username, password));
		 
	}
	 
	@CrossOrigin
	@GetMapping("/VerifUser/{username}")
	public boolean VerifUserName(@PathVariable String username)
	{
		 return (userservice.FindUserByUserName(username));
	}
	 
	 
	 
	 
	 @CrossOrigin
    @DeleteMapping("/DeleteSAdmin")
    public void Delete(@RequestBody SousAdmin sousadmin)
    {
    	servicesousadmin.Delete(sousadmin);
    	userservice.Delete(new Users(sousadmin.getId(),sousadmin.getUsername(),sousadmin.getPassword(),"SousAdmin"));
    	
    }
	 
	 
	@CrossOrigin
    @DeleteMapping("/DeleteSAdminById/{id}")
    public void DeleteById(@PathVariable String id)
    {
    	
    		servicesousadmin.DeleteById(id);
    		userservice.DeleteById(id);
    		
    }
    
   @CrossOrigin
   @PostMapping("/UpdateSAdmine/{id}")
   public void Update(@PathVariable String id,@RequestBody SousAdmin nouvelleSAdmin)
   {
	   verif=servicesousadmin.Update(id, nouvelleSAdmin);
	   if(verif==true)
	   {
	   userservice.UpdateData(id,nouvelleSAdmin.getUsername());
	   }
	}
   
   @CrossOrigin
   @PostMapping("/UpdatePASS/{password}")
   public Response Updatepassword(@PathVariable String password,@RequestBody String username)
   {
	   String message="";
	   try
	   {
	   servicesousadmin.UpdatePassword(password,username);
	   userservice.UpdatePassword(password,username);
	   message="vous avez changé votre mot de passe avec succès";
	   }
	   catch(Exception e)
	   {
		   message=e.getMessage();
	   }
	   Response resp=new Response(message);
  
       return resp;
   }
   
   @CrossOrigin
   @PostMapping("/UpdateIMAGE/{username}")
	public void UpdateImage(@PathVariable String username,@RequestBody String url)
	{
		servicesousadmin.UpdateImage(url, username);
	
   }
   
   
   @CrossOrigin
	@GetMapping("/GetUnder/{IdAdmin}")
	public List<SousAdmin> FindUnder(@PathVariable String IdAdmin)
	{
		 return (servicesousadmin.Findunder(IdAdmin));
		 
	}
  
    
    
    

}
