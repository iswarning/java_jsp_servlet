package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	private final String serverName = "localhost";
	private final String dbName = "mylaravel";
	private final String portNumber = "3306";
	private final String username = "vinh";
	private final String password = "123456";

	public Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://" + serverName + ": "+ portNumber +"/" + dbName;
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void main() throws Exception {
		
		Connection conn = new DBContext().getConnection();
		System.out.println(conn);
	}
	
}
