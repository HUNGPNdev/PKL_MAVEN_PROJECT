package mvcpkl.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String details;
    private String guarantee;
    private String part;
    private String support;
    private String image;
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cate_id", referencedColumnName = "id", nullable = false, updatable = true, insertable = true)
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(int id, String name, Double price, String details, String guarantee, String part, String support,
                         boolean status, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.status = status;
        this.category = category;
    }

    public ProductEntity(int id, String name, Double price, String details, String guarantee,
                         String part, String support, String image, boolean status, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.image = image;
        this.status = status;
        this.category = category;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", part='" + part + '\'' +
                ", support='" + support + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
