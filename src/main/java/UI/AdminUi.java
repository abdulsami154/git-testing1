package UI;

import UI.LoginUi;

import javax.swing.*;

public class AdminUi {
    public AdminUi(){
        JFrame frame =new JFrame("ADMIN PANEL");

        JButton btnFlight=new JButton();
        btnFlight.setBounds(100,100,150,30);
        btnFlight.setFocusable(false);
        btnFlight.setText("FLIGHT");

        btnFlight.addActionListener(btn->{
            frame.dispose();
//            new LookUpFlight();
            new LookUpFlightUi();
        });
        JButton btnPlane=new JButton();
        btnPlane.setBounds(100,200,150,30);
        btnPlane.setFocusable(false);
        btnPlane.setText("PLANE");

        btnPlane.addActionListener(btn-> {
            frame.dispose();
            new LookUpPlaneUi();
        });
        JButton btnLogout=new JButton();
        btnLogout.setBounds(100,300,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("LOGOUT");

        btnLogout.addActionListener(btn-> {
            frame.dispose();
            new LoginUi();
        });
        frame.add(btnFlight);
        frame.add(btnPlane);
        frame.add(btnLogout);


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
