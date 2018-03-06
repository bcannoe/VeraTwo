
public class SlotMachine {
	private String nameOfSlot;
	private double currentSlotBalance;
	private int bigPayout;// number of jackpots
	private int lilPayout;
	private double bigWin;
	private double lilWin;
	
	public SlotMachine(String nameOfSlot, double currentSlotBalance, int bigPayout, int lilPayout, double bigWin,
			double lilWin) {
		super();
		this.nameOfSlot = nameOfSlot;
		this.currentSlotBalance = currentSlotBalance;
		this.bigPayout = bigPayout;
		this.lilPayout = lilPayout;
		this.bigWin = bigWin;
		this.lilWin = lilWin;
	}
//------------------------------------------------------------------------------------------------------------------------------------
	public SlotMachine() {
		
		
	}
//-------------------------------------------------------------------------------------------------------------------------------------
	public String getNameOfSlot() {
		return nameOfSlot;
	}

	public void setNameOfSlot(String nameOfSlot) {
		this.nameOfSlot = nameOfSlot;
	}

	public double getCurrentSlotBalance() {
		return currentSlotBalance;
	}

	public void setCurrentSlotBalance(double currentSlotBalance) {
		this.currentSlotBalance = currentSlotBalance;
	}

	public int getBigPayout() {
		return bigPayout;
	}

	public void setBigPayout(int bigPayout) {
		this.bigPayout = bigPayout;
	}

	public int getLilPayout() {
		return lilPayout;
	}

	public void setLilPayout(int lilPayout) {
		this.lilPayout = lilPayout;
	}

	public double getBigWin() {
		return bigWin;
	}

	public void setBigWin(double bigWin) {
		this.bigWin = bigWin;
	}

	public double getLilWin() {
		return lilWin;
	}

	public void setLilWin(double lilWin) {
		this.lilWin = lilWin;
	}

	
	public String toString() {
		String result;
		result = " ";
		return result;
	}
	
	
	
}
