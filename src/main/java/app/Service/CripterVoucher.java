package app.Service;

import org.springframework.stereotype.Service;

@Service
public class CripterVoucher 
{
	
	public String encrypt(String code)
	{
		
		char[] chars=code.toCharArray();
		String enc="";
		String enc2="";
		for(char c:chars)
		{
			c +=5;
			enc+=c;
		}
		char[] char2=enc.toCharArray();
		
		for(char c:char2)
		{
			c +=12;
			enc2+=c;
		}
		enc+=enc2;
		
		return enc;
	}
	
	
	public String decrypt(String code)
	{
		
		char[] chars=code.toCharArray();
		String enc="";
		for(int i=0;i<((chars.length)/2);i++)
		{
			chars[i] -=5;
			enc+=chars[i];
			
			
		}
		return enc;
	}

}
