package glutten;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDB {
	public static List<MenuItem> searchMenuItems(String query){
		 var menuItems = new ArrayList<MenuItem>();
		 
		 var sql = "SELECT rest_name, menu_item, description FROM restaurant WHERE item_name LIKE ?;";
		 
		 try (var conn =  DB.connect();
	             var pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, '%' + query + '%');
	            var rs = pstmt.executeQuery();
	            while (rs.next()) {
	                var item = new MenuItem(
	                    rs.getString("rest_name"),
	                    rs.getString("menu_item"),
	                    rs.getString("description")
	                );
	               menuItems.add(item);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
		 return menuItems;
		 
	 }
	
	public static List<MenuItem> searchGFByRestaurant(String rest){
		 var menuItems = new ArrayList<MenuItem>();
		 
		 var sql = "SELECT menu_item, description FROM restaurant WHERE rest_name LIKE ? AND glutenContaining=0;";
		 
		 try (var conn =  DB.connect();
	             var pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, '%' + rest + '%');
	            var rs = pstmt.executeQuery();
	            while (rs.next()) {
	                var item = new MenuItem(
	                    rs.getString("rest_name"),
	                    rs.getString("menu_item"),
	                    rs.getString("description")
	                );
	               menuItems.add(item);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
		 return menuItems;
	}
	
	public static List<MenuItem> searchOptionsByRestaurant(String rest){
		 var menuItems = new ArrayList<MenuItem>();
		 
		 var sql = "SELECT menu_item, description FROM restaurant WHERE rest_name LIKE ? AND glutenContaining=1;";
		 
		 try (var conn =  DB.connect();
	             var pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, '%' + rest + '%');
	            var rs = pstmt.executeQuery();
	            while (rs.next()) {
	                var item = new MenuItem(
	                    rs.getString("rest_name"),
	                    rs.getString("menu_item"),
	                    rs.getString("description")
	                );
	               menuItems.add(item);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
		 return menuItems;
	}
}


