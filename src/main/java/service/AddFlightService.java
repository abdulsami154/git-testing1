package service;

import domain.Aeroplane;
import domain.Flight;
import repository.FlightRepository;
import repository.PlaneRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddFlightService {
    public static Boolean AddingFlights(String planeName, String source,String destination,
                                        Double fare, LocalDate date,String _flightNumber) {
        PlaneRepository planeRepository=new PlaneRepository();
        List<Aeroplane> aeroplanes=planeRepository.getAllAeroplane();
        Aeroplane aero=aeroplanes.stream().filter
                (a->a.getName().equalsIgnoreCase(planeName)).findAny().orElse(null);
        Long planeId = aeroplanes.stream().filter(a -> a.getName()
                .equalsIgnoreCase(planeName)).findAny().orElse(null).getId();
        System.out.println(planeId);
        if (aero!=null){
            Flight flight=new Flight(_flightNumber,date,source,destination,fare,planeId);
            FlightRepository flightRepository=new FlightRepository();
            flightRepository.AddingFlight(flight);
            System.out.println(flight);
            return true;
        }
        return false;

    }


}
