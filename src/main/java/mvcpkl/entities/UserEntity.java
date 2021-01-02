package mvcpkl.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String fullname;
    private String password;
    private String address;
    private String image;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean gender;
    private Date birthday;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();


    public UserEntity() {
    }

    public UserEntity(int user_id, String username, String email, String fullname, String password, String address,
                      boolean gender, boolean status) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.status = status;
    }

    public UserEntity(int user_id, String username, String email, String fullname, String password,
                      String address, String image, boolean gender, Date birthday, boolean status, List<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.address = address;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.status = status;
        this.roles = roles;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}
