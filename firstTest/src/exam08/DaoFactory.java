package exam08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
		 System.out.println("userDAo");
		return new UserDao(countConnection());
	}
	
	@Bean
	public CountConn countConnection(){
		System.out.println("CountConn");
		
		return new CountConn(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		System.out.println("ConnectionMaker");
		
		return new AConnectionMaker();
	}

}
