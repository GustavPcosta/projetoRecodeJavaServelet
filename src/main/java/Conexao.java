

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class Conexao {

		private static final String JDBC_URL = "jdbc:mysql://localhost:3306/viagens";
	    private static final String JDBC_USER = "root";
	    private static final String JDBC_PASSWORD = "88274297A";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	    }
	}


