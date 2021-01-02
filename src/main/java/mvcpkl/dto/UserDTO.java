package mvcpkl.dto;

public class UserDTO {
    private int user_id;
    private String username;
    private String email;
    private String fullname;
    private String address;
    private String password;
    private boolean gender;

    public UserDTO() {
    }

    public UserDTO(int user_id, String username, String email, String fullname, String address, boolean gender) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
    }

    public UserDTO(int user_id, String username, String email, String fullname, String address, String password, boolean gender) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.password = password;
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}
