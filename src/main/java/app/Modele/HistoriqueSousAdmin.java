package app.Modele;

import java.time.Instant;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document
public class HistoriqueSousAdmin {
	 
	@Field
	@Indexed(name ="CreatedAt2",expireAfterSeconds=50)
	LocalDate CreatedAt2;
	
	
	private Instant createdAt2;
	private String idSousAdmin;
	private String montant;
	private String nombre;
	private String type;
	private String nomGrossiste;
	private String prenomGrossiste;
	private String date;
	
	
	public String getNomGrossiste() {
		return nomGrossiste;
	}

	public void setNomGrossiste(String nomGrossiste) {
		this.nomGrossiste = nomGrossiste;
	}

	public String getPrenomGrossiste() {
		return prenomGrossiste;
	}

	public void setPrenomGrossiste(String prenomGrossiste) {
		this.prenomGrossiste = prenomGrossiste;
	}







	
	
	public String getIdSousAdmin() {
		return idSousAdmin;
	}

	public void setIdSousAdmin(String idSousAdmin) {
		this.idSousAdmin = idSousAdmin;
	}

	







	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}







	
	
	public HistoriqueSousAdmin(Instant createdAt2,String idSousAdmin, String montant,String nombre,String type, String nomGrossiste,String prenomGrossiste, String date) {
		
		this.idSousAdmin=idSousAdmin;
		this.createdAt2 = createdAt2;
		this.montant = montant;
		this.nombre=nombre;
		this.type=type;
		this.nomGrossiste = nomGrossiste;
		this.prenomGrossiste=prenomGrossiste;
		this.date = date;
	}







	
	
	public Instant getCreatedAt2() {
		return createdAt2;
	}



	public void setCreatedAt2(Instant createdAt2) {
		this.createdAt2 = createdAt2;
	}



	public String getMontant() {
		return montant;
	}



	public void setMontant(String montant) {
		this.montant = montant;
	}



	



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	
	
	
	
	public HistoriqueSousAdmin() {}
	
	
	
	
	
	

}