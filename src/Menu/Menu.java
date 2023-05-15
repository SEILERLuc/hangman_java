package Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La class menu, qui affiche le menu principal, et execute les options choisies par le joueur
 * @author lucky
 *
 */
public class Menu {
	
	String name;
	List<MenuItem> optionsList = new ArrayList<MenuItem>();
	Scanner scanner;
	
	/**
	 * Constructeur du menu, prenant un nom égal au nom de l'application
	 */
	public Menu(String name) {
		this.name = name;
	}
	
	/**
	 * Parcourt la liste des options de jeu, et les affiche
	 * Le joueur peut alors choisir une option
	 */
	public void displayMenu() {
		boolean end = false;
		scanner = new Scanner(System.in);
		do {
			System.out.println(this.name);
			for(int i=0; i< optionsList.size(); i++) {
				String line = String.format("%d - %s", i+1, optionsList.get(i).getOption());
				System.out.println(line);
			}			
			System.out.print("votre choix : ");
			try {
				int menuChoice = scanner.nextInt();
				scanner.nextLine();
				if(menuChoice <= optionsList.size() && menuChoice > 0) {
					optionsList.get(menuChoice - 1).executeFunction();
				} else {
					System.out.println("Saisie invalide. Choisissez un numero.");
				}
			} catch (Exception e) {
				System.out.println("Saisie invalide. Choisissez un numero.");
				end = true;
			}
		} while(!end);
		scanner.close();
	}
	
	/**
	 * Execute l'option associée, choisie par le joueur
	 * @param choice Choix de l'utilisateur pour les actions
	 */
	public void executeOption(int choice) {
        optionsList.get(choice - 1).executeFunction();
    }
	
	/**
	 * Permet d'ajouter une nouvelle option à la liste d'options
	 * @param option MenuItem : fonctionnalité ajouté au menu
	 */
	public void addItemToList(MenuItem option) {
		this.optionsList.add(option);
	}
	
}
