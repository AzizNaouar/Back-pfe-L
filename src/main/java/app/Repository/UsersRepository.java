package app.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import app.Modele.Users;

public interface UsersRepository extends MongoRepository<Users,String> 
{
	Users findByUsername(String username);
	
	@Query("{ 'Username' : ?0, 'Password' : ?1}")
    public Users findUser(String Username, String Password);
}
