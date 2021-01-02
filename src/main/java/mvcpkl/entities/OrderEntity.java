package mvcpkl.entities;

import javax.persistence.*;

@Entity
@Table(name = "order_pro")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pro_id;
    private int quantity;
    private String pro_name;
    private double price;
    private String username;
    private String img;

    public OrderEntity() {
    }

    public OrderEntity(int pro_id, int quantity, String pro_name, double price, String username, String img) {
        this.pro_id = pro_id;
        this.quantity = quantity;
        this.pro_name = pro_name;
        this.price = price;
        this.username = username;
        this.img = img;
    }

    public OrderEntity(int id, int pro_id, int quantity, String pro_name, double price, String username, String img) {
        this.id = id;
        this.pro_id = pro_id;
        this.quantity = quantity;
        this.pro_name = pro_name;
        this.price = price;
        this.username = username;
        this.img = img;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", pro_id=" + pro_id +
                ", quantity=" + quantity +
                ", pro_name='" + pro_name + '\'' +
                ", price=" + price +
                ", username='" + username + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
