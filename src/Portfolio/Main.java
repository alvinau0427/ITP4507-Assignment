/*
   FileName:		Portfolio.Main
   StudentName:		Au Chi Chung
   StudentID:		150533022
   ClassName:		IT114105 / HDSE2A
   Description:		Advanced Portfolio Management System (APMS) for maintaining security records.
   -				Program contains 8 command options for control the data of security, different function correspond different command key.
   
   - Functions List -
	(1)	Create Security Record (Command - "n") -> ("bo"/"st") -> ('string,string,float'/'string,string,string')
	(2)	Show Security Record (Command - "s") -> ('security code'/ "##")
	(3) Deposit Security (Command - "d") -> ('deposit quantity')
	(4) Withdraw Security (Command - "w") -> ('withdraw quantity')
	(5) Display the Undo/RedoList (Command - "l")
	(6) Undo Last Command in the Undo List (Command - "u")
	(7) Redo the last undo command (Command - "r")
	(8) Exit the system (Command - "q")
*/


package Portfolio;

import java.util.*;
import java.io.*;

public class Main {
	private static Vector security;
	private static Vector history;
	private static Vector undoHistory;
	private static Vector redoHistory;
	private static Stack<Command> undoStack;
	private static Stack<Command> redoStack;
	private static LinkedHashMap<String, String[]> commandList;
	private static LinkedHashMap<String, String[]> securityList;
	private static final boolean STATUS = true;
	
	public static void main(String[] args) {
		initial();
	}
	
	public static void initial() {
		// Setup the initial variable
		Scanner scanner = new Scanner(System.in);
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(input);
		Caretaker caretaker = new Caretaker();
		
		security = new Vector();
		history = new Vector();
		undoHistory = new Vector();
		redoHistory = new Vector();
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
		
		// Setup the LinkedHashMap with the command and the security list
		setCommandList();
		setSecurity();
		
		while(STATUS == true) {
			// Display the initial system message
			System.out.println("Advanced Security Management System");
			System.out.print("Please enter command: [");
			String commandString = "";
			Iterator iterator = commandList.keySet().iterator();
			
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				commandString += key + " | ";
			}
			System.out.println(commandString.substring(0, commandString.length() - 3) + "]");
			
			commandString = "";
			iterator = commandList.keySet().iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				commandString += key + " = " + commandList.get(key)[1] + ", ";
			}
			System.out.println(commandString.substring(0, commandString.length() - 2));
			System.out.println();
			
			// Offer an explanation of the command keys with undo & redo action
			try {
				String userInput = scanner.next().toLowerCase();
				if(userInput.equals("u")) {
					// undo action and pass action to Caretaker
					if(undoHistory.size() != 0) {
						Command command = undoStack.pop();
						redoStack.push(command);
						command.undo();
						caretaker.undo();
						redoHistory.add(undoHistory.remove(undoHistory.size() - 1));
						System.out.println("undo completed." + "\n");
					}else {
						System.out.println("undo failed." + "\n");
					}
				}else if(userInput.equals("r")) {
					// redo action and pass action to Caretaker
					if(redoHistory.size() != 0) {
						Command command = redoStack.pop();
						undoStack.push(command);
						command.redo();
						caretaker.redo();
						undoHistory.add(redoHistory.remove(redoHistory.size() - 1));
						System.out.println("redo completed." + "\n");
					}else {
						System.out.println("redo failed." + "\n");
					}
				}else {
					// Setup the variable of the metod in Command
					Command command = (Command)Class.forName("Portfolio." + commandList.get(userInput)[0]).newInstance();	
					command.setCaretaker(caretaker);
					command.setSecurity(securityList);
					command.setHistory(history);
					command.setUndoHistory(undoHistory);
					command.setRedoHistory(redoHistory);
					command.execute();
					
					if(command instanceof CreateCommand || command instanceof DepositCommand || command instanceof WithdrawCommand) {
						undoStack.push(command);
					}
				}
			}catch(Exception ex) {
				System.out.println("Please enter the corresponding command from existing option." + "\n");
			}
		}
	}
	
	// Command List
	public static void setCommandList() {
		commandList = new LinkedHashMap<String, String[]>();
		commandList.put("n", new String[]{"CreateCommand", "create security"});
		commandList.put("s", new String[]{"ShowCommand", "show security"});
		commandList.put("d", new String[]{"DepositCommand", "deposit security"});
		commandList.put("w", new String[]{"WithdrawCommand", "withdraw security"});
		commandList.put("u", new String[]{"UndoCommand", "undo"});
		commandList.put("r", new String[]{"RedoCommand", "redo"});
		commandList.put("l", new String[]{"ListCommand", "list undo/redo"});
		commandList.put("q", new String[]{"ExitCommand", "exit system"});
	}
	
	// Security List
	public static void setSecurity() {
		securityList = new LinkedHashMap<String, String[]>();
		securityList.put("bo", new String[]{"BondFactory", "bond"});
		securityList.put("st", new String[]{"StockFactory", "stock"});
	}
}