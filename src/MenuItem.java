
public class MenuItem {
	String option;
	Runnable action;
	
	public MenuItem(String option, Runnable action) {
		this.option = option;
		this.action = action;
	}
	
	public void setOption(String option) {
		this.option = option;
	}
	
	public String getOption() {
		return this.option;
	}	
	
	public void setDescription(Runnable action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "Name --> " + this.option + "; Description --> " + this.action;
	}

	public void executeFunction(){
	    if(this.action != null){
	       	System.out.println("menu function");
	        this.action.run();
	    }
	}
	
}
