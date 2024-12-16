package app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import app.Modele.Admin;



@Repository
public interface AdminRepository extends MongoRepository<Admin,String> 
{
     	
	@Query("{ 'Username' : ?0, 'Password' : ?1}")
    public Admin findAdmin(String Username, String Password);
	
	Admin findByUsername(String username);
	

}
