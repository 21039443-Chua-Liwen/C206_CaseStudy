
public class Deal extends Item {
	private int dealID; 
	private String sellerEmail; 
	private String buyerEmail; 
	private double transPrice; 
	private String localDate;
	
	public Deal(String name, int dealID, String sellerEmail, String buyerEmail,
			double transPrice, String localDate) {
		
		super(name);
		this.dealID = dealID;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transPrice = transPrice;
		this.localDate = localDate;
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

	public String getLocalDate() {
		return localDate;
	}
}
