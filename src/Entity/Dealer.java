package Entity;

public class Dealer {
    private String name;
    private String address;
    private Admin admin;
    private Cake cake;

    public Dealer() {
    }

    public Dealer(String name, String address, Admin admin, Cake cake) {
        this.name = name;
        this.address = address;
        this.admin = admin;
        this.cake = cake;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", admin=" + admin +
                ", cake=" + cake +
                '}';
    }
}
