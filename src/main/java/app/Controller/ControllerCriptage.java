package app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.Response;
import app.Service.CripterVoucher;

@RestController
public class ControllerCriptage 
{
	
	    @Autowired
	 	CripterVoucher cripter;
	    
	    
	    @CrossOrigin
	    @GetMapping("/encripte/{password}")
	    public Response encripte(@PathVariable String password)
	    {
	    	String password2=cripter.encrypt(password);
	    	System.out.println(password2);
	    	return(new Response(password2));
	    }
	    
	    @CrossOrigin
	    @GetMapping("/decripte/{password}")
	    public String decripte(@PathVariable String password)
	    {
	    	String password2=cripter.decrypt(password);
	    	System.out.println(password2+"d,d,d,d,");
	    	return(password2);
	    }
	     
}
