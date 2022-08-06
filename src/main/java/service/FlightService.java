package service;

import domain.Flight;
import repository.FlightRepository;

import java.util.List;

public class FlightService {
public static String[][] getAllFLightsForJTable(int length,String src,String des){
    FlightRepository flightRepository=new FlightRepository();
    List<Flight> flights=flightRepository.getAllFlight(src,des);
    String[][] data= new String[flights.size()][length];
    for (int row=0 ; row<flights.size(); row++){
        data[row][0] = flights.get(row).getFlightNumber();
        data[row][1] = flights.get(row).getDate().toString();
        data[row][2] = flights.get(row).getSource();
        data[row][3] = flights.get(row).getDestination();
        data[row][4] = flights.get(row).getFare().toString();
    }
    return data;
    }
}
