import java.util.ArrayList;

public interface ProductManager {
    boolean addProduct(Product product);

    boolean editProduct(int id, Product product);

    boolean deleteProduct(int id);

    Product findProduct(int id);

    void sortByPrice();

    ArrayList<Product> displayAllProducts();


}
