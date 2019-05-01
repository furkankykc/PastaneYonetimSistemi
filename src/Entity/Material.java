package Entity;

public class Material {
    private String name;
    private int price;

    public Material() {
        this.name = "";
        this.price = 0;
    }

    public Material(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price>=0)
            this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
