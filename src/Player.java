
public class Player {

	private String UserWord;
	private String UserLetter;
	
	public Player() {
		this.UserWord = "";
		this.UserLetter = "";
	}
	
	public String getWord() {
		return this.UserWord;
	}
	
	public String getLetter() {
		return this.UserLetter;
	}

	public void setLetter(String letter) {
		this.UserLetter = letter;
	}

	public void setWord(String word) {
		this.UserWord = word;
	}
	
}