import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileManager {
	
	private String filename;
	Scanner myReader;
	
	public FileManager(String filename) {
		this.filename = filename;
	}
	
	public String readAndChooseWord() {
		/*try {
		    File myFile = new File(this.filename);
		    myReader = new Scanner(myFile);
		    
		    if (myFile.exists()) {
		        System.out.println("File name: " + myFile.getName());
		    } else {
		        System.out.println("The file does not exist.");
		    }
		    
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	System.out.println(data);
		    }
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist !");
		    e.printStackTrace();
		} finally {
			myReader.close();
		}*/
		
		ArrayList<String> mots = new ArrayList<String>();
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(this.filename));
            String ligne = lecteur.readLine();
            while (ligne != null) {
                mots.add(ligne);
                ligne = lecteur.readLine();
            }
            lecteur.close();
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier " + this.filename);
        }
        Random rand = new Random();
        String motChoisi = mots.get(rand.nextInt(mots.size()));
        System.out.println("Le mot choisi est : " + motChoisi);
        return motChoisi;
		
	}
	
	public void writeNewWordToFile(String newWord) {
		
	}
	
}
