package Entity;

public class Menu {

    private String name;
    private String content;
    private String path;
    private int price;

    public Menu() {
    }

    public Menu(String name, String content, String path, int price) {
        this.name = name;
        this.content = content;
        this.path = path;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", path='" + path + '\'' +
                ", price=" + price +
                '}';
    }
}
