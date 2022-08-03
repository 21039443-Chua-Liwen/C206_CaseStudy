import java.util.ArrayList;
import java.util.Date;

public class App {

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Category> catList = new ArrayList<Category>(); 
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();
		
		//testing 
//		userList.add(new User("KEN","Student", "ken191@gmail.com","dskjdwd"));
//		itemList.add(new Item("Test Name", "Test Description", 3, "12/12/2022", "30/12/12022", 5));
//		bidList.add(new Bid("Bid Name", 358, "Mary289@gmail.com", "David463@gmail.com", 10.00));
	
		int option = 0;

		while (option != 6) {

			App.menu();
			option = Helper.readInt("Enter an option > ");

		if (option == 1) { // ADD, VIEW AND DELETE USER 
			int UserChoice = 0; 
			while (UserChoice != 4) {

				UserMenu();
				UserChoice= Helper.readInt("Enter an option > ");
				
				//add
				if (UserChoice == 1) {
					App.setHeader("ADD");
					User ii = inputUser(); 
					App.addUser(userList, ii);
					System.out.println("User added");
					
				//view 
				} else if (UserChoice == 2) {
					App.viewAllUser(userList);
									
				
				//delete
				} else if (UserChoice == 3) {
					App.setHeader("DELETE");
					App.deleteUser(userList); 	
				}
			}
						
		} else if (option == 2) { // ADD, VIEW AND DELETE CATEGORY
		
			int CatChoice = 0; 
			while (CatChoice != 4) {

				CatMenu();
				CatChoice= Helper.readInt("Enter an option > ");
				
				//add
				if (CatChoice == 1) {
					App.setHeader("ADD");
					Category ii = inputCat(); 
					App.addCat(catList, ii);
					System.out.println("Category added");
					
				//view 
				} else if (CatChoice == 2) {
					App.viewAllcat(catList);
									
				
				//delete
				} else if (CatChoice == 3) { 
					App.setHeader("DELETE");
					App.deleteCat(catList); 	
				}
			}
			
		} else if (option == 3) { // ADD, VIEW AND DELETE ITEMS
			int itemChoice = 0; 
			while (itemChoice != 4) {

				ItemMenu();
				itemChoice= Helper.readInt("Enter an option > ");
				
				//add
				if (itemChoice == 1) {
					App.setHeader("ADD");
					Item i = inputItem(); 
					App.addItem(itemList, i);
					System.out.println("Item added");
					
				//view 
				} else if (itemChoice == 2) {
					App.viewAllItems(itemList);
									
				
				//delete
				} else if (itemChoice == 3) {
					App.setHeader("DELETE");
					App.deleteItem(itemList); 	
				} 
			}
			
		} else if (option == 4) { // ADD, VIEW AND DELETE BID
			int bidChoice = 0; 
			while (bidChoice != 4) {

				BidMenu();
				bidChoice= Helper.readInt("Enter an option > ");
				
				//add
				if (bidChoice == 1) {
					App.setHeader("ADD");
					Bid b = inputBid(); 
					App.addBid(bidList, b);
					System.out.println("Bid added");
					
				//view 
				} else if (bidChoice == 2) {
					App.viewAllBids(bidList);
									
				
				//delete
				} else if (bidChoice == 3) {
					App.setHeader("DELETE");
					App.deleteBid(bidList); 	
				} 
			}
			
		} else if (option == 5) {
			
		} else if (option == 6) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid option");
		}

	}

}

	public static void menu() {
			App.setHeader("CAMPUS ONLINE AUCTION SHOP");
			System.out.println("1. User Account");
			System.out.println("2. Category");
			System.out.println("3. Item");
			System.out.println("4. Bid");
			System.out.println("5. Deal");
			System.out.println("6. Quit"); 
			Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//================================= Option 1 USER (ADD/VIEW/DELETE) =================================
	
	//user menu
	private static void UserMenu() {
		App.setHeader("USER OPTION");
		System.out.println("1. Add User");
		System.out.println("2. View User");
		System.out.println("3. Delete User");
		System.out.println("4. Quit");
		
	}

	//retrieve all user 
	public static String retrieveAllUser (ArrayList <User> userList) {
		String output = "";

		for (int i = 0; i < userList.size(); i++) {
			
			output += String.format ("%-10s %-10s %-30s %-40s\n", userList.get(i).getName(),
					userList.get(i).getRole(),
					userList.get(i).getEmail(), 
					userList.get(i).getPassword());

		}
		return output;
	}
	
	
	// add user 
	public static User inputUser() {
		String name = Helper.readString("Enter name > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email > ");
		String password = Helper.readString("Enter password > ");

		User ur = new User (name, role, email, password);
		return ur;
	}
	
	public static void addUser (ArrayList<User> userList, User ur) {
		userList.add(ur); 
	}
	
	
	// view user
	public static void viewAllUser(ArrayList<User> userList) {
		String output = String.format("%-10s %-10s %-30s %-40s\n", "NAME", "ROLE",
				"EMAIL", "PASSWORD");
		output += retrieveAllUser(userList);	
		System.out.println(output);
	}
	
	
	//delete user
	public static boolean dodeleteUser (ArrayList<User> userList, String email) {
		
		boolean isDeleted = false; 
		
		for (int i = 0; i < userList.size(); i++ ) {
			if (email.equalsIgnoreCase(userList.get(i).getEmail())) { 
				
				userList.remove(i); 
				isDeleted = true; 		
			}		
		}
		return isDeleted; 
	}

	public static void deleteUser (ArrayList<User> userList) {
		retrieveAllUser(userList);
		String email = Helper.readString("Enter email > ");
		Boolean isDeleted = dodeleteUser(userList,email); 	
		
		if (isDeleted == false) { 
			System.out.println("Invalid email"); 
			
		}else{ 
			System.out.println("User deleted");
			
		}
	}
//================================= Option 2 CATEGORY (ADD/VIEW/DELETE) =================================
		
		//user menu
		private static void CatMenu() {
			App.setHeader("CATEGORY OPTION");
			System.out.println("1. Add Category");
			System.out.println("2. View Category");
			System.out.println("3. Delete Category");
			System.out.println("4. Quit");
		}

		//retrieve all category 
		public static String retrieveAllCat (ArrayList <Category> catList) {
			String output = "";

			for (int i = 0; i < catList.size(); i++) {
				
				output += String.format ("%-10s\n", catList.get(i).getName());
			}
			return output;
		}
		
		
		// add category 
		public static Category inputCat() {
			String name = Helper.readString("Enter name > ");
	
			Category ca = new Category (name);
			return ca;
		}
		
		public static void addCat (ArrayList<Category> catList, Category ca) {
			catList.add(ca); 
		}
		
		
		// view category 
		public static void viewAllcat(ArrayList<Category> catList) {
			String output = String.format("%-10s\n", "NAME" );
			output += retrieveAllCat(catList);	
			System.out.println(output);
		}
		
		//delete category 
		public static boolean dodeletecat (ArrayList<Category> catList, String name) {
			boolean isDeleted = false; 
			
			for (int i = 0; i < catList.size(); i++ ) {
				if (name.equalsIgnoreCase(catList.get(i).getName())) { 
					
					catList.remove(i); 
					isDeleted = true; 		
				}		
			}
			return isDeleted; 
		}

		public static void deleteCat (ArrayList<Category> catList) {
			retrieveAllCat(catList);
			String name = Helper.readString("Enter name > ");
			Boolean isDeleted = dodeletecat(catList,name); 	
			
			if (isDeleted == false) { 
				System.out.println("Invalid category"); 
				
			}else{ 
				System.out.println("Category deleted"); 
			}
		}
//================================= Option 3 ITEMS (ADD/VIEW/DELETE) =================================
		// Item Menu
		private static void ItemMenu() {
			App.setHeader("ITEM OPTION");
			System.out.println("1. Add Item");
			System.out.println("2. View Item");
			System.out.println("3. Delete Item");
			System.out.println("4. Quit");
		}
		
		//retrieve all item
		public static String retrieveAllItem (ArrayList <Item> itemList) {
			String output = "";
			for (int i = 0; i < itemList.size(); i++) {
				output += String.format ("%-15s %-30s %-25.2f %-25s %-20s %-20.2f\n", 
						itemList.get(i).getName(), itemList.get(i).getDescription(), itemList.get(i).getMinbidprice(),
						itemList.get(i).getStartdate(), itemList.get(i).getEnddate(), itemList.get(i).getBidincrement());
			}
				return output;
		}
		
		// add item 
		public static Item inputItem() {
			String name = Helper.readString("Enter item name > ");
			String description = Helper.readString("Enter description of item > ");
			double minBidPrice = Helper.readDouble("Enter minimum bid price for item > ");
			String startDate = Helper.readString("Enter Auction Start Date > ");
			String endDate = Helper.readString("Enter Auction End Date > ");
			double bidIncrement = Helper.readDouble("Enter Bid Increment > ");
			Item i = new Item (name, description, minBidPrice, startDate, endDate, bidIncrement);
			
			return i;
		}
				
		public static void addItem (ArrayList<Item> itemList, Item i) {
			itemList.add(i); 
		}
		
		
		// View item
		public static void viewAllItems(ArrayList<Item> itemList) {
			String output = String.format("%-15s %-30s %-25s %-25s %-20s %-20s\n", "ITEM NAME", "ITEM DESCRIPTION", "MINIMUM BID PRICE", 
					"AUCTION START DATE", "AUCTION END DATE", "BID INCREMENT");
			output += retrieveAllItem(itemList);	
			System.out.println(output);
		}
				
		
		//Delete item
		public static boolean doDeleteItem (ArrayList<Item> itemList, String name) {
			boolean isDeleted = false; 	
			for (int i = 0; i < itemList.size(); i++ ) {
				if (name.equalsIgnoreCase(itemList.get(i).getName())) { 
					itemList.remove(i); 
					isDeleted = true; 		
				}		
			}
			return isDeleted; 
		}

		
		public static void deleteItem (ArrayList<Item> itemList) {
			retrieveAllItem(itemList);
			String name = Helper.readString("Enter name > ");
			Boolean isDeleted = doDeleteItem(itemList,name); 	
					
			if (isDeleted == false) { 
				System.out.println("Item cannot be found"); 
						
			} else { 
				System.out.println("Item deleted"); 
			}
		}
//================================= Option 4 BID (ADD/VIEW/DELETE) =================================
		// Bid Menu
		private static void BidMenu() {
			App.setHeader("BID OPTION");
			System.out.println("1. Add Bid");
			System.out.println("2. View Bid");
			System.out.println("3. Delete Bid");
			System.out.println("4. Quit");
		}
		
		//retrieve all bid
		public static String retrieveAllBid (ArrayList <Bid> BidList) {
			String output = "";
			for (int i = 0; i < BidList.size(); i++) {
				output += String.format ("%-15s %-25d %-25s %-20s %-20.2f\n", 
						BidList.get(i).getName(), BidList.get(i).getBidId(),
						BidList.get(i).getSellerEmail(), BidList.get(i).getBuyerEmail(), BidList.get(i).getBidPrice());
			}
				return output;
		}
		// add bid 
		public static Bid inputBid() {
			String name = Helper.readString("Enter item name > ");
//			String description = Helper.readString("Enter description of bid > ");
			int id = Helper.readInt("Enter bid id > ");
			String selleremail = Helper.readString("Enter seller email > ");
			String buyeremail = Helper.readString("Enter buyer email > ");
			double bidprice = Helper.readDouble("Enter bid price > ");
			
			Bid b = new Bid(name, id, selleremail, buyeremail, bidprice);
			
			return b;
		}
				
		public static void addBid (ArrayList<Bid> bidList, Bid b) {
			bidList.add(b); 
		}
		
		
		// View bid
		public static void viewAllBids(ArrayList<Bid> bidList) {
			String output = String.format("%-15s %-25s %-25s %-20s %-20s\n", "BID NAME", "BID ID", "SELLER EMAIL", 
					"BUYER EMAIL", "BID PRICE");
			output += retrieveAllBid(bidList);	
			System.out.println(output);
		}
				
		
		//Delete bid
		public static boolean doDeleteBid (ArrayList<Bid> bidList, int id) {
			boolean isDeleted = false; 	
			for (int i = 0; i < bidList.size(); i++ ) {
				if (id==(bidList.get(i).getBidId())) { 
					bidList.remove(i); 
					isDeleted = true; 		
				}		
			}
			return isDeleted; 
		}

		
		public static void deleteBid (ArrayList<Bid> bidList) {
			retrieveAllBid(bidList);
			int id = Helper.readInt("Enter id > ");
			Boolean isDeleted = doDeleteBid(bidList,id); 	
					
			if (isDeleted == false) { 
				System.out.println("Bid does not exist"); 
						
			} else { 
				System.out.println("Bid deleted"); 
			}
		}
	
}