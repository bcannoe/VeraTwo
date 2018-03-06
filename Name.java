import javax.swing.JOptionPane;
public class Name 
{
	private String first;
	private char initial;
	private String last;
	
	public Name(String fir, char init, String las)
	{
		this.first = fir;
		this.initial = init;
		this.last = las;
	}
	public void setFirst(String fir)
	{
		fir = JOptionPane.showInputDialog("Enter your first name");
		
		this.first = fir;
	}
	public String getFirst()
	{
		return first;
	}
	public void setInitial(char init)
	{
		String input;
		input = JOptionPane.showInputDialog("Enter your middle initial");
		init = input.charAt(0);
		this.initial = init;
	}
	public char getInitial()
	{
		return initial;
	}
	public void setLast(String las)
	{
		las = JOptionPane.showInputDialog("Enter your middle initial");
		this.last = las;
	}
	public String getlast()
	{
		return last;
	}
	public String toString()
	{
		String result;
		result = first + "" + initial + ". " + last;
		return result;
	}
}
