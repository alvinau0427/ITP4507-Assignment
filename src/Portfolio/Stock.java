package Portfolio;

public class Stock extends Security {
	String exchange;
	
	public Stock() {
		
	}
	
	public Stock(String code, String name, String exchange) {
		super(code, name);
		setExchange(exchange);
	}
	
	public String getExchange() {
		return exchange;
	}
	
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	// Additional method for display value (exchange) in ShowCommand table
	public String toString() {
		return "Exchange: " + exchange;
	}
}