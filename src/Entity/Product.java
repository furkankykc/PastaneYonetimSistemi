package Entity;

public class Product {
    private String name;
    private String image_path;
    private String price;

    public Product() {
    }

    public Product(String name, String image_path, String price) {
        this.name = name;
        this.image_path = image_path;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", image_path='" + image_path + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
