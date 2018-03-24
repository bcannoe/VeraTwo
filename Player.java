import javax.swing.JOptionPane;
public class Player {
	
	// local variables 
	private Name name; //  reference variable of object
	private Date dob; // reference variable of object
	private double moneyBalance;

// Constructors ===================================================================================================================================================
	
	public Player() 
	{
		
		
	}
	public Player(Date dob, Name name, double moneyBalance) 
	{
		super();
		setDob(dob);
		setName(name);
		setMoneyBalance(moneyBalance);
	}
	
// Setters & Getters =================================================================================================================================================

	public Name getName() 
	{
		return name;
	}
	
	public void setName(Name name) // **********Not sure if this is properly filled out
	{
		// this creates a name object in the setName method within player
		name = new Name();
		name.setFirst("");
		name.setInitial(' ');
		name.setLast("");
		
		this.name = name;
	}
	
	public Date getDob() 
	{
		return dob;
	}

	public void setDob(Date dob) 
	{
		dob = new Date();
		dob.setYear(0);
		dob.setMonth(0);
		dob.setDay(0);
		
		this.dob = dob;
	}

	public double getMoneyBalance() 
	{
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) 
	{
		//this needs to be up here result in addPlayer will not take the one under it
		moneyBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your money balance"));	// not sure if I should add this ??
		this.moneyBalance = moneyBalance;
	}
	
// toString method =======================================================================================================================================
	
	public String toString() 
	{
		String result;
		result = name + " \n" + dob + " \n" + moneyBalance + "\n";
		return result;
	}
	
// addPlayer method =====================================================================================================================================
	

	/* In addPlayer method, nothing is passed & an object called 'result' of type Player is returned;
	 * objects of type Date & Name are created to populate the player object & the user is also prompted for the players balance;
	 * when the dob & name objects are created, the user is prompted for the individual values necessary to populate them;
	 */
	public static Player addPlayer()
	{
		// reference variables declared & initialized
		Player result;
		Name tempPlayerName = null;
		Date tempDob = null;
		//int day = 0, month = 0, year = 0;
		double tempPlayerBalance = 0;
		
		JOptionPane.showMessageDialog(null, "Before any objects are created"); // CHECKPOINT 1
		
		// when a Player is created, since a player and date object are created within the setters of Player, the user is prompted for everything here except playerbalance
		result = new Player(tempDob, tempPlayerName, tempPlayerBalance);
		
		
	
		
		JOptionPane.showMessageDialog(null, "RESULT: " + result); // CHECKPOINT 3
		
		return result;
	}

	
}
