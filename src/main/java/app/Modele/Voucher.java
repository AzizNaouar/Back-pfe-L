package app.Modele;

public class Voucher
{
	
		@Override
	public String toString() {
		return "Voucher [code=" + code + ", serialnum=" + serialnum + ", montant=" + montant + ", validity=" + validity
				+ "]";
	}

		private String code;
		private String serialnum;
		private String  montant;
		private String validity;
	    
	    public Voucher(String code, String serialnum, String montant,String validity) 
		{
	    	
			this.code = code;
			this.serialnum = serialnum;
			this.montant = montant;
			this.validity=validity;
			
		}
		
		public Voucher()
		{
			
		}
		
		public String getCode() 
		{
			return code;
		}

		public void setCode(String code) 
		{
			this.code = code;
		}

		public String getSerialnum() 
		{
			return serialnum;
		}

		public void setSerialnum(String serialnum) 
		{
			this.serialnum = serialnum;
		}

		public String getMontant() 
		{
			return montant;
		}

		public void setMontant(String montant) 
		{
			this.montant = montant;
		}

		public String getValidity() 
		{
			return validity;
		}

		public void setValidity(String validity) 
		{
			this.validity = validity;
		}

	
		
	}

