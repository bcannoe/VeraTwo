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
	public Player(Name name, Date dob, double moneyBalance) 
	{
		super();
		setName(name);
		setDob(dob);
		setMoneyBalance(moneyBalance);
	}
	
// Setters & Getters =================================================================================================================================================

	public Name getName() 
	{
		return name;
	}
	
	public void setName(Name name) // **********Not sure if this is properly filled out
	{
		// how do I invoke the methods of the Name class and pass them into here so that the player's
		// name is set inside of player by referencing name 
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
		this.dob = dob;
	}

	public double getMoneyBalance() 
	{
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) 
	{
		//moneyBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your money balance"));	// not sure if I should add this ??
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
	

	// In addPlayer method, objects of type Date & Name are created to populate the player object 
	public static Player addPlayer()
	{
		// reference variables declared & initialized
		Player result;
		Name tempPlayerName = null;
		Date tempDob = null;
		int day = 0, month = 0, year = 0;
		Double tempPlayerBalance = null;
		
		JOptionPane.showMessageDialog(null, "Inside 'addPlayer' checkpoint 1"); // CHECKPOINT 1
		
		tempDob = new Date(day, month, year);
		tempPlayerName = new Name(" ", ' ', " "); // this prompts user for input
		
		JOptionPane.showMessageDialog(null, "Inside 'addPlayer' checkpoint 2 -- TEMPDOB: " + tempDob + " TEMPPLAYERNAME: " + tempPlayerName); // CHECKPOINT 2
		
		// populating variables with values
//		tempPlayerName.setFirst(" ");
//		tempPlayerName.setInitial(' '); // 'initial' as in middle name initial
//		tempPlayerName.setLast(" ");
		
//		tempDob.setDay(0);
//		tempDob.setMonth(0);
//		tempDob.setYear(0);

		tempPlayerBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter player's balance:"));
	
		result = new Player(tempPlayerName, tempDob, tempPlayerBalance);
		
		JOptionPane.showMessageDialog(null, "Inside 'addPlayer' checkpoint 3 -- RESULT: " + result); // CHECKPOINT 1 // CHECKPOINT 3
		
		return result;
	}

	
}
