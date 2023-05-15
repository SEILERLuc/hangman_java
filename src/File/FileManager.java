package File;
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
 */
public class FileManager {
	
	private String filename;
	Scanner myReader;
	
	/**
	 * Constructeur du file manager, ayant comme nom celui du fichier
	 */
	public FileManager(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Lit le fichier s'il existe et choisi un mot au hasard pour le jeu
	 */
	public String readAndChooseWord() {	
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
	
	/**
	 * Vérifie si le mot choisi lorsqu'il veut en rajouter un est déjà dans le fichier
	 */
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
	
	/**
	 * Ajoute/Ecrit dans le fichier le nouveau mot choisi par le joueur
	 */
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
