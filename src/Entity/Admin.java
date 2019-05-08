package Entity;

public class Admin extends User{

    private boolean yetki;

    public Admin() {
    }

    public Admin(String username, String password, String name, String surname, Long tc_number, Long phone_number, boolean yetki) {
        super(username, password, name, surname, tc_number, phone_number);
        this.yetki = yetki;
    }

    public boolean isYetki() {
        return yetki;
    }

    public void setYetki(boolean yetki) {
        this.yetki = yetki;
    }

    @Override
    public String toString() {
        return super.toString()+
                "yetki=" + yetki +
                '}';
    }
}
