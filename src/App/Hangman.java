package App;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Hangman, qui contient le mot à trouver, ainsi que le mot actuel,
 * qui est affiché pour le joueur
 */
public class Hangman {
	
	private String wordToFind;
	private List<Character> currentWord = new ArrayList<Character>();
	private int lives;
	
	/*public void EasyLives() {
		lives=10;
	}
	public void NormalLives() {
		lives=5;
	}
	public void HardLives() {
		lives=3;
	}*/
	
	public void setDifficulty(String difficulty) {
		if (difficulty.equals("1")) {
			this.lives = 10;
			System.out.println(this.getLives());
		} else if (difficulty.equals("2")) {
			this.lives = 5;
			System.out.println(this.getLives());
		} else if (difficulty.equals("3")) {
			this.lives = 3;
			System.out.println(this.getLives());
		}
	}
	
	public Hangman(String wordToFind) {
		this.wordToFind = wordToFind;
		for (int i = 0; i < wordToFind.length(); i++) {
			this.currentWord.add('_');
		}
	}
	
	public int getLives() {
		return this.lives;
	}
	
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
	
	public String getCurrentString() {
		 StringBuilder sb = new StringBuilder();
		 for (Character ch : this.currentWord) {
	         sb.append(ch);
	     }
	     String currentString = sb.toString();
	     return currentString;
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
		System.out.println("Game over, le mot était " + this.wordToFind.toUpperCase());
		System.exit(0);
	}
			
	public void win() {
		System.out.println("Félicitations! Le mot était bien "+this.wordToFind);
		System.exit(0);
	}
}
