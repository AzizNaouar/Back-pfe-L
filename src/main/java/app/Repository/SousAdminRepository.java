package app.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import app.Modele.SousAdmin;


@Repository
public interface SousAdminRepository extends MongoRepository<SousAdmin,String> 
{
	SousAdmin findByUsername(String username);
	
	@Query("{ 'Username' : ?0, 'Password' : ?1}")
    public SousAdmin findSousAdmin(String Username, String Password);
	
	@Query("{'IdAdmin' : ?0}")
	public List<SousAdmin> findunder(String IdAdmin);
}

