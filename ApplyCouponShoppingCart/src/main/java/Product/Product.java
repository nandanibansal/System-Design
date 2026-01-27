package Product;

public abstract class Product {
    String name;
    public double originalPrice;
    ProductType type;

    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.originalPrice = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public ProductType getType() {
        return type;
    }

}
