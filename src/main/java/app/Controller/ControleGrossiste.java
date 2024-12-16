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
import app.Modele.Grossiste;
import app.Modele.Response;
import app.Modele.UserInfo;
import app.Modele.Users;
import app.Service.EmailService;
import app.Service.GrossisteService;
import app.Service.UsersService;
import freemarker.template.TemplateException;

@RestController
public class ControleGrossiste 
{
	
	 //injection de dépondence
	 @Autowired
	 GrossisteService servicegrossiste;
     @Autowired
     UsersService userservice;
     
     @Autowired
	 EmailService mailservice;
     Boolean verif;
     
     
     @CrossOrigin
     @PostMapping("/InsertGrossiste")
     public Response Insert(@RequestBody Grossiste grossiste)
     {
    	 
     	Response respons;
     	String response="";
     	//vérifier l'existence de username in DB 
     	if((servicegrossiste.Exist(grossiste.getid()))==false)
        {
     		if(!userservice.Exist(grossiste.getid()))
     		 {
     			System.out.println(grossiste.getid());
     	
     	if(VerifUserName(grossiste.getUsername()))
     	{
     	try 
     	{
     		servicegrossiste.Insert(grossiste);
         	userservice.Insert(new Users(grossiste.getid(),grossiste.getUsername(),grossiste.getPassword(),"grossiste"));
			mailservice.sendEmail(new UserInfo(grossiste.getNom(),grossiste.getUsername(),grossiste.getPassword()),"your account is created");
			response= "l'utilisateur est ajouté avec succès";
     	} 
     	catch (MessagingException | IOException | TemplateException e) 
     	{
			e.printStackTrace();
			response=e.getMessage();
		}
     	}
        else if(!VerifUserName(grossiste.getUsername()))
        {
     	   response="l'email existe déjà";
     	}
        }
     	else if((userservice.Exist(grossiste.getid())))
     	{
     		response="Vous avez ajouté un utilisateur avec le même identifiant";
     	}
     	
   
     }
     	else if((servicegrossiste.Exist(grossiste.getid()))==true)
     	{
     		response="L'identifiant existe déjà";
     	}
     	  System.out.println(response);
          respons=new Response(response);
          return(respons);
          
     }
     
    @CrossOrigin
    @PostMapping("/SaveGrossiste")
    public void Save(@RequestBody Grossiste grossiste)
    {
    	servicegrossiste.Save(grossiste);
    }
    
    
    @CrossOrigin
    @GetMapping("/GetAllGrossiste")
    public List<Grossiste> FindAll()
    {
    	return(servicegrossiste.FindAll());
    }
    
    
    @CrossOrigin
    @GetMapping("/GetGrossisteById/{Id}")
    public Grossiste FindById(@PathVariable String Id)
    {
    	return(servicegrossiste.FindById(Id));
    }
     
    
    @CrossOrigin
    @GetMapping("/Get/{Usernama}/{Password}")
    public Grossiste FindGrossiste(@PathVariable String Usernama, @PathVariable String Password)
    {
     	return(servicegrossiste.findgrossiste(Usernama, Password));
    }
     
    
    @CrossOrigin
    @GetMapping("/VerifUserr/{username}")
     public Boolean VerifUserName(@PathVariable String username)
     {
     	return(userservice.FindUserByUserName(username));
     }
     
    
    @CrossOrigin
    @DeleteMapping("/DeleteGrossiste")
    public void Delete(@RequestBody Grossiste grossiste)
    {
    	servicegrossiste.Delete(grossiste);
    	
    	userservice.Delete(new Users(grossiste.getid(),grossiste.getUsername(),grossiste.getPassword(),"grossiste"));
    }
    
    
    @CrossOrigin
    @DeleteMapping("/DeleteGrossisteById/{id}")
    public void DeleteById(@PathVariable String id)
    {
    	
    	servicegrossiste.DeleteById(id);
    	userservice.DeleteById(id);
    }
    
    @CrossOrigin
    @PostMapping("/UpdateGrossiste/{id}")
    public void UpdateById(@PathVariable String id,@RequestBody Grossiste nouvellegrossiste)
    {
    	verif=servicegrossiste.UpdateById(id, nouvellegrossiste);
    	if(verif==true)
    	{
    		 userservice.UpdateData(id,nouvellegrossiste.getUsername());
    	}
    }
   
    
    @CrossOrigin
    @PostMapping("/Updatepass/{password}")
	public Response UpdatePassword(@PathVariable String password,@RequestBody String username)
	{
    	String message="";
    	try
    	{
		servicegrossiste.UpdatePassword(password,username);
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
    @PostMapping("/Updatephoto/{username}")
	public void UpdateImage(@PathVariable String username,@RequestBody String url)
	{
		servicegrossiste.UpdateImage(url, username);
	
    }
    
    @CrossOrigin
	@GetMapping("/GetGunder/{IdUser}")
	public List<Grossiste> FindGunder(@PathVariable String IdUser)
	{
		 return (servicegrossiste.FindGunder(IdUser));
		 
	}



   
   
  
    
    
    
    
    
    
    
    
    
    
    
    

}
