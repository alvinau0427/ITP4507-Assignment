package Portfolio;

import java.util.*;

public class WithdrawCommand implements Command {
	private Vector history;
	private Vector undoHistory;
	private Object securityObj;
	private int quantity;
	private Caretaker caretaker;
	
	public void execute() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter code: ");
			String userInput = scanner.next();
			System.out.println("Quantity to withdraw: ");
			quantity = scanner.nextInt();
			if((userInput.isEmpty()) == false) {
				if(quantity > 0) {
					for(int i = 0; i < history.size(); i++) {
						securityObj = history.elementAt(i);
						if((((Security)securityObj).getCode()).equals(userInput)) {
							if(((Security)securityObj).getQuantity() >= quantity) {
								((Security)securityObj).setQuantity(((Security)securityObj).getQuantity() - quantity);
								caretaker.saveSecurity(securityObj);
								undoHistory.add(getStatus());
								System.out.println("Withdrew " + quantity + " from " + ((Security)securityObj).getCode() + ". Current quantity is " + (((Security)securityObj).getQuantity() + "." + "\n"));
							}else {
								System.out.println("Invalid quantity (current quantity < withdrawal quantity)." + "\n");
							}
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
			System.out.println("Please enter the corresponding command from existing option." + " (Withdraw Security) " + "\n");
		}
	}
	
	public void undo() {
		// undo() method have no any action
	}
	
	public void redo() {
		// redo() method have no any action
	}
	
	public String getStatus() {
		return "Withdraw " + quantity + " " + ((Security)securityObj).getCode();
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