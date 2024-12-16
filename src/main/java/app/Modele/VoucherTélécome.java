package app.Modele;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="VoucherTélécome")
public class VoucherTélécome extends Voucher
{

    @Id
	private String id;
	private ArrayList<Voucher> vouchers1telecome;
	private ArrayList<Voucher> vouchers5telecome;
	private ArrayList<Voucher> vouchers10telecome;
	
	
    public VoucherTélécome(String code, String serialnum, String montant,String validity) 
	{
		super(code,serialnum,montant,validity);
	}
	
	public VoucherTélécome (String id, ArrayList<Voucher> listvoucher) 
	{

		this.id=id;
		if(listvoucher.get(0).getMontant().equals("1000"))
		{
			this.vouchers1telecome = listvoucher;
		}
		if(listvoucher.get(0).getMontant().equals("5000"))
		{
			this.vouchers5telecome = listvoucher;
		}
		if(listvoucher.get(0).getMontant().equals("10000"))
		{
			this.vouchers10telecome = listvoucher;
		}
	}
	
	public VoucherTélécome()
	{
		
	}
	
	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}
	
    public ArrayList<Voucher> getVouchers1telecome()
    {
		return vouchers1telecome;
	}

	public void setVouchers1telecome(ArrayList<Voucher> vouchers1telecome) 
	{
		this.vouchers1telecome = vouchers1telecome;
	}

	public ArrayList<Voucher> getVouchers5telecome() 
	{
		return vouchers5telecome;
	}

	public void setVouchers5telecome(ArrayList<Voucher> vouchers5telecome) 
	{
		this.vouchers5telecome = vouchers5telecome;
	}

	public ArrayList<Voucher> getVouchers10telecome() 
	{
		return vouchers10telecome;
	}

	public void setVouchers10telecome(ArrayList<Voucher> vouchers10telecome) 
	{
		this.vouchers10telecome = vouchers10telecome;
	}



}
