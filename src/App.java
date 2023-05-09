import java.util.Scanner;

/**
 * Cette classe permet de gérer toute l'application de HANGMAN
 * @author lucky
 *
 */
public class App {
	
	private String name;
	private Scanner scanner = new Scanner(System.in);
	private Player player = new Player("Test");
	private FileManager fileManager = new FileManager("mots.txt");
	private Hangman hangman = new Hangman(fileManager.readAndChooseWord());
	private HangmanSprite hangmanSprite = new HangmanSprite();
	
	public App(String name) {
		this.name = name;
	}
	
	/**
	 * Genère le menu principal, avec les différentes options
	 * D'autres options peuvent être ajoutées dynamiquement
	 */
	public void generateMenu() {
		Menu menu = new Menu(this.name);
		menu.addItemToList(new MenuItem("Choisir une lettre", this::userLetterChoice));
		menu.addItemToList(new MenuItem("Choisir un mot", this::userWordChoice));
		menu.addItemToList(new MenuItem("Ajouter un mot au fichier", this::addNewWord));
		menu.addItemToList(new MenuItem("Quitter", this::quit));
		menu.displayMenu(); 
	}
	
	private void userLetterChoice() {
		hangman.displayCurrentWord();
		System.out.print("Votre lettre : ");
		try {
			String userLetter = scanner.nextLine();	
			while(Character.isAlphabetic(userLetter.charAt(0))==false||userLetter.length()>1) {
				System.out.println("That's not a letter");
				userLetter = scanner.nextLine();
			}
			if (hangman.isInside(userLetter)) {
				System.out.println("La lettre choisie est dans le mot");
				hangman.updateCurrentWord(userLetter.charAt(0));
				System.out.println(hangman.getCurrentString() + " " + hangman.getWordToFind());
				if (hangman.getCurrentString().equals(hangman.getWordToFind())) {
					hangman.win();
				}
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
			while(userWord.length()<2||userWord.matches("[a-zA-Z]+")==false) {
				System.out.println("That's not a word");
				userWord = scanner.nextLine();
			}
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
	
	/**
	 * Permet à l'utilisateur d'ajouter un nouveau mot dans le fichier
	 */
	private void addNewWord() {
		// Ajoute un mot choisi par l'utilisateur au fichier
		System.out.println("Saisissez un mot à ajouter");
		try {
			String newWord = scanner.nextLine();
			while (newWord.length() < 2 || newWord.matches("[a-zA-Z]+") == false) {
				System.out.println("That's not a word");
				newWord = scanner.nextLine();
			}
			if (fileManager.alreadyInFile(newWord)) {
				System.out.println("Ce mot existe déjà");
			} else {
				fileManager.writeToFile(newWord);
				System.out.println("Mot ajouté au fichier");
			}
		} catch (Exception e) {
			System.out.println("Saisie invalide.");
		}
	}
	
	/**
	 * Ferme l'application
	 */
	private void quit() {
		System.out.println("Fermeture de l'application");
		System.exit(0);
	}

}
