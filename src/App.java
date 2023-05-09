import java.util.Scanner;

public class App {
	private String name;
	Scanner scanner = new Scanner(System.in);
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
	// Player 
	Player player = new Player("Test");
	// Hangman
	FileManager fileManager = new FileManager("mots.txt");
	Hangman hangman = new Hangman(fileManager.readAndChooseWord());
	HangmanSprite hangmanSprite = new HangmanSprite();
	
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
	
	public void generateMenu() {
		Menu menu = new Menu("=====Hangman=====");
		menu.addItemToList(new MenuItem("Choisir une lettre", this::userLetterChoice));
		menu.addItemToList(new MenuItem("Choisir un mot", this::userWordChoice));
		menu.addItemToList(new MenuItem("Quitter", this::quit));
		menu.displayMenu(); 
	}
	
	private void userLetterChoice() {
		hangman.displayCurrentWord();
		System.out.print("Votre lettre : ");
		try {
			String userLetter = scanner.nextLine();
			if (hangman.isInside(userLetter)) {
				System.out.println("La lettre choisie est dans le mot");
				hangman.updateCurrentWord(userLetter.charAt(0)); 
			} else {
				if (player.isAldreadyWrong(userLetter.charAt(0))) {
					System.out.println("Vous avez déjà choisi cette lettre");
				} else {
					System.out.println("La lettre n'est pas dans le mot");
					hangman.Wrongletter();
					player.addToWrongChoices(userLetter.charAt(0));
					player.getWrongChoices();
					hangmanSprite.showSprites(hangman.getLives());;
				}
			}
		} catch (Exception e) {
			System.out.println("Saisie invalide.");
		}
		hangman.displayCurrentWord();
	}

	private void userWordChoice() {
		hangman.displayCurrentWord();
		System.out.print("Votre mot : ");
		try {
			String userWord = scanner.nextLine();
			if (hangman.isWordToFind(userWord)) {
				System.out.println("Vous avez choisi le bon mot");
				hangman.win();
			} else {
				System.out.println("Ce n'est pas le bon mot");
				hangman.Wrongletter();
				player.addToWrongChoices(userWord.charAt(0));
				player.getWrongChoices();
				hangmanSprite.showSprites(hangman.getLives());;
			}
		} catch (Exception e) {
			System.out.println("Saisie invalide.");
		}
		hangman.displayCurrentWord();
	}
	
	private void addNewWordToFile(String word) {
		// Ajoute un mot choisi par l'utilisateur au fichier
		System.out.println("Ajouter un mot dans le fichier");
	}
	
	private void quit() {
		System.out.println("Fermeture de l'application");
		System.exit(0);
	}

}
