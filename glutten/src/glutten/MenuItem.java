package glutten;

public class MenuItem {
    private String restaurant;
    private String item_name;
    private String description;
    private int gluten;

    public MenuItem(String rest, String name, String desc, int gluten){
        restaurant = rest;
        item_name = name;
        description = desc;
        this.gluten = gluten;
    }

    public MenuItem(String rest, String name, String desc){
        restaurant = rest;
        item_name = name;
        description = desc;
        this.gluten = -1;
    }
    
    public String getName() {
        return item_name;
    }

    public void setName(String name) {
        item_name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        description = desc;
    }

    public String getRestaurant() { 
    	return restaurant; 
    }

    public void setRestaurant(String rest) { 
    	restaurant = rest; 
    }
    
    public int getGluten() {
    	return gluten;
    }
    
    public void setGluten(int gluten) {
    	this.gluten = gluten;
    }

    @Override
    public String toString() {
        return "MenuItem {" +
                "Restaurant=" + restaurant +
                ", menu_item=" + item_name + '\'' +
                ", description=" + description +
                ", glutenContaining=" + gluten +
                '}';
    }
}
