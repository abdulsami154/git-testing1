package service;

import domain.Aeroplane;
import repository.PlaneRepository;

import java.util.List;

public class ViewPlaneService {
    public static String[][] getAllAirplane(int length) {
        PlaneRepository planeRepository=new PlaneRepository();


        List<Aeroplane> aeroplane=planeRepository.getAllAeroplane();
        String[][] data =new String[aeroplane.size()][length];
        for (int row=0;row<aeroplane.size();row++){
            data[row][0]=aeroplane.get(row).getName();
            data[row][1]=aeroplane.get(row).getCapacity().toString();
            data[row][2]=aeroplane.get(row).getAirline();

        }
        return data;
    }
}
