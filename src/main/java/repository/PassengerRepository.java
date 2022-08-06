package repository;

import domain.Passenger;
import repository.BaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 public class PassengerRepository extends BaseConnection {
     public List<Passenger> getPassengerThroughContact(String contact) {
            List<Passenger> passengerList = new ArrayList<>();
//         if (con.isClosed()){
//             openConnection();
//         }
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select p.id, p.name,p.address,p.contact_Number,p.flight_id,f.flight_number from passenger p inner join flight f on p.flight_id = f.id where p.contact_Number='"+contact+"'");
                while (rs.next()){
                    Passenger pass = new Passenger();
                    pass.populate(rs);
                    passengerList.add(pass);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return passengerList;
        }

    }

