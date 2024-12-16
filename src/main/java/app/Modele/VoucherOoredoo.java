package app.Modele;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="VoucherOoredoo")
public class VoucherOoredoo extends Voucher 
{
	
	@Id
	private String id;
	private ArrayList<Voucher> vouchers1ooredoo;
	private ArrayList<Voucher> vouchers5ooredoo;
	private ArrayList<Voucher> vouchers10ooredoo;
	

	public VoucherOoredoo(String code, String serialnum, String montant,String validity) 
	{
			super(code,serialnum,montant,validity);
	}

	public VoucherOoredoo(String id,ArrayList<Voucher> vouchersooredoo) 
	{
		
		this.id=id;
		if(vouchersooredoo.get(0).getMontant().equals("1000"))
		{
			this.vouchers1ooredoo = vouchersooredoo;
		}
		if(vouchersooredoo.get(0).getMontant().equals("5000"))
		{
			this.vouchers5ooredoo = vouchersooredoo;
		}
		if(vouchersooredoo.get(0).getMontant().equals("10000"))
		{
			this.vouchers10ooredoo = vouchersooredoo;
		}
			
		
	}
	
	public VoucherOoredoo() 
	{
		
	}
	
	public ArrayList<Voucher> getVouchers1ooredoo() 
	{
		return vouchers1ooredoo;
	}

	public void setVouchers1ooredoo(ArrayList<Voucher> vouchers1ooredoo) 
	{
		this.vouchers1ooredoo = vouchers1ooredoo;
	}

	public ArrayList<Voucher> getVouchers5ooredoo() 
	{
		return vouchers5ooredoo;
	}

	public void setVouchers5ooredoo(ArrayList<Voucher> vouchers5ooredoo) 
	{
		this.vouchers5ooredoo = vouchers5ooredoo;
	}

	public ArrayList<Voucher> getVouchers10ooredoo() 
	{
		return vouchers10ooredoo;
	}

	public void setVouchers10ooredoo(ArrayList<Voucher> vouchers10ooredoo) 
	{
		this.vouchers10ooredoo = vouchers10ooredoo;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}
	

}
