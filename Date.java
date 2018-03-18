import javax.swing.JOptionPane;


public class Date {
	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date() {
		
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year"));// we will use honor system for the year for now
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month (A number between 1 - 12"));
		//I haven't tested this but I'm fairly confident that it works.
		do {
			if(month < 1 || month > 12) {
				month = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry, enter a number between 1 and 12"));
			}
		} while(month < 1 || month > 12);
		
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day"));
		
		boolean error = true;// I don't want to make some overly complex while loop at the bottom there so this is the best option I can think of
		
		
		//I haven't tested this either but I'm fairly certain that something is wrong with it, but I will get to it.
		do {
			if(day < 1 || day > 31) {
				day = Integer.parseInt(JOptionPane.showInputDialog("That does not work or make sense, please enter a day between 1 and 31"));
				
			}
			else if (month == 2 && day < 1 || day > 28) {
				day = Integer.parseInt(JOptionPane.showInputDialog("It's Feburaury and leap year does not exist in this program so enter a day between 1 and 28"));
			}
			else if((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {//I am not sure if this is how this works but it looks right
				day = Integer.parseInt(JOptionPane.showInputDialog("please enter a valid day between 1 and 30"));// 
			} else {
				error = false;
			}
			
			
		}while(error);
		this.day = day;
	}
	

	public String toString() {
		String result;
		result = month + " / " + day + " / " + year;	
		return result;
	}
	
	
	
	
}
