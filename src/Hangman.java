import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Hangman, qui contient le mot à trouver, ainsi que le mot actuel,
 * qui est affiché pour le joueur
 * @author lucky
 *
 */
public class Hangman {
	
	private String wordToFind;
	private List<Character> currentWord = new ArrayList<Character>();
	private boolean wordFind;
	private int lives = 10;
	
	public Hangman(String wordToFind) {
		this.wordToFind = wordToFind;
		for (int i = 0; i < wordToFind.length(); i++) {
			this.currentWord.add('_');
		}
		this.wordFind = false;
	}
	public int getLives() {
		return this.lives;
	}
	/*public void ShowSprites() {
		if (lives==1){
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n/    |\n=======");
		}
		if (lives==2){
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n     |\n=======");
		}
		if (lives==3){
			System.out.println(" +---+\n |   |\n O   |\n/|   |\n     |\n=======");
		}
		if (lives==4){
			System.out.println(" +---+\n |   |\n O   |\n |   |\n     |\n=======");
		}
		if (lives==5){
			System.out.println(" +---+\n |   |\n O   |\n     |\n     |\n=======");
		}
		if (lives==6){
			System.out.println(" +---+\n |   |\n     |\n     |\n     |\n=======");
		}
		if (lives==7){
			System.out.println(" +---+\n     |\n     |\n     |\n     |\n=======");
		}
		if (lives==8){
			System.out.println("      \n     |\n     |\n     |\n     |\n=======");
		}
		if (lives==9){
			System.out.println("      \n      \n      \n      \n      \n=======");
		}
	}*/
	@Override
	public String toString() {
		return this.wordToFind;
	}
	
	public void displayCurrentWord() {
		System.out.println(this.currentWord);
		System.out.print("The current word is : ");
		for (char character : currentWord) {
			System.out.print(character);
		}
		System.out.println("\n");
	}
	
	public boolean isInside(String letter) {
		if (this.wordToFind.contains(letter)) {
			return true;
		}
		return false;
	}
	
	public boolean isWordToFind(String word) {
		if (this.wordToFind.equals(word)) {
			return true;
		}
		return false;
	}
	
	public void updateCurrentWord(char letter) {
		for (int i = 0; i < this.wordToFind.length(); i++) {
			if (this.wordToFind.charAt(i) == letter) {
				this.currentWord.set(i, letter);
			}
		}
	}
	
	public String getWordToFind() {
		return this.wordToFind;
	}
	
	public void Wrongletter() {
		lives-=1;
	}
	
	public void Wrongword() {
		lives-=2;
	}
	
	public void GameOver() {
		System.out.println(lives);
		System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n=======");
		System.out.println("Game over");
		System.exit(0);
	}
			
	public void win() {
		System.out.println("Félicitations! Le mot était bien "+this.wordToFind);
		System.exit(0);
	}
}
