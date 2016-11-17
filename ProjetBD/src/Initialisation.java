import java.sql.*;
public class Initialisation {
	public static void initBase (Connection conn) throws SQLException {
		
		Requetes req = new Requetes(conn);
		req.setautocommit();
		if (!req.tableExists("CategoriesVehicules")) {
		req.createTableCategories();

		}
		if (!req.tableExists("Stations")) {
			req.createTableStations();
		}
		if (!req.tableExists("Vehicules")) {
			req.createTableVehicules();
		}
		if (!req.tableExists("Abonnes")) {
			req.createTableAbonnes();
		}
		if (!req.tableExists("Locations")) {
			req.createTableLocations();
		}
		if (!req.tableExists("Forfaits")) {
			req.createTableForfaits();
		}
		if (!req.tableExists("Forfait1")) {
			req.createTableForfait1();
		}
		if (!req.tableExists("Forfait2")) {
			req.createTableForfaits2();
		}
		if (!req.tableExists("EstDans")) {
			req.createTableEstDans();
		}
		if (!req.tableExists("PlacesLibres")) {
			req.createTablePlacesLibres();
		}
		
		req.deleteTableContent("CategoriesVehicules");
		req.deleteTableContent("Stations");
		req.deleteTableContent("Vehicules");
		req.deleteTableContent("Abonnes");
		req.deleteTableContent("Locations");
		req.deleteTableContent("Forfaits");
		req.deleteTableContent("Forfait1");
		req.deleteTableContent("Forfait2");
		req.deleteTableContent("EstDans");
		req.deleteTableContent("PlacesLibres");
		
		req.insertCategorieVehicule("Velo", 5, 1, 10);
		req.insertCategorieVehicule("VeloElec", 5, 2, 20);
		req.insertCategorieVehicule("VoitureElec", 5, 4, 40);
		req.insertCategorieVehicule("VeloRemork", 5, 3, 30);
		req.insertCategorieVehicule("Utilitaire", 5, 5, 50);
		
		 
		req.insertStation("Patate", "3 avenue de l Empereur Le Net");
		req.insertStation("Navet", "7 ruelle du Bagou");
		req.insertStation("Carotte", "6 rue de la Princesse Nicolas");
		req.insertStation("Radis", "144 rue du Pape Gaunet");
		req.insertStation("Choux Fleur", "14 avenue du General Hamm");
		req.insertStation("Poix Chiche", "17 rue des Arlequins");
		req.insertStation("Courge", "133 avenue du Seigneur Wagner");
		req.insertStation("Poireau", "6 rue des Champs Elysees");
		req.insertStation("Aubergine", "1 Cours Saint Mnacho");
		req.insertStation("Cornichon", "32 rue du Claire Obscur");
		req.insertStation("Epinard", "17 avenue du Roi Claude");

		
		req.insertPlacesLibres("Patate", 50, "Velo");
		req.insertPlacesLibres("Navet", 50, "Velo");
		req.insertPlacesLibres("Carotte", 50, "Velo");
		req.insertPlacesLibres("Radis", 50, "Velo");
		req.insertPlacesLibres("Choux Fleur", 50, "Velo");
		req.insertPlacesLibres("Poix Chiche", 50, "Velo");
		req.insertPlacesLibres("Courge", 50, "Velo");
		req.insertPlacesLibres("Poireau", 50, "Velo");
		req.insertPlacesLibres("Aubergine", 50, "Velo");
		req.insertPlacesLibres("Cornichon", 50, "Velo");
		req.insertPlacesLibres("Epinard", 50, "Velo");
		
		req.insertPlacesLibres("Patate", 10, "VeloElec");
		req.insertPlacesLibres("Navet", 10, "VeloElec");
		req.insertPlacesLibres("Carotte", 10, "VeloElec");
		req.insertPlacesLibres("Radis", 10, "VeloElec");
		req.insertPlacesLibres("Choux Fleur", 10, "VeloElec");
		req.insertPlacesLibres("Poix Chiche", 10, "VeloElec");
		req.insertPlacesLibres("Courge", 10, "VeloElec");
		req.insertPlacesLibres("Poireau", 10, "VeloElec");
		req.insertPlacesLibres("Aubergine", 10, "VeloElec");
		req.insertPlacesLibres("Cornichon", 10, "VeloElec");
		req.insertPlacesLibres("Epinard", 10, "VeloElec");
		
		req.insertPlacesLibres("Patate", 5, "VoitureElec");
		req.insertPlacesLibres("Navet", 10, "VoitureElec");
		req.insertPlacesLibres("Carotte", 5, "VoitureElec");
		req.insertPlacesLibres("Radis", 10, "VoitureElec");
		req.insertPlacesLibres("Choux Fleur", 10, "VoitureElec");
		req.insertPlacesLibres("Poix Chiche", 15, "VoitureElec");
		req.insertPlacesLibres("Courge", 10, "VoitureElec");
		req.insertPlacesLibres("Poireau", 5, "VoitureElec");
		req.insertPlacesLibres("Aubergine", 10, "VoitureElec");
		req.insertPlacesLibres("Cornichon", 10, "VoitureElec");
		req.insertPlacesLibres("Epinard", 10, "VoitureElec");
		
		req.insertPlacesLibres("Patate", 10, "VeloRemork");
		req.insertPlacesLibres("Navet", 5, "VeloRemork");
		req.insertPlacesLibres("Carotte", 5, "VeloRemork");
		req.insertPlacesLibres("Radis", 20, "VeloRemork");
		req.insertPlacesLibres("Choux Fleur", 5, "VeloRemork");
		req.insertPlacesLibres("Poix Chiche", 5, "VeloRemork");
		req.insertPlacesLibres("Courge", 10, "VeloRemork");
		req.insertPlacesLibres("Poireau", 10, "VeloRemork");
		req.insertPlacesLibres("Aubergine", 10, "VeloRemork");
		req.insertPlacesLibres("Cornichon", 10, "VeloRemork");
		req.insertPlacesLibres("Epinard", 5, "VeloRemork");
		
		req.insertPlacesLibres("Patate", 12, "Utilitaire");
		req.insertPlacesLibres("Navet", 13, "Utilitaire");
		req.insertPlacesLibres("Carotte", 5, "Utilitaire");
		req.insertPlacesLibres("Radis", 5, "Utilitaire");
		req.insertPlacesLibres("Choux Fleur", 5, "Utilitaire");
		req.insertPlacesLibres("Poix Chiche", 5, "Utilitaire");
		req.insertPlacesLibres("Courge", 5, "Utilitaire");
		req.insertPlacesLibres("Poireau", 5, "Utilitaire");
		req.insertPlacesLibres("Aubergine", 10, "Utilitaire");
		req.insertPlacesLibres("Cornichon", 7, "Utilitaire");
		req.insertPlacesLibres("Epinard", 4, "Utilitaire");
		
		
		
		
		
		int compteur = 0;
		for (int i = 0; i < 101; i++) {
			req.insertVehicules(i, 1, "Velo");
			
			switch (compteur) {
			case 1: 
				req.insertEstDans(i, "Patate");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Patate");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Patate");
					req.insertEstDans(170+i, "Patate");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Patate");
				}
				break;
			case 2: 
				req.insertEstDans(i, "Navet");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Navet");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Navet");
					req.insertEstDans(170+i, "Navet");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Navet");
				}
				break;
			case 3: 
				req.insertEstDans(i, "Carotte");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Carotte");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Carotte");
					req.insertEstDans(170+i, "Carotte");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Carotte");
				}
				break;
			case 4: 
				
				req.insertEstDans(i, "Radis");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Radis");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Radis");
					req.insertEstDans(170+i, "Radis");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Radis");
				}
				break;
			case 5: 
				req.insertEstDans(i, "Choux Fleur");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Choux Fleur");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Choux Fleur");
					req.insertEstDans(170+i, "Choux Fleur");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Choux Fleur");
				}
				break;
			case 6: 
				req.insertEstDans(i, "Poix Chiche");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Choux Fleur");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Choux Fleur");
					req.insertEstDans(170+i, "Choux Fleur");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Choux Fleur");
				}
				break;
			case 7: 
				req.insertEstDans(i, "Courge");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Courge");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Courge");
					req.insertEstDans(170+i, "Courge");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Courge");
				}
				break;
			case 8: 
				req.insertEstDans(i, "Poireau");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Poireau");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Poireau");
					req.insertEstDans(170+i, "Poireau");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Poireau");
				}
				break;
			case 9: 
				req.insertEstDans(i, "Aubergine");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Aubergine");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Aubergine");
					req.insertEstDans(170+i, "Aubergine");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Aubergine");
				}
				break;
			case 10: 
				req.insertEstDans(i, "Cornichon");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Cornichon");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Cornichon");
					req.insertEstDans(170+i, "Cornichon");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Cornichon");
				}
				break;
			case 11: 
				req.insertEstDans(i, "Epinard");
				if (i<31) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDans(100+i, "Epinard");
					
				}
				if (i<16) {
					req.insertVehicules(140+i, 2, "VoitureElec");
					req.insertVehicules(170+i, 2, "VeloRemork");
					req.insertEstDans(140+i, "Epinard");
					req.insertEstDans(170+i, "Epinard");
				}
				if (i < 10) {
					req.insertVehicules(200+i, 2, "Utilitaire");
					req.insertEstDans(200+i, "Epinard");
				}
				break;
			}
			compteur += 1 % 11;
		}

		
		req.insertAbonnes(1, "Bagou", "Claire", "08-07-1994", "2 rue Thomas Edison 38000 Grenoble");
		req.insertAbonnes(2, "Le Net", "Dorian", "12-01-1995", "3 rue Gabriel Peri 38000 Grenoble");
		req.insertAbonnes(3, "Nicolas", "Louise", "22-10-1995", "5 avenue Jules Flandrin 38000 Grenoble");
		req.insertAbonnes(4, "Gaunet", "Cyril", "06-06-1960", "3 place de Verdun 38000 Grenoble");
		req.insertAbonnes(5, "Bagou", "Jean-Paul", "09-11-1958", "10 avanue des Magatis 38000 Grenoble");
		req.insertAbonnes(6, "Bagou", "Olivier", "06-11-1982", "4 clot de la Violette 38000 Grenoble");
		req.insertAbonnes(7, "Touil", "Loubna", "13-06-1980", "3 place de la Madeleine 38000 Grenoble");
		req.insertAbonnes(8, "Cerutti", "Nathalie", "01-06-1994", "2 avenue de la petite Chartreuse 38000 Grenoble");
		req.insertAbonnes(9, "Ruaro", "Delphine", "21-06-1995", "3 rue de Puyricard 38000 Grenoble");
		req.insertAbonnes(10, "James", "LeBron", "13-10-1983", "17 ruelle du Bagou 38000 Grenoble");
		req.insertAbonnes(11, "Cesar", "Jules", "06-11-1993", "7 avenue de la Grande Depression 38000 Grenoble");
		req.insertAbonnes(12, "Paul", "Paul", "27-01-1942", "24 avenue du Dragon du Groupe 38000 Grenoble");
		req.insertAbonnes(13, "Quatorze", "Louis", "22-03-1999", "122 du Soleil 38000 Grenoble");
		req.insertAbonnes(14, "Zidane", "Zinedine", "09-10-1974", "33 rue du Ballon 38000 Grenoble");
		req.insertAbonnes(15, "Bagou", "Marc", "13-10-1973", "17 ruelle du Bagou 38000 Grenoble");
		req.insertAbonnes(16, "Djokovic", "Novak", "26-10-1985", "16 avenue de la Joie 38000 Grenoble");
		req.insertAbonnes(17, "Kira", "Sha", "13-11-1976", "22 rue du Tapas 38000 Grenoble");
		req.insertAbonnes(18, "Lamar", "Kendrick", "14-08-1990", "190 rue des Champs Elysees 38000 Grenoble");
		req.insertAbonnes(19, "Dupont", "Pierre", "30-10-1973", "46 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(20, "Dupond", "Pierre", "01-12-1963", "73 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(21, "Dupons", "Pierre", "31-05-1983", "22 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(22, "Ferrari", "Laurence", "13-09-1979", "28 avenue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(23, "Heinsenberg", "Luc", "04-05-1959", "133 rue du Claire Obscur 38000 Grenoble");
		req.insertAbonnes(24, "Parrat", "Morgan", "14-02-1993", "46 avenue du Seigneur Wagner 38000 Grenoble");
		req.insertAbonnes(25, "Depardieu", "Gerard", "02-08-1960", "22 rue du Pape Gaunet 38000 Grenoble");
		req.insertAbonnes(26, "Gainsbourg", "Charlotte", "06-11-1973", "46 avenue de l'Empereur Le Net 38000 Grenoble");
		req.insertAbonnes(27, "Leray", "Philippe", "30-10-1973", "7 Cours Saint Mnacho 38000 Grenoble");
		req.insertAbonnes(28, "Orsini", "Lucie", "03-08-1983", "48 Cours Saint Mnacho 38000 Grenoble");
		req.insertAbonnes(29, "Keirle", "Sophie", "12-12-1996", "123 rue de la Princesse Nicolas 38000 Grenoble");
		req.insertAbonnes(30, "Dallard", "Francois", "06-08-1999", "27 rue de la Princesse Nicolas 38000 Grenoble");
		req.insertAbonnes(31, "Mazollini", "Marie", "14-10-1965", "46 avenue du General Hamm 38000 Grenoble");
		req.insertAbonnes(32, "Delon", "Justine", "27-09-1979", "64 avenue du Generel Hamm 38000 Grenoble");
		req.insertAbonnes(33, "Marquis", "Penelope", "09-07-1980", "137 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(34, "Georges", "Rachid", "01-03-1982", "74 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(35, "Lunardelli", "Rose", "30-08-1987", "50 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(36, "Gallet", "Jacques", "28-02-1975", "46 rue du Pape Gaunet 38000 Grenoble");
		req.insertAbonnes(37, "Labourasse", "Gustave", "03-12-1958", "1 Cours Mnacho 38000 Grenoble");
		req.insertAbonnes(38, "Mabouche", "Henri", "17-11-1949", "7 rue des Scorpions 38000 Grenoble");
		req.insertAbonnes(39, "Lefort", "Maxime", "14-01-1979", "23 rue de la Petite Marchande 38000 Grenoble");
		req.insertAbonnes(40, "Fer", "Odeline", "30-03-1991", "32 Quai des Reveurs 38000 Grenoble");
		
		// INSERER LES LOCATIONS
		
		// INSERER LES FORFAITS !!!!
		
		
		
	
		req.commit();
		
		
	}
}
