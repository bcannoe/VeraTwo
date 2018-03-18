import javax.swing.JOptionPane;

public class SlotMachine {
	private String nameOfSlot;
	private double currentSlotBalance;
	private double bigPayout; // jackpot win amount is __
	private double lilPayout; // regular win amount is __
	private int bigWinFrequency; // jackpot occurs once every __ times
	private int lilWinFrequency; // regular win occurs once every __ times
	
	// Constructors ---------------------------------------------------------------------------------------------------------
	public SlotMachine(String nameOfSlot, double currentSlotBalance, double bigPayout, double lilPayout, 
			int bigWinFrequency, int lilWinFrequency) 
	{
		super();
		setNameOfSlot(nameOfSlot);
		setCurrentSlotBalance(currentSlotBalance);
		setBigPayout(bigPayout);
		setLilPayout(lilPayout);
		setBigWinFrequency(bigWinFrequency);
		setLilWinFrequency(lilWinFrequency);
	}
	public SlotMachine() 
	{
		// not sure if we really need this no args constructor
		
	}
	
// Setters & Getters --------------------------------------------------------------------------------------------------------
	
	public String getNameOfSlot() 
	{
		return nameOfSlot;
	}

	public void setNameOfSlot(String nameOfSlot) 
	{
		this.nameOfSlot = nameOfSlot;
	}

	public double getCurrentSlotBalance() 
	{
		return currentSlotBalance;
	}

	public void setCurrentSlotBalance(double currentSlotBalance) 
	{
		this.currentSlotBalance = currentSlotBalance;
	}

	public double getBigPayout() 
	{
		return bigPayout;
	}

	public void setBigPayout(double bigPayout) 
	{
		this.bigPayout = bigPayout;
	}

	public double getLilPayout()
	{
		return lilPayout;
	}

	public void setLilPayout(double lilPayout) 
	{
		this.lilPayout = lilPayout;
	}

	public int getBigWinFrequency() 
	{
		return bigWinFrequency;
	}

	public void setBigWinFrequency(int bigWin) 
	{
		this.bigWinFrequency = bigWin;
	}

	public int getLilWinFrequency() 
	{
		return lilWinFrequency;
	}

	public void setLilWinFrequency(int lilWinFrequency) 
	{
		this.lilWinFrequency = lilWinFrequency;
	}

	
	public String toString() 
	{
		String result;
		result = nameOfSlot + ", hopper has " + currentSlotBalance + " dollars.\t The jackpot occurs once every " + 
				bigWinFrequency + " plays, the jackpot pays " + bigPayout + " dollars.\t The regular payout occurs once every " + 
				lilWinFrequency + " plays, the regular payout is " + lilPayout;
		return result;
	}
	
// addSlotMachine method ==============================================================
	
	public static SlotMachine addSlotMachine()
	{
		SlotMachine result; // reference variable will be used later
		String tempSlotName = null;
		Double tempSlotBalance = null;
		Double tempBigPayout = null;
		Double tempLilPayout = null;
		int tempBigWinFre = 0;
		int tempLilWinFre = 0;
		tempSlotName = JOptionPane.showInputDialog(null, "Enter a name of slot machine:");
		tempSlotBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter balance for slot machine:"));
		tempBigPayout = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Jackpot payout amount:"));
		tempLilPayout = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter regular win payout amount:"));
		tempBigWinFre = Integer.parseInt(JOptionPane.showInputDialog(null, "Jackpot will occur once every __ times: "));
		tempLilWinFre = Integer.parseInt(JOptionPane.showInputDialog(null, "Regular win will occur once every __ times: "));
		result = new SlotMachine(tempSlotName, tempSlotBalance, tempBigPayout, tempLilPayout, tempBigWinFre, tempLilWinFre);
		return result;
		
	}
	
	
	
}
