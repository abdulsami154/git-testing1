package repository;

import domain.Aeroplane;
import domain.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository extends BaseConnection{
    public List<Aeroplane> getAllAeroplane(){
        List<Aeroplane> aeroplaneList=new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane");
            while (rs.next()) {
                Aeroplane aeroplane =new Aeroplane();
                aeroplane.populate(rs);
                aeroplaneList.add(aeroplane);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aeroplaneList;
    }

    public List<Aeroplane> addingAeroplane(Aeroplane aeroplane){
        List<Aeroplane> aeroplaneList=new ArrayList<>();
        try {
            if (con.isClosed()){
                openConnection();
            }

            PreparedStatement ps = con.prepareStatement("insert into aeroplane(name,capacity,airline) values(?,?,?)");
            ps.setString(1, aeroplane.getName());
            ps.setString(2, aeroplane.getCapacity());
            ps.setString(3, aeroplane.getAirline());
            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }
        return aeroplaneList;
    }
}
