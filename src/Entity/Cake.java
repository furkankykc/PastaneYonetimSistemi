package Entity;

public class Cake extends Product {

    private Material material;
    private int size;

    public Cake() {
        super();
    }

    public Cake(String name, Material material, String picturePath,String price) {
        super(name,picturePath,price);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + this.getName() + '\'' +
                ", material=" + material +
                ", picturePath='" + this.getImage_path() + '\'' +
                ", size=" + size +
                ", price=" + this.getPrice() +
                '}';
    }
}
