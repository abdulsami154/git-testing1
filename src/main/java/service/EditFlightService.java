package service;

import domain.Aeroplane;
import domain.Flight;
import repository.FlightRepository;
import repository.PlaneRepository;

import java.time.LocalDate;

public class EditFlightService {
    public static boolean searchSpecificFlightIntoPlane(String airlineName, String flightNumber,
                                                        String source, String destination) {
        PlaneRepository planeRepository = new PlaneRepository();
        Aeroplane planes = planeRepository.getAllPlaneByPlaneName(airlineName);
        Long planeId = planes.getId();
        if (planeId != null) {
            FlightRepository flightRepository = new FlightRepository();
            Flight flight = flightRepository.getFlightsById(planeId);
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber) && flight.getSource().equalsIgnoreCase(source)
                    && flight.getDestination().equalsIgnoreCase(destination)) ;
            System.out.println(flight.getFlightNumber());
            System.out.println(source);
            return true;
        }
        return false;
    }

    public static Flight findFlight(String airlineName, String flightNumber, String source, String destination) {
        PlaneRepository planeRepository = new PlaneRepository();
        Aeroplane planes = planeRepository.getAllPlaneByPlaneName(airlineName);
        Long planeId = planes.getId();
        if (planeId != null) {
            FlightRepository flightRepository = new FlightRepository();
            Flight flight1 = flightRepository.getFlightsById(planeId);
            System.out.println(flight1);
//            if (flight1.getFlightNumber().equalsIgnoreCase(flightNumber) && flight1.getSource().equalsIgnoreCase(source)
//                    && flight1.getDestination().equalsIgnoreCase(destination)) ;
//            System.out.println(flight1.getFlightNumber());
//            System.out.println(source);
            return flight1;

        }
        return  null;
    }



    public static Boolean updatedFlight(String flightNumber, LocalDate flightDate, String flightSource, String flightDestination, double flightFare) {
        FlightRepository flightRepository = new FlightRepository();
        flightRepository.updateFlight(flightNumber,flightDate,flightSource,flightDestination,flightFare);
        return true;
    }

    }

