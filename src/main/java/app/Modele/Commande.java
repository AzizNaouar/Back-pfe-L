package app.Modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="commande")
public class Commande 
{
	
	@Id
	private String id;
	private String operateure;
	private String prix;
	private String quantite;
	private String idgrossiste;
	private String idsgrossiste;
	private String datee;
	private String montant;
	private String payer;
	private String nomgrossiste;
	
	public Commande(String id, String operateure, String prix, String quantite, String idgrossiste,
			String idsgrossiste, String datee,String montant,String payer,String nomgrossiste ) {
		super();
		this.id = id;
		this.operateure = operateure;
		this.prix = prix;
		this.quantite = quantite;
		this.idgrossiste = idgrossiste;
		this.idsgrossiste = idsgrossiste;
		this.datee = datee;
		this.montant=montant;
		this.payer=payer;
		this.nomgrossiste=nomgrossiste;
	}
	


	public Commande()
	{
		
	}
	
	public String getNomgrossiste() 
	{
		return nomgrossiste;
	}

	public void setNomgrossiste(String nomgrossiste) 
	{
		this.nomgrossiste = nomgrossiste;
	}

	public String getMontant() 
	{
		return montant;
	}

	public void setMontant(String montant) 
	{
		this.montant = montant;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperateure() {
		return operateure;
	}

	public void setOperateure(String operateure) {
		this.operateure = operateure;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getQuantite() {
		return quantite;
	}




	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}




	public String getDatee() {
		return datee;
	}




	public void setDatee(String datee) {
		this.datee = datee;
	}

	
	public String getIdgrossiste() {
		return idgrossiste;
	}





	public void setIdgrossiste(String idgrossiste) {
		this.idgrossiste = idgrossiste;
	}





	public String getIdsgrossiste() {
		return idsgrossiste;
	}





	public void setIdsgrossiste(String idsgrossiste) {
		this.idsgrossiste = idsgrossiste;
	}
	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}


	


	

	

}
