
public class Deal extends Item {
	private int dealID; 
	private String sellerEmail; 
	private String buyerEmail; 
	private double transPrice; 
	private String endDate;
	
	public Deal(String name, int dealID, String sellerEmail, String buyerEmail,
			double transPrice, String endDate) {
		
		super(name);
		this.dealID = dealID;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transPrice = transPrice;
		this.endDate = endDate;
	}

	public int getDealID() {
		return dealID;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getTransPrice() {
		return transPrice;
	}

	public String getEndDate() {
		return endDate;
	}
}
