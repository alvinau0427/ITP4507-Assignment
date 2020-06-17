package Portfolio;

public class StockMemento implements Memento {
	private Stock stock;
	private String exchange;
	private int quantity;
	
	public StockMemento(Stock stock) {
		this.stock = stock;
		exchange = stock.getExchange();
		quantity = stock.getQuantity();
	}
	
	public void restore() {
		stock.setExchange(exchange);
		stock.setQuantity(quantity);
	}
}