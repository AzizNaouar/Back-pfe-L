package app.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import app.Modele.VoucherOoredoo;


@Repository
public interface VoucherOoredooRepository extends MongoRepository<VoucherOoredoo,String> 
{
	
	//@Query(value="{'id':?0}" , fields="{'vouchers1ooredoo':1,'id':0}")
	@Query("{'id':?0}")
	public VoucherOoredoo findList1(String id);
	
	//@Query(value="{'id':?0}" , fields="{'vouchers5ooredoo':1,'id':0}")
	@Query("{'id':?0}")
	public VoucherOoredoo findListe5(String id);
	
	//@Query(value="{'id':?0}" , fields="{'vouchers10ooredoo':1,'id':0}")
	@Query("{'id':?0}")
	public VoucherOoredoo findListe10(String id);
}
