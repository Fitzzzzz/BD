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
		req.deleteTableContent("PlacesLibres");
		req.deleteTableContent("EstDans");
		req.deleteTableContent("Forfait2");
		req.deleteTableContent("Forfait1");
		req.deleteTableContent("Forfaits");
		req.deleteTableContent("Locations");
		req.deleteTableContent("Abonnes");
		req.deleteTableContent("Vehicules");
		req.deleteTableContent("Stations");
		req.deleteTableContent("CategoriesVehicules");
	
		
	
		
		
		
		
		
		
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

		
		req.insertAbonnes(1, "Bagou", "Claire", "19940708", "2 rue Thomas Edison 38000 Grenoble");
		req.insertAbonnes(2, "Le Net", "Dorian", "19950112", "3 rue Gabriel Peri 38000 Grenoble");
		req.insertAbonnes(3, "Nicolas", "Louise", "19951022", "5 avenue Jules Flandrin 38000 Grenoble");
		req.insertAbonnes(4, "Gaunet", "Cyril", "19600606", "3 place de Verdun 38000 Grenoble");
		req.insertAbonnes(5, "Bagou", "Jean-Paul", "19581109", "10 avanue des Magatis 38000 Grenoble");
		req.insertAbonnes(6, "Bagou", "Olivier", "19821106", "4 clot de la Violette 38000 Grenoble");
		req.insertAbonnes(7, "Touil", "Loubna", "19800613", "3 place de la Madeleine 38000 Grenoble");
		req.insertAbonnes(8, "Cerutti", "Nathalie", "19940601", "2 avenue de la petite Chartreuse 38000 Grenoble");
		req.insertAbonnes(9, "Ruaro", "Delphine", "19950625", "3 rue de Puyricard 38000 Grenoble");
		req.insertAbonnes(10, "James", "LeBron", "19831013", "17 ruelle du Bagou 38000 Grenoble");
		req.insertAbonnes(11, "Cesar", "Jules", "19931106", "7 avenue de la Grande Depression 38000 Grenoble");
		req.insertAbonnes(12, "Paul", "Paul", "19420127", "24 avenue du Dragon du Groupe 38000 Grenoble");
		req.insertAbonnes(13, "Quatorze", "Louis", "19990322", "122 du Soleil 38000 Grenoble");
		req.insertAbonnes(14, "Zidane", "Zinedine", "19741009", "33 rue du Ballon 38000 Grenoble");
		req.insertAbonnes(15, "Bagou", "Marc", "19731013", "17 ruelle du Bagou 38000 Grenoble");
		req.insertAbonnes(16, "Djokovic", "Novak", "19851026", "16 avenue de la Joie 38000 Grenoble");
		req.insertAbonnes(17, "Kira", "Sha", "19761113", "22 rue du Tapas 38000 Grenoble");
		req.insertAbonnes(18, "Lamar", "Kendrick", "19900814", "190 rue des Champs Elysees 38000 Grenoble");
		req.insertAbonnes(19, "Dupont", "Pierre", "19731030", "46 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(20, "Dupond", "Pierre", "19631201", "73 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(21, "Dupons", "Pierre", "19830531", "22 rue des Arlequins 38000 Grenoble");
		req.insertAbonnes(22, "Ferrari", "Laurence", "19790913", "28 avenue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(23, "Heinsenberg", "Luc", "19590504", "133 rue du Claire Obscur 38000 Grenoble");
		req.insertAbonnes(24, "Parrat", "Morgan", "19930214", "46 avenue du Seigneur Wagner 38000 Grenoble");
		req.insertAbonnes(25, "Depardieu", "Gerard", "19600802", "22 rue du Pape Gaunet 38000 Grenoble");
		req.insertAbonnes(26, "Gainsbourg", "Charlotte", "19731106", "46 avenue de lEmpereur Le Net 38000 Grenoble");
		req.insertAbonnes(27, "Leray", "Philippe", "19731030", "7 Cours Saint Mnacho 38000 Grenoble");
		req.insertAbonnes(28, "Orsini", "Lucie", "19830803", "48 Cours Saint Mnacho 38000 Grenoble");
		req.insertAbonnes(29, "Keirle", "Sophie", "19961212", "123 rue de la Princesse Nicolas 38000 Grenoble");
		req.insertAbonnes(30, "Dallard", "Francois", "19990806", "27 rue de la Princesse Nicolas 38000 Grenoble");
		req.insertAbonnes(31, "Mazollini", "Marie", "19651014", "46 avenue du General Hamm 38000 Grenoble");
		req.insertAbonnes(32, "Delon", "Justine", "19790927", "64 avenue du Generel Hamm 38000 Grenoble");
		req.insertAbonnes(33, "Marquis", "Penelope", "19800709", "137 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(34, "Georges", "Rachid", "19820301", "74 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(35, "Lunardelli", "Rose", "19870830", "50 rue du Roi Claude 38000 Grenoble");
		req.insertAbonnes(36, "Gallet", "Jacques", "19750228", "46 rue du Pape Gaunet 38000 Grenoble");
		req.insertAbonnes(37, "Labourasse", "Gustave", "19581203", "1 Cours Mnacho 38000 Grenoble");
		req.insertAbonnes(38, "Mabouche", "Henri", "19491117", "7 rue des Scorpions 38000 Grenoble");
		req.insertAbonnes(39, "Lefort", "Maxime", "19790114", "23 rue de la Petite Marchande 38000 Grenoble");
		req.insertAbonnes(40, "Fer", "Odeline", "19910330", "32 Quai des Reveurs 38000 Grenoble");
		
		// INSERER LES LOCATIONS
		
		// INSERER LES FORFAITS !!!!
		// Test de location au pif
		
		// AUTO INCREMENTATION A RAJOUTEEEEEEEEEEEEEEEER 
		req.insertLocations(1, "20131025", 5, 1, 7, "Patate");
		req.finLocation(1, 12, "Navet");
	
		req.commit();
		conn.close();
		
	}
}
