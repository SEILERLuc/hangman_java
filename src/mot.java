import java.util.ArrayList;
import java.util.List;

public class mot {
	
	String[] mots= {
			"banc",
			"bureau",
			"cabinet",
			"carreau",
			"chaise",
			"classe",
			"cle",
			"coin",
			"couloir",
			"dossier",
			"eau",
			"ecole",
			"ecriture",
			"entree",
			"escalier",
			"etagere",
			"etude",
			"exterieur",
			"fenetre",
			"interieur",
			"lavabo",
			"lecture",
			"lit",
			"marche",
			"matelas",
			"maternelle",
			"meuble",
			"mousse",
			"mur",
			"porte",
			"portemanteau",
			"poubelle",
			"radiateur",
			"rampe",
			"recreation",
			"rentree",
			"toilette"
	};
	
	private List<Character> Letters = new ArrayList<Character>();
	
	public mot() {}
	
	public String ChooseRandomWord() {
		int randomIndex = (int) (Math.random() * mots.length);
		String randomWord = mots[randomIndex];
		return randomWord;
	}
	
	public void stringToCharArray(String mot) {
		for (char ch : mot.toCharArray()) {
			Letters.add(ch);
		}
	}
	
	public List<Character> getWord() {
		return this.Letters;
	}
	
	public void display() {
		for (char ch : Letters) {
			System.out.print(ch);
		}
		System.out.print("\n");
	}
	
	
	/*public List<Character> toListOfChar() {
		List<Character> charsList = new ArrayList<>();
		for (char character : mot.toCharArray()) {
			charsList.add(character);
		}
		return charsList;
	}*/
	
}
