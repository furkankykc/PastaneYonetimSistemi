package Entity;

import java.util.ArrayList;

public class Dealer {
    private String name;
    private String address;
    private ArrayList<Patisserie> patisseries;

    public Dealer() {
    }

    public Dealer(String name, String address, ArrayList<Patisserie> patisseries) {
        this.name = name;
        this.address = address;
        this.patisseries = patisseries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public ArrayList<Patisserie> getPatisseries() {
        return patisseries;
    }

    public void setPatisseries(ArrayList<Patisserie> patisseries) {
        this.patisseries = patisseries;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", patisseries=" + patisseries +
                '}';
    }
}
