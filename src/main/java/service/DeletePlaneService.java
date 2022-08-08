package service;


import domain.Aeroplane;
import repository.PlaneRepository;

import java.util.List;

public class DeletePlaneService {
public static Boolean DeletePlane(String airline){
    PlaneRepository planeRepository=new PlaneRepository();
    List<Aeroplane> aeroplanes=planeRepository.getAllAeroplane();
    Aeroplane aero=aeroplanes.stream().filter(
            f->f.getName().equalsIgnoreCase(airline)).findAny().orElse(null);
    if (aero!=null){
 PlaneRepository planeRepository1=new PlaneRepository();
 planeRepository1.deletePlane(airline);
 return true;
    }
return false;
}

}
