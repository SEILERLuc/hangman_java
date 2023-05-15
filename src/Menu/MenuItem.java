package Menu;

/**
 * Class MenuItem est un objet correspondant à une option du menu
 */
public class MenuItem {
	String option;
	Runnable action;
	
	/**
	 * Constructeur du MenuItem, prenant une option et une fonction associée
	 * @param option Le nom de l'action affichée sur le menu
	 * @param action La fonction associée à l'action
	 */
	public MenuItem(String option, Runnable action) {
		this.option = option;
		this.action = action;
	}
	
	/**
	 * Met le nom de l'option
	 * @param option Nom de l'option, affichée sur le menu
	 */
	public void setOption(String option) {
		this.option = option;
	}
	
	/**
	 * Récuprérer le nom de l'option
	 * @return option Le nom de l'option
	 */
	public String getOption() {
		return this.option;
	}	
	
	/**
	 * Mettre la description de l'action, qui sera affichée sur le menu
	 * @param action Fonction de l'option associée
	 */
	public void setDescription(Runnable action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "Name --> " + this.option + "; Description --> " + this.action;
	}

	/**
	 * Execute la fonction de l'action associée
	 */
	public void executeFunction(){
	    if(this.action != null){
	        this.action.run();
	    }
	}
	
}
