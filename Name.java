import javax.swing.JOptionPane;
public class Name 
{
	private String first;
	private char initial;
	private String last;
	
// Constructors ===========================================================================================================================
	
	public Name()
	{
		// no args constructor
	}
	public Name(String first, char initial, String last)
	{
		setFirst(first);
		setInitial(initial);
		setLast(last);
	}
	
// Setters & Getters =====================================================================================================================
	public void setFirst(String first)
	{
		first = JOptionPane.showInputDialog("Enter first name");
		this.first = first;
	}
	public String getFirst()
	{
		return first;
	}
	public void setInitial(char initial)
	{
		String input;

		input = JOptionPane.showInputDialog("Enter middle name initial (enter space if there is no middle initial)");
		initial = input.charAt(0);
		this.initial = initial;
	}
	public char getInitial()
	{
		return initial;
	}
	public void setLast(String last)
	{
		last = JOptionPane.showInputDialog("Enter last name");
		this.last = last;
	}
	public String getLast()
	{
		return last;
	}
	
// toString method =====================================================================================================================
	
	public String toString()
	{
		String result;
		result = first + "" + initial + ". " + last;
		return result;
	}
	
}
