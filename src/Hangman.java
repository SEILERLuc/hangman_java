
public class Hangman {
	
	private String WordToFind;
	private String CurrentWord;
	private boolean IsWordFind;
	private int Lives=10;
	mot wordToFind=new mot();
	
	public Hangman() {
		this.WordToFind = wordToFind.ChooseRandomWord();
		this.CurrentWord = "";
		for (int i = 0; i < WordToFind.toString().length(); i++) {
			this.CurrentWord += "-";
		}
		this.IsWordFind = false;
	}
	
	@Override
	public String toString() {
		return this.WordToFind + ", " + this.CurrentWord + ", " + this.IsWordFind;
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
	
	public boolean isInside(String letter) {
		if (this.WordToFind.contains(letter)) {
			return true;
		}
		return false;
	}
	
	public void displayWord() {
		System.out.println("The current word is: " + this.CurrentWord);
	}
	public void Win() {
		System.out.println("Félicitations! Le mot était bien "+this.WordToFind);
	}
}
