package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Modele.Commande;
import app.Repository.CommandRepository;

@Service
public class CommandeService 
{
	@Autowired
	CommandRepository commanderepository;
	
	
	public void AddCommande(Commande c,String date)
	{
		c.setDatee(date);
		commanderepository.insert(c);
	}
	
	public void deleteCommande(Commande c)
    {
		commanderepository.delete(c);
	}
	
	public void UpdateCommande(Commande c,String op)
	{
		c.setOperateure(op);
		commanderepository.save(c);
		
	}
	
	public List<Commande> findAllCommand()
	{
		
		return commanderepository.findAll();
	}
	
	public Commande FindCommande(String id)
	{
		
		return(commanderepository.findById(id).get());
	}
	
	public List<Commande> FindAllCommandessg(String Idsgrossiste,String payer)
	{
		return(commanderepository.findcommandesg(Idsgrossiste,payer));
	}
	
	public List<Commande> FindAllCommandeg(String Idsgrossiste,String payer)
	{
		return(commanderepository.findcommandeg(Idsgrossiste,payer));
	}
	
	public void Delete(String id)
	{
		Commande commande=commanderepository.findById(id).get();
		deleteCommande(commande);
		
	}
	
	public List<Commande> FindCommandeByPayer(String payer)
	{
		return (commanderepository.findBypayer(payer));
	}
	public List<Commande> Find(String payer,String id)
	{
		return (commanderepository.findcommandeg(id, payer));
	}
	
	public void deletecommande(Commande comm)
	{
		commanderepository.delete(comm);
		
	}
	
	public void updatecommande(Commande c)
	{
		commanderepository.save(c);
	}
	
	
	
	
	

}
