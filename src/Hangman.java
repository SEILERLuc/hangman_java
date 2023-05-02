
public class Hangman {
	
	private String wordToFind;
	private String currentWord;
	private boolean wordFind;
	private int Lives=10;
	
	public Hangman(String wordToFind) {
		this.wordToFind = wordToFind;
		/*this.currentWord = "";
		for (int i = 0; i < wordToFind.toString().length(); i++) {
			this.currentWord += "-";
		}*/
		this.wordFind = false;
	}
	
	@Override
	public String toString() {
		return this.wordToFind + ", " + this.currentWord + ", " + this.wordFind;
	}
	
	public void displayWord() {
		System.out.println("The current word is: " + this.currentWord);
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
		System.out.println(Lives);
		System.out.println("Wrong letter! You lost 1 life");
		Lives-=1;
		System.out.println(Lives);
	}
	
	public void Wrongword() {
		System.out.println(Lives);
		System.out.println("Wrong word! You lost 2 lifes");
		Lives-=2;
		System.out.println(Lives);
	}
	
	public void GameOver() {
		System.out.println(Lives);
		System.out.println("Game over");
		System.exit(0);
	}
			
	public void Win() {
		System.out.println("Félicitations! Le mot était bien "+this.wordToFind);
	}
}
