import javax.swing.JOptionPane;
public class Player {
	
	
	private Name name; 
	private Date dob;
	private double moneyBalance = 0;

// Constructors ===================================================================================================================================================
	
	public Player() 
	{
		setDob(dob);
		setName(name);
		setMoneyBalance(moneyBalance);	
	}
	
	public Player(Date dob, Name name, double moneyBalance) 
	{
		this.dob = dob;
		this.name = name;
		this.moneyBalance = moneyBalance;
	}
	
// Setters & Getters =================================================================================================================================================

	public Name getName() 
	{
		return name;
	}
	
	public void setName(Name name) 
	{
		name = new Name();		
		this.name = name;
	}
	
	public Date getDob() 
	{
		return dob;
	}

	public void setDob(Date dob) 
	{
		dob = new Date();
		this.dob = dob;
	}

	public double getMoneyBalance() 
	{
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) 
	{
		// This if statement serves the purpose of allowing the user to set a new money balance by calling 'setMoneyBalance()' & passing that new value
		// they wish to set without being overridden by the JOp user prompt; 
		// This will not affect the process of creating a new player when the no-param constuctor is called which then calls this method because is the moneyBalance is not greater than 0
		// it will prompt the user; (remember also, the moneyBalance is initially set to 0
		if(moneyBalance > 0)
		{
			this.moneyBalance = moneyBalance;
		}
		else if(moneyBalance == 0)
		{
			moneyBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your money balance"));	
			this.moneyBalance = moneyBalance;
		}
		
	}
	
// toString method =======================================================================================================================================
	
	public String toString() 
	{
		String result;
		result = name + "\n" + dob + "\n" + moneyBalance + "\n";
		return result;
	}
	
// addPlayer method =====================================================================================================================================
	
	/* In addPlayer method, nothing is passed & an object called 'result' of type Player is returned;
	 * When Player object is created, the no-param constructor method in the Player class is called; 
	 * Within the constructor method, the class's setters are called, and the class's fields are passed through those setters;
	 * Within the setter methods, the user is prompted via JOp. for their name, dob & moneyBalance;
	 */
	public static Player addPlayer()
	{
		Player result;
		result = new Player();
		return result;
	}

	
}
