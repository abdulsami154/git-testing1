package UI;

import service.EditFlightService;
import service.EditPlaneService;

import javax.swing.*;
import java.awt.*;

public class SearchEditFlightUi {
   public SearchEditFlightUi() {
        JFrame frame = new JFrame("Search Edit Flight Panel");
        JLabel planeNameLb = new JLabel("Please Enter Plane Name :");
        planeNameLb.setBounds(100, 60, 150, 30);
        JTextField planeNameTf = new JTextField(10);
        planeNameTf.setBounds(270, 60, 150, 20);
        JLabel flightNumberLb = new JLabel("Please Enter Flight Number :");
        flightNumberLb.setBounds(100, 110, 200, 20);
        JTextField flightNumberTf = new JTextField(10);
        flightNumberTf.setBounds(270, 110, 150, 20);
        JLabel sourceLb = new JLabel("Please Enter Source :");
        sourceLb.setBounds(100, 160, 150, 20);
        JTextField sourceTf = new JTextField(10);
        sourceTf.setBounds(270, 160, 150, 20);
        JLabel destinationLb = new JLabel("Please Enter Destination :");
        destinationLb.setBounds(100, 210, 150, 20);
        JTextField destinationTf = new JTextField(10);
        destinationTf.setBounds(270, 210, 150, 20);
        JButton btnEnter = new JButton();
        btnEnter.setText("Enter");
        btnEnter.setBounds(100, 250, 150, 30);
        JButton btnBack = new JButton();
        btnBack.setBounds(270, 250, 150, 30);
        btnBack.setText("Back");
        frame.add(planeNameLb);
        frame.add(planeNameTf);
        frame.add(flightNumberLb);
        frame.add(flightNumberTf);
        frame.add(sourceLb);
        frame.add(sourceTf);
        frame.add(destinationLb);
        frame.add(destinationTf);
        frame.add(btnEnter);
        frame.add(btnBack);
        btnEnter.addActionListener((btn) -> {
            String airlineName = planeNameTf.getText();
            String flightNumber = flightNumberTf.getText();
            String source = sourceTf.getText();
            String destination = destinationTf.getText();
            boolean searchSpecificFlight =
                    EditFlightService.searchSpecificFlightIntoPlane(airlineName, flightNumber, source, destination);
            if (searchSpecificFlight) {
                JOptionPane.showMessageDialog(frame, "Flight is Available for Edit");
                frame.dispose();

                new EditFlightUi(EditFlightService.findFlight(airlineName, flightNumber, source, destination));

            } else {
                JOptionPane.showMessageDialog(frame, "Flight is not Available");
            }

        });
        btnBack.addActionListener((btn) -> {
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
