package app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import app.Modele.VoucherTélécome;

public interface VoucherTélécomeRepository extends MongoRepository<VoucherTélécome,String> 
{

	@Query("{'id':?0}")
	public VoucherTélécome findList1(String id);
	
	
	@Query("{'id':?0}")
	public VoucherTélécome findListe5(String id);
	
	
	@Query("{'id':?0}")
	public VoucherTélécome findListe10(String id);
}
