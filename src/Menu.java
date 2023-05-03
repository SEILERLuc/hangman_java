import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	String name;
	List<MenuItem> optionsList = new ArrayList<MenuItem>();
	Scanner scanner;
	
	public Menu(String name) {
		this.name = name;
	}
	
	public void displayMenu() {
		if (optionsList == null) {
			System.out.println("Menu vide");
		} else {
			System.out.println("Choose an options :");
			for (int i = 0; i < optionsList.size(); i++) {
				System.out.println(i+1 + " " + optionsList.get(i).toString());
			}
			scanner = new Scanner(System.in);
			System.out.println("Ecrire un nombre: ");
	        String user = scanner.nextLine();
	        optionsList.get(1).execute();
		}
	}
	
	public void addItemToList(MenuItem option) {
		this.optionsList.add(option);
	}
	
}
