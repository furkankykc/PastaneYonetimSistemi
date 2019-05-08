package Entity;

import java.util.ArrayList;

public class Cake extends Product {

    private ArrayList<Material> materials;
    private int size;

    public Cake() {
    }

    public Cake(String name, ArrayList<Material> materials, String picturePath, int price,int size) {
        super(name,picturePath,price);
        this.materials = materials;
        this.size = size;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
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
                ", materials=" + materials +
                ", picturePath='" + this.getImage_path() + '\'' +
                ", size=" + size +
                ", price=" + this.getPrice() +
                '}';
    }
}
