//Blake Cannoe
//Ester Aguilera
//Mimi
import javax.swing.JOptionPane;
import java.util.*;
public class TestClass {

	public static void main(String[] args) {
	
		
		char choice = 0;
		ArrayList<String> playerArray = new ArrayList<String>();
		ArrayList<String> slottyArray = new ArrayList<String>();
		//This is a good menu
			do {
			String menu;
			String message = "A. Add a player.\n";
			message += "B. Add a slot machine.\n";
			message += "C. Play Slots.\n";
			message += "D. View money balance\n";
			message += "Q.Quit.\n";
			menu = JOptionPane.showInputDialog(message, "Enter your selection.");
			choice = menu.toUpperCase().charAt(0);
		
			
		
			switch(choice) {
			case 'A'://Adds a player
				
				
				break;
				
				
			case 'B'://adds a slot machine
				
				
				break;
				
			case 'C'://allows user to play slot machine
				
				
				break;
				
			
			case 'D'://view player balance
				
				
				break;
				
			case 'Q'://quit input
			
				JOptionPane.showMessageDialog(null, "Don't come back.");
				
				break;
			
			default://bad input
				
				JOptionPane.showMessageDialog(null, "Invalid");
				
				break;
			}
			
		
		
		}while (choice != 'Q');
			
			
			
			
		}
	
}


