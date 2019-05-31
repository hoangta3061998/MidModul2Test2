import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ProductManagerImpl productManager = new ProductManagerImpl();
        do {
            System.out.println("\n********************************");
            System.out.println("Product Managerment");
            System.out.println("1.Add product");
            System.out.println("2.Edit product");
            System.out.println("3.Delete product");
            System.out.println("4.Find product");
            System.out.println("5.Show list of products");
            System.out.println("6.Sort by price");
            System.out.println("0.Exit");
            System.out.println("\n********************************");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter price:");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter status(true = available, false = not available):");
                    boolean status = scanner.nextBoolean();
                    Product product = new Product(id, name, description, price, status);
                    if (productManager.addProduct(product)) {
                        System.out.println("Added success");
                    } else {
                        System.out.println("Product is already existed.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter id product you want to edit:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter new description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter new price");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new status(true or false):");
                    boolean status = scanner.nextBoolean();
                    Product product = new Product(id, name, description, price, status);
                    if (productManager.editProduct(id, product)) {
                        System.out.println("Edited success");
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (productManager.deleteProduct(id)) {
                        System.out.println("Delete success");
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (productManager.findProduct(id) != -1) {
                        Product product = productManager.getProductsList().get(productManager.findProduct(id));
                        System.out.println("Result:");
                        System.out.println("\nId \t Name \t Description \t Price \t Status");
                        System.out.printf("\n%d \t %s \t %s \t %d \t %b ", product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.isStatus());
                    }else {
                        System.out.println("Invalid ID");
                    }
                    break;
                }
                case 5:
                    ArrayList<Product> list = productManager.displayAllProducts();
                    System.out.println("Id \t Name \t Description \t Price \t Status");
                    for (Product p : list) {
                        System.out.printf("\n%d \t %s \t %s \t %d \t %b", p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.isStatus());
                    }
                    break;
                case 6:
                    productManager.sortByPrice();
                    break;
                case 0:
                    System.exit(0);


            }
        } while (choice != 0);
    }
}

