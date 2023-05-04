import java.util.Scanner;

public class App {
	private String name;
	String[] wordList = {
			"banc",
			"bureau",
			"cabinet",
			"carreau",
			"chaise",
			"classe",
			"cle",
			"coin",
			"couloir",
			"dossier",
			"eau",
			"ecole",
			"ecriture",
			"entree",
			"escalier",
			"etagere",
			"etude",
			"exterieur",
			"fenetre",
			"interieur",
			"lavabo",
			"lecture",
			"lit",
			"marche",
			"matelas",
			"maternelle",
			"meuble",
			"mousse",
			"mur",
			"porte",
			"portemanteau",
			"poubelle",
			"radiateur",
			"rampe",
			"recreation",
			"rentree",
			"toilette"
	};
	
	public App(String name) {
		this.name = name;
	}
	
	public String getRandomWord() {
		/*System.out.println("Mot au hasard");
		return "RANDOM MOT";*/
		int randomIndex = (int) (Math.random() * wordList.length);
		String randomWord = wordList[randomIndex];
		return randomWord;
	}

	public void Menu() {
		// Choisir un mot au hasard
		FileManager filemanager = new FileManager("mots.txt");
		filemanager.chooseWord();

		// Player 
		Player player = new Player("Test");
		
		// Hangman
		Hangman hangman = new Hangman(this.getRandomWord());
		
		/* --- MENU --- */
		while (true) {
			if(hangman.GetLives()>0) {
				System.out.println("Voici la liste des options :");
				System.out.println("1- Saisir une lettre (-1 si échec)");
				System.out.println("2- Saisir un mot (-2 si échec)");
				System.out.println("3- Quitter sans sauvegarder");
				System.out.println("4- Quitter en sauvegardant");
					
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
						hangman.Wrongletter();
					}
					//scannerLetter.close();
				}
				if (userChoice.equals("2")) {
					//scanner.close();
				
					Scanner scannerWord = new Scanner(System.in);
					System.out.println("Entrez votre choix : ");
					String userWord = scannerWord.nextLine();
					System.out.println("Vous avez entré : " + userWord);
					player.setLetter(userWord);
					System.out.println("Word of the player " + player.getWord());
					if (userWord.equals(hangman.getWordToFind())) {
						System.out.println("Le mot choisi est  correct");
						hangman.Win();
					} else {
						System.out.println("Le mot choisi est incorrect");
						hangman.Wrongword();
					}
					//scannerLetter.close();
				}
				//scanner.close();
				
				
				}
		if(hangman.GetLives()==0) {
			hangman.GameOver();
		}
		}
		
			}
	
	
	public void generateMenu() {
		Menu menu = new Menu("MyMenu");
		menu.addItemToList(new MenuItem("Choisir une lettre", this::userLetterChoice));
		menu.addItemToList(new MenuItem("Choisir un mot", this::userWordChoice));
		menu.addItemToList(new MenuItem("Quitter", this::quitApp));
		menu.displayMenu(); 
	}
	
	private void userLetterChoice() {
		System.out.println("Je print hello world");
	}

	private void userWordChoice() {
		System.out.println("Date du jour");
	}
	
	private void quitApp() {
		System.out.println("Fermeture de l'application");
	}

}
