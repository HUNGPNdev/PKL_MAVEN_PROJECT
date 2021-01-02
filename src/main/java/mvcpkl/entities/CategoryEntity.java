package mvcpkl.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "category")
    private List<ProductEntity>  prolist;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String name, boolean status, List<ProductEntity> prolist) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.prolist = prolist;
    }

    public CategoryEntity(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public CategoryEntity(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public List<ProductEntity> getProlist() {
        return prolist;
    }

    public void setProlist(List<ProductEntity> prolist) {
        this.prolist = prolist;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
