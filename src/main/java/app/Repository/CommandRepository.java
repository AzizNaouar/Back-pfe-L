package app.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.Modele.Commande;

@Repository
public interface CommandRepository extends MongoRepository<Commande,String> 
{
	
   public List<Commande> findByidsgrossiste(String idsgrossiste);
   
   public List<Commande> findBypayer(String payer);
   
   @Query("{ 'idsgrossiste' : ?0, 'payer' : ?1}")
   public List<Commande> findcommandesg(String id,String payer);
   
   @Query("{ 'idgrossiste' : ?0, 'payer' : ?1}")
   public List<Commande> findcommandeg(String id,String payer);
   
}