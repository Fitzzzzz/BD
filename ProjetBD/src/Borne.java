/**
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Borne {

	private String nomStation;
	private Scanner sc;
	private Boolean newClient;
	private Requetes requests;
	private int CB;
	

	public Borne(String nomStation, Requetes requests) {
		
		this.requests = requests;
		this.nomStation = nomStation;
	}
	
	/**
	 * Welcome message printed on the interface.
	 * The user has to say if he or she is a new client 
	 */
	public void welcome() {
		this.sc = new Scanner(System.in);

		System.out.println("Bonjour et bienvenue chez esCARgo!");

		
		
		boolean repondu = false;
		System.out.println("Etes-vous êtes déjà client chez nous? (O/n)");
		
		
		
		LinkedList<String> answers = new LinkedList<String>();

		answers.add("O");
		answers.add("n");
		String answer = sc.nextLine();
		repondu = expectedResult(answer, answers);
		while (!repondu) {
			System.out.println("Veuillez répondre par O ou n.");
			System.out.println("Etes-vous êtes déjà client chez nous? (O/n)");
			repondu = expectedResult(sc.nextLine(), answers);
		}
		if (answer.equals("O")) {
			this.newClient = false;
		}
		else {
			this.newClient = true;
		}
		
		if (newClient) {
			createAccount();
		}
		else {
			System.out.println("Veuillez entrer votre numéro de CB.");
			this.CB = Integer.parseInt(sc.nextLine());
		}
	
	}
	
	
	/**
	 * Create an account if the user is a new client
	 */
	public void createAccount() {
		
		System.out.println("Veuillez donner votre nom");
		String name = sc.nextLine();
		System.out.println("Veuillez donner votre prénom");
		String vorName = sc.nextLine();
		System.out.println("Veuillez donner votre date de naissance au format yyyy");
		String birthDate = sc.next();
		System.out.println("Veuillez donner votre adresse.");
		String adress = sc.next();
		System.out.println("Veuillez donner votre numéro de carte bancaire.");
		this.CB = Integer.parseInt(sc.nextLine());
		try {
			requests.insertAbonnes(CB, name, vorName, birthDate, adress);
		} catch (SQLException e) {
			System.out.println("Vous avez déjà un compte chez nous! Vos données n'ont pas été mises à jour");
		}
		
	}
	

	/**
	 * Return of a vehicule in a station
	 */
	public void depotVehicule() {
		
		try {
			int numLoc = requests.findLocation(CB);
			
			
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			Date dateobj = new Date();
			
			
			
			// a rajouter : recup la date dans un string et le mettre dans 
			// dans les param de l'appel de finLoc
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			requests.finLocation(numLoc, dateFormat.format(cal), df.format(dateobj), this.nomStation);
		} catch (SQLException e) {
			System.out.println("Vous n'avez pas de location en cours.");
		}
	}
	

	
	/**
	 * Create a new Package for a client
	 * @throws SQLException 
	 */
	public void subscribeToNewForfait() throws SQLException {

		
		// FIRFAUT1 : ILLIMITE PDT DUREE LIMITE 
		// FORFAIT2 :
		
		System.out.println("Voulez un forfait à durée limité et usages illimités ou un forfait à durée illimité mais à usage limité? (1/2)");
		int forfait = Integer.parseInt(sc.next());
		
		
		
		
		switch (forfait) {
		case 1:
			System.out.println("Pour quelle catégories de véhicules voulez-vous votre forfait?");
			System.out.println("1) Velo");
			System.out.println("2) Velo électrique");
			System.out.println("3) Voiture électrique");
			System.out.println("4) Vélo à remorque");
			System.out.println("5) Véhicule utilitaire");
			int categorie = Integer.parseInt(sc.next());
			String cat= "";
			switch (categorie) {
			
			case 1:
				cat = "Velo";
				break;
			case 2:
				cat = "VeloElec";
				break;
			case 3:
				cat = "VoitureElec";
				break;
			case 4:
				cat = "VeloRemork";
				break;
			case 5:
				cat = "Utilitaire";
				break;
			default:
				subscribeToNewForfait();
				return;
			}	
			if (!requests.alreadyGotForfait1(CB, cat)) {
				Date today = new Date();
				Calendar calendar = Calendar.getInstance();         
				calendar.setTime(today);
				calendar.add(Calendar.MONTH, 1);
				Date nextMonth = calendar.getTime();
				int idForfait = requests.getMaxIdForfait() + 1;
				this.requests.insertForfaits1(
						idForfait, cat, CB, 
						new SimpleDateFormat("yyyyMMdd").format(today), 
						new SimpleDateFormat("yyyyMMdd").format(nextMonth));
				requests.makePayement(idForfait, CB);
				System.out.println("Votre forfait a été créé.");
				
			}
			else {
				System.out.println("Vous avez déjà un forfait de ce type en cours de validité.");
				welcome();
				return;
			}
			break;
		case 2:
			System.out.println("Pour quelle catégories de véhicules voulez-vous votre forfait?");
			System.out.println("1) Velo");
			System.out.println("2) Velo électrique");
			System.out.println("3) Voiture électrique");
			System.out.println("4) Vélo à remorque");
			System.out.println("5) Véhicule utilitaire");
			int categorie2 = Integer.parseInt(sc.next());
			String cat2 = "";
			switch (categorie2) {
			
			case 1:
				cat = "Velo";
				break;
			case 2:
				cat = "VeloElec";
				break;
			case 3:
				cat = "VoitureElec";
				break;
			case 4:
				cat = "VeloRemork";
				break;
			case 5:
				cat = "Utilitaire";
				break;
			default:
				subscribeToNewForfait();
				return;
			}
			break;
			
		default:
			subscribeToNewForfait();
			return;
		}
		
		
		
		
	
		
	}
	
	public void processLocation() throws SQLException {
		
		System.out.println("Quel type de véhicule voulez-vous louer?");
		System.out.println("1) Velo");
		System.out.println("2) Velo électrique");
		System.out.println("3) Voiture électrique");
		System.out.println("4) Vélo à remorque");
		System.out.println("5) Véhicule utilitaire");
		int categorie = Integer.parseInt(sc.next());

		String cat = "";
		switch (categorie) {
		
		case 1:
			cat = "Velo";
			break;
		case 2:
			cat = "VeloElec";
			break;
		case 3:
			cat = "VoitureElec";
			break;
		case 4:
			cat = "VeloRemork";
			break;
		case 5:
			cat = "Utilitaire";
			break;
		default:
			welcome();
			return;
		}	
		if (requests.alreadyGotForfait1(CB, cat)) {
			ResultSet rs = requests.location(this.nomStation, cat);
			if (rs == null) {
				System.out.println("Désolé, il n'y a pas de véhicules de ce type disponible ici.");
				welcome();
				return;
			}
			else {
				int idVehicule = rs.getInt(1);
				Date today = new Date();
				
				int numLoc = requests.getMaxNumLoc() + 1;
				requests.insertLocations(numLoc, new SimpleDateFormat("yyyyMMdd").format(today), new SimpleDateFormat("HH:mm:ss").format(today), idVehicule, CB, this.nomStation);
				requests.deleteFromEstDans(idVehicule);
			}
		}
		else if (requests.alreadyGotForfait2(CB, cat)) {
			ResultSet rs = requests.location(this.nomStation, cat);
			if (rs == null) {
				System.out.println("Désolé, il n'y a pas de véhicules de ce type disponible ici.");
				welcome();
				return;
			}
			else {
				int idVehicule = rs.getInt(1);
				Date today = new Date();
				
				int numLoc = requests.getMaxNumLoc() + 1;
				requests.insertLocations(numLoc, new SimpleDateFormat("yyyyMMdd").format(today), new SimpleDateFormat("HH:mm:ss").format(today), idVehicule, CB, this.nomStation);
				requests.deleteFromEstDans(idVehicule);
			}
		}
		
	}
	
	

	
	
	
	/**
	 * Ask the user what he or she wants to do
	 * @throws SQLException 
	 */
	public void whatDoYouWannaDo() throws SQLException {

		
		System.out.println("Choisissez votre demande : (1/2/3) ");
		System.out.println("1) Je souhaite effectuer une location.");
		System.out.println("2) Je souhaite prendre un nouveau forfait.");
		System.out.println("3) Je souhaite déposer mon véhicule de location.");
		
		
		int choice = Integer.parseInt(sc.nextLine());
		
		switch (choice) {
		case 3:
			depotVehicule();
			break;
		case 2:
			this.subscribeToNewForfait();
			break;
		case 1:
			break;
		default:
			whatDoYouWannaDo();
		}
	}

	
	/**
	 * Check if the anwser is the anwser expected
	 * @return true if it is an expected anwser
	 */
	public Boolean expectedResult(String answer, LinkedList<String> acceptableAnswers) {
		
		Boolean found = false;
		Iterator<String> itr = acceptableAnswers.iterator();
		while (!found && itr.hasNext()) {
			if (itr.equals(answer)) {
				found = true;
			}
			itr.next();
		}
		return found;
		
		
	}
		
}
