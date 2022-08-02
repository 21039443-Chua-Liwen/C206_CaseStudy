import java.time.LocalDate;
import java.util.Date;

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
	}
	
	public Item(String name, String description, double minbidprice, String startdate, String enddate,
			double bidincrement) {
		this.name = name;
		this.description = description;
		this.minbidprice = minbidprice;
		this.startdate = startdate;
		this.enddate = enddate;
		this.bidincrement = bidincrement;
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