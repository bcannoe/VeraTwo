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
		year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year"));
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month"));
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day"));
		this.day = day;
	}
	

	public String toString() {
		String result;
		result = month + " / " + day + " / " + year;	
		return result;
	}
	
	
	
	
}
