
public class mot {
	String[] mots= {"banc",
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
			"toilette"};
	public void ChooseRandomWord() {
		int randomIndex = (int) (Math.random() * mots.length);
		String randomWord = mots[randomIndex];
		System.out.println("Mot n° "+randomIndex);
		System.out.println(randomWord);
	}
	public mot() {}
}
