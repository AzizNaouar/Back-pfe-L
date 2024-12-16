package app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.HistoriqueGrossiste;
import app.Repository.HistoriqueGrossisteRepository;


@Service
public class HistoriqueGrossisteService {

	
	
	  @Autowired
	  HistoriqueGrossisteRepository historygrossisterepository;
	  
	  
	  public List<HistoriqueGrossiste> findHistoriqueGrossiste(String id)
	  {
		  return historygrossisterepository.findHistoriqueGrossiste(id);
	  }
	  
	  public void Insert(HistoriqueGrossiste gr)
	  {
		  historygrossisterepository.insert(gr);
	  }
	  public List<HistoriqueGrossiste> GetAllHistoriqueGrosssite()
	  {
		 return historygrossisterepository.findAll();
	  }
	  
	  
	 
	  
	 
}
