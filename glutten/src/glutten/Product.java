package glutten;

public class Product {
    private int fdc_id;
    private String brand_name;
    private String description;

    public Product(int id, String name, String desc){
        fdc_id = id;
        brand_name = name;
        description = desc;
    }

    public String getName() {
        return brand_name;
    }

    public void setName(String name) {
        brand_name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        description = desc;
    }

    public int getId() { 
    	return fdc_id; 
    }

    public void setId(int id) { 
    	fdc_id = id; 
    }

    @Override
    public String toString() {
        return "Product{" +
                "fdc_id=" + fdc_id +
                ", brand_name='" + brand_name + '\'' +
                ", description=" + description +
                '}';
    }
}
