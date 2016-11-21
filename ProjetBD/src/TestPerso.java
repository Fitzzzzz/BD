import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPerso {

	public static void main(String[] args) throws SQLException {
		Utilitaires.createRegister();
		Connection conn = Utilitaires.openConnection();
		Statement sttable = conn.createStatement();
		String query = "SELECT * FROM Locations";
		ResultSet rs = sttable.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
		conn.close();		
	}

}
