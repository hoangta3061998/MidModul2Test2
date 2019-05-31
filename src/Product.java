public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private String description;
    private int price;
    private boolean status;

    public Product() {
        id = 0;
        name = "unknown";
        description = "unknown";
        price = 0;
        status = false;
    }

    public Product(int id, String name, String description, int price, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public int compareTo(Product product){
        if(this.price>product.price){
            return 1;
        } else if(this.price==product.price){
            return 0;
        } else {
            return -1;
        }
    }
}
