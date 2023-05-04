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
		
		boolean end = false;
		scanner = new Scanner(System.in);
		do {
			System.out.println(this.name);
			for(int i=0; i< optionsList.size(); i++) {
				String line = String.format("%d - %s", i+1, optionsList.get(i).getOption());
				System.out.println(line);
			}			
			System.out.print("votre choix : ");
			try {
				int menuChoice = scanner.nextInt();
				scanner.nextLine();
				if(menuChoice <= optionsList.size() && menuChoice > 0) {
					optionsList.get(menuChoice - 1).executeFunction();
				} else {
					end = true;
				}
			} catch (Exception e) {
				System.out.println("Saisie invalide. Choisissez un num�ro.");
			}
		} while(!end);
		scanner.close();;
	}
	
	public void executeOption(int choice) {
        optionsList.get(choice - 1).executeFunction();
    }
	
	public void addItemToList(MenuItem option) {
		this.optionsList.add(option);
	}
	
}
