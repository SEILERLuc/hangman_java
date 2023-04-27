
public class Hangman {
	
	private String WordToFind;
	private String CurrentWord;
	private boolean IsWordFind;
	
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
	
}
