/**
 * Test of the database
 */

import java.sql.*;

public class TestBD {

	public static void main(String[] args) throws SQLException {
		Utilitaires.createRegister();
		Connection conn = Utilitaires.openConnection();
		Initialisation.initBase(conn);
		conn.close();

	}
}
