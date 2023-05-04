import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private String UserWord;
	private String UserLetter;
	private List<Character> wrongChoices = new ArrayList<Character>();
	
	public Player(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
