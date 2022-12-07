package pl.coherentSolutions.products;

public class Product {
    private final String name;
    private final double price;
    private final double rate;


    public Product(String name, double rate, double price) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("Product name: '%s', Product price: '%s', Product rate: '%s'", name, price, rate);
    }

    public void printProduct() {
        System.out.println("Name: " + getName() + ";  " +
                "Price: " + getPrice() + ";  " +
                "Rate: " + getRate() + ";");
    }
}
