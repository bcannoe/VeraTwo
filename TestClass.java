/*Creators: Blake Cannoe, Ester Aguilera, Mimi & Alaeldeen
 *Program Name: VeraGoesToVegas2
 *Program Purpose:
 *Program Menu:
	Option A: Create a Player
	- can create up to 50 Players (51 including Aunt Vera)
	- prompt user for a DOB, name and money balance
	Option B: Create a Slot Machine
	- can create up to 50 Slot Machines (47 after the 3 premade machines)
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
public class TestClass 
{
	public static void main(String[] args) 
	{	
		char choice = 0;
		
		// Player & Slot Machine array lists:
		ArrayList<Player>playerArray = new ArrayList<Player>(50);
		ArrayList<SlotMachine> slottyArray = new ArrayList<SlotMachine>(50);
	
		// PRE-MADE VERA PLAYER
		Name verasName = new Name("Aunt", 'Y', "Vera");
		Date verasDob = new Date(01, 01, 1975);
		Player vera = new Player(verasDob, verasName, 100000);
		playerArray.add(vera);
		
		// PRE-MADE SLOT MACHINES
		// Parameter values order: nameOfSlot, currentSlotBalance, bigPayout, lilPayout, bigWinFrequency, lilWinFrequency 
		SlotMachine luckySeven = new SlotMachine("Lucky 7", 10000, 2000, 5, 10000, 10);
		SlotMachine luckyLotto = new SlotMachine("Lucky Lotto", 95000, 7000, 25, 100000, 50);
		SlotMachine purplePeopleEater = new SlotMachine("Purple People Eater", 1000, 40, 2, 50, 5);
		SlotMachine easyWinTest = new SlotMachine("Easy Win Boi", 100000, 100, 10.50, 5, 2); // TESTCODE
		slottyArray.add(luckySeven);
		slottyArray.add(luckyLotto);
		slottyArray.add(purplePeopleEater);
		slottyArray.add(easyWinTest); // TESTCODE

		//This is a good menu
			do {
			String menu;
			String message = "A. Add Player.\n";
			message += "B. Add Slot Machine.\n";
			message += "C. Play Slots.\n";
			message += "D. View money balance\n";
			message += "Q. Quit.\n";
			menu = JOptionPane.showInputDialog(message, "Enter your selection");
			choice = menu.toUpperCase().charAt(0);
		
			
			switch(choice) {
			case 'A'://ADDS PLAYER
				
				// player object is created & populated by invoking 'addPlayer' method within Player class which returns player object
				Player player = Player.addPlayer();
				// That player is then added to the playerArray [where all user created players are held + pre-made Vera player]
				playerArray.add(player);
				JOptionPane.showMessageDialog(null, "playerArray:" + playerArray); // TESTCODE
				break;
			
			case 'B'://ADDS SLOT MACHINE
				
				// slotMachine object is created & populated by invoking 'addSlotMachine' method within SlotMachine class which returns slotMachine object
				SlotMachine slotMachine = SlotMachine.addSlotMachine();
				// That slotMachine is then added to the slottyArray [where all user created slot machines are held + 3 pre-made slot machines]
				slottyArray.add(slotMachine);
				break;
				
			case 'C'://PLAYS SLOT MACHINES
				
				// selectedSlot object is created to hold values of the selected slot from 'selectSlot' method
				SlotMachine selectedSlot = new SlotMachine();
				// 'selectSlot' is called, and slottyArray is passed; the user selected slot is returned
				selectedSlot = selectSlot(slottyArray);
				// Test Code
				JOptionPane.showMessageDialog(null, "You have selected " + selectedSlot); 
				
				//'selectedPlayer' variable name is declared (at this point however, it is NOT an object, just a name);
				Player selectedPlayer;
				//'selectPlayer' is called, and playerArray is passed; the a player the user has selected is returned;
				// selectedPlayer object is created to hold values of the selected player from 'selectPlayer' method
				
				selectedPlayer = selectPlayer(playerArray);
				selectedPlayer = new Player(selectedPlayer.getDob(), selectedPlayer.getName(), selectedPlayer.getMoneyBalance());
				
				
				// Test Code
				JOptionPane.showMessageDialog(null, "You have selected " + selectedPlayer);
				
				
				// selected slot & selected player are passed into playSlots method
				int userPlays = 0; // userPlayers accounts for # of players the user has made in order to 
				int playAgain = 1;
				while(selectedPlayer.getMoneyBalance() >= 1 && playAgain != 0)
				{
					/* This while loop validates the selected players money balance, if they don't have at least 1 dollar they can not play;
					 * Once that has been validated, the method 'playSlots' is invoked, the selectedSlot, selectedPlayer objects are passed & the userPlays
					 * int is passed; the value returned should be the userPlays amount which will override any values in userPlays and replace them;
					 * Then, the user will be prompted if they wish to play again with the same slot machine & player, if yes, once again their moneyBalance
					 * is validated & playSlots is invoked once again passing through it the necessary updated slot & player info as well the updated userPlays;
					 */
					userPlays = playSlots(selectedSlot, selectedPlayer, userPlays); // playSlots method should return the result of the play & the players balance
					playAgain = Integer.parseInt(JOptionPane.showInputDialog("Play again? (1 for Yes, 0 for No)"));
					
					if(playAgain == 1 && selectedPlayer.getMoneyBalance() >= 1)
					{
						userPlays = playSlots(selectedSlot, selectedPlayer, userPlays); // playSlots method should return the result of the play & the players balance
						playAgain = Integer.parseInt(JOptionPane.showInputDialog("Play again? (1 for Yes, 0 for No)"));
					}
					else if(playAgain != 0 && playAgain != 1)
					{
						System.out.println("Invalid Entry");
					}
				
				}
				break;
				
			case 'Q'://QUIT PROGRAM
				JOptionPane.showMessageDialog(null, "Don't come back.");
				break;
			
			default://INVALID ENTRY
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
			menuList += "\n" + playerArray.get(i).getName();
		}
		
		// User Prompt to enter the name of a player: (only players that have been created will appear)  
		userChoice = JOptionPane.showInputDialog(null, "Enter a Player from list: "
				+ "(MUST type in FIRST or LAST name of player as is *Not Both) " + 
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
			
				if(playerArray.get(i).getName().getFirst().equalsIgnoreCase(userChoice) || playerArray.get(i).getName().getLast().equalsIgnoreCase(userChoice)) 
					// from getName(), getFirst() is invoked because getName() returns an object which
					// can not be compared with a string (the users input)
				{
					result = playerArray.get(i);
					return result; // SHOULD return slot array object associated with user chosen slot name
				}
		
			}
			
		JOptionPane.showMessageDialog(null, "Your choice was invalid, please try again");
		userChoice = JOptionPane.showInputDialog(null, "Enter a Player from list: " //you forgot to change this earlier
				+ "(MUST type in full name of player as is) " + 
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
		
		// User Prompt to enter the name of a slot machine: (only slot machines that have been created will appear 
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
		
		/* If the number of times the user has played can be evenly divided into either of the win frequencies,
		 * the user has won & the code within if statement will run;
		 */
		
		if(plays % userSelectedSlot.getBigWinFrequency() == 0)
		{
			System.out.println("Inside jackpot if statement"); // testcode
			playersBalance = userSelectedPlayer.getMoneyBalance() - 1 + userSelectedSlot.getBigPayout();
				
			System.out.println("Inside regular win if statement -- selected user's money balance: " + playersBalance); //testcode
			userSelectedPlayer.setMoneyBalance(playersBalance); // updates players NEW balance
			System.out.println(userSelectedPlayer.getMoneyBalance()); // TESTCODE to verify users new balance has been updated
				
			slotsBalance = userSelectedSlot.getCurrentSlotBalance() + 1 - userSelectedSlot.getBigPayout();
			userSelectedSlot.setCurrentSlotBalance(slotsBalance); // updates slot machines NEW balance
			System.out.println(userSelectedSlot.getCurrentSlotBalance()); // TESTCODE to verify slot machines new balance has been updated
				
			JOptionPane.showMessageDialog(null, "CONGRATULATIONS! " + userSelectedPlayer.getName() + "\nYOU HAVE HIT THE JACKPOT AND WON " 
					+ userSelectedSlot.getBigPayout()  + "!!!\nCurrent Balance: " + playersBalance);
		
		}
		if(plays % userSelectedSlot.getLilWinFrequency() == 0)
		{
			if((plays % userSelectedSlot.getLilWinFrequency() == 0) && plays % userSelectedSlot.getBigWinFrequency() != 0) {// This prevents lilWin from overlapping with bigWin
				System.out.println("selected slot's lil payout: " + userSelectedSlot.getLilPayout()); //testcode
				playersBalance = userSelectedPlayer.getMoneyBalance() - 1 + userSelectedSlot.getLilPayout(); 
				
				System.out.println("Selected user's money balance: " + playersBalance); //testcode
				userSelectedPlayer.setMoneyBalance(playersBalance); // updates players NEW balance
				System.out.println(userSelectedPlayer.getMoneyBalance()); // TESTCODE to verify users new balance has been updated
				
				slotsBalance = userSelectedSlot.getCurrentSlotBalance() + 1 - userSelectedSlot.getBigPayout();
				userSelectedSlot.setCurrentSlotBalance(slotsBalance); // updates slot machines NEW balance
				System.out.println(userSelectedSlot.getCurrentSlotBalance()); // TESTCODE to verify slot machines new balance has been updated
				
				JOptionPane.showMessageDialog(null, "CONGRATULATIONS " + userSelectedPlayer.getName() + "!\nYOU HAVE WON " 
						+ userSelectedSlot.getLilPayout() + "!!!\nCurrent Balance: " + playersBalance);
			} 
		}
		if(plays % userSelectedSlot.getLilWinFrequency() != 0 && plays % userSelectedSlot.getBigWinFrequency() != 0)
		{
		    playersBalance = userSelectedPlayer.getMoneyBalance();// calling most recent players balance
		    playersBalance -= 1;
			userSelectedPlayer.setMoneyBalance(playersBalance);
			JOptionPane.showMessageDialog(null, "I'm sorry you have not won anything.\n" + "Your current balance is " + playersBalance );
		}
		
		return plays; // returns plays to keep track of how many plays the selected users has so far (REMEMBER all data is cleared once the user exits the program in any way)
	}
	
} // end of main class


