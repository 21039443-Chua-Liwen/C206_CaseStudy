import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("KEN","Student", "ken191@gmail.com","dskjdwd"));
		
		ArrayList<Category> catList = new ArrayList<Category>(); 
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		ArrayList<Deal> dealList = new ArrayList<Deal>();
	
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


	//================================= Option 1 USER (ADD/VIEW/DELET) =================================
	
	//user menu
	private static void UserMenu() {
		App.setHeader("USER OPTON");
		System.out.println("1. Add User");
		System.out.println("2. View User");
		System.out.println("3. Delete User");
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
//================================= Option 2 CATEGORY (ADD/VIEW/DELET) =================================
		
		//user menu
		private static void CatMenu() {
			App.setHeader("CATEGORY OPTON");
			System.out.println("1. Add Category");
			System.out.println("2. View Category");
			System.out.println("3. Delete Category");
		}

		//retrieve all user 
		public static String retrieveAllCat (ArrayList <Category> catList) {
			String output = "";

			for (int i = 0; i < catList.size(); i++) {
				
				output += String.format ("%-10s\n", catList.get(i).getName());
			}
			return output;
		}
		
		
		// add user 
		public static Category inputCat() {
			String name = Helper.readString("Enter name > ");
	
			Category ca = new Category (name);
			return ca;
		}
		
		public static void addCat (ArrayList<Category> catList, Category ca) {
			catList.add(ca); 
		}
		
		
		// view user
		public static void viewAllcat(ArrayList<Category> catList) {
			String output = String.format("%-10s\n", "NAME" );
			output += retrieveAllCat(catList);	
			System.out.println(output);
		}
		
		//delete user
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
	}