package pl.monikamaria.access;

public class User_ {

    private String username;
    private String password;
    private String role;
    private Integer count;

    public User_() {
    }

    public User_(String username, String password, String role, Integer count) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
