package exam08;

import java.sql.Connection;
import java.sql.SQLException;

public class CountConn  implements ConnectionMaker{

	private ConnectionMaker scm ;

	int count = 0;
	
	public CountConn(ConnectionMaker scm) {
		this.scm = scm;
	}

	

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		count++;
		return scm.makeConnection();
	}
	

	public void showCount(){
		System.out.println(count);
		
	}

}
