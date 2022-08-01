public class Item {
	private String name; 
	private String description; 
	private double minbidprice; 
	private String startdate; 
	private String enddate;
	private double bidincrement; 
	
	public Item (String name, String description) {
		this.name = name;
		this.description = description; 
		this.minbidprice = 0;
		this.startdate = "";
		this.enddate = "";
		this.bidincrement = 0;
	}
	
	public String getName() { 
		return name; 
	}
	
	public String getDescription() { 
		return description; 
	}

	public double getMinbidprice() {
		return minbidprice;
	}

	public String getStartdate() {
		return startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public double getBidincrement() {
		return bidincrement;
	}
}