package app.Modele;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document
public class HistoriqueGrossiste {
	 
	@Field
	@Indexed(name ="CreatedAt1",expireAfterSeconds=50)
	LocalDate CreatedAt1;
	

	
	
	private Instant createdAt1;
	private String idGrossiste;
	private String montant;
	private String codeVoucher;
	private String type;
	private String numero;
	private String date;
	
	public String getIdGrossiste() {
		return idGrossiste;
	}

	public void setIdGrossiste(String idGrosssiste) {
		this.idGrossiste = idGrosssiste;
	}

	


	
	
	public String getCodeVoucher() {
		return codeVoucher;
	}

	public void setCodeVoucher(String codeVoucher) {
		this.codeVoucher = codeVoucher;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public Instant getCreatedAt1() {
		return createdAt1;
	}

	public void setCreatedAt1(Instant createdAt1) {
		this.createdAt1 = createdAt1;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public HistoriqueGrossiste( Instant createdAt1,String idGrossiste, String montant,String codeVoucher,String type, String numero,String date) 
	{
		this.createdAt1 = createdAt1;
		this.idGrossiste=idGrossiste;
		this.montant = montant;
		this.codeVoucher=codeVoucher;
		this.type=type;
		this.numero = numero;
		this.date=date;
	}

	
	public HistoriqueGrossiste() {
		
	}

}

