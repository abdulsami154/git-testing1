package UI;

import domain.Passenger;
import service.BookingService;
import service.FlightService;

import javax.swing.*;
import java.awt.*;

import static service.BookingService.*;

public class BookPassengerUi {
    public BookPassengerUi() {
        JFrame frame = new JFrame("AIRPORT SYSTEM");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0,0,1000,100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0,100,1000,800);

        JLabel title=new JLabel("BOOKING PANEL");
        JLabel passengerN=new JLabel("Passenger Name");
        JTextField passengerName=new JTextField(10);
        JLabel passengerCon=new JLabel("Contact");
        JTextField passengerContact=new JTextField(10);
        JLabel passengerAddress=new JLabel("Address");
        JTextField passengerAddressTf=new JTextField(10);

        JLabel flightId=new JLabel("Flight ID");
        JTextField flightNumber=new JTextField(10);

        JButton book=new JButton("BOOK");

        JButton backButton=new JButton(">");

        title.setBounds(10,30,400,60);

        passengerN.setBounds(250,50,150,35);
        passengerName.setBounds(400,50,150,35);
        passengerCon.setBounds(250,100,150,35);
        passengerContact.setBounds(400,100,150,35);

        passengerAddress.setBounds(250,150,150,35);
        passengerAddressTf.setBounds(400,150,150,35);

        flightId.setBounds(250,200,150,35);
        flightNumber.setBounds(400,200,150,35);

        book.setBounds(400,250,150,35);

        book.addActionListener(btn->{
            String PassengerName=passengerName.getText();
            String PassengerAddress=passengerAddressTf.getText();
            String Contact=passengerContact.getText();
            String FlightNumber=flightNumber.getText();

            System.out.println(passengerName.getText());
            System.out.println(passengerAddressTf.getText());
            System.out.println(passengerContact.getText());
            System.out.println(flightNumber.getText());
//            BookingService bookingService = new BookingService();
            Boolean flightBooking =
                    addPassenger(PassengerName,PassengerAddress, Contact,FlightNumber);
            if (flightBooking){
                JOptionPane.showMessageDialog(frame,"Booking Confirmed");
            }else {
                JOptionPane.showMessageDialog(frame,"Booking Failed");
            }
        });

        backButton.setBounds(900,5,50,50);



        title.setFont(new Font("Serif",Font.BOLD,35));


        backButton.addActionListener(btn->{
            frame.dispose();
            new UserUi();
        });

        topPanel.add(title);
        bottomPanel.add(passengerN);
        bottomPanel.add(passengerName);
        bottomPanel.add(passengerCon);
        bottomPanel.add(passengerContact);
        bottomPanel.add(passengerAddress);
        bottomPanel.add(passengerAddressTf);
        bottomPanel.add(flightId);
        bottomPanel.add(flightNumber);
        bottomPanel.add(book);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
