import java.util.ArrayList;
import java.util.List;

public class Hangman {
	
	private String wordToFind;
	private List<Character> currentWord = new ArrayList<Character>();
	private boolean wordFind;
	private int lives = 10;
	
	public Hangman(String wordToFind) {
		this.wordToFind = wordToFind;
		for (int i = 0; i < wordToFind.length(); i++) {
			this.currentWord.add('-');
		}
		this.wordFind = false;
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
		System.out.println(lives);
		lives -= 1;
		System.out.println(lives);
	}
	
	public void Wrongword() {
		System.out.println(lives);
		lives -= 2;
		System.out.println(lives);
	}
	
	public void GameOver() {
		System.out.println(lives);
		System.out.println("Game over");
		System.exit(0);
	}
			
	public void Win() {
		System.out.println("Félicitations! Le mot était bien "+this.wordToFind);
	}
}
