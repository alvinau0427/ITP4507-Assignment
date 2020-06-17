package Portfolio;

import java.util.*;

public interface Command {
	public abstract void execute();
	public abstract void undo();
	public abstract void redo();
	public abstract String getStatus();
	public abstract void setCaretaker(Caretaker caretaker);
	public abstract void setSecurity(LinkedHashMap<String, String[]> securityList);
	public abstract void setHistory(Vector history);
	public abstract void setUndoHistory(Vector undoHistory);
	public abstract void setRedoHistory(Vector redoHistory);
}