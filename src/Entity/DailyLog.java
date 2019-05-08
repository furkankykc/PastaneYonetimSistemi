package Entity;

import java.util.ArrayList;

public class DailyLog {

    private ArrayList<Product> products;

    public DailyLog() {
    }

    public DailyLog(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "DailyLog{" +
                "products=" + products +
                '}';
    }

}
