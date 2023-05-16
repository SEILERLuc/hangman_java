package Main;

import App.App;

/**
 * Classe Main: lance l'application
 *
 */
public class Main {

	public static void main(String[] args) {
		App app = new App("=====Hangman=====");
		app.generateMenu();
		
	}
}
