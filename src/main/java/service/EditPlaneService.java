package service;

import domain.Aeroplane;
import domain.Flight;
import repository.PlaneRepository;

public class EditPlaneService {

    public static Boolean searchSpecificFlightIntoPlane(String airlineName) {
        PlaneRepository planeRepository = new PlaneRepository();
        Aeroplane aeroplane = planeRepository.getAllPlaneByPlaneName(airlineName);
        System.out.println(aeroplane);
        if (aeroplane != null) {
            return true;
        }
    return false;
    }

    public static Aeroplane findFlightIntoPlane(String airlineName) {
    PlaneRepository planeRepository=new PlaneRepository();
    Aeroplane aero =planeRepository.getAllPlaneByPlaneName(airlineName);
    return aero;
    }

    public static void updatedPlane(String name, Integer capacity, String airline, Long id) {
        PlaneRepository planeRepository=new PlaneRepository();
        planeRepository.updatePlane(name,capacity,airline,id);
    }
}
