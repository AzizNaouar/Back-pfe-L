package app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import app.Modele.VoucherOrange;

public interface VoucherOrangeRepository extends MongoRepository<VoucherOrange,String> 
{

	@Query("{'id':?0}")
	public VoucherOrange findList1(String id);
	
	
	@Query("{'id':?0}")
	public VoucherOrange findListe5(String id);
	
	
	@Query("{'id':?0}")
	public VoucherOrange findListe10(String id);
}
