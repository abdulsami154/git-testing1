package service;

import domain.Flight;
import domain.Passenger;
import repository.BookingRepository;

import java.util.List;
import java.util.Objects;

public class BookingService {
    public static Boolean addPassenger(String name, String address, String contact, String flightNumber) {
        BookingRepository bookingRepository=new BookingRepository();
        List<Flight> flightList = bookingRepository.getflight();
        Flight flight = flightList.stream().filter(
                f-> f.getFlightNumber().equalsIgnoreCase(flightNumber)).findAny().orElse(null);
        System.out.println(flight);
        Long flightid = flightList.stream().filter(
                f -> f.getFlightNumber().equalsIgnoreCase(flightNumber)).findAny().orElse(null).getId();
        if (flight != null) {
            Passenger passenger=new Passenger(name,address,contact,flightid);
//            bookingRepository.bookingPassengers(new Passenger(name,address,contact,flightid));
//            Passanger passenger = new Passanger(name,contact,address,flightid);
            BookingRepository bookingRepository1 = new BookingRepository();
            bookingRepository1.bookingPassengers(passenger);
            return true;
        }
        return false;
    }
    }

