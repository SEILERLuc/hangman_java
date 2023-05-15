package App;
import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private String userWord;
	private String userLetter;
	private List<Character> wrongChoices = new ArrayList<Character>();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getWord() {
		return this.userWord;
	}
	
	public String getLetter() {
		return this.userLetter;
	}

	public void setLetter(String letter) {
		this.userLetter = letter;
	}

	public void setWord(String word) {
		this.userWord = word;
	}
	
	@Override
	public String toString() {
		return "Player is : " + this.name + "Wrong choices :  " + this.wrongChoices;
	}
	
	public List<Character> getWrongChoices() {
		System.out.println(this.wrongChoices);
		return wrongChoices;
	}
	
	public void addToWrongChoices(char wrongLetter) {
		this.wrongChoices.add(wrongLetter);
	}
	
	public boolean isAldreadyWrong(char userChoice) {
		if (this.wrongChoices.size() == 0) {return false;}
		for (int i = 0; i < this.wrongChoices.size(); i++) {
			if (this.wrongChoices.get(i) == userChoice) {
				return true;
			}
		}
		return false;
	}
	
}
