import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Choose a random word for the Hangman
		mot word=new mot();
		word.ChooseRandomWord();
		System.out.println("HANGMAN en java");
		Hangman hangman = new Hangman();
		
		//Create the Player
		Player player = new Player();
		
		//Create a Hangman
		System.out.println(hangman.toString());
		hangman.displayWord();
		
		// Faire menu
		// afficher le mot en tirets
		// demander à l'utilisateur de saisir une entrée
		// se servir des autres classes pour détecter la présence du mot/de la lettre
		// réafficher le mot en tirets mis à jour
		
		/* --- MENU --- */
		while (true) {
			System.out.println("Voici la liste des options :");
			System.out.println("1- Saisir une lettre 1");
			System.out.println("2- Quitter sans sauvegarder");
			System.out.println("3- Quitter en sauvegardant");
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Entrez votre choix : ");
			String userChoice = scanner.nextLine();
			System.out.println("Vous avez entré : " + userChoice);
			
			if (userChoice.equals("1")) {
				//scanner.close();
		
				Scanner scannerLetter = new Scanner(System.in);
				System.out.print("Entrez votre choix : ");
				String userLetter = scannerLetter.nextLine();
				System.out.println("Vous avez entré : " + userLetter);
				player.setLetter(userLetter);
				System.out.println("Letter of the player " + player.getLetter());
				if (hangman.isInside(userLetter)) {
					System.out.println("La lettre choisie est dans le mot");
				} else {
					System.out.println("La lettre choisie n'est pas dans le mot");
				}
				break;
			}
		}
		System.out.println("FIN");
	}
}
