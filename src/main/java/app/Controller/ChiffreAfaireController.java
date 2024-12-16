package app.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.Modele.ChiffreAffaire;
import app.Modele.Response;
import app.Service.ChiffreAfaireService;

@RestController
public class ChiffreAfaireController 
{
	@Autowired
	ChiffreAfaireService chiffrafaireservice;
	
	
	
	
	@CrossOrigin
	@GetMapping("/getchiffre/{id}")
    
	public ArrayList<Double> getChiffre(@PathVariable String id)
    {
		
	ArrayList<Double> list=new ArrayList<Double>();
	ChiffreAffaire chiffre=chiffrafaireservice.getchiffre(id);
	if(chiffre!=null)
	{

	list.add(Double.parseDouble(chiffre.getJanvier()));
	list.add(Double.parseDouble(chiffre.getFévrier()));
	list.add(Double.parseDouble(chiffre.getMars()));
	list.add(Double.parseDouble(chiffre.getAvril()));
	list.add(Double.parseDouble(chiffre.getMai()));
	list.add(Double.parseDouble(chiffre.getJuin()));
	list.add(Double.parseDouble(chiffre.getJuillet()));
	list.add(Double.parseDouble(chiffre.getAoût()));
	list.add(Double.parseDouble(chiffre.getSeptembre()));
	list.add(Double.parseDouble(chiffre.getOctobre()));
	list.add(Double.parseDouble(chiffre.getNovembre()));
	list.add(Double.parseDouble(chiffre.getDécembre()));
	}
	
	return list;
	
   }
	


@CrossOrigin
@GetMapping("/getchiffretotale/{type}")
public Response GetNumberTotale(@PathVariable String type)
{
	String totale=chiffrafaireservice.getAll(type);
	Response resp=new Response(totale);
	return resp;
	
}




}
