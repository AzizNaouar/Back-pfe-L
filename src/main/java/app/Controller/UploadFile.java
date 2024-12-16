package app.Controller;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.Modele.Response;
import app.Modele.Voucher;
import app.Modele.VoucherOoredoo;
import app.Modele.VoucherOrange;
import app.Modele.VoucherTélécome;
import app.Repository.VoucherOoredooRepository;
import app.Service.CripterVoucher;
import app.Service.VoucherOoredooService;
import app.Service.VoucherOrangeService;
import app.Service.VoucherTélécomeService;

@CrossOrigin
@RestController
public class UploadFile 
{
	
     @Autowired
     VoucherTélécomeService  télécomeservice;
     @Autowired
     VoucherOoredooService ooredooservice;
     @Autowired
     VoucherOrangeService orangeservice;
     @Autowired
     CripterVoucher cripter;
     int i;
     String type=null;
     ArrayList<Voucher> vouchers=new ArrayList<Voucher>();
     String montant;
     Response response;
     @Autowired
     VoucherOoredooRepository rep;
     String master = "local[*]";
     SparkConf conf = new SparkConf().setAppName("voucher").setMaster(master);
     JavaSparkContext sc = new JavaSparkContext(conf);   
     
	//@PostMapping("/upload/{id}/{type}")
	public Response uploadData(@RequestParam("file") MultipartFile file , @PathVariable String id, @PathVariable String type) throws Exception 
	{
		
		 i=0;
		 vouchers.clear();
		
			 
		if (file == null) 
		{
			throw new RuntimeException("You must select the a file for uploading");
		}
		
		else
		{
			 
			  System.out.println(file.getSize());
			        this.type=type;
			       long time=System.nanoTime();
			        try (InputStream fis = file.getInputStream();
		                InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
		                BufferedReader br = new BufferedReader(isr)) 
			          {
				                 
				          br.lines().forEach(line -> {
				    	  if(line.length()>0) 
				    	  {
				    		 split(line,i);i++;
			               }
				    	  });
				        response=AddVoucher(id);
				    
				      }
			        long time2=System.nanoTime();
			        float res=(time2-time)/1000000000;
			        System.out.println(res);
			        
		}
		
		if(response!=null)
		{
		System.out.println(response.getResponse());
		}
		
		return response;
		
}
      
	
	
	
	//Add the voucher in a array
	public void split(String ligne,int j)
	
