
public class Main {

	public static void main(String[] args) {
		//Choose a random word for the Hangman
		mot word=new mot();
		word.ChooseRandomWord();
		System.out.println("HANGMAN en java");
<<<<<<< HEAD
		
		//Create the Player
		Player player = new Player();
		
		//Create a Hangman
=======
>>>>>>> fa4955498dc1b4550705b6c56baed182b756ab3d
		Hangman hangman = new Hangman("HELLOWORLD");
		System.out.println(hangman.toString());
		
		// Faire menu
		// afficher le mot en tirets
		// demander à l'utilisateur de saisir une entrée
		// se servir des autres classes pour détecter la présence du mot/de la lettre
		// réafficher le mot en tirets mis à jour
	}
}
