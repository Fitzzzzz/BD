import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Requetes {

	// CREATE TABLES
	
	/**
	 * Create Table Categories
	 * @param conn : connection used
	 */
	public static void createTableCategories (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Categories (CategorieVehicule varchar(20) primary key,"
						+ " DureeMax int constraint dureePos check (DureeMax >= 0),"
						+ "PrixHoraire int constraint prixPos check (PrixHoraire >= 0),"
						+ "MontantCaution int constraint CautionPos check (MontantCaution >= 0))"
				);
		sttable.close();
	}
	
	/**
	 * Create Table Stations
	 * @param conn : connection used
	 */
	public static void createTableStations(Connection conn) throws SQLException{
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Stations (NomStation varchar(20) primary key,"
				+ "AdresseStation varchar(40))"
				);
		sttable.close();
	}

	/**
	 * Create Table Vehicules
	 * @param conn : connection used
	 */
	public static void createTableVehicules (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"CREATE TABLE VEHICULES (IdVehicule int CONSTRAINT IdPos CHECK (IdVehicule >= 0),"
						+ "NbPlaces int CONSTRAINT PlacesPos CHECK (NbPlaces >= 0), "
						+ "CategorieVehicule varchar(20), "
						+ "CONSTRAINT CatVehicule FOREIGN KEY (CategorieVehicule) REFERENCES CATEGORIES(CategorieVehicule),"
						+ "PRIMARY KEY (IdVehicule))" 
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table Abonnes
	 * @param conn : connection used
	 */
	public static void createTableAbonnes(Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("create table abonnees (NumCarteBancaire  int CONSTRAINT CBPos CHECK (NumCarteBancaire > 0),"
				+ "NomAbonne VARCHAR(20),"
				+ "PrenomAbonne VARCHAR(20), "
				+ "DateNaissance DATE,"
				+ "AdresseAbonne VARCHAR(100), "
				+ "primary key (NumCarteBancaire))"
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table Locations
	 * @param conn : connection used
	 */
	public static void createTableLocations (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Locations ( NumLoc int constraint numLocPos check (NumLoc >= 0),"
						+ "DateLocation date,"
						+ "heureDebut int,"
						+ "heureFin int,"
						+ "IdVehicule  int,"
						+ "numCarteBancaire int,"
						+ "nomStationDepart varchar(20),"
						+ "nomStationArrivee varchar(20),"
						+ "primary key (NumLoc),"
						+ "constraint IdVehiculeForeign foreign key (IdVehicule) references Vehicules(IdVehicule),"
						+ "constraint NumCarteBancaireForeign foreign key (numCarteBancaire) references Abonne(NumCarteBancaire)"
						+ "constraint NomStationDepartForeign foreign key (NomStation) references Stations(NomStation),"
						+ "constraint NomStationArriveeForeign foreign key (NomStation) references Stations(NomStation)"
						+ ")"
				);
		sttable.close();
	}

	
	/**
	 * Create Table Forfaits
	 * @param conn : connection used
	 */
	public static void createTableForfaits(Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"IdForfait INT CONSTRAINT ForfaitPos CHECK (IdForfait >= 0),"
				+ "TypeForfait INT CONSTRAINT TypsPos CHECK ((TypeForfait = 1) OR (TypeForfait = 2)),"
				+ "CategorieVehicule varchar(20),"
				+ "NumCarteBancaire int,"
				+ "primary key (IdForfait),"
				+ "CONSTRAINT NumCarteBancaireForeign FOREIGN KEY (NumCarteBancaire) REFERENCES CATEGORIES(NumCarteBancaire)"
				+ "CONSTRAINT CatVehiculeRoreign FOREIGN KEY (CategorieVehicule) REFERENCES CATEGORIES(CategorieVehicule)"
				+ ")"
				);
		sttable.close();
	}

	
	/**
	 * Create Table Forfaits2
	 * @param conn : connection used
	 */
	public static void createTableForfaits2(Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("create table Forfait2 (IdForfait int primary key, "
				+ "NbMaxLocations int constraint dureeForf2Pos check (NbMaxLocations >= 0),"
				+ "NbLocationsGratuites int constraint nbLocGratuite2 check (NbLocationsGratuites >= 0),"
				+ "PrixForfait int constraint prixForf2Pos check (PrixForfait >= 0), "
				+ "constraint IdForfait2Foreign foreign key (IdForfait) references Forfaits(IdForfait)) "
				);
		sttable.close();
	}	


	/**
	 * Create Table Forfaits1
	 * @param conn : connection used
	 */
	public static void createTableForfait1 (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Forfait1 (IdForfait int primary key,"
				+ "DureeForfait int constraint dureeForfPos check (DureeForfait >= 0),"
				+ "DebutValidite date, PrixForfait int constraint prixForfPos check (PrixForfait >= 0),"
				+ " constraint IdForfaitForeign foreign key (IdForfait) references Forfaits(IdForfait))"
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table EstDans
	 * @param conn : connection used
	 */
	public static void createTableEstDans (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table EstDans (IdVehicule int primary key,"
				+ "NomStation varchar(20))"
				);
		sttable.close();
	}

	
	/**
	 * Create Table Places
	 * @param conn : connection used
	 */
	public static void createTablePlacesLibres (Connection conn) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		sttable.executeUpdate(
				"create table PlacesLibres ( NomStation varchar(20), "
				+ "CategorieVehicule varchar(20), "
				+ "Places int constraint PlacesPos check (Places >= 0), "
				+ "constraint NomStationForeign foreign key (NomStation) references Stations(Nomstation), "
				+ "constraint CatVehiculeForeign2 foreign key (CategorieVehicule) references Categories(CategorieVehicule), "
				+ "primary key (NomStation, CategorieVehicule))"
				); 
		sttable.close(); 
	}

	// DROP AND COMMIT 
	
	/**
	 * Drop table in parameters
	 * @param conn : connection used
	 * @param NomTable : name of the table to drop 
	 */
	public static void dropTable(Connection conn,String NomTable) throws SQLException {
		Statement sttable = conn.createStatement();
		
		String request = "DROP TABLE " + NomTable + " ";
		System.out.println(request);
		sttable.executeUpdate(request);
		sttable.close();
	}
	/**
	 * Commit
	 * @conn : connection used
	 */
	public static void commit(Connection conn) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("commit");
		sttable.close();
	}
	
	/**
	 * Set an auto commit
	 * @param conn : connection used
	 */
	public static void setautocommit(Connection conn) throws SQLException {
		conn.setAutoCommit(false); 
	}
	
	
	
	// INSERT IN TABLES
	
	
	/**
	 * Insert values in Table Categorie
	 * @param conn : connection used
	 * @param catVehicule : category of the vehicule
	 * @param dureeMax : maximum duration of the location for the chosen category
	 * @param prixHoraire : price for 1 hour of rent
	 * @param caution : amount of the caution
	 */
	public static void insertCategorie(Connection conn, 
									   String catVehic, 
									   int dureeMax, 
									   int prixHoraire, 
									   int caution) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		String update = "insert into Categories values ('"
				+ catVehic + "', "
				+ dureeMax + ", "
				+ prixHoraire + ", "
				+ caution + ")";
		
		System.out.println(update);
		sttable.executeUpdate(update) ; 
	}

	
	/**		sttable.e
	 * Insert values in Table Station
	 * @param conn : connection used
	 * @param nomStation : name of the station
	 * @param adresseStation : adress of the station
	 */
	public static void insertStation(Connection conn, 
									String nomStation, 
									String adresseStation) throws SQLException {
			Statement sttable = conn.createStatement();       
			sttable.executeUpdate("insert into Stations values ('" 
					+ nomStation + "', '" 
					+ adresseStation + "', " 
					+ ")"
					);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Vehicules
	 * @param conn : connection used
	 * @param idVehicule : identification number of the vehicule
	 * @param nbPlaces : number of places of the vehicule
	 * @param categorieVehicule : category of the vehicule
	 */
	public static void insertVehicules(Connection conn, 
									   int idVehicule, 
									   int nbPlaces , 
									   String categorieVehicule) throws SQLException {
			Statement sttable = conn.createStatement();       
			sttable.executeUpdate("insert into Vehicules values (" 
			+ idVehicule+ ", " 
			+ nbPlaces + ", '" 
			+ categorieVehicule+ "' ) "
			);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Abonnes
	 * @param conn : connection used
	 * @param numCarteBancaire : number of the paycard of the user
	 * @param nomAbonne : last name of the client
	 * @param prenomAbonne : first name of the client
	 * @param dateNaissance : date of birth of the client
	 * @param adresseabonne : adress of the client
	 */
	public static void  insertAbonnes (Connection conn, 
										int numCarteBancaire, 
										String nomAbonne, 
										String prenomAbonne, 
										String dateNaissance, 
										String adresseAbonne) throws SQLException {
		
	    	DateFormat formatJour = new SimpleDateFormat("dd-MM-yyyy");
	    	java.util.Date date;
			try {
				date = formatJour.parse(dateNaissance);
				Calendar myCal = new GregorianCalendar();
		    	myCal.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
			Statement sttable = conn.createStatement() ; 
			sttable.executeUpdate("insert into Abonnes values (" 
					+ numCarteBancaire + ", '" 
					+ nomAbonne + "','" 
					+ prenomAbonne + "'," 
					+ dateNaissance + ",'" 
					+ adresseAbonne + "')" 
					);
			sttable.close() ; 
		
		
	}
	
	/**
	 * Insert values in Table Locations
	 * @param conn : connection used
	 * @param nulLoc : number of the rent
	 * @param nomStationDepart : name of the departure station
	 * @param nomStationArrivee : name of the arrival station
	 * @param dateLocation : date of the rent
	 * @param heureDebut : time of the beggining of the rent
	 * @param heureFin : time of the end of the rent
	 * @param idVehicule : identification nuimber of the vehicule used for the rent
	 * @param numCarteBancaire : number if the paycard used by the client for the rent 
	 */
	public static void insertLocations(Connection conn, 
									   int numLoc, 
									   String nomStationDepart, 
									   String nomStationArrivee, 
									   Date dateLocation,
									   int heureDebut, 
									   int heureFin, 
									   int idVehicule, 
									   int numCarteBancaire) throws SQLException {
			Statement sttable = conn.createStatement();       
			sttable.executeUpdate("insert into Vehicules values ('" 
				+ nomStationDepart + "', '" 
				+ nomStationDepart + "', " 
				+ dateLocation + ", " 
				+ heureDebut + ", " 
				+ heureFin + ", " 
				+ idVehicule + ", "
				+ numCarteBancaire + ")"
					); 	
			sttable.close();
			// rajouter une fonction qui enleve un vehicule ds la station concernee et qui rajoute une place libre
	}

	private static void insererForfaits (Connection conn, int IdForfait, int TypeForfait, 
			String CatVehicule, int NumCarteBancaire) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("insert into Vehicules values ('" 
				+ IdForfait + "', '" 
				+ TypeForfait + "', " 
				+ CatVehicule + ", " 
				+ NumCarteBancaire + ")"
				); 	
		sttable.close();
	}

	/**
	 * Insert values in Table Forfaits1
	 * @param conn : connection used
	 * @param idforfait : identification number of the package
	 * @param dureeForfait : time duration of the package
	 * @param debutValidite : time of beginning of the package
	 * @param prixForfait : price of the package
	 */
	public static void insertForfaits1(Connection conn, int idForfait, 
									   String CatVehicule, int numCB,
									   int dureeForfait, 
									   Date debutValidite, 
									   int prixForfait)	throws SQLException {
			insererForfaits (conn, idForfait, 1, CatVehicule, numCB);
			Statement sttable = conn.createStatement();
			sttable.executeUpdate(" insert into Forfaits1 values (" 
					+ idForfait + ", " 
					+ dureeForfait + ", "
					+ debutValidite + "," 
					+ prixForfait + ")"
					);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Forfaits2
	 * @param conn : connection used
	 * @param ifForfait : identification number of the package
	 * @param nbMaxLocations : number maximum of locations for this package
	 * @param nbLocationsGratuites : number maximum of free locations for this package
	 * @param prixForfait : price of the package
	 */
	public static void insertForfaits2(Connection conn, 
									   int idForfait,
									   String CatVehicule, int numCB,
									   int nbMaxLocations,
									   int nbLocationsGratuites,
									   int prixForfait) throws SQLException {
			insererForfaits (conn, idForfait, 2, CatVehicule, numCB);
			Statement sttable = conn.createStatement() ; 
			sttable.executeUpdate(" insert into Forfaits1 values ("
					+ idForfait + ", "
					+ nbMaxLocations + ", "
					+ nbLocationsGratuites + ","
					+ prixForfait + ")"
					) ;
			sttable.close() ; 
	}

	public static void insertEstDans (Connection conn, int IdVehicule, String NomStation) throws SQLException {

	Statement sttable = conn.createStatement() ; 
	sttable.executeUpdate(" insert into Forfaits1 values ("
			+ IdVehicule + ", "
			+ NomStation
			+ ")"
			) ;
	//  A FAIRE!! : recuperer le nbre de place libre de la catgorie de IdVehic ds la station 
				// 
	sttable.close();
}
	
	
	public static  void insertPlacesLibres (Connection conn, String NomStation, int places, String CatVehicule) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		sttable.executeUpdate(" insert into Forfaits1 values ("
				+ NomStation + ", "
				+ places + ", "
				+ CatVehicule
				+ ")"
				) ;
		sttable.close();
	}
	
	public static void finLocation (Connection conn, int numCB, int idVehicule, String nomStation) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		// on recupere le nombre de place libre dans la station ou l'on veut rendre le vehicule
		ResultSet rs = sttable.executeQuery("Select PlacesLibres.Places from PlacesLibres Where PlacesLibres.NomStation = " + nomStation );
		
		// on verifie qu'il y a de la place:
		int placeLibre = rs.getInt(1);
		if (placeLibre > 0) {
			// on met le vehicule dedans 
			insertEstDans(conn, idVehicule, nomStation);
			// on decremente le nbre de place libre dans cette station et dans cette categorie
			// on recupere d'abord la categorie
			ResultSet catVehicule = sttable.executeQuery ("Select Vehicules.CategorieVehicule From Vehicules Where Vehicules.IdVehicule ="+ idVehicule);
		}
		sttable.close();
		// mettre le vehicule dedans
		// decrementer le nbre de place libre de cette categorie
	}
	

	public static boolean tableExists(String tableName, Connection conn) throws SQLException {

		DatabaseMetaData md = conn.getMetaData();
		ResultSet rs = md.getTables(null, null, tableName, null);
		if (rs.next()) {
			return true;
		}
		return false;

	}

}




	
	