	{
		Voucher voucher = null;
		
		if(j>0)
		{		
			String[] List=ligne.split(",");
			if(this.type.equals("Ooredoo"))
			{
				
				 voucher= new VoucherOoredoo(cripter.encrypt(List[0]),List[1],List[2],List[3]);
			}
			if(this.type.equals("Tunisie Telecom"))
			{
				voucher= new VoucherTélécome(cripter.encrypt(List[0]),List[1],List[2],List[3]);
			}
			if(this.type.equals("Orange"))
			{
                voucher= new VoucherOrange(cripter.encrypt(List[0]),List[1],List[2],List[3]);
			}
			vouchers.add(voucher);
	    }
	}
	
	
	//Add the the array of voucher in a db
	public Response AddVoucher(String id)
	{ 
		
		if(vouchers.size()>0)
		{ 

		 if(vouchers.get(0).getMontant().equals("1000"))
		 {
			 this.montant="1000";
	     }
		 if(vouchers.get(0).getMontant().equals("5000"))
		 {
			 this.montant="5000";
		 }
		 if(vouchers.get(0).getMontant().equals("10000"))
		 {
			 this.montant="10000";
		 }
	
		 
	    if(this.type.equals("Ooredoo"))
		{
		
		 if(this.montant=="1000")
		 {	 
	
             VoucherOoredoo voucherr=new VoucherOoredoo(id,vouchers);
		     response=ooredooservice.AddVoucher(voucherr,this.montant);
	     }
		 if(this.montant=="5000")
		 {
			 VoucherOoredoo voucherr=new VoucherOoredoo(id,vouchers);
			 response=ooredooservice.AddVoucher(voucherr,this.montant);
		 }
		 if(this.montant=="10000")
		 {
			 VoucherOoredoo voucherr=new VoucherOoredoo(id,vouchers);
			 response=ooredooservice.AddVoucher(voucherr,this.montant);
		 }
		    
		 }
	 
		if(this.type.equals("Tunisie Telecom"))
		{
			if(this.montant=="1000")
			 {
				VoucherTélécome voucherr=new VoucherTélécome(id,vouchers);
			    response=télécomeservice.AddVoucher(voucherr,this.montant);
			 }
			
			 if(this.montant=="5000")
			 {
				    VoucherTélécome voucherr=new VoucherTélécome(id,vouchers);
				    response=télécomeservice.AddVoucher(voucherr,this.montant);
			 }
			 
			 if(this.montant=="10000")
			 {
				 VoucherTélécome voucherr=new VoucherTélécome(id,vouchers);
				 response=télécomeservice.AddVoucher(voucherr,this.montant);
		     }
			 
		 }
		
		if(this.type.equals("Orange"))
		{
			if(this.montant=="1000")
			 {
				VoucherOrange voucherr=new VoucherOrange(id,vouchers);
				response=orangeservice.AddVoucher(voucherr,this.montant);	
		     }
			 if(this.montant=="5000")
			 {
				 VoucherOrange voucherr=new VoucherOrange(id,vouchers);
				 response=orangeservice.AddVoucher(voucherr,this.montant);	
			 }
			 if(this.montant=="10000")
			 {
				 System.out.println(vouchers.size()+"the size est ");
			     VoucherOrange voucherr=new VoucherOrange(id,vouchers);
				 response=orangeservice.AddVoucher(voucherr,this.montant);
			 }
			
		}
	}
		
		return response;
	
	}
	
	
	
	
	
	
	//big data
	private void readFile(List<String> liste,String type) 
    {
		
   	 Voucher voucher=null;
     
   	 if(type.equals("Ooredoo"))
   	  {
   		 if(liste.size()>0)
   	     {
   	      for(int i=1;i<liste.size();i++)
   	      {
   		    if(liste.get(i).length()>0)
   		    {
   		    	
   		      // String line=liste.get(i);
   		      // splite= sc.textFile(line.
   	
   		    String[] headers = liste.get(i).split(",");
   		    System.out.println(headers[0]);
   		    voucher= new VoucherOoredoo(cripter.encrypt(headers[0]),headers[1],headers[2],headers[3]);
	        vouchers.add(voucher);
   	        }
   		  }
   	    }
   	 }
     
  
   	if(type.equals("Tunisie Telecom"))
 	  {
   		 if(liste.size()>0)
   	     {
   	      for(int i=1;i<liste.size();i++)
   	      {
   		    if(liste.get(i).length()>0)
   		    {
   		    	
   		    String[] headers = liste.get(i).split(",");
   		    voucher= new VoucherTélécome(cripter.encrypt(headers[0]),headers[1],headers[2],headers[3]);
	        vouchers.add(voucher);
   	        }
   		  }
   	    }
    }
   	
   	
	if(type.equals("Orange"))
	  {
   		 if(liste.size()>0)
   	     {
   	      for(int i=1;i<liste.size();i++)
   	      {
   		    if(liste.get(i).length()>0)
   		    {
   		    	
   		    String[] headers = liste.get(i).split(",");
   		    voucher= new VoucherOrange(cripter.encrypt(headers[0]),headers[1],headers[2],headers[3]);
	        vouchers.add(voucher);
   	        }
   		  }
   	    }
     }
		
	}
	
	
	
	
	@PostMapping("/upload/{id}/{type}")
	public Response upload(@RequestParam("file") MultipartFile file , @PathVariable String id, @PathVariable String type) throws Exception 
	{
		  this.type=type;
		  vouchers.clear();
		  
		  if (file == null) 
			{
				throw new RuntimeException("You must select the a file for uploading");
			}
			
			else
			{
				
		     byte[] bytes = file.getBytes();
		     try (FileOutputStream stream = new FileOutputStream("src/new.txt")) 
		     {
		       stream.write(bytes);
		     }
		     
             JavaRDD<String> counts = sc.textFile("src/new.txt");
             List<String> liste=counts.collect();
             this.readFile(liste,type);
 		     response=this.AddVoucher(id);
 		  
			} 
		 
		 return(response);
		
   }
	
	

	
	
	
	
	
	
}