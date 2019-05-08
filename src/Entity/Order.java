package Entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<Product> products;
    private String address;
    private Date time;

    public Order() {
    }
    public Order(ArrayList products, String address, Date time) {
        this.products = products;
        this.address = address;
        this.time = time;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", address='" + address + '\'' +
                ", time=" + time +
                '}';
    }
}
