package app.Modele;

import java.util.ArrayList;

public class ReponseImprimier 
{
	
	private String response;
	private ArrayList<Voucher> listevoucher;
	
	public ReponseImprimier(String response, ArrayList<Voucher> listevoucher) 
	{
		
		this.response = response;
		this.listevoucher = listevoucher;
	}
	
	
	
	public String getResponse() 
	{
		return response;
	}
	public void setResponse(String response) 
	{
		this.response = response;
	}
	public ArrayList<Voucher> getListevoucher() 
	{
		return listevoucher;
	}
	public void setListevoucher(ArrayList<Voucher> listevoucher) 
	{
		this.listevoucher = listevoucher;
	}
}
