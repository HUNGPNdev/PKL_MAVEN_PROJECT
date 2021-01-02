package mvcpkl.dto;


import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

    private int id;
    private String name;
    private Double price;
    private String details;
    private String guarantee;
    private String part;
    private String support;
    private MultipartFile image;
    private String img;
    private boolean status;
    private int cate_id;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, Double price, String details, String guarantee, String part, String support,
                      String img, boolean status, int cate_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.img = img;
        this.status = status;
        this.cate_id = cate_id;
    }

    public ProductDTO(int id, String name, Double price, String details, String guarantee, String part, String support,
                      MultipartFile image, boolean status, int cate_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.guarantee = guarantee;
        this.part = part;
        this.support = support;
        this.image = image;
        this.status = status;
        this.cate_id = cate_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", part='" + part + '\'' +
                ", support='" + support + '\'' +
                ", image=" + image.getOriginalFilename() +
                ", status=" + status +
                ", cate_id=" + cate_id +
                '}';
    }
}
