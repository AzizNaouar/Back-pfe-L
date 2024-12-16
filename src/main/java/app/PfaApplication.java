package app;

import org.springframework.beans.factory.InitializingBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PfaApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(PfaApplication.class, args);
	}
	
	//configuration pour supprimier le champ _class dans mongodb
	@Configuration
	public class MongoDBConfig implements InitializingBean {

	    @Autowired
	    @Lazy
	    private MappingMongoConverter mappingMongoConverter;

	    @Override
	    public void afterPropertiesSet() throws Exception {
	        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
	    }
	}

}
