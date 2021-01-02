package mvcpkl.entities;

public class CartEntity {

    private int pro_id;
    private int quantity;
    private String name;
    private double price;
    private String img;

    public CartEntity() {
    }

    public CartEntity(int pro_id, int quantity, String name, double price, String img) {
        this.pro_id = pro_id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "pro_id=" + pro_id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }
}
