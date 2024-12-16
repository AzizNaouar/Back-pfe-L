package app.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.Modele.Notif;

@Repository
public interface NotifRepository extends MongoRepository<Notif,String> 
{
	
	
	@Query("{'IdUtili' : ?0}")
	public List<Notif> findNotif(String IdUtili);
	
	public Notif findByidcommande(String idcommande);
}