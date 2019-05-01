package Entity;

public class DailyLog {

    private Product soldProducts;

    public DailyLog() {
    }

    public DailyLog(Product soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Product getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Product soldProducts) {
        this.soldProducts = soldProducts;
    }

    @Override
    public String toString() {
        return "DailyLog{" +
                "soldProducts=" + soldProducts +
                '}';
    }

}
