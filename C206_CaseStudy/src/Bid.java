public class Bid extends Item {
	private int bidId; 
	private String sellerEmail; 
	private String buyerEmail; 
	private double bidPrice; 
	
	public Bid(String name, int bidId, String sellerEmail, String buyerEmail, double bidPrice) {
		super(name);
		this.bidId = bidId;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.bidPrice = bidPrice;
	}

	public int getBidId() {
		return bidId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getBidPrice() {
		return bidPrice;
	}
}
	
	
	
	
	
	

