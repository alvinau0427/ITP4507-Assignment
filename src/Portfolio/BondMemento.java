package Portfolio;

public class BondMemento implements Memento {
	private Bond bond;
	private float yield;
	private int quantity;
	
	public BondMemento(Bond bond) {
		this.bond = bond;
		yield = bond.getYield();
		quantity = bond.getQuantity();
	}
	
	public void restore() {
		bond.setYield(yield);
		bond.setQuantity(quantity);
	}
}