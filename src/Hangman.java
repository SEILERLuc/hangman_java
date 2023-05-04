import java.util.ArrayList;
import java.util.List;

public class Hangman {
	
	private String wordToFind;
	private List<Character> currentWord = new ArrayList<Character>();
	private boolean wordFind;
	private int Lives = 10;
	
	public Hangman(String wordToFind) {
		this.wordToFind = wordToFind;
		for (int i = 0; i < wordToFind.toString().length(); i++) {
			this.currentWord.add('-');
		}
		this.wordFind = false;
	}
	
	public int GetLives() {
		return Lives;
	}
	public void ShowSprites() {
		if (GetLives()==1){
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n/    |\n=======");
		}
		if (GetLives()==2){
			System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n     |\n=======");
		}
		if (GetLives()==3){
			System.out.println(" +---+\n |   |\n O   |\n/|   |\n     |\n=======");
		}
		if (GetLives()==4){
			System.out.println(" +---+\n |   |\n O   |\n |   |\n     |\n=======");
		}
		if (GetLives()==5){
			System.out.println(" +---+\n |   |\n O   |\n     |\n     |\n=======");
		}
		if (GetLives()==6){
			System.out.println(" +---+\n |   |\n     |\n     |\n     |\n=======");
		}
		if (GetLives()==7){
			System.out.println(" +---+\n     |\n     |\n     |\n     |\n=======");
		}
		if (GetLives()==8){
			System.out.println("      \n     |\n     |\n     |\n     |\n=======");
		}
		if (GetLives()==9){
			System.out.println("      \n      \n      \n      \n      \n=======");
		}
	}
	@Override
	public String toString() {
		return this.wordToFind;
	}
	
	public void displayWord() {
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
	
	public String getWordToFind() {
		return this.wordToFind;
	}
	
	public void Wrongletter() {
		Lives-=1;
	}
	
	public void Wrongword() {
		Lives-=2;
	}
	
	public void GameOver() {
		System.out.println(" +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n=======");
		System.out.println("Game over");
		System.exit(0);
	}
			
	public void Win() {
		System.out.println("Félicitations! Le mot était bien "+this.wordToFind);
	}
}
