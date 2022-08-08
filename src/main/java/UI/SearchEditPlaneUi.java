package UI;

import service.EditPlaneService;

import javax.swing.*;
import java.awt.*;

public class SearchEditPlaneUi {
    public SearchEditPlaneUi(){
        JFrame frame = new JFrame("Search Edit Airline Panel");
        JLabel planeNameLb = new JLabel("Please Enter Airline Name :");
        planeNameLb.setBounds(100, 60, 200, 30);
        JTextField airlineNameTf = new JTextField();
        airlineNameTf.setBounds(270, 60, 150, 30);
        JButton btnEnter = new JButton();
        btnEnter.setText("Enter");
        btnEnter.setBounds(100, 150, 150, 30);
        JButton btnBack = new JButton();
        btnBack.setBounds(270, 150, 150, 30);
        btnBack.setText("Back");
        frame.add(planeNameLb);
        frame.add(airlineNameTf);
        frame.add(btnEnter);
        frame.add(btnBack);
        btnEnter.addActionListener((btn) -> {
            String airlineName = airlineNameTf.getText();
            boolean searchSpecificAirline = EditPlaneService.searchSpecificFlightIntoPlane(airlineName);
            if (searchSpecificAirline) {
                JOptionPane.showMessageDialog(frame, "Airline is Available for Edit");
                // new EditPlaneUi(PlaneService.findFlightIntoPlane(airlineName));
                new EditPlaneUi(EditPlaneService.findFlightIntoPlane(airlineName));

                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Airline is not Available");
            }

        });
        btnBack.addActionListener((btn) -> {
            frame.dispose();
            new LookUpPlaneUi();
        });
        frame.setLayout((LayoutManager)null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
    }
    }

