package Portfolio;

import java.util.*;

public class Caretaker {
	protected Memento securityType;
	protected Vector<Memento> undoList;
	protected Vector<Memento> redoList;
	
	public Caretaker() {
		undoList = new Vector<Memento>();
		redoList = new Vector<Memento>();
	}
	
	public void undo() {
		/*
		redoList.add((Memento)(undoList.remove(undoList.size() - 1)));
		if(undoList.size() != 0) {
			((Memento)undoList.get(undoList.size() - 1)).restore();
		}
		*/
		
		try {
			if(undoList.size() >= 1) {
				redoList.add(undoList.lastElement());
			}
			if(undoList.lastElement() instanceof BondMemento) {
				undoList.remove(undoList.lastElement());
				for(int i = 0; i < undoList.size(); i++){
					if(undoList.get(i) instanceof BondMemento) {
						securityType = undoList.get(i);
					}
				}
			}else {
				undoList.remove(undoList.lastElement());
				for(int i = 0; i < undoList.size(); i++){
					if(undoList.get(i) instanceof StockMemento) {
						securityType = undoList.get(i);
					}
				}
			}
			securityType.restore();
		}catch(Exception ex) {
			// ex.printStackTrace();
			// System.out.println("No corresponding action in undo list.");
		}
	}
	
	public void redo() {
		/*
		((Memento)redoList.get(redoList.size() - 1)).restore();
		undoList.add((Memento)(redoList.remove(redoList.size() - 1)));
		*/
		
		try{
			if(redoList.size() >= 1) {
				undoList.add(redoList.lastElement());
				// System.out.println(redoList.get(redoList.size() - 1));
				redoList.get(redoList.size() - 1).restore();
				redoList.remove(redoList.lastElement());
			}
		}catch(Exception ex) {
			System.out.println("No corresponding action in redo list.");
		}
	}
	
	public void saveSecurity(Object securityObj) {
		if(securityObj instanceof Bond) {
			undoList.add(new BondMemento((Bond)securityObj));
		}else if(securityObj instanceof Stock) {
			undoList.add(new StockMemento((Stock)securityObj));
		}
	}
}