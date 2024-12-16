package app.Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class ServiceSms 
{
	public String GetToken()
	{
		String token="";
		
		Unirest.setTimeouts(0, 0);
		try {
			com.mashape.unirest.http.HttpResponse<String> response =  Unirest.post("https://api.orange.com/oauth/v3/token")
			  .header("Content-Type", "application/x-www-form-urlencoded")
			  .header("Authorization", "Basic R1dOQ3QwMUcwRWN2eVJWazcyRVhqQXZjcENkSWhNRko6eTMxUDdKRXF2SHZLalpoQw==s")
			  .field("grant_type", "client_credentials")
			  .asString();
			JSONObject myObject = new JSONObject(response.getBody());
			
			token=myObject.get("access_token").toString();
			
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
		

	}
	
	 
	public void sendsms(String numero,String msg)
	{
		 String token=GetToken();
		Unirest.setTimeouts(0, 0);
		try {
			com.mashape.unirest.http.HttpResponse<String> response = Unirest.post("https://api.orange.com/smsmessaging/v1/outbound/tel%3A%2B21652206402/requests")
			  .header("Content-Type", "application/json")
			  .header("Authorization", "Bearer "+token)
			  .body("{\n\t\"outboundSMSMessageRequest\": {\n\t\t\"address\": \"tel:+216"+numero+"\",\n\t\t\"senderAddress\":\"tel:+21652206402\",\n\t\t\"outboundSMSTextMessage\": {\n\t\t\t\"message\": \""+msg+"  \"\n\t\t}\n\t}\n} ")
			  .asString();
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
