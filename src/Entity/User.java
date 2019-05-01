package Entity;

public class User {

    private String username;
    private String password;
    private String name;
    private String surname;
    private Long tc_number;
    private Long phone_number;


    public User() {
    }

    public User(String username, String password, String name, String surname, Long tc_number, Long phone_number) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.tc_number = tc_number;
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getTc_number() {
        return tc_number;
    }

    public void setTc_number(Long tc_number) {
        this.tc_number = tc_number;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tc_number=" + tc_number +
                ", phone_number=" + phone_number +
                '}';
    }
}
