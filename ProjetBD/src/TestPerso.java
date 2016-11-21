import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPerso {

	public static void main(String[] args) throws SQLException {
		Utilitaires.createRegister();
		Connection conn = Utilitaires.openConnection();
		Requetes req = new Requetes(conn);
		
		req.printTable("Forfaits");
		req.printTable("Forfait1");
		req.printTable("Forfait2");
		req.printTable("EstDans");
		req.printTable("Abonnes");
		//req.printTable("CategoriesVehicules");
		req.printTable("Vehicules");
		req.printTable("Locations");
		
		conn.close();		
	}

}
