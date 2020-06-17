package Portfolio;

import java.util.*;
import java.io.*;

public class BondFactory implements SecurityFactory {
	// Pass value (code, name, yield) from CreateCommand to class Bond
	public Bond create() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter code, name and yield: ");
		String[] userInput = scanner.nextLine().split(",");
		String code = userInput[0].trim();
		String name = userInput[1].trim();
		String info = userInput[2].trim();
		return new Bond(code, name, Float.parseFloat(info));
	}
}