package pl.coherentSolutions.products;

import lombok.Getter;

@Getter
public class Product {

    private String name;
    private double price;
    private double rate;

    //Builder
    public static ProductBuilder newProductBuilder() {
        return new Product().new ProductBuilder();
    }

    public class ProductBuilder {
        private String name;
        private double price;
        private double rate;

        public ProductBuilder() {
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setRate(double rate) {
            this.rate = rate;
            return this;
        }

        public Product build() {
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;
            return Product.this;
        }
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
