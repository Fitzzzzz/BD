

import java.sql.SQLException;
import java.util.Calendar;
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
		this.sc = new Scanner(System.in);
	}
	
	public void welcome() {
		
		System.out.println("Bonjour et bienvenue chez esCARgo!");
		
		
		Boolean repondu = false;
		System.out.println("Etes-vous êtes déjà client chez nous? (O/n)");
		
		
		
		LinkedList<String> answers = new LinkedList<>();
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
	

	public void depotVehicule() {
		
		try {
			int numLoc = requests.findLocation(CB);
			Calendar rightNow = Calendar.getInstance();
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			// a rajouter : recup la date dans un string et le mettre dans 
			// dans les param de l'appel de finLoc
			requests.finLocation(numLoc, hour, this.nomStation);
		} catch (SQLException e) {
			System.out.println("Vous n'avez pas de location en cours.");
		}
		
		
	}
	
	public void subscribeToNewForfait() {
		
		// FIRFAUT1 : ILLIMITE PDT DUREE LIMITE 
		// FORFAIT2 :
		
		System.out.println("Voulez un forfait à durée limité et usages illimités ou un forfait à durée illimité mais à usage limité? (1/2)");
		int forfait = Integer.parseInt(sc.next());
		
		
		
		
		switch (forfait) {
		case 1:
			
			break;
		case 2:
			
			break;
			
		default:
			subscribeToNewForfait();
			return;
		}
		
		System.out.println("Pour quelle catégories de véhicules voulez-vous votre forfait?");
		System.out.println("1) Velo");
		System.out.println("2) Velo électrique");
		System.out.println("3) Voiture électrique");
		System.out.println("4) Vélo à remorque");
		System.out.println("5) Véhicule utilitaire");
		int categorie = Integer.parseInt(sc.next());
		
		
		
	}
	
	public void whatDoYouWannaDo() {
		
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
			
			break;
		case 1:
			break;
		default:
			whatDoYouWannaDo();
		}
	}

	
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
