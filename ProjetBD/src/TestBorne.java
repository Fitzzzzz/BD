import java.sql.Connection;
import java.sql.SQLException;

public class TestBorne {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Utilitaires.createRegister();
		Connection conn = Utilitaires.openConnection();
		Requetes req = new Requetes(conn);
		
		Borne borneDeTest = new Borne("Carotte", req);
		borneDeTest.welcome();
		
		conn.close();
	}

}
