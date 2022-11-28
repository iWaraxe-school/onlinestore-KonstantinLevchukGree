package pl.coherentSolutions.products;

public class Product {

    private final String name;
    private final double rate;
    private final double price;


    public Product(String name, double rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }
}
