
public class Name 
{
	String first;
	char initial;
	String last;
	
	public Name(String fir, char init, String las)
	{
		first = fir;
		initial = init;
		last = las;
	}
	public void setFirst(String fir)
	{
		first = fir;
	}
	public String getFirst()
	{
		return first;
	}
	public void setInitial(char init)
	{
		initial = init;
	}
	public char getInitial()
	{
		return initial;
	}
	public void setLast(String las)
	{
		last = las;
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
