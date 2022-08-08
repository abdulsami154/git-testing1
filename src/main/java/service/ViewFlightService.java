package service;

import domain.Flight;
import repository.FlightRepository;

import java.util.List;

public class ViewFlightService {
    //find get all adding flights
    public static String[][] getAllAddingFlightsForJTable(int length,String planeName) {
        FlightRepository flightRepository=new FlightRepository();

        List<Flight> flightSearch=flightRepository.getAllFlightsByPlaneName(planeName);
        String[][] data =new String[flightSearch.size()][length];
        for (int row=0;row<flightSearch.size();row++){
            data[row][0]=flightSearch.get(row).getFlightNumber();
            data[row][1]=flightSearch.get(row).getDate().toString();
            data[row][2]=flightSearch.get(row).getSource();
            data[row][3]=flightSearch.get(row).getDestination();
            data[row][4]=flightSearch.get(row).getFare().toString();
        }
        return data;
    }
}
