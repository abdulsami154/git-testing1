package service;

import domain.Aeroplane;
import repository.PlaneRepository;

import java.util.List;

public class AddPlaneService {
    public static Boolean addAeroplane(String name, Integer capacity, String airline) {
        PlaneRepository planeRepository=new PlaneRepository();
        List<Aeroplane> aeroplanes=planeRepository.getAllAeroplane();
        Aeroplane aero=aeroplanes.stream().filter
                (f->f.getName().equalsIgnoreCase(name)).findAny().orElse(null);

        if (aero==null){
            Aeroplane aeroplane=new Aeroplane(name,capacity,airline);
            planeRepository.addingAeroplane(aeroplane);
            return true;
        }
    return false;
    }
}
