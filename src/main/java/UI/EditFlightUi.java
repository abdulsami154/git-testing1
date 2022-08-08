package UI;

import domain.Flight;
import service.EditFlightService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class EditFlightUi {
  public EditFlightUi(Flight flight) {
        JFrame frame = new JFrame("Edit Flight Panel");
        JLabel flightNumberLb = new JLabel("Flight Number");
        flightNumberLb.setBounds(150, 110, 150, 100);
        JTextField flightNumberTf = new JTextField();
        flightNumberTf.setBounds(270, 150, 150, 20);
        flightNumberTf.setText(flight.getFlightNumber());
        JLabel flightDateLb = new JLabel("Date");
        flightDateLb.setBounds(150, 160, 150, 100);
        JTextField flightDateTf = new JTextField();
        flightDateTf.setBounds(270, 200, 150, 20);
        flightDateTf.setText("YYYY-MM-DD");
        flightDateTf.setText(String.valueOf(flight.getDate()));
        JLabel flightSourceLb = new JLabel("Source");
        flightSourceLb.setBounds(150, 210, 150, 100);
        JTextField flightSourceTf = new JTextField();
        flightSourceTf.setBounds(270, 250, 150, 20);
        flightSourceTf.setText(flight.getSource());
        JLabel flightDestinationLb = new JLabel("Destination");
        flightDestinationLb.setBounds(150, 260, 150, 100);
        JTextField flightDestinationTf = new JTextField();
        flightDestinationTf.setBounds(270, 300, 150, 20);
        flightDestinationTf.setText(flight.getDestination());
        JLabel flightFareLb = new JLabel("Fare");
        flightFareLb.setBounds(150, 310, 150, 100);
        JTextField flightFareTf = new JTextField();
        flightFareTf.setBounds(270, 350, 150, 20);
        flightFareTf.setText(String.valueOf(flight.getFare()));
        JButton updateFlightBtn = new JButton();
        updateFlightBtn.setBounds(200, 400, 100, 50);
        updateFlightBtn.setText("Update Flight");
        JButton backFlightBtn = new JButton();
        backFlightBtn.setBounds(300, 400, 100, 50);
        backFlightBtn.setText("Back");
        frame.add(flightNumberLb);
        frame.add(flightNumberTf);
        frame.add(flightDateLb);
        frame.add(flightDateTf);
        frame.add(flightSourceLb);
        frame.add(flightSourceTf);
        frame.add(flightDestinationLb);
        frame.add(flightDestinationTf);
        frame.add(flightFareLb);
        frame.add(flightFareTf);
        frame.add(updateFlightBtn);
        frame.add(backFlightBtn);
        updateFlightBtn.addActionListener((btn) -> {
            String flightNumber = flightNumberTf.getText();
            LocalDate flightDate = LocalDate.parse(flightDateTf.getText());
            String flightSource = flightSourceTf.getText();
            String flightDestination = flightDestinationTf.getText();
            Double flightFare = Double.valueOf(flightFareTf.getText());
            EditFlightService.updatedFlight(flightNumber,flightDate,flightSource,flightDestination,flightFare.doubleValue());
//            flight.setFlightNumber(flightNumber);
//            flight.setDate(flightDate);
//            flight.setSource(flightSource);
//            flight.setDestination(flightDestination);
//            flight.setFare(flightFare);
            JOptionPane.showMessageDialog(frame, "Flight Edited Successfully");
            frame.dispose();
            new LookUpFlightUi();
        });
        backFlightBtn.addActionListener((btn) -> {
            frame.dispose();
            new LookUpFlightUi();
        });
        frame.setLayout((LayoutManager)null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
    }
}
