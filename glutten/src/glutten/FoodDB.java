package glutten;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDB {
	 public static List<Product> searchProducts(String query){
		 var products = new ArrayList<Product>();
		 
		 var sql = "SELECT fdc_id, brand_name, description FROM food_name WHERE description LIKE ?;";
		 
		 try (var conn =  DB.connect();
	             var pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, '%' + query + '%');
	            var rs = pstmt.executeQuery();
	            while (rs.next()) {
	                var product = new Product(
	                    rs.getInt("fdc_id"),
	                    rs.getString("brand_name"),
	                    rs.getString("description")
	                );
	               products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
		 return products;
		 
	 }
	 
	 public static String isGlutenFree(int id) {
		 Product products = searchGluten(id);
		 if(products == null)
			 return null;
		 var sql1 = "SELECT brand_name, description, ingredients "
		 		+ "FROM food_name "
		 		+ "WHERE fdc_id=? AND LOWER(ingredients) "
		 		+ "LIKE ANY (ARRAY['%wheat%', '%durum%', '%emmer%', "
		 		+ "'%semolina%', '%spelt%', '%farina%', '%farro%', '%graham%', '%khorasan%', "
		 		+ "'%rye%', '%barley%', '%triticale%', '%malt%', '%yeast%'])";
		 var sql2 = "SELECT brand_name, description, ingredients "
		 		+ "FROM food_name "
		 		+ "WHERE fdc_id=? AND LOWER(ingredients) "
		 		+ "LIKE ANY (ARRAY['%oat%', '%french fries%', '%potato chip%', "
		 		+ "'%lunch meat%', '%soup%', '%multigrain%', '%dressing%', '%soy sauce%'])"
		 		+ " AND LOWER(ingredients) NOT LIKE ANY (ARRAY['%wheat%', '%durum%', '%emmer%', "
		 		+ "'%semolina%', '%spelt%', '%farina%', '%farro%', '%graham%', '%khorasan%', "
		 		+ "'%rye%', '%barley%', '%triticale%', '%malt%', '%yeast%'])";
		 var sql3 = "SELECT brand_name, description, ingredients "
		 		+ "FROM food_name "
		 		+ "WHERE fdc_id=? AND LOWER(ingredients) "
		 		+ "NOT LIKE ANY (ARRAY['%wheat%', '%durum%', '%emmer%', "
		 		+ "'%semolina%', '%spelt%', '%farina%', '%farro%', '%graham%', '%khorasan%', "
		 		+ "'%rye%', '%barley%', '%triticale%', '%malt%', '%yeast%'])"
		 		+ " OR LOWER(ingredients) NOT LIKE ANY (ARRAY['%oat%', '%french fries%', '%potato chip%', "
		 		+ "'%lunch meat%', '%soup%', '%multigrain%', '%dressing%', '%soy sauce%'])";
		 try (var conn1 =  DB.connect();
		            var pstmt1 = conn1.prepareStatement(sql1)) {
		            pstmt1.setInt(1, id);
		            var rs1 = pstmt1.executeQuery();
		            if (rs1.next()) {
		            	return "Contains Gluten\n" + products.toString();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		 try (var conn2 =  DB.connect();
		            var pstmt2 = conn2.prepareStatement(sql2)) {
		            pstmt2.setInt(1, id);
		            var rs2 = pstmt2.executeQuery();
		            if (rs2.next()) {
		            	return "May Contain Gluten\n" + products.toString();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		 try (var conn3 =  DB.connect();
		            var pstmt3 = conn3.prepareStatement(sql3)) {
		            pstmt3.setInt(1, id);
		            var rs3 = pstmt3.executeQuery();
		            if (rs3.next()) {
		            	return "Gluten Free\n" + products.toString();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		 return null;
	 }
	 
	 private static Product searchGluten(int id){
		
		 var sql = "SELECT fdc_id, brand_name, ingredients FROM food_name WHERE fdc_id=? ";
		 
		 try (var conn =  DB.connect();
	            var pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            var rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Product(
	                    rs.getInt("fdc_id"),
	                    rs.getString("brand_name"),
	                    rs.getString("ingredients")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 
		 return null;
		 
	 }

}
