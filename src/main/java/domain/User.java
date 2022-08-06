package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private Long id;
    private String username;
    private String password;
    private String type;

public User(){
}

    public User(Long id, String username, String password, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public void populate(ResultSet rs)throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setUsername(rs.getString("username"));
        this.setPassword(rs.getString("password"));
        this.setType(rs.getString("type"));
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
