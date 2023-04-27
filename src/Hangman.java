
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
		System.out.println("Wrong letter! You lost 1 life");
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
			System.out.println("La lettre choisie n'est pas dans le mot");
			return true;
		}
		System.out.println("La lettre choise est dans le mot");
		return false;
	}
	
}
