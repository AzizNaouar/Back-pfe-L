package app.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.Modele.Users;
import app.Repository.UsersRepository;

@Service
public class UsersService 
{
	@Autowired
	UsersRepository userrepository;
	
	Users user;
	
	
	
    public void Insert(Users user)
    {
    	userrepository.insert(user);
    }
   
    public void Save(Users user)
    {
    	userrepository.save(user);
    }
    
    
    public Users FindUser(String username,String password)
    {
    	return (userrepository.findUser(username, password));
    }
    
   //false(userexiste )
    public Boolean FindUserByUserName(String username)
    {
    	Users user=userrepository.findByUsername(username);
    	if(user==null)
    		return true;
    	else
    		return false;
    }
    
   
    public List<Users> FindAll()
    {
    	return(userrepository.findAll());
    }
    
  
    public Users FindById(String Id)
    {
    	Users user1=null;
    	if(Exist(Id))
    	 {
    	   user1=userrepository.findById(Id).get();
         }
    	return user1;
    }
    public void Delete(Users user)
    {
    	if(Exist(user.getId()))
    	{
           userrepository.delete(user);
        }
    }
    
    public void DeleteById(String id)
    {
    	if(Exist(id))
    	{
    		userrepository.deleteById(id);
        }
    	
    }
    
   public void UpdateData( String id,String username)
   {
	   if(Exist(id))
	   {
	     Users UserInitiale=FindById(id);
	     UserInitiale.setUsername(user.getUsername());
	     Save(UserInitiale);
	   }
   }
   
   
   public void Update(Users user)
   {
	    Save(user);
   }
   
   public Boolean Exist(String id)
   {
	   return(userrepository.existsById(id));
   }
   
   public String ForgetPassword()
   {
	   
   Random rand = new Random();
   String password="";
   for(int i=0;i<15;i++)
   {
	  char c = (char)(rand.nextInt(26) + 97);
      password=password+c;
   }
   
   return password;
   
   }
   
   
   public Users FindUser(String mail)
   {
	   return(userrepository.findByUsername(mail));
   }
   
   
   public void UpdatePassword(String password,String username)
   {
	   
	   user=userrepository.findByUsername(username);
	   user.setPassword(password);
	   userrepository.save(user);
   }
   
 
   
   
}
