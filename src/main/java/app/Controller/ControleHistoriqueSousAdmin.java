package app.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.Modele.HistoriqueSousAdmin;
import app.Service.HistoriqueSousAdminService;


@RestController
public class ControleHistoriqueSousAdmin {
	
	 @Autowired
	 HistoriqueSousAdminService historiqueservice;
	 
	 
	 @CrossOrigin
	 @PostMapping("/InsertHistoriqueSousAdmin")
	 public void Insert(@RequestBody HistoriqueSousAdmin h)
	 {
		 historiqueservice.Insert(h);
		 
	 }
	 
	 @CrossOrigin
	 @GetMapping("/GetHistoriqueSousAdmin/{id}")
	 public List<HistoriqueSousAdmin> getHistoriqueSous(@PathVariable String id)
	 {
		return historiqueservice.findHistoriqueSousAdmin(id);
		 
	 }
	 
	 
	

}
