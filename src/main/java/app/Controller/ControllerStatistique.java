package app.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.Modele.Response;
import app.Modele.Statistique;
import app.Service.ServiceStatistique;

@RestController
public class ControllerStatistique 
{
	@Autowired
	ServiceStatistique servicestatistique;
	
	
	@CrossOrigin
	@GetMapping("/getstatic/{id}")
	public ArrayList<Integer> getliste(@PathVariable String id)
	{
		return(servicestatistique.getporcent(id));
	}
	
	@CrossOrigin
	@GetMapping("/getpoint/{id}")
	public Response getpointfidélité(@PathVariable String id)
	{
		String nbrpoint=servicestatistique.getnbrpoint(id);
		Response res=new Response(nbrpoint);
		return res;
	}
	
	
	@CrossOrigin
	@PostMapping("/save")
	public void save(@RequestBody Statistique sta)
	{
		servicestatistique.save(sta);
	}

	
	@CrossOrigin
	@GetMapping("/findstatistique/{id}")
	public Statistique findbyiduser(@PathVariable String id)
	{
		return (servicestatistique.findbyiduser(id));
	}
	
	
	

}
