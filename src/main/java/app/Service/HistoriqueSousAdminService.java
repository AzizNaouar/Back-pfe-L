package app.Service;


import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.HistoriqueSousAdmin;
import app.Repository.HistoriqueSousAdminRepository;


@Service
public class HistoriqueSousAdminService 
{
	
	@Autowired
	HistoriqueSousAdminRepository historiquesousadmin;
	
	 public List<HistoriqueSousAdmin> findHistoriqueSousAdmin(String id)
	  {
		  return historiquesousadmin.findHistoriqueSousAdmin(id);
	  }
	  
	  public void Insert(HistoriqueSousAdmin gr)
	  {
		  historiquesousadmin.insert(gr);
	  }
	  

	  public void insert(Instant date,String id,String montant,String q,String op,String nom,String prenom,String da)
	  {
		  historiquesousadmin.insert(new HistoriqueSousAdmin(date,id,montant,q,op,nom,prenom,da));
			 
	  }

}
