package service;

import domain.User;
import repository.LoginRepository;

public class AuthenticationService {

    public static boolean authenticateAdmin(String username, String password) {
        LoginRepository loginRepository = new LoginRepository();
        User user = loginRepository.authenticate(username, password);
        if (user != null && user.getType().equalsIgnoreCase("ADMIN")) {
            return true;
        }
        return false;
    }
    public static boolean authenticateUser(String username, String password) {
        LoginRepository loginRepository =new LoginRepository();
        User user =loginRepository.authenticate(username,password);
        if (user!=null && user.getType().equalsIgnoreCase("USER")){
            return true;
        }
        return false;
    }
}
