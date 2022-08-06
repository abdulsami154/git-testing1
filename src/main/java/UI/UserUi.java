package UI;

import javax.swing.*;

public class UserUi {
    public UserUi(){
        JFrame frame = new JFrame("User Panel");
        JButton btnLookupFlight = new JButton();
        btnLookupFlight.setBounds(100,100,250,30);
        btnLookupFlight.setFocusable(false);
        btnLookupFlight.setText("Lookup Flights");



        JButton btnBookPassenger = new JButton();
        btnBookPassenger.setBounds(100,200,250,30);
        btnBookPassenger.setFocusable(false);
        btnBookPassenger.setText("Book Passenger");

        JButton btnPassengerInquiry = new JButton();
        btnPassengerInquiry.setBounds(100,300,250,30);
        btnPassengerInquiry.setFocusable(false);
        btnPassengerInquiry.setText("Passenger Inquiry");

        frame.add(btnLookupFlight);
        frame.add(btnBookPassenger);
        frame.add(btnPassengerInquiry);

        btnLookupFlight.addActionListener(btn->{
            frame.dispose();
            new LookUpUi();
        });
        btnBookPassenger.addActionListener(btn->{
            //passenger book
            frame.dispose();
            new BookPassengerUi();
        });
        btnPassengerInquiry.addActionListener(btn->{
            //passenger inquiry
            frame.dispose();
            new PassengerInquiryUi();
        });


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
