import javax.swing.JOptionPane;
public class Date 
{
	private int year;
	private int month;
	private int day;

// Constructors =========================================================================================================================================================
	
	public Date() 
	{
		
	}
	
	public Date(int month, int day, int year) 
	{
		super();
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
// Setters & Getters ====================================================================================================================================================
	
	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		year = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));// we will use honor system for the year for now
		if(year < 1880)
		{
			JOptionPane.showMessageDialog(null, "Invalid Entry"); //  oldest age we accept is 138 
		}
		if(year > 2000)
		{
			JOptionPane.showMessageDialog(null, "Must be 18+ years old to play");
		}
			
			this.year = year;
	
	
	}

	public int getMonth() 
	{
		return month;
	}

	public void setMonth(int month) 
	{
		month = Integer.parseInt(JOptionPane.showInputDialog("Enter month (01 - 12 ONLY):"));
		//I haven't tested this but I'm fairly confident that it works.
		//** This do-while loop validates the user's month entry**
		do {
			if(month < 1 || month > 12) {
				month = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry, enter number between 01 and 12"));
			}
		} while(month < 1 || month > 12);
		
		this.month = month;
	}


	public int getDay() 
	{
		return day;
	}


	public void setDay(int day) 
	{
		day = Integer.parseInt(JOptionPane.showInputDialog("Enter day:"));
		
		boolean error = true;// I don't want to make some overly complex while loop at the bottom there so this is the best option I can think of
		
		//I haven't tested this either but I'm fairly certain that something is wrong with it, but I will get to it.
		//**This do-while loop validates user's day entry making sure it is valid for the corresponding month it is paired with**
		do {
			if(day < 1 || day > 31) {
				day = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry, please enter a day between 1 and 31"));
			}
			else if (month == 2 && day > 0) 
			{
				if (year % 4 == 0 && day < 29)
				day = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry for month of February: ....."));
			}
			else if((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {//I am not sure if this is how this works but it looks right
				day = Integer.parseInt(JOptionPane.showInputDialog("please enter a valid day between 1 and 30"));// 
			} else {
				error = false;
			}
			
			
		}while(error);
		this.day = day;
	}
	
// toString method ===================================================================================================================================================
	
	public String toString() 
	{
		String result;
		result = month + " / " + day + " / " + year;	
		return result;
	}
	

	
}