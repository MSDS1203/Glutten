package glutten;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	
    	Scanner input = new Scanner(System.in);
    	char options = 'y';
    	String keyword, restaurant;
    	char y_n = 'y';
    	int id;
    	
    	try (var connection =  DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    	
    	System.out.println("**** Welcome to Glutten! **** ");
    	
    	while(options != 'n')
    	{
    		System.out.println("Would like to search by product (p) or by restaurant (r) or end application (n)?");
        	options = input.next().charAt(0);
        	
    		if (options == 'p')
        	{
        		while(y_n == 'y')
        		{
        			input.nextLine();
            		System.out.println("Enter a keyword: ");
               		keyword = input.nextLine();
                    
                    List<Product> productsWKeyword = new ArrayList<Product>();
                    productsWKeyword = FoodDB.searchProducts(keyword);
                    
                    for(int i = 0; i < productsWKeyword.size(); i++) {
                    	System.out.println(productsWKeyword.get(i).toString());
                    	
                    }
                    
                    System.out.println("Would you like to search again?");
                    y_n = input.next().charAt(0);
        		}
        		
        		do {
        			input.nextLine();
        			System.out.println("Enter an fdc_id to see all ingredients: ");
                	id = input.nextInt();
                	String getId;
                	getId = FoodDB.isGlutenFree(id);
                    System.out.println(getId);
                    
                    System.out.println("Would you like to search for another item?");
                    y_n = input.next().charAt(0);
                    
        		}while(y_n == 'y');
    			

        	}
    		
    		else if (options == 'r') {
    			input.nextLine();
    			System.out.println("Enter a restaurant: ");
    			restaurant = input.nextLine();
    			System.out.println("Hit enter to continue: ");
    			input.nextLine();
    			List<MenuItem> rest1 = new ArrayList<MenuItem>();
    			List<MenuItem> rest2 = new ArrayList<MenuItem>();
    	        rest1 = RestaurantDB.searchGFByRestaurant(restaurant);
    	        rest2 = RestaurantDB.searchOptionsByRestaurant(restaurant);
    	        
    	        System.out.println("\nGluten-Free Menu Items:");
    	        for(int i = 0; i < rest1.size(); i++) {
                	System.out.println(rest1.get(i).getName());
                	
                }
    	        
    	        System.out.println("\nMenu Items that Have the Option to be Gluten Free:");
    	        for(int i = 0; i < rest2.size(); i++) {
    	        	
    	        	System.out.println(rest2.get(i).getName());
                	
                }
    			
    		}
    		else if(options == 'n') {
    			System.out.println("Good bye!");
    		}
    		
    		else {
    			System.out.println("Invalid input - try again");
    		}
    	
    	}
    	
    	
    	
        
        
        /*
        List<Product> testTest = new ArrayList<Product>();
        testTest = FoodDB.searchProducts("chicken");
        System.out.println(testTest.toString());
        
        String test;
        test = FoodDB.isGlutenFree(1163689);
        System.out.println(test);
        
        List<MenuItem> menuTest = new ArrayList<MenuItem>();
        menuTest = RestaurantDB.searchMenuItems("burger");
        System.out.println(menuTest.toString()); */
        
    }
}
