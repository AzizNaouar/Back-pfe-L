package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.HistoriqueGrossiste;
import app.Service.HistoriqueGrossisteService;

@RestController
public class ControleHistoriqueGrossiste {

	 @Autowired
	 HistoriqueGrossisteService historiqueservice;
	 
	 
	 @CrossOrigin
	 @GetMapping("/GetHistoriqueGrossiste/{id}")
	 public List<HistoriqueGrossiste> GetHistoriqueGrossiste(@PathVariable String id)
	 {
		 return historiqueservice.findHistoriqueGrossiste(id);
	 }
	 
	 @CrossOrigin
	 @GetMapping("/GetAllHistoriqueGrossiste")
	 public List<HistoriqueGrossiste> GetAllHG()
	 {
		return historiqueservice.GetAllHistoriqueGrosssite();
	 }
	 
	 
	
	 
	 

	
	 
}

