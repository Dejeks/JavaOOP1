package org.example.Homework.HW7;

import java.util.ArrayList;
import java.util.List;

class Product {
    private final String name;
    private final double price;
    private final int rating;

    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}

class Category {
    private String name;
    private final List<Product> products;

    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Basket {
    private final List<Product> purchasedProducts;

    public Basket() {
        purchasedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        purchasedProducts.add(product);
    }

    public void removeProduct(Product product) {
        purchasedProducts.remove(product);
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
}

class User {
    private final String username;
    private final String password;
    private final Basket basket;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        basket = new Basket();
    }

    public Basket getBasket() {
        return basket;
    }

    public String getUsername() {
        return username;
    }
}

public class Task {
    public static void main(String[] args) {
        Product product1 = new Product("Товар 1", 10.99, 4);
        Product product2 = new Product("Товар 2", 5.99, 3);
        Product product3 = new Product("Товар 3", 7.49, 5);

        Category category1 = new Category("Категория 1");
        category1.addProduct(product1);
        category1.addProduct(product2);

        Category category2 = new Category("Категория 2");
        category2.addProduct(product3);

        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        user1.getBasket().addProduct(product1);
        user1.getBasket().addProduct(product3);

        user2.getBasket().addProduct(product2);

        System.out.println("Каталог продуктов:");
        printCatalog(category1);
        printCatalog(category2);

        System.out.println("\nПокупки пользователей:");
        printPurchases(user1);
        printPurchases(user2);
    }

    public static void printCatalog(Category category) {
        System.out.println("Категория: " + category.getName());
        List<Product> products = category.getProducts();
        for (Product product : products) {
            System.out.println("Название: " + product.getName() + ", Цена: " + product.getPrice() + ", Рейтинг: " + product.getRating());
        }
        System.out.println();
    }

    public static void printPurchases(User user) {
        System.out.println("Пользователь: " + user.getUsername());
        List<Product> purchasedProducts = user.getBasket().getPurchasedProducts();
        for (Product product : purchasedProducts) {
            System.out.println("Название: " + product.getName() + ", Цена: " + product.getPrice() + ", Рейтинг: " + product.getRating());
        }
        System.out.println();
    }
}
