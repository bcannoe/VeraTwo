import javax.swing.JOptionPane;
public class Date {
	
	private int year;
	private int month;
	private int day;

// Constructors =========================================================================================================================================================
	
	public Date() 
	{
		setYear(year); // user should be asked for the year they were born FIRST to check whether it is a leap year or not
		setMonth(month); // then, the user should be asked for the month next because depending on the month, the day they can choose is limited to certain numbers
		setDay(day);
	}
	
	public Date(int month, int day, int year) 
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
// Setters & Getters ====================================================================================================================================================

	public int getMonth() 
	{
		return month;
	}

	public void setMonth(int month) 
	{
		month = Integer.parseInt(JOptionPane.showInputDialog("Enter birth month (01 - 12 ONLY):"));
		//**This do-while loop validates the user's month entry**
		do {
			if(month < 1 || month > 12) 
			{
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
		day = Integer.parseInt(JOptionPane.showInputDialog("Enter birth day:"));
		
		boolean error = true;
		
	
		//**This do-while loop validates user's day entry making sure it is valid for the corresponding month it is paired with**
		do {
			if(day < 1 || day > 31) 
			{
				day = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry, please enter day between 01 and 31"));
			}
			else if (month == 2 && day > 29) // if the month is February & the day is greater than 0, check next condition...
			{
				if ((!(year % 4 == 0) && day > 29) || (year % 4 == 0 && day > 28)) 
					day = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry for month of February"));
			}
			else if((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) // for the following months, the entered day must not exceed 30
			{	//I am not sure if this is how this works but it looks right
				day = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry, please enter day between 01 and 30"));
			} 
			else 
			{
				error = false;
			}	
			
		}while(error);
		this.day = day;
	}
	
	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		boolean invalid = true; // false until true
		while(invalid)
		{
			year = Integer.parseInt(JOptionPane.showInputDialog("Enter year of birth:"));
			if(year < 1880)
			{
				JOptionPane.showMessageDialog(null, "Invalid Entry"); // oldest age we accept is 138 -- oldest person ever recorded to live was 122
			}
			if(year > 2000)
			{
				JOptionPane.showMessageDialog(null, "Must be 18+ years old to play"); // assuming the gambling age in this hypothetical is 18+
			}
			if(year > 1880 && year < 2000)
			{
				invalid = false; // the year is NOW valid	
			}
		}
		this.year = year;	
		
	}
	
// toString method ===================================================================================================================================================
	
	public String toString() 
	{
		String result;
		result = month + " / " + day + " / " + year;	
		return result;
	}
	
}