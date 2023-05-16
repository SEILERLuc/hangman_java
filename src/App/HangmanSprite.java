package App;

/**
 * Classe HangmanSprite: pour les sprites de Hangman en ASCII art
 */
public class HangmanSprite {
	
	public HangmanSprite() {}
	
	/**
	 * Montre les sprites du Hangman au court de la partie
	 * @param lives: nombre de vies restantes du Hangman 
	 */
	public void showSprites(int lives) {
		if (lives == 1) {
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n/    |\n=======");
		}
		if (lives == 2) {
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n     |\n=======");
		}
		if (lives == 3) {
			System.out.println(" +---+\n |   |\n O   |\n/|   |\n     |\n=======");
		}
		if (lives == 4) {
			System.out.println(" +---+\n |   |\n O   |\n |   |\n     |\n=======");
		}
		if (lives == 5) {
			System.out.println(" +---+\n |   |\n O   |\n     |\n     |\n=======");
		}
		if (lives == 6) {
			System.out.println(" +---+\n |   |\n     |\n     |\n     |\n=======");
		}
		if (lives == 7) {
			System.out.println(" +---+\n     |\n     |\n     |\n     |\n=======");
		}
		if (lives == 8) {
			System.out.println("      \n     |\n     |\n     |\n     |\n=======");
		}
		if (lives == 9) {
			System.out.println("      \n      \n      \n      \n      \n=======");
		}
	}
	
}
