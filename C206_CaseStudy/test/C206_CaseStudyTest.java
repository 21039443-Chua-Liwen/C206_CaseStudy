import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//prepare test data
	private User uu1; 
	private User uu2;
	private User uu3;
	private Category cc1; 
	private Category cc2; 
	private Category cc3; 
	private Item ii1; 
	private Item ii2;
	private Item ii3;
	private Bid bb1; 
	private Bid bb2; 
	private Bid bb3; 
	private Deal dd1; 
	private Deal dd2;
	private Deal dd3; 
	
	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<Category> catList = new ArrayList<Category>(); 
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Bid> bidList = new ArrayList<Bid>();
	ArrayList<Deal> dealList = new ArrayList<Deal>();
	

	@Before
	public void setUp() throws Exception {
		// prepare test data
		uu1 = new User("KEN","Student", "ken191@gmail.com","dskjdwd");
		uu2 = new User("MART","Student", "mart91@gmail.com","dkjwd"); 
		uu3 = new User("DANISH","Student", "danish19@gmail.com","dkd"); 
		
		cc1 = new Category ("shoes"); 
		cc2 = new Category ("clothes"); 
		cc3 = new Category ("electronics"); 
		
		ii1 = new Item ("Macbook","Brand new", 100.00, "01/01/2010","01/03/2012", 2.00); 
		ii2 = new Item ("Book","New", 20.00, "01/01/2011","01/03/2014", 1.00); 
		ii3 = new Item("Test Name", "Test Description", 3, "12/12/2022", "30/12/2022", 5);
		
		bb1 = new Bid("Bid Name", 358, "Mary289@gmail.com", "David463@gmail.com", 10.00);
		bb2 = new Bid("Bid Name", 320, "John289@gmail.com", "Henry463@gmail.com", 50.00);
		bb3 = new Bid("Bid Name", 5, "Shaun289@gmail.com", "Jingen463@gmail.com", 5.00);
		
		dd1 = new Deal ("Deal Name", 2, "Shaun289@gmail.com", "Jingen463@gmail.com", 20.0,"12/12/2022"); 
		dd2 = new Deal ("Deal Name", 3, "John289@gmail.com", "Henry463@gmail.com", 50.00, "12/12/2022"); 
		dd3 = new Deal ("Deal Name", 4, "Mary289@gmail.com", "David463@gmail.com", 10.00, "12/12/2022");
		
		userList= new ArrayList<User>();
		catList = new ArrayList<Category>(); 
		itemList = new ArrayList<Item>();
		bidList = new ArrayList<Bid>();
		dealList = new ArrayList<Deal>();
	}
	
