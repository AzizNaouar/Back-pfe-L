package app.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import app.Modele.Grossiste;

@Repository
public interface GrossisteRepository extends MongoRepository<Grossiste,String> 
{
	
	Grossiste findByUsername(String username);
	
	@Query("{ 'Username' : ?0, 'Password' : ?1}")
    public Grossiste findGrossiste(String Username, String Password);
	
	@Query("{'IdUser' : ?0}")
	public List<Grossiste> findGunder(String IdUser);
}