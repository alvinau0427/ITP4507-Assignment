package Portfolio;

public class Security {
	String code;
	String name;
	int quantity = 0;
	
	public Security() {
		
	}
	
	public Security(String code, String name) {
		setCode(code);
		setName(name);
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int qty) {
		quantity = qty;
	}
}