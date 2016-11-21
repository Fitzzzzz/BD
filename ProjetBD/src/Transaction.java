import java.sql.*;
public class Transaction {
	private Connection conn;

	public Transaction(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public void begin() throws SQLException{
		Statement stmt = conn.createStatement();
		String query = "begin";
		stmt.executeQuery(query);
	}
	
	public void commit() throws SQLException{
		String query = "commit";
		Statement stmt = this.conn.createStatement();
		stmt.executeQuery(query);
	}
}
