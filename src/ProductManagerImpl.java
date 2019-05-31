import java.util.ArrayList;
import java.util.Collections;

public class ProductManagerImpl implements ProductManager {
    private static final int INVALIDID = -1;
    private ArrayList<Product> productsList;

    public ProductManagerImpl() {
        productsList = new ArrayList<>();
    }

    public ProductManagerImpl(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    private int getIndexById(int id) {
        int index = INVALIDID;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    private boolean isDuplicateProduct(Product product) {
        boolean isDuplicate = false;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == product.getId()) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    @Override
    public boolean addProduct(Product product) {
        if (isDuplicateProduct(product)) {
            return false;
        } else {
            productsList.add(product);
            return true;
        }
    }

    @Override
    public boolean editProduct(int id, Product product) {
        if (getIndexById(id) != -1) {
            Product productEdit = productsList.get(getIndexById(id));
            productEdit.setName(product.getName());
            productEdit.setDescription(product.getDescription());
            productEdit.setPrice(product.getPrice());
            productEdit.setStatus(product.isStatus());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        if(getIndexById(id)!= -1){
            productsList.remove(getIndexById(id));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int findProduct(int id) {
        if(getIndexById(id)!= INVALIDID){
            return getIndexById(id);
        } else {
            return INVALIDID;
        }
    }

    @Override
    public void sortByPrice() {
        Collections.sort(productsList);
    }

    @Override
    public ArrayList<Product> displayAllProducts() {
        return productsList;
    }
}
