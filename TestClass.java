import javax.swing.JOptionPane;
public class TestClass {

	public static void main(String[] args) {
	
		
		char choice = 0;
		
		
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
			case 'A':
				
				
				break;
				
				
			case 'B':
				
				
				break;
				
			case 'C':
				
				
				break;
				
			
			case 'D':
				
				
				break;
				
			case 'Q':
			
				JOptionPane.showMessageDialog(null, "Don't come back.");
				
			default:
				JOptionPane.showMessageDialog(null, "Invalid");
			}
			
		
		
		}while (choice != 'Q');
			
			
			
			
		}
	
}


