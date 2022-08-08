package UI;

import service.DeletePlaneService;
import service.FlightService;

import javax.swing.*;
import java.awt.*;

public class DeletePlaneUi {
    public DeletePlaneUi(){
        JFrame frame = new JFrame("ADMIN PANEL");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD FLIGHT");
        JLabel planeName = new JLabel("Plane Name");
        JTextField planeNameTf = new JTextField(10);

        JLabel capacity = new JLabel("Capacity");
        JTextField capacityTf = new JTextField(10);
        JLabel airlineName = new JLabel("Airline Name");
        JTextField airlineNameTf = new JTextField(10);


        JButton btnDelete = new JButton("DELETE");

        JButton backButton = new JButton(">");


        planeName.setBounds(250, 100, 150, 35);
        planeNameTf.setBounds(400, 100, 150, 35);

        capacity.setBounds(250, 150, 150, 35);
        capacityTf.setBounds(400, 150, 150, 35);

        airlineName.setBounds(250, 200, 150, 35);
        airlineNameTf.setBounds(400, 200, 150, 35);

        backButton.setBounds(900,5,50,50);
        btnDelete.setBounds(400, 300, 150, 35);

        btnDelete.addActionListener(btn->{
            System.out.println(planeNameTf.getText());
            System.out.println(capacityTf.getText());
            System.out.println(airlineNameTf.getText());

            Boolean delFlight= DeletePlaneService.DeletePlane(airlineNameTf.getText());
            if (delFlight){
                JOptionPane.showMessageDialog(frame,"Delete Confirmed");
            }else {
                JOptionPane.showMessageDialog(frame,"Delete Failed");
            }

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new LookUpPlaneUi();
        });
        topPanel.add(title);
        bottomPanel.add(planeName);
        bottomPanel.add(planeNameTf);
        bottomPanel.add(capacity);
        bottomPanel.add(capacityTf);
        bottomPanel.add(airlineName);
        bottomPanel.add(airlineNameTf);

        bottomPanel.add(btnDelete);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
