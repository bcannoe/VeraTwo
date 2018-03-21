/*Creators: Blake Cannoe, Ester Aguilera, Mimi & Alaeldeen
 *Program Name: VeraGoesToVegas2
 *Program Purpose:
 *Program Menu:
	Option A: Create a Player
	- can create up to 50 Players
	- prompt user for a Name, DOB and money balance
	Option B: Create a Slot Machine
	- can create up to 50 Slot Machines
	- prompt user for Name, money balance (of slot machine),
	  win frequency of jackpot & regular win ( ex: "win will occur once every __ times")
	  and jackpot & regular win payout
	Option C: Slot Plays
	- a list of players will appear that the user can select from (validation for having at least
	  one dollar will occur when creating a player and adding money balance)
	- once a player has been selected, the user will select a slot machine from the list of slot machines
	- the selected player can play the same machine again (until moneybalance is 0 ??)
	- after the play, the players balance & result will be shown
	- include an option to return to main menu at any point before or after a play
	Option D: Quit Program
 */
import javax.swing.JOptionPane;
import java.util.*;
public class TestClass {

	public static void main(String[] args) {
	
		char choice = 0;
		ArrayList<Player>playerArray = new ArrayList<Player>(50);
		ArrayList<SlotMachine> slottyArray = new ArrayList<SlotMachine>(50);

		//This is a good menu
			do {
			String menu;
			String message = "A. Add a player.\n";
			message += "B. Add a slot machine.\n";
			message += "C. Play Slots.\n";
			message += "D. View money balance\n";
			message += "Q. Quit.\n";
			menu = JOptionPane.showInputDialog(message, "Enter your selection.");
			choice = menu.toUpperCase().charAt(0);
		
			
			switch(choice) {
			case 'A'://Adds a player
				
				JOptionPane.showMessageDialog(null, "Inside 'switch case: A' first line of code"); // CHECKPOINT 1
				Player player = Player.addPlayer();
				JOptionPane.showMessageDialog(null, "Inside 'switch case A' AFTER 'addplayer' has been called & result returned -- player: " + player); // CHECKPOINT 2
				playerArray.add(player);
				
				JOptionPane.showMessageDialog(null, "playerArray: " + playerArray); // CHECKPOINT 3
				break;
			
			case 'B'://adds a slot machine
				
				SlotMachine slotMachine = SlotMachine.addSlotMachine();
				slottyArray.add(slotMachine);
				break;
				
			case 'C'://allows user to play slot machine
				
				// selectedSlot object meant to be populated by selected slot returned from 'selectSlot' method
				SlotMachine selectedSlot = new SlotMachine();
				selectedSlot = selectSlot(slottyArray); // place returned value from selectSlot method into selectedSlot variable
				JOptionPane.showMessageDialog(null, "You have selected " + selectedSlot); //test code
				
				
				Player selectedPlayer = new Player();
				selectedPlayer = selectPlayer(playerArray);
				JOptionPane.showMessageDialog(null, "You have selected " + selectedPlayer); //test code
				
//				// selected slot & selected player are passed into playSlots method
//				int userPlays = 0; // userPlayers accounts for # of players the user has made in order to 
//				int playAgain = 0;
//				while(selectedPlayer.getMoneyBalance() >= 1 && playAgain == 1)
//				{
//					/* This while loop validates the selected players money balance, if they don't have at least 1 dollar they can not play;
//					 * Once that has been validated, the method 'playSlots' is invoked, the selectedSlot, selectedPlayer objects are passed & the userPlays
//					 * int is passed; the value returned should be the userPlays amount which will override any values in userPlays and replace them;
//					 * Then, the user will be prompted if they wish to play again with the same slot machine & player, if yes, once again their moneyBalance
//					 * is validated & playSlots is invoked once again passing through it the necessary updated slot & player info as well the updated userPlays;
//					 */
//					System.out.println("inside FIRST while loop -- money balance: " + selectedPlayer.getMoneyBalance()); // test code
//					userPlays = playSlots(selectedSlot, selectedPlayer, userPlays); // playSlots method should return the result of the play & the players balance
//					System.out.println("userPlays: " + userPlays + "selectedPlayer's money balance: " + selectedPlayer.getMoneyBalance()); // test code
//					playAgain = Integer.parseInt(JOptionPane.showInputDialog("Play again? (1 for Yes, 0 for No)"));
//					if(playAgain == 1 && selectedPlayer.getMoneyBalance() >= 1)
//					{
//						userPlays = playSlots(selectedSlot, selectedPlayer, userPlays); // playSlots method should return the result of the play & the players balance
//						playAgain = Integer.parseInt(JOptionPane.showInputDialog("Play again? (1 for Yes, 0 for No)"));
//					}
//					else if(playAgain == 0)
//					{
//						break;
//					}
//					else
//					{
//						System.out.println("Invalid Entry");
//					}
//						
//				}
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


// selectPlayerMethod ==============================================================================================================
	
	private static Player selectPlayer(ArrayList<Player> playerArray) 
	{
		Player result = null;
		String userChoice;
		String menuList = " ";
		
		// For-Loop for adding slot names to menu:
		for(int i = 0; i < playerArray.size(); i++)
		{
			menuList += "\n" + playerArray.get(i).getName(); // not sure if this will work
		}
		
		// User Prompt: 
		userChoice = JOptionPane.showInputDialog(null, "Enter a Slot Machine from list: "
				+ "(MUST type in full name of slot machine as is) " + 
				"\n======================================================================\n" + menuList);
		
		boolean invalid = true;
		while(invalid)
		{
			/* This while loop will continue to run until the user enters a name on the menuList;
			 * The for-loop is used to check every slot name in the slot array;
			 * The check is made to find which slot name is equal to the slot name the user has entered;
			 * Once a slot name has been found that is equal to the users choice, the object associated with that
			 * name will be placed into result & returned to main class.
			 */
			for(int i = 0; i < playerArray.size(); i++)
			{
			
			/* if statement compares users choice to names in slot array to find
			 * the object associated with the name; this allows us to now handle
			 * the slot machine object that has been selected by the user
			 * the loop should finish testing all slot machine names until a matching result is found
			 */
			
				if(playerArray.get(i).getName().getFirst().equalsIgnoreCase(userChoice)) 
					// from getName(), getFirst() is invoked because getName() returns an object which
					// can not be compared with a string (the users input)
				{
					result = playerArray.get(i);
					return result; // SHOULD return slot array object associated with user chosen slot name
				}
		
			}
			
		JOptionPane.showMessageDialog(null, "Your choice was invalid, please try again");
		userChoice = JOptionPane.showInputDialog(null, "Enter a Slot Machine from list: "
				+ "(MUST type in full name of slot machine as is) " + 
				"\n========================================\n" + menuList);
		} // end of while
		
		return null;
	}
	
	
	
	
// selectSlotMethod ================================================================================================================
	
	public static SlotMachine selectSlot(ArrayList<SlotMachine> slotArray)
	{
		SlotMachine result = null;
		String userChoice;
		String menuList = " ";
		
		// For-Loop for adding slot names to menu:
		for(int i = 0; i < slotArray.size(); i++)
		{
			menuList += "\n" + slotArray.get(i).getNameOfSlot();
		}
		
		// User Prompt: 
		userChoice = JOptionPane.showInputDialog(null, "Enter a Slot Machine from list: "
				+ "(MUST type in full name of slot machine as is) " + 
				"\n======================================================================\n" + menuList);
		
		boolean invalid = true;
		while(invalid)
		{
			/* This while loop will continue to run until the user enters a name on the menuList;
			 * The for-loop is used to check every slot name in the slot array;
			 * The check is made to find which slot name is equal to the slot name the user has entered;
			 * Once a slot name has been found that is equal to the users choice, the object associated with that
			 * name will be placed into result & returned to main class.
			 */
			for(int i = 0; i < slotArray.size(); i++)
			{
			
			/* if statement compares users choice to names in slot array to find
			 * the object associated with the name; this allows us to now handle
			 * the slot machine object that has been selected by the user
			 * the loop should finish testing all slot machine names until a matching result is found
			 */
				if(slotArray.get(i).getNameOfSlot().equalsIgnoreCase(userChoice)) 
				{
					result = slotArray.get(i);
					return result; // SHOULD return slot array object associated with user chosen slot name
				}
		
			}
			
		JOptionPane.showMessageDialog(null, "Your choice was invalid, please try again");
		userChoice = JOptionPane.showInputDialog(null, "Enter a Slot Machine from list: "
				+ "(MUST type in full name of slot machine as is) " + 
				"\n========================================\n" + menuList);
		} // end of while
		
	return result;
	}

// playSlots Method ===========================================================================================================================================
	
	public static int playSlots(SlotMachine userSelectedSlot, Player userSelectedPlayer, int plays) // method takes in the selected slot & player
	{
		double playersBalance = 0; // players money balance within the playSlots method
		double slotsBalance = 0; // slot machines money balance within the playSlots method
		plays++;
		
	if(plays % userSelectedSlot.getBigWinFrequency() == 0)
	{
		System.out.println("Inside jackpot if statement"); // testcode
		playersBalance = userSelectedPlayer.getMoneyBalance() - plays + userSelectedSlot.getBigPayout();
		userSelectedPlayer.setMoneyBalance(playersBalance); // updating the players NEW balance
		slotsBalance = userSelectedSlot.getCurrentSlotBalance() + plays - userSelectedSlot.getBigPayout();
		userSelectedSlot.setCurrentSlotBalance(slotsBalance); // updating the slots NEW balance
		JOptionPane.showMessageDialog(null, "CONGRATULATIONS!  YOU HIT THE JACKPOT!\n" + userSelectedPlayer.getName() + 
				" has won " + userSelectedSlot.getBigPayout() 
				+ "\n Your current balance is: " 
				+ playersBalance);
		
	}
	if(plays % userSelectedSlot.getLilWinFrequency() == 0)
	{
		System.out.println("Inside regular win if statement -- selected user's money balance: " + userSelectedPlayer.getMoneyBalance()); //testcode
		System.out.println("selected slot's lil payout: " + userSelectedSlot.getLilPayout()); //testcode
		playersBalance = userSelectedPlayer.getMoneyBalance() - plays + userSelectedSlot.getLilPayout();
		userSelectedPlayer.setMoneyBalance(playersBalance); // updating the players NEW balance
		slotsBalance = userSelectedSlot.getCurrentSlotBalance() + plays - userSelectedSlot.getBigPayout();
		userSelectedSlot.setCurrentSlotBalance(slotsBalance); // updating the slots NEW balance
		// JOp message
	}
		
		return plays; // returns plays to keep track of how many plays the selected users has so far
	}
	
} // end of main class


