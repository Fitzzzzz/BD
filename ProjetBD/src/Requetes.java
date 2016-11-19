import java.sql.*;
public class Requetes {

	private Connection conn;
	
	public Requetes(Connection conn) {
		
		this.conn = conn;
	}
	public void deleteTableContent(String tableName) throws SQLException {
		
		String query = "DELETE FROM " + tableName;
		Statement stmt = this.conn.createStatement();
		stmt.executeQuery(query);
		
	}
	
	// CREATE TABLES
	
	/**
	 * Create Table Categories
	 * @param conn : connection used
	 */
	public void createTableCategories() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table CategoriesVehicules (CategorieVehicule varchar(20) primary key,"
						+ " DureeMax int constraint dureePos check (DureeMax >= 0),"
						+ "PrixHoraire int constraint prix1Pos check (PrixHoraire >= 0),"
						+ "PrixMensuel int constraint prix2Pos check (PrixMensuel >= 0),"
						+ "MontantCaution int constraint CautionPos check (MontantCaution >= 0))"
				);
		sttable.close();
	}
	
	/**
	 * Create Table Stations
	 * @param conn : connection used
	 */
	public void createTableStations() throws SQLException{
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
	public void createTableVehicules() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"CREATE TABLE VEHICULES (IdVehicule int CONSTRAINT IdPos CHECK (IdVehicule >= 0),"
						+ "NbPlaces int CONSTRAINT PlacesPos CHECK (NbPlaces >= 0), "
						+ "CategorieVehicule varchar(20), "
						+ "CONSTRAINT CatVehicule FOREIGN KEY (CategorieVehicule) REFERENCES CATEGORIESVEHICULES(CategorieVehicule),"
						+ "PRIMARY KEY (IdVehicule))" 
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table Abonnes
	 * @param conn : connection used
	 */
	public void createTableAbonnes() throws SQLException {
		Statement sttable = conn.createStatement();  
		String query = "create table Abonnes (NumCarteBancaire  int CONSTRAINT CBPA CHECK (NumCarteBancaire > 0), "
				+ "NomAbonne VARCHAR(20), "
				+ "PrenomAbonne VARCHAR(20), "
				+ "DateNaissance DATE, "
				+ "AdresseAbonne VARCHAR(100), "
				+ "Solde int CONSTRAINT SoldePos CHECK (Solde >= 0),"
				+ "primary key (NumCarteBancaire))";
		System.out.println(query);
		sttable.executeUpdate(query);
		sttable.close();
	}
	
	
	/**
	 * Create Table Locations
	 * @param conn : connection used
	 */
	public void createTableLocations() throws SQLException {
		Statement sttable = conn.createStatement(); 
		String request = "create table Locations (NumLoc int constraint numLocPos check (NumLoc >= 0),"
				+ "DateLocation date,"
				+ "DateFinLocation date,"
				+ "heureDebut int,"
				+ "heureFin int,"
				+ "IdVehicule  int,"
				+ "numCarteBancaire int,"
				+ "nomStationDepart varchar(20),"
				+ "nomStationArrivee varchar(20),"
				+ "primary key (NumLoc),"
				+ "constraint IdVehiculeForeign foreign key (IdVehicule) references Vehicules(IdVehicule),"
				+ "constraint NumCarteBancaireForeign foreign key (numCarteBancaire) references Abonnes(NumCarteBancaire), "
				+ "constraint NomStationDepartForeign foreign key (nomStationDepart) references Stations(NomStation),"
				+ "constraint NomStationArriveeForeign foreign key (nomStationArrivee) references Stations(NomStation)"
				+ ")";
		System.out.println(request);
		sttable.executeUpdate(request);
		sttable.close();
	}

	
	/**
	 * Create Table Forfaits
	 * @param conn : connection used
	 */
	public void createTableForfaits() throws SQLException {
		Statement sttable = conn.createStatement();  
		String request = "create table Forfaits (IdForfait INT CONSTRAINT ForfaitPos CHECK (IdForfait >= 0),"
				+ "TypeForfait INT CONSTRAINT TypsPos CHECK ((TypeForfait = 1) OR (TypeForfait = 2)),"
				+ "CategorieVehicule varchar(20),"
				+ "NumCarteBancaire int,"
				+ "primary key (IdForfait),"
				+ "CONSTRAINT NumCarteBancForeign FOREIGN KEY (NumCarteBancaire) REFERENCES ABONNES(NumCarteBancaire),"
				+ "CONSTRAINT CatVehiculeRoreign FOREIGN KEY (CategorieVehicule) REFERENCES CATEGORIESVEHICULES(CategorieVehicule)"
				+ ")";
		sttable.executeUpdate(request);
		sttable.close();
	}

	
	/**
	 * Create Table Forfaits2
	 * @param conn : connection used
	 */
	public void createTableForfaits2() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("create table Forfait2 (IdForfait int primary key, "
				+ "NbMaxLocations int constraint dureeForf2Pos check (NbMaxLocations >= 0),"
				+ "NbLocationsGratuites int constraint nbLocGratuite2 check (NbLocationsGratuites >= 0),"
				+ "constraint IdForfait2Foreign foreign key (IdForfait) references Forfaits(IdForfait)) "
				);
		sttable.close();
	}	


	/**
	 * Create Table Forfaits1
	 * @param conn : connection used
	 */
	public void createTableForfait1() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Forfait1 (IdForfait int primary key,"
				+ "DureeForfait int constraint dureeForfPos check (DureeForfait >= 0),"
				+ "DebutValidite date,"
				+ "constraint IdForfaitForeign foreign key (IdForfait) references Forfaits(IdForfait))"
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table EstDans
	 * @param conn : connection used
	 */
	public void createTableEstDans () throws SQLException {
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
	public void createTablePlacesLibres () throws SQLException {
		Statement sttable = conn.createStatement();
		String query = "create table PlacesLibres ( NomStation varchar(20), "
				+ "CategorieVehicule varchar(20), "
				+ "Places int constraint PlacesPosL check (Places >= 0), "
				+ "constraint NomStationForeign foreign key (NomStation) references Stations(Nomstation), "
				+ "constraint CatVehiculeForeign2 foreign key (CategorieVehicule) references CategoriesVehicules(CategorieVehicule), "
				+ "primary key (NomStation, CategorieVehicule))";
		sttable.executeUpdate(query); 
		sttable.close(); 
	}

	// DROP AND COMMIT 
	
	/**
	 * Drop table in parameters
	 * @param conn : connection used
	 * @param NomTable : name of the table to drop 
	 */
	public void dropTable(String NomTable) throws SQLException {
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
	public void commit() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("commit");
		sttable.close();
	}
	
	/**
	 * Set an auto commit
	 * @param conn : connection used
	 */
	public void setautocommit() throws SQLException {
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
	public void insertCategorieVehicule(String catVehic, 
									   int dureeMax, 
									   int prixHoraire,
									   int prixMensuel,
									   int caution) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		String update = "insert into CategoriesVehicules values ('"
				+ catVehic + "', "
				+ dureeMax + ", "
				+ prixHoraire + ", "
				+ prixMensuel + ", "
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
	public void insertStation(String nomStation, 
									String adresseStation) throws SQLException {
			Statement sttable = conn.createStatement();  
			String request = "insert into Stations values ('"+nomStation+"', '"+adresseStation+"')";
			System.out.println(request);
			sttable.executeUpdate(request);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Vehicules
	 * @param conn : connection used
	 * @param idVehicule : identification number of the vehicule
	 * @param nbPlaces : number of places of the vehicule
	 * @param categorieVehicule : category of the vehicule
	 */
	public void insertVehicules(int idVehicule, 
									   int nbPlaces , 
									   String categorieVehicule) throws SQLException {
			Statement sttable = conn.createStatement();       
			sttable.executeUpdate("insert into Vehicules values (" 
			+ idVehicule+ ", " 
			+ nbPlaces + ", '" 
			+ categorieVehicule+ "' ) "
			);
			System.out.println("insert into Vehicules values (" 
			+ idVehicule+ ", " 
			+ nbPlaces + ", '" 
			+ categorieVehicule+ "' ) ");
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
	public void  insertAbonnes (int numCarteBancaire, 
										String nomAbonne, 
										String prenomAbonne, 
										String dateNaissance, 
										String adresseAbonne) throws SQLException {
		
		String request = "insert into Abonnes values (" 
				+ numCarteBancaire + ", '" 
				+ nomAbonne + "','" 
				+ prenomAbonne + "'," 
				+ "to_date('" + dateNaissance + "', 'yyyymmdd')" + ",'" 
				+ adresseAbonne + "'"
				+ ")";
	    	
		Statement sttable = conn.createStatement() ;
		sttable.executeUpdate(request);	
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
	public void insertLocations(int numLoc, 
								String dateLocation,
								int heureDebut, 
								int idVehicule, 
								int numCarteBancaire,
								String nomStationDepart)
									    throws SQLException {
		
		String request = "insert into Locations values (" 
				+ numLoc + ", "
				+ "to_date('" + dateLocation + "', 'yyyymmdd')" + ", " 				
				+ "null" + ","
				+ heureDebut + ", "
				+ "null" + ", "
				+ idVehicule + ", "
				+ numCarteBancaire + ", '"
				+ nomStationDepart + "', " 
				+ "null" 
				+ ")";
	    	System.out.println(request);
		
		
		Statement sttable = conn.createStatement() ;
		sttable.executeUpdate(request);	
		
		
		// on recupere d'abord la categorie
		ResultSet rs = sttable.executeQuery ("Select Vehicules.CategorieVehicule From Vehicules Where Vehicules.IdVehicule ="+ idVehicule);
		rs.next();
		String categorie = rs.getString(1);
		
		// on recupere le nombre de place libre dans la station ou l'on veut rendre le vehicule
		
		rs = sttable.executeQuery("Select PlacesLibres.Places from PlacesLibres Where (PlacesLibres.NomStation = '" + nomStationDepart
				+ "' and PlacesLibres.CategorieVehicule = '" + categorie + "' )");
		rs.next();
		int placeLibre = rs.getInt(1);
		placeLibre++;
		// on incremente le nbre de place libre dans cette station et dans cette categorie
		
		String ajoutPlace = "UPDATE PlacesLibres SET Places=" + placeLibre + " Where (NomStation ='" + nomStationDepart
				+ "' AND CategorieVehicule ='" + categorie + "')";
		System.out.println(ajoutPlace);
		sttable.executeUpdate(ajoutPlace);
		
		//  enleve un vehicule de la station
		String query = "DELETE FROM EstDans WHERE IdVehicule =" + idVehicule;
		sttable.executeQuery(query);
		sttable.close() ; 	
			
		
			
	}

	private void insererForfaits (int IdForfait, int TypeForfait, 
			String CatVehicule, int NumCarteBancaire) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("insert into Forfaits values (" 
				+ IdForfait + ", " 
				+ TypeForfait + ",'" 
				+ CatVehicule + "', " 
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
	public void insertForfaits1(int idForfait, 
									   String CatVehicule, 
									   int numCB,
									   int dureeForfait, 
									   String debutValidite)	throws SQLException {
			insererForfaits (idForfait, 1, CatVehicule, numCB);
			Statement sttable = conn.createStatement();

			sttable.executeUpdate(" insert into Forfait1 values (" 
					+ idForfait + ", "
					+ dureeForfait + ", "
					+ "to_date('" + debutValidite + "', 'yyyymmdd')"
					+ ")"
					);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Forfaits2
	 * @param conn : connection used
	 * @param ifForfait : iden        java.sql.Date sql = new java.sql.Date(parsed.getTime());tification number of the package
	 * @param nbMaxLocations : number maximum of locations for this package
	 * @param nbLocationsGratuites : number maximum of free locations for this package
	 * @param prixForfait : price of the package
	 */
	public void insertForfaits2(int idForfait,
									   String CatVehicule, int numCB,
									   int nbMaxLocations) throws SQLException {
			insererForfaits (idForfait, 2, CatVehicule, numCB);
			Statement sttable = conn.createStatement();
			sttable.executeUpdate(" insert into Forfait2 values ("
					+ idForfait + ", "
					+ nbMaxLocations + ", "
					+ 3 + ")"
					) ;
			sttable.close() ; 
	}


	public void insertEstDans (int IdVehicule, String NomStation) throws SQLException {

	Statement sttable = conn.createStatement() ; 
	/*
	String update = " insert into EstDans values ("
			+ IdVehicule + ", '"
			+ NomStation
			+ "')";
			*/
	String update = "UPDATE EstDans SET NomStation='" + NomStation + "' WHERE (IdVehicule = " + IdVehicule + ")" ;
	System.out.println(update);
	sttable.executeUpdate(update) ;
	//  A FAIRE!! : recuperer le nbre de place libre de la catgorie de IdVehic ds la station 
				// 
	sttable.close();
}
	
	
	public void insertPlacesLibres (String NomStation, int places, String CatVehicule) throws SQLException {
		Statement sttable = conn.createStatement() ; 
		sttable.executeUpdate(" insert into PlacesLibres values ('"
				+ NomStation + "', '"
				+ CatVehicule + "', "
				+ places
				+ ")"
				) ;
		sttable.close();
	}
	public int findLocation(int CB) throws SQLException {
		
		Statement sttable = conn.createStatement();
		String query = "SELECT numloc FROM locations WHERE (numcartebancaire=" + CB +  " AND datefinlocation null)";
		ResultSet rs = sttable.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		
		
	}



	public void finLocation (int numLoc, String dateFinLoc, int heureArrivee, String nomStationArrivee) throws SQLException {

		
		
		
		Statement sttable = conn.createStatement();
		
		// On récupère l'id du véhicule 
		
		ResultSet rs = sttable.executeQuery("Select IdVehicule FROM Locations WHERE (NUMLOC = " + numLoc + ")");
		rs.next();
		int idVehicule = rs.getInt(1);
		// on recupere d'abord la categorie
		
		
		rs = sttable.executeQuery ("Select Vehicules.CategorieVehicule From Vehicules Where Vehicules.IdVehicule ="+ idVehicule);
		rs.next();

		String categorie = rs.getString(1);
		// on recupere le nombre de place libre dans la station ou l'on veut rendre le vehicule
		String query = "SELECT PlacesLibres.Places from PlacesLibres Where (PlacesLibres.NomStation = '" + nomStationArrivee
				+ "' AND PlacesLibres.CategorieVehicule = '" + categorie + "')";
		System.out.println(query);
		
		
		rs = sttable.executeQuery(query);
		// on verifie qu'il y a de la place:
		rs.next();
		int placeLibre = rs.getInt(1);
		
		if (placeLibre > 0) {
			
			// on met le vehicule dedans 
			insertEstDans(idVehicule, nomStationArrivee);
			
			// on decremente le nbre de place libre dans cette station et dans cette categorie
			placeLibre--;
			String minusPlace = "UPDATE PlacesLibres SET Places=" + placeLibre + " WHERE (NomStation='" + nomStationArrivee + "' AND CategorieVehicule = '" + categorie + "')";
			System.out.println(minusPlace);
			sttable.executeUpdate(minusPlace);
			String miseAjourStat = "UPDATE Locations SET nomStationArrivee = '"+ nomStationArrivee +"'";
			sttable.executeUpdate(miseAjourStat);
			String miseAjourDate = "UPDATE Locations SET dateFinLocation = to_date('" + dateFinLoc + "', 'yyyymmdd')";				
			sttable.executeUpdate(miseAjourDate);
			String miseAjourHeure = "UPDATE Locations SET heureFin = "+ heureArrivee ;
			sttable.executeUpdate(miseAjourHeure);
		}
		else  {
			
			// TODO !
			
		}
		/*
		 * 
		String ajoutPlace = "UPDATE PlacesLibres SET Places=" + placeLibre + " Where (NomStation ='" + nomStationDepart
				+ "' AND CategorieVehicule ='" + categorie + "')";
		 */
		
		sttable.close();
	}
	

	public  boolean tableExists(String tableName) {

		
		
		String query = "SELECT 1 FROM " + tableName;
		Statement smt;
		try {
			smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(query);
			System.out.println(tableName + " exists");
			return true;
			
		} catch (SQLException e) {
			System.out.println(tableName + " doesnt exists");
			return false;
		}
		

	}

}




	
	