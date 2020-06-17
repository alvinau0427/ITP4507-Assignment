package Portfolio;

public class Bond extends Security {
	float yield;
	
	public Bond() {
		
	}
	
	public Bond(String code, String name, float yield) {
		super(code, name);
		setYield(yield);
	}
	
	public float getYield() {
		return yield;
	}
	
	public void setYield(float yield) {
		this.yield = yield;
	}
	
	// Additional method for display value (yield) in ShowCommand table
	public String toString() {
		return "Yield: " + yield;
	}
}