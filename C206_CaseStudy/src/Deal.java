
public class Deal extends Item {
	private String dealID; 
	private String sellerEmail; 
	private String buyerEmail; 
	private double transPrice; 
	private String localDate;
	
	public Deal(String name, String description, String dealID, String sellerEmail, String buyerEmail,
			double transPrice, String localDate) {
		
		super(name, description);
		this.dealID = dealID;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transPrice = transPrice;
		this.localDate = localDate;
	}

	public String getDealID() {
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

	public String getLocalDate() {
		return localDate;
	}
}
