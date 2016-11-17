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
			String  url = "jdbc:oracle:thin:@ensioracle1.imag.fr:" + "1521: ensioracle1";
			String  user = "bagouc";
			String  passwd = "bagouc";
			Connection  connection = DriverManager.getConnection(url , user , passwd );
			return connection;
		}
		catch (SQLException f) {
			f.printStackTrace ();
			return null;
		}
		
	}
	
	
}


