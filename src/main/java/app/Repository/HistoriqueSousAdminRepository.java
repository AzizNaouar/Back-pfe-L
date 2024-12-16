package app.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import app.Modele.HistoriqueSousAdmin;

public interface HistoriqueSousAdminRepository extends MongoRepository<HistoriqueSousAdmin,String> {
	
	@Query("{'idSousAdmin' : ?0}")
	public List<HistoriqueSousAdmin> findHistoriqueSousAdmin(String idSousAdmin);

}
