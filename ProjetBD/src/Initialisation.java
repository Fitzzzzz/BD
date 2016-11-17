import java.sql.*;
public class Initialisation {
	public static void initBase (Connection conn) throws SQLException {
		
		Requetes req = new Requetes(conn);
		
		Requetes.setautocommit(conn);
		if (!Requetes.tableExists("Categories", conn)) {
			System.out.println("caca");
			Requetes.createTableCategories(conn);
		}
		if (!Requetes.tableExists("Stations", conn)) {
			Requetes.createTableStations(conn);
		}
		if (!Requetes.tableExists("Vehicules", conn)) {
			Requetes.createTableVehicules(conn);
		}
		if (!Requetes.tableExists("Abonnes", conn)) {
			Requetes.createTableAbonnes(conn);
		}
		if (!Requetes.tableExists("Locations", conn)) {
			Requetes.createTableLocations(conn);
		}
		if (!Requetes.tableExists("Forfaits", conn)) {
			Requetes.createTableForfaits(conn);
		}
		if (!Requetes.tableExists("Forfait1", conn)) {
			Requetes.createTableForfait1(conn);
		}
		if (!Requetes.tableExists("Forfait2", conn)) {
			Requetes.createTableForfaits2(conn);
		}
		if (!Requetes.tableExists("EstDans", conn)) {
			Requetes.createTableEstDans(conn);
		}
		if (!Requetes.tableExists("PlacesLibres", conn)) {
			Requetes.createTablePlacesLibres(conn);
		}
		
		req.deleteTableContent("Categories");
		req.deleteTableContent("Stations");
		req.deleteTableContent("Vehicules");
		req.deleteTableContent("Abonnes");
		req.deleteTableContent("Locations");
		req.deleteTableContent("Forfaits");
		req.deleteTableContent("Forfait1");
		req.deleteTableContent("Forfait2");
		req.deleteTableContent("EstDans");
		req.deleteTableContent("PlacesLibres");
		
		
		
		
		Requetes.insertCategorie(conn, "Velo", 5, 1, 10);
		Requetes.insertCategorie(conn, "VeloElec", 5, 2, 20);
		Requetes.insertCategorie(conn, "VoitureElec", 5, 4, 40);
		Requetes.insertCategorie(conn, "VeloRemork", 5, 3, 30);
		Requetes.insertCategorie(conn, "Utilitaire", 5, 5, 50);
		 
		Requetes.insertStation(conn, "Patate", "3 avenue de l'Empereur Le Net");
		Requetes.insertStation(conn, "Navet", "7 ruelle du Bagou");
		Requetes.insertStation(conn, "Carotte", "6 rue de la Princesse Nicolas");
		Requetes.insertStation(conn, "Radis", "144 rue du Pape Gaunet");
		Requetes.insertStation(conn, "Choux Fleur", "14 avenue du General Hamm");
		Requetes.insertStation(conn, "Poix Chiche", "17 rue des Arlequins");
		Requetes.insertStation(conn, "Courge", "133 avenue du Seigneur Wagner");
		Requetes.insertStation(conn, "Poireau", "6 rue des Champs Elysees");
		Requetes.insertStation(conn, "Aubergine", "1 Cours Saint Mnacho");
		Requetes.insertStation(conn, "Cornichon", "32 rue du Claire Obscur");
		Requetes.insertStation(conn, "Epinard", "17 avenue du Roi Claude");
		
		Requetes.insertPlacesLibres(conn, "Patate", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Navet", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Carotte", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Radis", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Choux Fleur", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Poix Chiche", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Courge", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Poireau", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Aubergine", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Cornichon", 50, "Velo");
		Requetes.insertPlacesLibres(conn, "Epinard", 50, "Velo");
		
		Requetes.insertPlacesLibres(conn, "Patate", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Navet", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Carotte", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Radis", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Choux Fleur", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Poix Chiche", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Courge", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Poireau", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Aubergine", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Cornichon", 10, "VeloElec");
		Requetes.insertPlacesLibres(conn, "Epinard", 10, "VeloElec");
		
		Requetes.insertPlacesLibres(conn, "Patate", 5, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Navet", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Carotte", 5, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Radis", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Choux Fleur", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Poix Chiche", 15, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Courge", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Poireau", 5, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Aubergine", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Cornichon", 10, "VoitureElec");
		Requetes.insertPlacesLibres(conn, "Epinard", 10, "VoitureElec");
		
		Requetes.insertPlacesLibres(conn, "Patate", 10, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Navet", 5, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Carotte", 5, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Radis", 20, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Choux Fleur", 5, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Poix Chiche", 5, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Courge", 10, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Poireau", 10, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Aubergine", 10, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Cornichon", 10, "VeloRemork");
		Requetes.insertPlacesLibres(conn, "Epinard", 5, "VeloRemork");
		
		Requetes.insertPlacesLibres(conn, "Patate", 12, "Uitilitaire");
		Requetes.insertPlacesLibres(conn, "Navet", 13, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Carotte", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Radis", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Choux Fleur", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Poix Chiche", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Courge", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Poireau", 5, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Aubergine", 10, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Cornichon", 7, "Utilitaire");
		Requetes.insertPlacesLibres(conn, "Epinard", 4, "Utilitaire");
		
		
		
		
		
		int compteur = 0;
		for (int i = 0; i < 101; i++) {
			Requetes.insertVehicules(conn, i, 1, "Velo");
			
			switch (compteur) {
			case 1: 
				Requetes.insertEstDans(conn, i, "Patate");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Patate");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Patate");
					Requetes.insertEstDans(conn, 170+i, "Patate");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Patate");
				}
				break;
			case 2: 
				Requetes.insertEstDans(conn, i, "Navet");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Navet");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Navet");
					Requetes.insertEstDans(conn, 170+i, "Navet");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Navet");
				}
				break;
			case 3: 
				Requetes.insertEstDans(conn, i, "Carotte");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Carotte");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Carotte");
					Requetes.insertEstDans(conn, 170+i, "Carotte");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Carotte");
				}
				break;
			case 4: 
				Requetes.insertEstDans(conn, i, "Radis");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Radis");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Radis");
					Requetes.insertEstDans(conn, 170+i, "Radis");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Radis");
				}
				break;
			case 5: 
				Requetes.insertEstDans(conn, i, "Choux Fleur");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Choux Fleur");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Choux Fleur");
					Requetes.insertEstDans(conn, 170+i, "Choux Fleur");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Choux Fleur");
				}
				break;
			case 6: 
				Requetes.insertEstDans(conn, i, "Poix Chiche");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Choux Fleur");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Choux Fleur");
					Requetes.insertEstDans(conn, 170+i, "Choux Fleur");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Choux Fleur");
				}
				break;
			case 7: 
				Requetes.insertEstDans(conn, i, "Courge");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Courge");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Courge");
					Requetes.insertEstDans(conn, 170+i, "Courge");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Courge");
				}
				break;
			case 8: 
				Requetes.insertEstDans(conn, i, "Poireau");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Poireau");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Poireau");
					Requetes.insertEstDans(conn, 170+i, "Poireau");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Poireau");
				}
				break;
			case 9: 
				Requetes.insertEstDans(conn, i, "Aubergine");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Aubergine");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Aubergine");
					Requetes.insertEstDans(conn, 170+i, "Aubergine");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Aubergine");
				}
				break;
			case 10: 
				Requetes.insertEstDans(conn, i, "Cornichon");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Cornichon");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Cornichon");
					Requetes.insertEstDans(conn, 170+i, "Cornichon");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Cornichon");
				}
				break;
			case 11: 
				Requetes.insertEstDans(conn, i, "Epinard");
				if (i<31) {
					Requetes.insertVehicules(conn, 100+i, 1, "VeloElec");
					Requetes.insertEstDans(conn, 100+i, "Epinard");
					
				}
				if (i<16) {
					Requetes.insertVehicules(conn, 140+i, 2, "VoitureElec");
					Requetes.insertVehicules(conn, 170+i, 2, "VeloRemork");
					Requetes.insertEstDans(conn, 140+i, "Epinard");
					Requetes.insertEstDans(conn, 170+i, "Epinard");
				}
				if (i < 10) {
					Requetes.insertVehicules(conn, 200+i, 2, "Utilitaire");
					Requetes.insertEstDans(conn, 200+i, "Epinard");
				}
				break;
			}
			compteur += 1 % 11;
		}

		
		Requetes.insertAbonnes(conn, 1, "Bagou", "Claire", "08-07-1994", "2 rue Thomas Edison 38000 Grenoble");
		Requetes.insertAbonnes(conn, 2, "Le Net", "Dorian", "04-06-1994", "3 rue Gabriel Peri 38000 Grenoble");
		Requetes.insertAbonnes(conn, 3, "Nicolas", "Louise", "22-10-1995", "5 avenue Jules Flandrin 38000 Grenoble");
		Requetes.insertAbonnes(conn, 4, "Gaunet", "Cyril", "06-06-1960", "3 place de Verdun 38000 Grenoble");
		Requetes.insertAbonnes(conn, 5, "Bagou", "Jean-Paul", "09-11-1958", "10 avanue des Magatis 38000 Grenoble");
		Requetes.insertAbonnes(conn, 6, "Bagou", "Olivier", "06-11-1982", "4 clot de la Violette 38000 Grenoble");
		Requetes.insertAbonnes(conn, 7, "Touil", "Loubna", "13-06-1980", "3 place de la Madeleine 38000 Grenoble");
		Requetes.insertAbonnes(conn, 8, "Cerutti", "Nathalie", "01-06-1994", "2 avenue de la petite Chartreuse 38000 Grenoble");
		Requetes.insertAbonnes(conn, 9, "Ruaro", "Delphine", "21-06-1995", "3 rue de Puyricard 38000 Grenoble");
		Requetes.insertAbonnes(conn, 10, "James", "LeBron", "13-10-1983", "17 ruelle du Bagou 38000 Grenoble");
		Requetes.insertAbonnes(conn, 11, "Cesar", "Jules", "06-11-1993", "7 avenue de la Grande Depression 38000 Grenoble");
		Requetes.insertAbonnes(conn, 12, "Paul", "Paul", "27-01-1942", "24 avenue du Dragon du Groupe 38000 Grenoble");
		Requetes.insertAbonnes(conn, 13, "Quatorze", "Louis", "22-03-1999", "122 du Soleil 38000 Grenoble");
		Requetes.insertAbonnes(conn, 14, "Zidane", "Zinedine", "09-10-1974", "33 rue du Ballon 38000 Grenoble");
		Requetes.insertAbonnes(conn, 15, "Bagou", "Marc", "13-10-1973", "17 ruelle du Bagou 38000 Grenoble");
		Requetes.insertAbonnes(conn, 16, "Djokovic", "Novak", "26-10-1985", "16 avenue de la Joie 38000 Grenoble");
		Requetes.insertAbonnes(conn, 17, "Kira", "Sha", "13-11-1976", "22 rue du Tapas 38000 Grenoble");
		Requetes.insertAbonnes(conn, 18, "Lamar", "Kendrick", "14-08-1990", "190 rue des Champs Elysees 38000 Grenoble");
		Requetes.insertAbonnes(conn, 19, "Dupont", "Pierre", "30-10-1973", "46 rue des Arlequins 38000 Grenoble");
		Requetes.insertAbonnes(conn, 20, "Dupond", "Pierre", "01-12-1963", "73 rue des Arlequins 38000 Grenoble");
		Requetes.insertAbonnes(conn, 21, "Dupons", "Pierre", "31-05-1983", "22 rue des Arlequins 38000 Grenoble");
		Requetes.insertAbonnes(conn, 22, "Ferrari", "Laurence", "13-09-1979", "28 avenue du Roi Claude 38000 Grenoble");
		Requetes.insertAbonnes(conn, 23, "Heinsenberg", "Luc", "04-05-1959", "133 rue du Claire Obscur 38000 Grenoble");
		Requetes.insertAbonnes(conn, 24, "Parrat", "Morgan", "14-02-1993", "46 avenue du Seigneur Wagner 38000 Grenoble");
		Requetes.insertAbonnes(conn, 25, "Depardieu", "Gerard", "02-08-1960", "22 rue du Pape Gaunet 38000 Grenoble");
		Requetes.insertAbonnes(conn, 26, "Gainsbourg", "Charlotte", "06-11-1973", "46 avenue de l'Empereur Le Net 38000 Grenoble");
		Requetes.insertAbonnes(conn, 27, "Leray", "Philippe", "30-10-1973", "7 Cours Saint Mnacho 38000 Grenoble");
		Requetes.insertAbonnes(conn, 28, "Orsini", "Lucie", "03-08-1983", "48 Cours Saint Mnacho 38000 Grenoble");
		Requetes.insertAbonnes(conn, 29, "Keirle", "Sophie", "12-12-1996", "123 rue de la Princesse Nicolas 38000 Grenoble");
		Requetes.insertAbonnes(conn, 30, "Dallard", "Francois", "06-08-1999", "27 rue de la Princesse Nicolas 38000 Grenoble");
		Requetes.insertAbonnes(conn, 31, "Mazollini", "Marie", "14-10-1965", "46 avenue du General Hamm 38000 Grenoble");
		Requetes.insertAbonnes(conn, 32, "Delon", "Justine", "27-09-1979", "64 avenue du Generel Hamm 38000 Grenoble");
		Requetes.insertAbonnes(conn, 33, "Marquis", "Penelope", "09-07-1980", "137 rue du Roi Claude 38000 Grenoble");
		Requetes.insertAbonnes(conn, 34, "Georges", "Rachid", "01-03-1982", "74 rue du Roi Claude 38000 Grenoble");
		Requetes.insertAbonnes(conn, 35, "Lunardelli", "Rose", "30-08-1987", "50 rue du Roi Claude 38000 Grenoble");
		Requetes.insertAbonnes(conn, 36, "Gallet", "Jacques", "28-02-1975", "46 rue du Pape Gaunet 38000 Grenoble");
		Requetes.insertAbonnes(conn, 37, "Labourasse", "Gustave", "03-12-1958", "1 Cours Mnacho 38000 Grenoble");
		Requetes.insertAbonnes(conn, 38, "Mabouche", "Henri", "17-11-1949", "7 rue des Scorpions 38000 Grenoble");
		Requetes.insertAbonnes(conn, 39, "Lefort", "Maxime", "14-01-1979", "23 rue de la Petite Marchande 38000 Grenoble");
		Requetes.insertAbonnes(conn, 40, "Fer", "Odeline", "30-03-1991", "32 Quai des Reveurs 38000 Grenoble");
		
		// INSERER LES LOCATIONS
		
		// INSERER LES FORFAITS !!!!
		
		
		
	
		Requetes.commit(conn);
		
		
	}
}
