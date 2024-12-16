package app.Controller;


import java.io.IOException;

import javax.mail.MessagingException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.Modele.Admin;
import app.Modele.Grossiste;
import app.Modele.Response;
import app.Modele.SousAdmin;
import app.Modele.UserInfo;
import app.Modele.Users;
import app.Service.AdminService;
import app.Service.EmailService;
import app.Service.GrossisteService;
import app.Service.SousAdminService;
import app.Service.UsersService;
import freemarker.template.TemplateException;

@RestController
public class ControleUser 
{

	@Autowired
	UsersService userservice;
	@Autowired
	EmailService  emailService;
	@Autowired
	GrossisteService grossisteservice;
	@Autowired
	SousAdminService sousadminservice;
	@Autowired
	AdminService adminservice;
	Response resp=new Response();
	
	
	@CrossOrigin
	@GetMapping("/login/{username}/{password}")
	public Users Login(@PathVariable String username,@PathVariable String password)
	{
		
		Users user=userservice.FindUser(username, password);
		return user;
	}
	
	
	@CrossOrigin
	@GetMapping("/renetialiser/{mail}/{numtel}")
	public Response ResetPassword(@PathVariable String mail,@PathVariable String numtel )
	{
		String code="";
		

		
		//cree un nouveau password
		String Newpassword=userservice.ForgetPassword();
		//update user
		Users user=userservice.FindUser(mail);
		
		if(user!=null)
		{
		if(user.getType().equals("grossiste"))
		{
			Grossiste grossiste=grossisteservice.FindGrossiste(mail);
			if(grossiste!=null)
			{
				if(grossiste.getNumtel().equals(numtel))
				{    
					  user.setPassword(Newpassword);
				      userservice.Update(user);
					  grossiste.setPassword(Newpassword);
			          grossisteservice.UpdateGrossiste(grossiste);
			          
			          try 
						{
						   emailService.sendEmail(new UserInfo ("",mail,Newpassword),"New Password For your Count");
						}   
						catch (MessagingException | IOException | TemplateException e) 
						{
							e.printStackTrace();
						}
			          
			          code="votre mot de passe à été changé avec succès";
		        }
				
				else if(grossiste.getNumtel()!=numtel)
				{
					code="le numéro de téléphone ne correspond pas à l'adresse électronique que vous avez saisie";
				}
			}
			
			else if(grossiste==null)
			{
				code="l'adresse e-mail que vous avez saisie ne correspond pas à un utilisateur";	
			}
		}
		
		if(user.getType().equals("SousAdmin"))
		{
			SousAdmin sousadmin=sousadminservice.FindSousAdmin(mail);
			if(sousadmin!=null)
			{
	
			if(sousadmin.getNumtel().equals(numtel))
			{
				
				user.setPassword(Newpassword);			 
				userservice.Update(user);
			    sousadmin.setPassword(Newpassword);
			    sousadminservice.UpdateSousAdmin(sousadmin);
			    
			    try 
				{
				   emailService.sendEmail(new UserInfo ("",mail,Newpassword),"New Password For your Count");
				}   
				catch (MessagingException | IOException | TemplateException e) 
				{
					e.printStackTrace();
				}
			    code="votre mot de passe à été changé avec succès";
			}
			else if(sousadmin.getNumtel()!=numtel)
			{
				code="le numéro de téléphone ne correspond pas à l'adresse électronique que vous avez saisie";
			}
				
			}
			else if(sousadmin==null)
			{
				code="l'adresse e-mail que vous avez saisie ne correspond pas à un utilisateur";	
			}
	     }
		
		
		if(user.getType().equals("Admin"))
		{
			Admin admin=adminservice.FindAdmin(mail);
			if(admin!=null)
			{
				if(admin.getNumtel().equals(numtel))
				{
					user.setPassword(Newpassword);			 
					userservice.Update(user);
					admin.setPassword(Newpassword);
					adminservice.UpdateAdmine(admin);
					
					   try 
						{
						   emailService.sendEmail(new UserInfo ("",mail,Newpassword),"New Password For your Count");
						}   
						catch (MessagingException | IOException | TemplateException e) 
						{
							e.printStackTrace();
						}
					   code="votre mot de passe à été changé avec succès";
				}
				
				else if(admin.getNumtel()!=numtel)
			    {
					code="le numéro de téléphone ne correspond pas à l'adresse électronique que vous avez saisie";
			    }
					
			}
			else if(admin==null)
			{
				code="l'adresse e-mail que vous avez saisie ne correspond pas à un utilisateur";	
			}
		}
			
		}
		
		else if(user==null)
		{
         code="l'adresse e-mail que vous avez saisie ne correspond pas à un utilisateur";
		}
	
	     resp.setResponse(code);
		System.out.println(resp.getResponse());
		
		return resp;
	}
	
	@CrossOrigin
	@GetMapping("/")
	public String  EnvoyerSms()
	
	{
		String codegenere="";
		codegenere=getcode();
		return codegenere;
	}
	
	
	public String getcode()
	{
		String code="";
		for(int i=0;i<2;i++)
		   {
			  int c =5;
		      code=code+c;
		   }
		return code;
	}
	
	
	
	

}
