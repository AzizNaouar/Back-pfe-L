package app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.Admin;
import app.Modele.Response;
import app.Service.AdminService;
import app.Service.UsersService;
import app.Service.VoucherOoredooService;

@RestController
public class ControleAdmin 
{
	@Autowired
	AdminService adminservice;
	@Autowired
	UsersService  userservice;
	Boolean verif;
	@Autowired
	VoucherOoredooService  voucher;
	
	@CrossOrigin
    @GetMapping("/getAdmin/{username}/{password}")
	public Admin FindAdmin(@PathVariable String username,@PathVariable String password )
	{
		return(adminservice.getAdmin(username, password));
	}
	
	@CrossOrigin
    @PostMapping("/UpdateAdmin/{id}")
	public void Update(@PathVariable String id,@RequestBody Admin admin)
	{
		
		verif=adminservice.UpdateById(id,admin);
		if(verif==true)
		{
			userservice.UpdateData(id,admin.getUsername());
	    }
	}
	
	@CrossOrigin
    @PostMapping("/UpdatePass/{password}")
	public Response UpdatePassword(@PathVariable String password,@RequestBody String username)
	{
		String message="";
	    try
	    {
		adminservice.UpdatePassword(password, username);
		userservice.UpdatePassword(password,username );
		message="Vous avez changé votre mot de passe avec succès";
	    }
	    catch(Exception e)
	    {
	    	message=e.getMessage();
	    }
	    
        Response resp=new Response(message);
		return resp;
	}
	
	@CrossOrigin
    @PostMapping("/UpdateImage/{username}")
	public void UpdateImage(@PathVariable String username,@RequestBody String url)
	{
		adminservice.UpdateImage(url, username);
	
    }
	

	
	
	
	
	

}
