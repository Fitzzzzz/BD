import java.sql.*;
public class Utilitaires {

	public static void createRegister() {
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver ());
		}
		catch (SQLException e) {
			e.printStackTrace ();
		}
	}

	public static Connection openConnection () {
		try
		{

			Connection  connection = DriverManager.getConnection(url , user , passwd );
			return connection;
		}
		catch (SQLException f) {
			f.printStackTrace ();
			return null;
		}
		
	}
	
	
}


