package Entity;

import java.util.ArrayList;

public class Patisserie {
    private ArrayList<Menu> menus;
    private ArrayList<Cake> cakes;
    private ArrayList<Employee> emploies;
    private ArrayList<Table> tables;
    private ArrayList<Reservation> reservations;
    private ArrayList<Admin> admins;

    public Patisserie() {
    }

    public Patisserie(ArrayList<Menu> menus, ArrayList<Cake> cakes, ArrayList<Employee> emploies, ArrayList<Table> tables, ArrayList<Reservation> reservations, ArrayList<Admin> admins) {
        this.menus = menus;
        this.cakes = cakes;
        this.emploies = emploies;
        this.tables = tables;
        this.reservations = reservations;
        this.admins = admins;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public ArrayList<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(ArrayList<Cake> cakes) {
        this.cakes = cakes;
    }

    public ArrayList<Employee> getEmploies() {
        return emploies;
    }

    public void setEmploies(ArrayList<Employee> emploies) {
        this.emploies = emploies;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "Patisserie{" +
                "menus=" + menus +
                ", cakes=" + cakes +
                ", emploies=" + emploies +
                ", tables=" + tables +
                ", admins=" + admins +
                ", reservations=" + reservations +
                '}';
    }
}