//====================================== USER ==========================================================================
	@Test
	public void addUser() { 
		// user list is not null, so that can add a new user
		assertNotNull("Test if there is valid user arraylist to add to", userList);
		
		//given an empty list, after adding 1 user, the size of the list is 1
		App.addUser(userList, uu1);		
		assertEquals("Test if that user arraylist size is 1?", 1, userList.size());
		
		//The user just added is as same as the first user of the list
		assertSame("Test that user is added same as 1st item of the list?", uu1, userList.get(0));
		
		//Add 2 other users. Test The size of the list is 3?
		App.addUser(userList, uu2);
		App.addUser(userList, uu3);
		assertEquals("Test that user arraylist size is 3?", 3, userList.size());
		assertSame("Test that user is added same as 3rd item of the list?", uu2, userList.get(1));	
	}
	
	@Test
	public void viewAllUser() {
		// test if user list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		
		//test if the list of user retrieved is empty
		String allUser= App.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check view all userList", testOutput, allUser);
				
		//Given an empty list, after adding 2 users, test if the size of the list is 2
		App.addUser(userList, uu1);
		App.addUser(userList, uu2);
		assertEquals("Test if that user arraylist size is 2?", 2, userList.size());
		
		//test if the expected output string same as the list of user retrieved
		allUser= App.retrieveAllUser(userList);
		
		testOutput = String.format("%-10s %-10s %-30s %-40s\n","KEN","Student", "ken191@gmail.com","dskjdwd");
		testOutput += String.format("%-10s %-10s %-30s %-40s\n","MART","Student", "mart91@gmail.com","dkjwd");
	
		assertEquals("Check that viewAllUser", testOutput, allUser );
	}
	
	@Test
	public void deleteUser() { 
		//given an empty list, after adding 2 user, the size of the list is 2
		App.addUser(userList, uu1);	
		App.addUser(userList, uu2);	
		assertEquals("Test if that user arraylist size is 1?", 2, userList.size());
		
		//The user added is as same as the first item of the list
		assertSame("Test that user is added same as 1st item of the list?", uu1, userList.get(0));
				
		// user list is not null, so that can delete a new user
		assertNotNull("Test if there is valid user arraylist to delete from", userList);
		
		//Delete user. test The size of the list is back to 1
		App.dodeleteUser(userList, uu1.getEmail());
		assertEquals("Test that user arraylist size is 1?", 1, userList.size());
		assertSame("Test that 2nd user added is the first item of the list?", uu2, userList.get(0));	
	}
	
	//====================================== CATEGORY ==========================================================================
	@Test
	public void addCat() { 
		// user list is not null, so that can add a new category
		assertNotNull("Test if there is valid Category arraylist to add to", userList);
			
		//given an empty list, after adding 1 category, the size of the list is 1
		App.addCat(catList, cc1);		
		assertEquals("Test if that user arraylist size is 1?", 1, catList.size());
			
		//The user just added is as same as the first category of the list
		assertSame("Test that category is added same as 1st item of the list?", cc1, catList.get(0));
			
		//Add another user. Test The size of the list is 3
		App.addCat(catList, cc2);
		App.addCat(catList, cc3);
		assertEquals("Test that category arraylist size is 3?", 3, catList.size());
		assertSame("Test that category is added same as 3rd item of the list?", cc2, catList.get(1));	
	}
		
	@Test
	public void viewAllcat() {
		// test if user list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Category arraylist to add to", catList);
			
		//test if the list of user retrieved from the SourceCentre is empty
		String allCat = App.retrieveAllCat(catList);
		String testOutput = "";
		assertEquals("Check view all categoryList", testOutput, allCat);
					
		//Given an empty list, after adding 2 users, test if the size of the list is 2
		App.addCat(catList, cc1);
		assertEquals("Test if that Category arraylist size is 2?", 1, catList.size());
			
		//test if the expected output string same as the list of user retrieved from the SourceCentre
		allCat= App.retrieveAllCat(catList);
			
		testOutput = String.format("%-10s\n","shoes");;
		
		assertEquals("Check that viewAllCat", testOutput, allCat );
	}
		
	@Test
	public void deleteCat() { 
		//given an empty list, after adding 2 Category, the size of the list is 2
		App.addCat(catList, cc1);	
		App.addCat(catList, cc2);	
		assertEquals("Test if that category arraylist size is 1?", 2, catList.size());
			
		//The Category added is as same as the first Category of the list
		assertSame("Test that category is added same as 1st category of the list?", cc1, catList.get(0));
					
		// Category list is not null, so that can delete a new Category
		assertNotNull("Test if there is valid category arraylist to delete from", catList);
			
		//Delete category. test The size of the list is back to 1
		App.dodeletecat(catList, cc1.getName());
		assertEquals("Test that category arraylist size is 1?", 1, catList.size());
		assertSame("Test that 2nd category added is the first item of the list?", cc2, catList.get(0));	
	}
	
	//====================================== ITEM ==========================================================================
	@Test
	public void addItem() { 
		// user list is not null, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
					
		//given an empty list, after adding 1 item, the size of the list is 1
		App.addItem(itemList, ii1);		
		assertEquals("Test if that item arraylist size is 1?", 1, itemList.size());
					
		//The item just added is as same as the first item of the list
		assertSame("Test that item is added same as 1st item of the list?", ii1, itemList.get(0));
					
		//Add another item. test The size of the list is 2?
		App.addItem(itemList, ii2);
		assertEquals("Test that item arraylist size is 3?", 2, itemList.size());
		assertSame("Test that item is added same as 3rd item of the list?", ii2, itemList.get(1));	
	}
				
	@Test
	public void viewAllItem() {
		// test if item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", itemList);
			
		//test if the list of item retrieved from the SourceCentre is empty
		String allItem = App.retrieveAllItem(itemList);			
		String testOutput = "";
		assertEquals("Check view all itemList", testOutput, allItem);
								
		//Given an empty list, after adding 2 item, test if the size of the list is 2
		App.addItem(itemList, ii1);
		assertEquals("Test if that item arraylist size is 2?", 1, itemList.size());
						
		//test if the expected output string same as the list of item retrieved from the SourceCentre
		allItem= App.retrieveAllItem(itemList);
						
		testOutput += String.format ("%-15s %-30s %-25.2f %-25s %-20s %-20.2f\n","Macbook","Brand new", 100.00, "01/01/2010","01/03/2012", 2.00); 
		assertEquals("Check that viewAllItem", testOutput, allItem );
	}
				
	@Test
	public void deleteItem() { 
		//given an empty list, after adding 2 item, the size of the list is 2
		App.addItem(itemList, ii1);	
		App.addItem(itemList, ii2);	
		assertEquals("Test if that item arraylist size is 1?", 2, itemList.size());
					
		//The user added is as same as the first item of the list
		assertSame("Test that item is added same as 1st category of the list?", ii1, itemList.get(0));
							
		// user list is not null, so that can delete a new item
		assertNotNull("Test if there is valid item arraylist to delete from", itemList);
					
		//Delete item. test The size of the list is back to 1
		App.doDeleteItem(itemList, ii1.getName());
		assertEquals("Test that item arraylist size is 1?", 1, itemList.size());
		assertSame("Test that 2nd item added is the first item of the list?", ii2, itemList.get(0));	
	}
	
	//====================================== Bid ==========================================================================
	@Test
	public void addBid() { 
		// user list is not null, so that can add a new bid
		assertNotNull("Test if there is valid bid arraylist to add to", bidList);
							
		//given an empty list, after adding 1 bid, the size of the list is 1
		App.addBid(bidList, bb1);		
		assertEquals("Test if that bid arraylist size is 1?", 1, bidList.size());
						
		//The user just added is as same as the first bid of the list
		assertSame("Test that item is added same as 1st item of the list?", bb1, bidList.get(0));
							
		//Add another bid. test The size of the list is 3?
		App.addBid(bidList, bb2);
		App.addBid(bidList, bb3);
		assertEquals("Test that bid arraylist size is 3?", 3, bidList.size());
		assertSame("Test that bid is added same as 2nd item of the list?", bb2, bidList.get(1));	
	}
						
	@Test
	public void viewAllBid() {
		// test if bid list is not null but empty, so that can add a new bid
		assertNotNull("Test if there is valid Item arraylist to add to", bidList);
						
		//test if the list of bid retrieved from the SourceCentre is empty
		String allBid = App.retrieveAllBid(bidList);			
		String testOutput = "";
		assertEquals("Check view all bidList", testOutput, allBid);
											
		//Given an empty list, after adding 2 bid, test if the size of the list is 2
		App.addBid(bidList, bb1);
		assertEquals("Test if that bid arraylist size is 2?", 1, bidList.size());
									
		//test if the expected output string same as the list of bid retrieved from the SourceCentre
		allBid= App.retrieveAllBid(bidList);
									
		testOutput += String.format ("%-15s %-25d %-25s %-20s %-20.2f\n","Bid Name", 358, "Mary289@gmail.com", "David463@gmail.com", 10.00); 
		assertEquals("Check that viewAllBid", testOutput, allBid );
	}
						
	@Test
	public void deleteBid() { 
		//given an empty list, after adding 2 bid, the size of the list is 2
		App.addBid(bidList, bb1);	
		App.addBid(bidList, bb2);	
		assertEquals("Test if that bid arraylist size is 1?", 2, bidList.size());
						
		//The bid added is as same as the first item of the list
		assertSame("Test that bid is added same as 1st category of the list?", bb1, bidList.get(0));
									
		// bid list is not null, so that can delete a new bid
		assertNotNull("Test if there is valid bid arraylist to delete from", bidList);
							
		//Delete user. test The size of the list is back to 1
		App.doDeleteBid(bidList, bb1.getBidId());
		assertEquals("Test that bid arraylist size is 1?", 1, bidList.size());
		assertSame("Test that 2nd bid added is the first bid of the list?", bb2, bidList.get(0));	
	}	
			
	//====================================== Deal ==========================================================================
	@Test
	public void addDeal() { 

		// deal list is not null, so that can add a new deal
		assertNotNull("Test if there is valid deal arraylist to add to", dealList);
								
		//given an empty list, after adding 1 deal, the size of the list is 1
		App.addDeal(dealList, dd1);		
		assertEquals("Test if that deal arraylist size is 1?", 1, dealList.size());
							
		//The deal just added is as same as the first user of the list
		assertSame("Test that deal is added same as 1st item of the list?", dd1, dealList.get(0));
								
		//Add another deal. test The size of the list is 3?
		App.addDeal(dealList, dd2);
		App.addDeal(dealList, dd3);
		assertEquals("Test that deal arraylist size is 2?", 3, dealList.size());
		assertSame("Test that item is added same as 3rd item of the list?", dd2, dealList.get(1));	
	}
							
	@Test
	public void viewAllDeal() {
		// test if user list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Item arraylist to add to", dealList);
							
		//test if the list of user retrieved from the SourceCentre is empty
		String allDeal = App.retrieveAllDeal(dealList);			
		String testOutput = "";
		assertEquals("Check view all dealList", testOutput, allDeal);
												
		//Given an empty list, after adding 2 deals, test if the size of the list is 2
		App.addDeal(dealList, dd1);
		assertEquals("Test if that item arraylist size is 2?", 1, dealList.size());
										
		//test if the expected output string same as the list of deal retrieved from the SourceCentre
		allDeal= App.retrieveAllDeal(dealList);
										
		testOutput += String.format ("%-15s %-25s %-25s %-20s %-20s %-20s\n","Deal Name", 2, "Shaun289@gmail.com", "Jingen463@gmail.com", 20.0,"12/12/2022"); 
		assertEquals("Check that viewAllItem", testOutput, allDeal );
	}
							
	@Test
	public void deleteDeal() { 
		//given an empty list, after adding 2 deal, the size of the list is 2
		App.addDeal(dealList, dd1);	
		App.addDeal(dealList, dd2);	
		assertEquals("Test if that deal arraylist size is 1?", 2, dealList.size());
							
		//The deal added is as same as the first deal of the list
		assertSame("Test that deal is added same as 1st category of the list?", dd1, dealList.get(0));
										
		// deal list is not null, so that can delete a new deal
		assertNotNull("Test if there is valid deal arraylist to delete from", dealList);
								
		//Delete deal. test The size of the list is back to 1
		App.doDeleteDeal(dealList, dd1.getDealID());
		assertEquals("Test that item arraylist size is 1?", 1, dealList.size());
		assertSame("Test that 2nd item added is the first item of the list?", dd2, dealList.get(0));	
	}		
	
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
