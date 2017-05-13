package exam08;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AConnectionMaker implements ConnectionMaker{
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		final String DB_USER = "lsh";
		final String DB_PASSWORD = "lsh";

	Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;	
	}

}
