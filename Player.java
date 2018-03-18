import javax.swing.JOptionPane;

public class Player {
	
	// local variables 
	private Name name; //  reference variable of object
	private Date dob; // reference variable of object
	private double moneyBalance;
	
	public Player(Name name, Date dob, double moneyBalance) {
		super();
		this.name = name;
		this.dob = dob;
		this.moneyBalance = moneyBalance;
	}
	
	public Player() {
		
		
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		// how do I invoke the methods of the Name class and pass them into here so that the player's
		// name is set inside of player by referencing name 
		Name playerName = new Name();
		playerName.setFirst("");
		playerName.setInitial(' ');
		playerName.setLast("");
		
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) {
		//moneyBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your money balance"));	
		this.moneyBalance = moneyBalance;
	}

	
	public String toString() {
		String result;
		result = name + " \n" + dob + " \n" + moneyBalance + "\n";
		return result;
	}
	
//	public static Player createPlayer() {
//		
//		/* The purpose of this method is to collect all the values that create a Player, put them into
//		 * a player object
//		 */
//		Player testResult;
//		testResult = setDob();
//		Player result = null;
//		return result; // result here is an object of type player: should include every element of a player
//	}
	
	
	
	
	
		
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
}
