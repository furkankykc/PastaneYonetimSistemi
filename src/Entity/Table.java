package Entity;

import java.util.ArrayList;

public class Table {
    private int number;
    private ArrayList<Product> products;
    private int count;

    public Table() {
    }

    public Table(int number, ArrayList<Product> products, int count) {
        this.number = number;
        this.products = products;
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Table{" +
                "number=" + number +
                ", products=" + products +
                ", count=" + count +
                '}';
    }
}
