package app.Repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.Modele.*;

@Repository
public interface ChiffreAfaireRepository  extends MongoRepository<ChiffreAffaire,String> 
{
	ChiffreAffaire findByid(String id);
	
	List<ChiffreAffaire> findBytype(String type);
}
