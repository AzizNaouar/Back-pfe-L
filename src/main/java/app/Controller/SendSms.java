package app.Controller;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import app.Service.ServiceSms;

@RestController
public class SendSms 
{
	@Autowired
	ServiceSms servicesms;
	
	 Random rand = new Random();
	 
	
	@CrossOrigin
	@GetMapping("/envoiecode/{num}")
	public String  EnvoyerSms(@PathVariable String num)
	
	{
		String codegenere="";
		codegenere=getcode();
		servicesms.sendsms(num, codegenere);
		return codegenere;
	}
	
	
	public String getcode()
	{
		String code="";
		for(int i=0;i<2;i++)
		   {
			  int c = rand.nextInt(26) + 97;
		      code=code+c;
		   }
		return code;
	}
	
	

}
