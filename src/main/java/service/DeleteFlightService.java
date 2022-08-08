package service;

import domain.Aeroplane;
import domain.Flight;
import repository.FlightRepository;
import repository.PlaneRepository;

import java.util.List;

public class DeleteFlightService {
    public static Boolean deleteFlights(String planeName, String source, String destination, String flightId) {
        PlaneRepository planeRepository=new PlaneRepository();
        List<Aeroplane> aeroplanes=planeRepository.getAllAeroplane();
        Aeroplane aero =aeroplanes.stream().filter
                (a->a.getName().equalsIgnoreCase(planeName)).findAny().orElse(null);
        Long planeId=aeroplanes.stream().filter(
                f->f.getName().equalsIgnoreCase(planeName)).findAny().orElse(null).getId();

        if (aero!=null){
            FlightRepository flightRepository=new FlightRepository();
            List<Flight> flight =flightRepository.deleteFlightsFromPlane(planeId);

//            flightRepository.deleteFlight(flightId,source,destination);
            String findFlightId=flight.stream().filter
                    (f->f.getFlightNumber().equalsIgnoreCase(flightId)).findAny().orElse(null).getFlightNumber();
            String findSrc=flight.stream().filter
                    (s->s.getSource().equalsIgnoreCase(source)).findAny().orElse(null).getSource();
            String findDes=flight.stream().filter
                    (d->d.getDestination().equalsIgnoreCase(destination)).findAny().orElse(null).getDestination();
            if (findFlightId!=flightId && findSrc!=source && findDes != destination){
                flightRepository.deleteFlight(flightId);
                return true;
            }
        }
        return false;
    }
}
