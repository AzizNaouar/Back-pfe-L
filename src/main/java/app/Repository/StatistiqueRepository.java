package app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import app.Modele.*;

@Repository
public interface StatistiqueRepository  extends MongoRepository<Statistique,String> 
{
   Statistique findByiduser(String iduser);
}
