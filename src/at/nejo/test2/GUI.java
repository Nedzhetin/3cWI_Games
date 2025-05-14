package at.nejo.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class GUI {
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    private List<AbstractProduct> cart = new ArrayList<AbstractProduct>();
    private Scanner scanner = new Scanner(System.in);


    public void showUI() {
        System.out.println("1. Display Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. Show Cart");
        System.out.println("4. Sum of All Products");

    }

    public void addProduct(AbstractProduct product) {
        if (products == null) {
           return;
        }
        products.add(product);
    }

    public void displayProducts() {
        if(products == null) {
            System.out.println("No products available.");
            return;
        }
        for (AbstractProduct product : products) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Title: " + product.getTitle());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println();
        }
    }

    public void addToCart(AbstractProduct product) {
        cart.add(product);
        System.out.println("Added to cart: " + product.getTitle());
    }

    public void showCart() {
        System.out.println("Cart contents:");
        for (AbstractProduct product : cart) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Title: " + product.getTitle());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println();
        }
    }

    public void sumOfAllProducts() {
        double total = 0;
        for (AbstractProduct product : products) {
            total += product.getPrice();
        }
        System.out.println("Total price of all products: " + total);
    }

    public void start(){
        while(true){
            showUI();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    int id = scanner.nextInt();
                    for (AbstractProduct product : products) {
                        if (product.getId() == id) {
                            addToCart(product);
                            break;
                        }
                    }
                    break;
                case 3:
                    showCart();
                    break;
                case 4:
                    sumOfAllProducts();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }





}

