package service;

import domain.Aeroplane;
import domain.Flight;
import repository.FlightRepository;
import repository.PlaneRepository;

import java.time.LocalDate;
import java.util.List;

public class AddFlightService {
//    public static boolean AddingFlights(String planeName, String flightNumber, LocalDate date,
//                                        String source, String destination, Double fare) {
//        PlaneRepository planeRepository=new PlaneRepository();
//        List<Aeroplane> aeroplanes=planeRepository.getAllAeroplane();
//        Aeroplane aero=aeroplanes.stream().filter
//                (a->a.getAirline().equalsIgnoreCase(planeName)).findAny().orElse(null);
//        Long planeid = aeroplanes.stream().filter(a -> a.getName()
//                .equalsIgnoreCase(planeName)).findAny().orElse(null).getId();

//         Long planeid=aeroplanes.stream().filter(
//                p->p.getName().equalsIgnoreCase(planeName)).findAny().orElse(null).getAirline()


//        if (aero!=null){
//            Flight flight=new Flight(flightNumber,date,source,destination,fare);
//            FlightRepository.AddingFlight(flight);
//            return true;
//        }
//        return false;
//
//    }
}
