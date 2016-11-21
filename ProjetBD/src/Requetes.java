/**
* Methods to create tables and insert data in them
 */

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
	
	public void deleteFromEstDans(int idVehicule) throws SQLException {
		
		String query = "DELETE FROM EstDans WHERE (IdVehicule = " + idVehicule + " )";
		Statement stmt = this.conn.createStatement();
		stmt.executeQuery(query);
		commit() ; 
		
		
	}
	//////////////////////////////////////////////////
	// CREATE TABLES
	/////////////////////////////////////////////////
	
	/**
	 * Create Table Categories
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
	 */
	public void createTableLocations() throws SQLException {
		Statement sttable = conn.createStatement(); 
		String request = "create table Locations (NumLoc int constraint numLocPos check (NumLoc >= 0),"
				+ "DateLocation date,"
				+ "DateFinLocation date,"
				/*+ "heureDebut int,"
				+ "heureFin int,"*/
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
	 */
	public void createTableForfaits() throws SQLException {
		Statement sttable = conn.createStatement();  
		String request = "create table Forfaits (IdForfait INT CONSTRAINT ForfaitPos CHECK (IdForfait >= 0),"
				+ "TypeForfait INT CONSTRAINT TypsPos CHECK ((TypeForfait = 1) OR (TypeForfait = 2)),"
				+ "CategorieVehicule varchar(20),"
				+ "NumCarteBancaire int,"
				+ "DateCreation date,"
				+ "primary key (IdForfait),"
				+ "CONSTRAINT NumCarteBancForeign FOREIGN KEY (NumCarteBancaire) REFERENCES ABONNES(NumCarteBancaire),"
				+ "CONSTRAINT CatVehiculeRoreign FOREIGN KEY (CategorieVehicule) REFERENCES CATEGORIESVEHICULES(CategorieVehicule)"
				+ ")";
		sttable.executeUpdate(request);
		sttable.close();
	}

	
	/**
	 * Create Table Forfaits2
	 */
	public void createTableForfaits2() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("create table Forfait2 (IdForfait int primary key, "
				+ "NbMaxLocations int constraint dureeForf2Pos check (NbMaxLocations >= 0),"
				+ "NbLocationsGratuites int constraint nbLocGratuite2 check (NbLocationsGratuites >= 0),"
				+ "NbLocationsRestantes int constraint nbLocRest check (NbLocationsRestantes >= 0),"
				+ "constraint IdForfait2Foreign foreign key (IdForfait) references Forfaits(IdForfait)) "
				);
		sttable.close();
	}	


	/**
	 * Create Table Forfaits1
	 */
	public void createTableForfait1() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate(
				"create table Forfait1 (IdForfait int primary key,"
				//+ "DureeForfait int constraint dureeForfPos check (DureeForfait >= 0),"
				+ "FinValidite date,"
				+ "constraint IdForfaitForeign foreign key (IdForfait) references Forfaits(IdForfait))"
				);
		sttable.close();
	}
	
	
	/**
	 * Create Table EstDans
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

	
	//////////////////////////////////////////////////
	// DROP AND COMMIT 
	//////////////////////////////////////////////////
	
	/**
	 * Drop table in parameters
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
	 */
	public void commit() throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("commit");
		sttable.close();
	}
	
	/**
	 * Set an auto commit
	 */
	public void setautocommit() throws SQLException {
		conn.setAutoCommit(false); 
	}
	
	
	//////////////////////////////////////////////////		
	// INSERT IN TABLES
	//////////////////////////////////////////////////	
	
	/**
	 * Insert values in Table Categorie
	 * @param catVehicule : category of the vehicule
	 * @param dureeMax : maximum duration of the location for the chosen category
	 * @param prixHoraire : price for 1 hour of rent
	 * @param prixMensuel : price for 1 month of rent
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

	
	/**
	 * Insert values in Table Station
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
				+ ", 0"
				+ ")";
		System.out.println(request);
	    	
		Statement sttable = conn.createStatement() ;
		sttable.executeUpdate(request);	
		sttable.close() ; 	
			
		
		
	}
	
	/**
	 * Insert values in Table Locations
	 * @param numLoc : number of the rent
	 * @param dateLocation : date of the rent
	 * @param heureDebut : hour of the rent
	 * @param idVehicule : identification nuimber of the vehicule used for the rent
	 * @param numCarteBancaire : number if the paycard used by the client for the rent 
	 * @param nomStationDepart : station of departure
	 */
	public void insertLocations(int numLoc, 
								String dateLocation,
								String heureDebut, 
								int idVehicule, 
								int numCarteBancaire,
								String nomStationDepart)
									    throws SQLException {
		begin() ; 
		//TO_DATE('20110728T23:54:14Z',  'YYYYMMDD"T"HH24:MI:SS"Z"')
		String toDate = ("to_date('" + dateLocation + "T" + heureDebut + "Z', 'YYYYMMDD\"T\"HH24:MI:SS\"Z\"')");
		
		String request = "insert into Locations values (" 
				+ numLoc + ", "
				//+ "to_date('" + dateLocation + "', 'yyyymmdd')" + ", " 				
				+ toDate + "," 
				+ "null" + ","
				/*+ heureDebut + ", "
				+ "null" + ", "*/
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

	
	/**
	 * Insert values in Table Forfaits
	 * @param IdForfaits : Identification number of the package
	 * @param TypeForfait : number of the package's type
	 * @param debutval : beginning date of the paskage
	 * @param CatVehicule : category of the vehicule concerned by the package
	 * @param NumCarteBancaire : number of the user's cash card
	 */
	private void insererForfaits (int IdForfait, int TypeForfait, String debutVal,
			String CatVehicule, int NumCarteBancaire) throws SQLException {
		Statement sttable = conn.createStatement();       
		sttable.executeUpdate("insert into Forfaits values (" 
				+ IdForfait + ", " 
				+ TypeForfait + ",'" 
				+ CatVehicule + "', " 
				+ NumCarteBancaire + ","
				+ debutVal
				+ ")"
				); 	
		sttable.close();
	}

	/**
	 * Insert values in Table Forfaits1
	 * @param idforfait : identification number of the package
	 * @param CatVehicule : category of the vehicule
	 * @param numCB : number of the user's cash card
	 * @param debutValidite : date of beginning of the package
	 * @param finValiditï¿½ : date of the end of the package
	 */
	public void insertForfaits1(int idForfait, 
									   String CatVehicule, 
									   int numCB, 
									   String debutValidite,
									   String finValidite)	throws SQLException {
		
		
		String toDate1 = ("to_date('" + debutValidite + "', 'yyyymmdd')");
		String toDate2 = ("to_date('" + finValidite + "', 'yyyymmdd')");
		
		insererForfaits (idForfait, 1, toDate1, CatVehicule, numCB);
			Statement sttable = conn.createStatement();

			sttable.executeUpdate(" insert into Forfait1 values (" 
					+ idForfait + ", "
					//+ dureeForfait + ", "
					//+ "to_date('" + debutValidite + "', 'yyyymmdd')"
					+ toDate2
					+ ")"
					);
			sttable.close();
	}
	
	/**
	 * Insert values in Table Forfaits2
	 * @param idForfait : identification number of the package
	 * @param CatVehicule : category of the vehicule
	 * @param numCB : number of the user's cash card
	 * @param nbMaxLocations : number maximum of locations for this package
	 * @param nbLocRest : number of remaining locations for the package
	 * @param debutValiditï¿½ : ate of beginning of the package
	 */
	public void insertForfaits2(int idForfait,
									   String CatVehicule, 
									   int numCB,
									   int nbMaxLocations, 
									   String debutValidite) throws SQLException {
		String toDate1 = ("to_date('" + debutValidite + "', 'yyyymmdd')");	
		insererForfaits (idForfait, 2, toDate1, CatVehicule, numCB);
			Statement sttable = conn.createStatement();
			sttable.executeUpdate(" insert into Forfait2 values ("
					+ idForfait + ", "
					+ nbMaxLocations + ", "
					+ 3 + ","
					+ nbMaxLocations+ ")"
					) ;
			sttable.close() ; 
	}


	/**
	 * Insert values in Table EstDansInit
	 * All vehicules are inserted during the initialisation protocole
	 * @param IdVehicule : identification number of the vehicule
	 * @param NomStation : name of the station in which the vehicule is inserted
	 */
	public void insertEstDansInit(int IdVehicule, String NomStation) throws SQLException{
		Statement sttable = conn.createStatement() ; 
		sttable.executeUpdate("insert into EstDans values ("
				+ IdVehicule + ", '"
				+ NomStation
				+ "')");
		System.out.println("insert into EstDans values ("
				+ IdVehicule + ", '"
				+ NomStation
				+ "')");
		sttable.close();
	}
	
	/**
	 * Insert values in Table EstDans
	 * This method is used to update the new position of a vehicule
	 * All vehicules are inserted during the initialisation protocole
	 * @param IdVehicule : identification number of the vehicule
	 * @param NomStation : name of the station in which the vehicule is inserted
	 */
	public void insertEstDans (int IdVehicule, String NomStation) throws SQLException {

	Statement sttable = conn.createStatement() ; 
	String update = "UPDATE EstDans SET NomStation='" + NomStation + "' WHERE (IdVehicule = " + IdVehicule + ")" ;
	System.out.println(update);
	sttable.executeUpdate(update) ;
	//  A FAIRE!! : recuperer le nbre de place libre de la catgorie de IdVehic ds la station 
				// 
	commit() ; 
	sttable.close();
}
	
	/**
	 * Insert values in Table PlacesLibres
	 * @param NomStation : name of the station
	 * @param places : number of available places in the station
	 * @param CatVehicule : category of the vehicule 
	 */
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
	

	/**
	 * 
	 * @param CB : number of the user's cash card
	 * @param categorie : category of the vehicule
	 */
    public Boolean alreadyGotForfait1(int CB, String categorie) throws SQLException {


	
        
        Statement sttable = conn.createStatement();
        String getForfaitId = "SELECT IdForfait FROM Forfaits "
        		+ "WHERE (NumCarteBancaire=" + CB + " AND TYPEFORFAIT = 1 AND CATEGORIEVEHICULE = '" + categorie + "')";
        System.out.println(getForfaitId);
        ResultSet rs = sttable.executeQuery(getForfaitId);
        String ID = "";
        
        if (rs.next()) {
        	ID = "'" + rs.getString(1)+ "'" ; 	
        	while (rs.next()) {
             	
             	ID = ID + " OR IdForfait='" + rs.getString(1) + "'";
             	
             }
             String query = "SELECT FINVALIDITE FROM Forfait1 "
             		+ "WHERE (IDFORFAIT = " + ID + ")";
             System.out.println("query");
             rs = sttable.executeQuery(query);
             java.util.Date today = new java.util.Date();
             
             while (rs.next()) {
            	 
            	 java.util.Date end = new java.util.Date(rs.getDate(1).getTime());
            	 if (today.compareTo(end) < 0) {
            		 return true;
            	 }
            	 
             }
        }
        return false;
        
       
    }
    
    
    public int alreadyGotForfait2(int CB, String categorie) throws SQLException {
    	
    	 Statement sttable = conn.createStatement();
         String getForfaitId = "SELECT IdForfait FROM Forfaits "
         		+ "WHERE (NumCarteBancaire=" + CB + " AND TYPEFORFAIT = 2 AND CATEGORIEVEHICULE = '" + categorie + "')";
         ResultSet rs = sttable.executeQuery(getForfaitId);
         String ID = "";
         
         if (rs.next()) {
         	ID = "'" + rs.getString(1)+ "'" ; 	
         	while (rs.next()) {
              	
              	ID = ID + " OR IdForfait='" + rs.getString(1) + "'";
              	
              }
              String query = "SELECT IdForfait, NBLocationsRestantes FROM Forfait2 "
              		+ "WHERE (IDFORFAIT = " + ID + ")";
              rs = sttable.executeQuery(query);
              
              while (rs.next()) {
             	 
             	 if (rs.getInt(2) != 0) {
             		 return rs.getInt(1);
             	 }
             	 
              }
         }
         return 0;
    	
    	
    }
/*
    "create table Forfait1 (IdForfait int primary key,"
    + "DureeForfait int constraint dureeForfPos check (DureeForfait >= 0),"
    + "DebutValidite date,"
    + "constraint IdForfaitForeign foreign key (IdForfait) references Forfaits(IdForfait))"
    */
	/*
	 * + IdForfait + ", " 
				+ TypeForfait + ",'" 
				+ CatVehicule + "', " 
				+ NumCarteBancaire + ")"
	 */


	/**
	 * Find a rent from a user's cash card number
	 * @param CB : number of the user's cash card
	 * @return 
	 */
	public int findLocation(int CB) throws SQLException {
		
		Statement sttable = conn.createStatement();
		String query = "SELECT numloc FROM locations WHERE (numcartebancaire=" + CB +  " AND datefinlocation = null)";
		ResultSet rs = sttable.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		
		
	}

	public ResultSet location(String station, String categorie) throws SQLException {
		
		Statement sttable = conn.createStatement();
		String query = "SELECT IdVehicule FROM Vehicules WHERE (Vehicules.CategorieVehicule = '" + categorie + "' AND EstDans.nomStation  = '" + station + "')";
		ResultSet rs = sttable.executeQuery(query);
		if (rs.next()) {
			
			return rs;
		}
		else {
			return null;
		}
		
	}

	/**
	 * Find a rent
	 * @param numLoc : identification number of the rent
	 * @param dateFinLoc : date of the end of the rent
	 * @param heureArrivee : time of arrival
	 * @param nomStationArrivï¿½e : name of the arrival station
	 */
public void finLocation (int numLoc, String dateFinLoc, String heureArrivee, String nomStationArrivee) throws SQLException {

		
		
		Statement sttable = conn.createStatement();
		begin() ;
		// On recupere l'Id du vehicule 
		
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
			String toDate = ("to_date('" + dateFinLoc + "T" + heureArrivee +"Z', 'YYYYMMDD\"T\"HH24:MI:SS\"Z\"')" + "WHERE ( NumLoc = " + numLoc + ")");
			String miseAjourDate = "UPDATE Locations SET dateFinLocation =" + toDate;				
			sttable.executeUpdate(miseAjourDate);

			/*String miseAjourHeure = "UPDATE Locations SET heureFin = "+ heureArrivee ;
			sttable.executeUpdate(miseAjourHeure);*/
		} else {
			System.out.println("Pas de places disponibles dans cette station");			
		}
		
		
		/*
		 * 
		String ajoutPlace = "UPDATE PlacesLibres SET Places=" + placeLibre + " Where (NomStation ='" + nomStationDepart
				+ "' AND CategorieVehicule ='" + categorie + "')";
		 */
		
		sttable.close();
	}
	
	public int getMaxIdForfait() throws SQLException {
		
		String request = "SELECT MAX(IdForfait) AS IdForfait FROM Forfaits";
		Statement sttable = conn.createStatement();
		ResultSet rs = sttable.executeQuery(request);
		rs.next();
		return rs.getInt(1);
		
	}

	public int getMaxNumLoc() throws SQLException {
		
		String request = "SELECT MAX(numLoc) AS numLoc FROM Forfaits";
		Statement sttable = conn.createStatement();
		ResultSet rs = sttable.executeQuery(request);
		rs.next();
		return rs.getInt(1);
		
		
	}
	
	/**
	 * Check if a table exists or not
	 * @param tableName : name of the table
	 * @return true if the table exists
	 */
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
	

	public void printTable(String TableName) throws SQLException {
		
		Statement sttable = conn.createStatement();
		String query = "SELECT * FROM " + TableName;
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
	}
	
	public int tauxOccupation(int date, String Station) throws SQLException{
		Statement sttable = conn.createStatement();
		String toDate1 = ("to_date('" + date + "', 'yyyymmdd')");
		String querydebut = "SELECT DateLocation FROM LOCATIONS WHERE (locations.NomStation = Station "
				+ "AND locations.DateLocation = " + toDate1;
		ResultSet rsdebut = sttable.executeQuery(querydebut);
		ResultSetMetaData rsmddebut = rsdebut.getMetaData();
		
		String queryfin = "SELECT DateFinLocation FROM LOCATIONS WHERE (locations.NomStation = Station "
				+ "AND locations.DateLocation = " + toDate1;
		ResultSet rsfin = sttable.executeQuery(queryfin);
		ResultSetMetaData rsmdfin = rsfin.getMetaData();
		
		while (rsdebut.next()){
		}
		return(1);
	}	
	public void makePayement(int idForfait, int CB) throws SQLException{
		
		String query = "SELECT SOLDE FROM Abonnes WHERE (NUMCARTEBANCAIRE = " + CB + " )";
		Statement sttable = conn.createStatement();
		ResultSet rs = sttable.executeQuery(query);
		rs.next();
		int newSolde = rs.getInt(1) + facturation(idForfait);
		updateSolde(CB, newSolde);
		
	}
	
	public void updateSolde(int CB, int newSolde) throws SQLException {
		
		Statement sttable = conn.createStatement();
		String query = "UPDATE Abonnes SET SOLDE=" + newSolde;
		sttable.executeUpdate(query);

		
		
	}
	public void decreaseLocationsRestantes(int idForfait) throws SQLException {
		String query = "SELECT NBLocationsRestantes "
				+ "FROM Forfait2 "
				+ "WHERE (IdForfait = " + idForfait + " )";
		Statement sta = conn.createStatement();
		ResultSet rs = sta.executeQuery(query);
		rs.next();
		int newLocationsRestantes = rs.getInt(1) + 1;
		String update = "UPDATE Forfait2 SET NBLocationsRestantes = " + newLocationsRestantes + ")";
		
	}
	/**
	 * Calculate the price of a rent
	 * @param IdForfait : identification number of the package
	 * @return the price of the rent
	 */

	public int facturation(int IdForfait) throws SQLException{
		int prix = 0;
			Statement sttable = conn.createStatement();
			
			// On récupère le type du forfait
			ResultSet rs = sttable.executeQuery("SELECT TypeForfait FROM Forfaits WHERE IdForfait = " + IdForfait);
			rs.next();
			int typeForfait = rs.getInt(1);
			rs.close();
			// On agit en fonction du type de forfait
			switch(typeForfait){
			case 1:
				// on récupère la durée du forfait
				ResultSet rs1 = sttable.executeQuery("SELECT floor(months_between(FinValidite, forfaits.DATECREATION)) FROM forfaits, forfait1 WHERE forfaits.idforfait = forfait1.idforfait and forfaits.idforfait = " + IdForfait);
				rs1.next();
				prix = rs1.getInt(1);
				// on la multiplie par le prix mensuel du forfait en fonction de sa catégorie
				rs1 = sttable.executeQuery("SELECT PrixMensuel FROM CategoriesVehicules WHERE CategorieVehicule = (" + "SELECT CategorieVehicule FROM Forfaits WHERE IdForfait = " + IdForfait + ")");
				rs1.next();
				prix *= rs1.getInt(1);
				rs1.close();
				break;
			case 2:
				// on récupère le nombre de location max
				ResultSet rs2 = sttable.executeQuery("SELECT nbMaxLocations FROM Forfait2 WHERE IdForfait = " + IdForfait);
				rs2.next();
				prix = rs2.getInt(1);
				// on multiplie ce nombre par le cout de cette loc en fonction de sa catégorie
				rs2 = sttable.executeQuery("SELECT PrixHoraire FROM CategoriesVehicules WHERE CategorieVehicule = (" + "SELECT CategorieVehicule FROM Forfaits WHERE IdForfait = " + IdForfait + ")");
				rs2.next();
				prix *= rs2.getInt(1);
				rs2.close();
				break;
			default:
				return prix;
			}
			ResultSet rss = sttable.executeQuery("SELECT floor(months_between(datecreation, datenaissance)/12) FROM abonnes, forfaits WHERE forfaits.numcartebancaire = abonnes.numcartebancaire and forfaits.idforfait = " + IdForfait);
			rss.next();
			int age = rss.getInt(1);
			rss.close();		
			if (age < 25 || age > 65)
				return prix*3/4;
			else
				return prix;
	}
}




	
	