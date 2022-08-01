import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Category> categoryList = new ArrayList<Category>(); 
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();
	
	int option = 0;

	while (option != 6) {

		App.menu();
		option = Helper.readInt("Enter an option > ");

		if (option == 1) {

		} else if (option == 2) {
			
		} else if (option == 3) {
			
		} else if (option == 4) {
			
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


}
