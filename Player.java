import javax.swing.JOptionPane;

public class Player {
	private Name name;
	private Date dob;
	
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
		moneyBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter your money balance"));
		
		
		this.moneyBalance = moneyBalance;
	}

	
	public String toString() {
		String result;
		result = name + " \n" + dob + " \n" + moneyBalance + "\n";
		return result;
	}
	
	//public static Player createPlayer() {
		
		
		
		
	//}
	
	
	
	
	
		
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
}
