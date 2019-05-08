package Entity;

public class Employee extends User{

    private int salary;

    public Employee() {
    }

    public Employee(String username, String password, String name, String surname, Long tc_number, Long phone_number, int salary) {
        super(username, password, name, surname, tc_number, phone_number);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "salary=" + salary +
                '}';
    }
}
