
public class Hangman {
	
	private String WordToFind;
	private String CurrentWord;
	private boolean IsWordFind;
	private int Lives=10;
	public Hangman(String wordToFind) {
		this.WordToFind = wordToFind;
		this.CurrentWord = "";
		for (int i = 0; i < wordToFind.length(); i++) {
			this.CurrentWord += "-";
		}
		this.IsWordFind = false;
	}
	
	@Override
	public String toString() {
		return this.WordToFind + ", " + this.CurrentWord + ", " + this.IsWordFind;
	}
	public void Wrongletter(int Lives) {
		System.out.println(Lives);
		System.out.println("Wrong letter! You lost 1 life");
		Lives-=1;
		System.out.println(Lives);
	}
	public void Wrongword(int Lives) {
		System.out.println(Lives);
		System.out.println("Wrong letter! You lost 1 life");
		Lives-=2;
		System.out.println(Lives);
	}
	public void GameOver(int Lives) {
		System.out.println(Lives);
		System.out.println("Game over");
		System.exit(0);
	}
}
