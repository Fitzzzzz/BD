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









		req.insertCategorieVehicule("Velo", 5, 1, 10, 10);
		req.insertCategorieVehicule("VeloElec", 5, 2, 15, 20);
		req.insertCategorieVehicule("VoitureElec", 5, 4, 40, 40);
		req.insertCategorieVehicule("VeloRemork", 5, 3, 25, 30);
		req.insertCategorieVehicule("Utilitaire", 5, 5, 50, 50);


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
		for (int i = 0; i < 100; i++) {
			req.insertVehicules(i, 1, "Velo");
			System.out.println(compteur);
			switch (compteur) {
			case 0: 
				req.insertEstDansInit(i, "Patate");
				if (i<30){
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Patate");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Patate");
					req.insertEstDansInit(145+i, "Patate");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Patate");
				}
				break;
			case 1: 
				req.insertEstDansInit(i, "Navet");
				if (i<30){
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Navet");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Navet");
					req.insertEstDansInit(145+i, "Navet");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Navet");
				}
				break;
			case 2: 
				req.insertEstDansInit(i, "Carotte");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Carotte");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Carotte");
					req.insertEstDansInit(145+i, "Carotte");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Carotte");
				}
				break;
			case 3: 

				req.insertEstDansInit(i, "Radis");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Radis");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Radis");
					req.insertEstDansInit(145+i, "Radis");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Radis");
				}
				break;
			case 4: 
				req.insertEstDansInit(i, "Choux Fleur");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Choux Fleur");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Choux Fleur");
					req.insertEstDansInit(145+i, "Choux Fleur");
				}
				if (i<10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Choux Fleur");
				}
				break;
			case 5: 
				req.insertEstDansInit(i, "Poix Chiche");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Poix Chiche");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Poix Chiche");
					req.insertEstDansInit(145+i, "Poix Chiche");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Poix Chiche");
				}
				break;
			case 6: 
				req.insertEstDansInit(i, "Courge");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Courge");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Courge");
					req.insertEstDansInit(145+i, "Courge");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Courge");
				}
				break;
			case 7: 
				req.insertEstDansInit(i, "Poireau");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Poireau");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Poireau");
					req.insertEstDansInit(145+i, "Poireau");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Poireau");
				}
				break;
			case 8: 
				req.insertEstDansInit(i, "Aubergine");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Aubergine");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Aubergine");
					req.insertEstDansInit(145+i, "Aubergine");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Aubergine");
				}
				break;
			case 9: 
				req.insertEstDansInit(i, "Cornichon");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Cornichon");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Cornichon");
					req.insertEstDansInit(145+i, "Cornichon");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Cornichon");
				}
				break;
			case 10: 
				req.insertEstDansInit(i, "Epinard");
				if (i<30) {
					req.insertVehicules(100+i, 1, "VeloElec");
					req.insertEstDansInit(100+i, "Epinard");

				}
				if (i<15) {
					req.insertVehicules(130+i, 2, "VoitureElec");
					req.insertVehicules(145+i, 2, "VeloRemork");
					req.insertEstDansInit(130+i, "Epinard");
					req.insertEstDansInit(145+i, "Epinard");
				}
				if (i < 10) {
					req.insertVehicules(160+i, 2, "Utilitaire");
					req.insertEstDansInit(160+i, "Epinard");
				}
				break;
				
			}
			compteur = (compteur + 1) % 11;
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

		// INSERER LES FORFAITS !!!!
		/*	aits1(int idForfait, 
				   String CatVehicule, int numCB,
				   int dureeForfait, 
				   Date debutValidite,

		 *2(int idForfait,
									   String CatVehicule, int numCB,
									   int nbMaxLocations, */

		
		req.insertForfaits1 (1, "Utilitaire" , 4, "20161101", "20161201");
		req.insertForfaits2 (2, "Velo", 1, 4, "20161009");
		req.insertForfaits2 (3, "VeloRemork", 2, 5, "20161019");
		req.insertForfaits1 (4, "VeloRemork", 3, "20161001", "20161201");
		req.insertForfaits2(5, "Velo", 14, 10, "20161029");
		req.insertForfaits2(6, "VeloRemork", 10, 8, "20161009");
		req.insertForfaits2(7, "VeloElec", 37, 10, "20161009");
		req.insertForfaits2(8, "Utilitaire", 22, 3, "20161009");
		req.insertForfaits2(9, "Velo", 25, 5, "20161009");
		req.insertForfaits2(10, "VeloRemork", 17, 3, "20161009");
		req.insertForfaits2(11, "Utilitaire", 19, 15, "20161009");
		req.insertForfaits2(12, "VoitureElec", 4, 7, "20161009");
		req.insertForfaits2(13, "VeloElec", 4, 4, "20161009");

		
		req.insertLocations(1, "20161116", "21:00:00", 161, 4, "Navet");
		req.insertLocations(2, "20161120", "06:00:00", 0, 1, "Patate");
		req.insertLocations(3, "20161119", "13:00:00", 153, 2, "Aubergine");
		req.insertLocations(4, "20161122", "03:00:00", 136, 3, "Courge");
		req.insertLocations(5, "20161121", "21:00:00", 20, 14, "Cornichon");
		req.insertLocations(6, "20160130", "01:00:00", 155, 10, "Epinard");
		req.insertLocations(7, "20160305", "12:00:00", 105, 37, "Poix Chiche");
		req.insertLocations(8, "20160807", "05:00:00", 163, 22, "Radis");
		req.insertLocations(9, "20161226", "11:00:00", 18, 25, "Poireau");
		req.insertLocations(10, "20160203", "04:00:00", 147, 17,  "Carotte");
		req.insertLocations(11, "20160425", "14:00:00", 164, 19, "Choux Fleur");
		req.insertLocations(12, "20160701", "06:00:00", 134, 4, "Choux Fleur");
		req.insertLocations(13, "20160909", "01:00:00", 109, 4, "Cornichon");

		// INSERER LES FINS DE LOC
		//regarde si ca fonctionne bien
		req.insertLocations(50, "20160908", "01:00:00", 100, 30, "Patate");
		req.finLocation(50, "20160908", "03:00:00", "Patate");
		req.insertLocations(51, "20160909", "01:00:00", 100, 30, "Patate");
		req.finLocation(51, "20160909", "13:00:00", "Patate");
		req.insertLocations(52, "20160910", "11:00:00", 100, 30, "Patate");
		req.finLocation(52, "20160910", "15:00:00", "Patate");
		

		req.commit();
		
		/*System.out.println(req.facturation(4));
		System.out.println(req.facturation(12));*/
		


	}
}
