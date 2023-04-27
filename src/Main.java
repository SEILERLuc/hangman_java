
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mot word=new mot();
		word.ChooseRandomWord();
		System.out.println("HANGMAN en java");
		
		Hangman hangman = new Hangman("HELLOWORLD");
		System.out.println(hangman.toString());
	}

}
