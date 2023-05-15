import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Cette classe permet de faire la gestion de fichier :
 * - Lire un fichier de mots et en choisir un au hasard
 * - Ajouter un nouveau mot dans le fichier, choisi par l'utilisateur
 * @author lucky
 *
 */
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
		
		ArrayList<String> wordList = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filename));
            String ligne = reader.readLine();
            while (ligne != null) {
            	wordList.add(ligne);
                ligne = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier " + this.filename);
        }
        Random rand = new Random();
        String chosenWord = wordList.get(rand.nextInt(wordList.size()));
        System.out.println("Le mot choisi est : " + chosenWord);
        return chosenWord;
		
	}
	
	public boolean alreadyInFile(String word) {
		try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filename));
            String ligne = reader.readLine();
            while (ligne != null) {
            	//System.out.println(word + " --- " + ligne);
            	if (ligne.equals(word)) {
            		//System.out.println("EGALITE");
            		return true;
            	}
            	ligne = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier " + this.filename);
        }
		return false;
	}
	
	public void writeToFile(String newWord) {
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true));
            writer.write(newWord + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Erreur d'écriture dans le fichier " + this.filename);
        }
	}
	
}
