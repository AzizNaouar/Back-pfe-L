package app.Modele;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="VoucherOrange")
public class VoucherOrange extends Voucher
{
	
	    @Id
		private String id;
		private ArrayList<Voucher> vouchers1orange;
		private ArrayList<Voucher> vouchers5orange;
		private ArrayList<Voucher> vouchers10orange;
		
		
	 public VoucherOrange(String code, String serialnum, String montant,String validity) 
		{
			super(code,serialnum,montant,validity);
		}
	
	
		
		public VoucherOrange (String id, ArrayList<Voucher> listvoucher) 
		{
			this.id=id;
			if(listvoucher.get(0).getMontant().equals("1000"))
			{
				this.vouchers1orange= listvoucher;
			}
			if(listvoucher.get(0).getMontant().equals("5000"))
			{
				this.vouchers5orange = listvoucher;
			}
			if(listvoucher.get(0).getMontant().equals("10000"))
			{
				this.vouchers10orange = listvoucher;
			}
				
		}
		
		public VoucherOrange()
		{
			
		}
		
	    public ArrayList<Voucher> getVouchers1orange() 
	    {
				return vouchers1orange;
		}



	     public void setVouchers1orange(ArrayList<Voucher> vouchers1orange) 
		{
		     this.vouchers1orange = vouchers1orange;
	    }



		public ArrayList<Voucher> getVouchers5orange() 
		{
				return vouchers5orange;
		}



		public void setVouchers5orange(ArrayList<Voucher> vouchers5orange) 
		{
				this.vouchers5orange = vouchers5orange;
		}



		public ArrayList<Voucher> getVouchers10orange()
		{
				return vouchers10orange;
		}



		public void setVouchers10orange(ArrayList<Voucher> vouchers10orange) 
		{
				this.vouchers10orange = vouchers10orange;
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
