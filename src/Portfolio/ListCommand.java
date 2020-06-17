package Portfolio;

import java.util.*;

public class ListCommand implements Command {
	private Vector undoHistory;
	private Vector redoHistory;
	
	public void execute() {
		System.out.println("\n" + "Undo List: ");
		for (int i = 0; i < undoHistory.size(); i++) {
			System.out.println(undoHistory.get(i));
		}
		
		if(undoHistory.size() == 0) {
			System.out.println("Empty");
		}
		
		System.out.println("\n" + "Redo List: ");
		for (int i = 0; i < redoHistory.size(); i++) {
			System.out.println(redoHistory.get(i));
		}
		
		if(redoHistory.size() == 0) {
			System.out.println("Empty");
		}
		
		System.out.println();
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
		// setCaretaker() method have no any action
	}
	
	public void setSecurity(LinkedHashMap<String, String[]> securityList) {
		// setSecurity() method have no any action
	}
	
	public void setHistory(Vector History) {
		// setHistory() method have no any action
	}
	
	public void setUndoHistory(Vector undoHistory) {
		this.undoHistory = undoHistory;
	}
	
	public void setRedoHistory(Vector redoHistory) {
		this.redoHistory = redoHistory;
	}
}