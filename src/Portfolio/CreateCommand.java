package Portfolio;

import java.util.*;
import java.io.*;

public class CreateCommand implements Command {
	private Vector history;
	private Vector undoHistory;
	private Object securityObj;
	private LinkedHashMap<String, String[]> securityList;
	private Caretaker caretaker;
	
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter security type(");
		String commandString = "";
		Iterator iterator = securityList.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String)iterator.next();
			commandString += key + " = " + securityList.get(key)[1] + " / ";
		}
		System.out.println(commandString.substring(0, commandString.length() - 3) + ") : ");
		
		String userInput = scanner.next().toLowerCase();
		try {
			SecurityFactory factory = (SecurityFactory)Class.forName("Portfolio." + securityList.get(userInput)[0]).newInstance();
			securityObj = factory.create();
			history.add((Security)securityObj);
			caretaker.saveSecurity(securityObj);
			undoHistory.add(getStatus());
			System.out.println("New security record created." + "\n");
		}catch(Exception ex) {
			System.out.println("Please enter the corresponding command from existing option." + " (Create Security) " + "\n");
			execute();
		}
	}
	
	public void undo() {
		history.remove((Security)securityObj);
	}
	
	public void redo() {
		history.add((Security)securityObj);
	}
	
	public String getStatus() {
		return "Create " + ((Security)securityObj).getCode();
	}
	
	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}
	
	public void setSecurity(LinkedHashMap<String, String[]> securityList) {
		this.securityList = securityList;
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