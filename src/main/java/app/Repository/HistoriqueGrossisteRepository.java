package app.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import app.Modele.HistoriqueGrossiste;

public interface HistoriqueGrossisteRepository extends MongoRepository<HistoriqueGrossiste,String> {
	
	@Query("{'idGrossiste' : ?0}")
	public List<HistoriqueGrossiste> findHistoriqueGrossiste(String idGrossiste);
	
	

}
