package glutten;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try (var connection =  DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        List<Product> testTest = new ArrayList<Product>();
        testTest = FoodDB.searchProducts("chicken");
        System.out.println(testTest.toString());
        
        String test;
        test = FoodDB.isGlutenFree(1163689);
        System.out.println(test);
    }
}
