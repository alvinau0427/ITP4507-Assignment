package Portfolio;

import java.util.*;

public class ShowCommand implements Command {
	private Vector history;
	private Caretaker caretaker;
	
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter code(## to show all) : ");
		String userInput = scanner.nextLine();
		System.out.println("\n" + "Security information");
		if(!userInput.equals("##")) {
			for(int i = 0; i < history.size(); i++) {
				if((((Security)history.elementAt(i)).getCode()).equals(userInput)) {
					Security security = (Security)history.elementAt(i);
					System.out.println("Code: " + security.getCode());
					System.out.println("Name: " + security.getName());
					System.out.println("Quantity: " + security.getQuantity());
					System.out.println(security);
					System.out.println();
					return;
				}
			}
			System.out.println("The input value is not exists in database" + "\n");
		}else {
			System.out.printf("%-10s %-20s %-15s %-10s\n", "Code", "Name", "Quantity", "OtherInfo");
			for (int i = 0; i < history.size(); i++) {
				Security security = (Security)history.elementAt(i);
				System.out.printf("%-10s %-20s %-15d %-10s\n", security.getCode(), security.getName(), security.getQuantity(), security);
			}
			System.out.println();
		}
	}
	
	public void undo() {
		// undo() method have no any action
	}
	
	public void redo() {
		// redo() method have no any action
	}
	
	public String getStatus() {
		return null;
		// getStatus() method have no return value
	}
	
	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}
	
	public void setSecurity(LinkedHashMap<String, String[]> securityList) {
		// setSecurity() method have no any action
	}
	
	public void setHistory(Vector history) {
		this.history = history;
	}
	
	public void setUndoHistory(Vector undoHistory) {
		// setUndoHistory() method have no any action
	}
	
	public void setRedoHistory(Vector redoHistory) {
		// setRedoHistory() method have no any action
	}
}