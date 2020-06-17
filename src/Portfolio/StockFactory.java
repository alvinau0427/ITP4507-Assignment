package Portfolio;

import java.util.*;
import java.io.*;

public class StockFactory implements SecurityFactory {
	// Pass value (code, name, exchange) from CreateCommand to class Stock
	public Stock create() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter code, name and stock exchange:");
		String[] userInput = scanner.nextLine().split(",");
		String code = userInput[0].trim();
		String name = userInput[1].trim();
		String stock = userInput[2].trim();
		return new Stock(code, name, stock);
	}
}