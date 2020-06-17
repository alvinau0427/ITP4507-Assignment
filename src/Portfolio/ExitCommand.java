package Portfolio;

import java.util.*;

public class ExitCommand implements Command {
	public void execute() {
		System.out.println("\n" + "Leaving System...");
		System.exit(0);
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
		// setUndoHistory() method have no any action
	}
	
	public void setRedoHistory(Vector redoHistory) {
		// setRedoHistory() method have no any action
	}
}