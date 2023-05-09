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
	
	public void generateMenu() {
		Menu menu = new Menu(this.name);
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
			while(userLetter.length()>1) {
				System.out.println("That's not a letter.");
				userLetter = scanner.nextLine();
			}
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
			/*for(int i=0;i<userWord.length();i++) {
				if((userWord.charAt(i)<'a'|| userWord.charAt(i)>'z')||(userWord.charAt(i)<'A'|| userWord.charAt(i)>'Z')) {
					System.out.println("That's not a word");
					userWord = scanner.nextLine();
				}
			}*/
			while(userWord.length()<2) {
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
	
	private void addNewWordToFile(String word) {
		// Ajoute un mot choisi par l'utilisateur au fichier
		System.out.println("Ajouter un mot dans le fichier");
	}
	
	private void quit() {
		System.out.println("Fermeture de l'application");
		System.exit(0);
	}

}
