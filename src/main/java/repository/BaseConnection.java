package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {

    static Connection con;

    BaseConnection(){
    openConnection();
    }
    public void openConnection() {
try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ticketing_system","root","4321");
        } catch (Exception e){
e.printStackTrace();
}
    }
    }

