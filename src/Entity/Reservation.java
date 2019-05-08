package Entity;

public class Reservation {
    private Table table;
    private String hour;

    public Reservation() {
    }

    public Reservation(Table table, String hour) {
        this.table = table;
        this.hour = hour;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "table=" + table +
                ", hour='" + hour + '\'' +
                '}';
    }
}
