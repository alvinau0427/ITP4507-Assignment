package Portfolio;

import java.util.*;

public class DepositCommand implements Command {
	private Vector history;
	private Vector undoHistory;
	private Object securityObj;
	private int quantity;
	private Caretaker caretaker;
	
	public void execute() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Code: ");
			String userInput = scanner.next();
			System.out.println("Quantity to deposit: ");
			quantity = scanner.nextInt();
			if((userInput.isEmpty()) == false) {
				if(quantity > 0) {
					for(int i = 0; i < history.size(); i++) {
						securityObj = history.elementAt(i);
						if((((Security)securityObj).getCode()).equals(userInput)) {
							((Security)securityObj).setQuantity(((Security)securityObj).getQuantity() + quantity);
							caretaker.saveSecurity(securityObj);
							undoHistory.add(getStatus());
							System.out.println("Deposited " + quantity + " to " + ((Security)securityObj).getCode() + ". Current quantity is " + (((Security)securityObj).getQuantity() + "." + "\n"));
							return;
						}
					}
					System.out.println("Your code is not exist" + "\n");
				}else {
					System.out.println("Please enter the positive value of quantity." + "\n");
					execute();
				}
			}
		}catch(Exception ex) {
			System.out.println("Please enter the corresponding command from existing option." + " (Deposit Security) " + "\n");
		}
	}
	
	public void undo() {
		// undo() method have no any action
	}
	
	public void redo() {
		// redo() method have no any action
	}
	
	public String getStatus() {
		return "Deposit " + quantity + " " + ((Security)securityObj).getCode();
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
		this.undoHistory = undoHistory;
	}
	
	public void setRedoHistory(Vector redoHistory) {
		// setRedoHistory() method have no any action
	}
}
