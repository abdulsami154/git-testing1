package service;

import domain.Flight;
import domain.Passenger;
import repository.PassengerRepository;

import java.util.List;

public class PassengerInquiryService {
//    Flight flight = getAllFlights().stream()
//            .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightId))
//            .findAny().orElse(null);

  public static String[][] getAllPassengerByFlightIdJTable(int length,String contact){
    PassengerRepository passengerRepository=new PassengerRepository();

    List<Passenger> passengers=passengerRepository.getPassengerThroughContact(contact);
    String[][] data=new String[passengers.size()][length];
        for (int row=0; row< passengers.size();row++){
        data[row][0]=passengers.get(row).getName();
        data[row][1]=passengers.get(row).getContact();
        data[row][2]=passengers.get(row).getAddress();
        data[row][3]=passengers.get(row).getFlightId().toString();
    }
        return data;
}
}
