package UI;

import service.DeleteFlightService;
import service.FlightService;

import javax.swing.*;
import java.awt.*;

public class DeleteFlightUi {
    public DeleteFlightUi(){
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
    JLabel planeN = new JLabel("Plane Name");
    JTextField planeName = new JTextField(10);

    JLabel source = new JLabel("Source");
    JTextField sourceTf = new JTextField(10);
    JLabel destination = new JLabel("Destination");
    JTextField destinationTf = new JTextField(10);
    JLabel fare = new JLabel("Fare");
    JTextField fareTf = new JTextField(10);

    JLabel flightId = new JLabel("Flight ID");
    JTextField flightIdTf = new JTextField(10);

    JButton btnDelete = new JButton("DELETE");

    JButton backButton = new JButton(">");

        planeN.setBounds(250, 50, 150, 35);
        planeName.setBounds(400, 50, 150, 35);



        source.setBounds(250, 100, 150, 35);
        sourceTf.setBounds(400, 100, 150, 35);

        destination.setBounds(250, 150, 150, 35);
        destinationTf.setBounds(400, 150, 150, 35);

        fare.setBounds(250, 200, 150, 35);
        fareTf.setBounds(400, 200, 150, 35);

        flightId.setBounds(250, 250, 150, 35);
        flightIdTf.setBounds(400, 250, 150, 35);

        backButton.setBounds(900,5,50,50);
        btnDelete.setBounds(400, 300, 150, 35);

        btnDelete.addActionListener(btn->{
        System.out.println(planeName.getText());
        System.out.println(sourceTf.getText());
        System.out.println(destinationTf.getText());
        System.out.println(fareTf.getText());
        System.out.println(flightIdTf.getText());
            String _airlineName = planeName.getText();
            String _flightNumber = flightIdTf.getText();
            String _source = sourceTf.getText();
            String _destination = destinationTf.getText();
        Boolean delFlight= DeleteFlightService.deleteFlights(_airlineName,_source,
                _destination,_flightNumber);
        if (delFlight){
            JOptionPane.showMessageDialog(frame,"Delete Confirmed");
        }else {
            JOptionPane.showMessageDialog(frame,"Delete Failed");
        }

    });

backButton.addActionListener(btn->{
        frame.dispose();
        new LookUpFlightUi();
    });
        topPanel.add(title);
        bottomPanel.add(planeN);
        bottomPanel.add(planeName);
        bottomPanel.add(source);
        bottomPanel.add(sourceTf);
        bottomPanel.add(destination);
        bottomPanel.add(destinationTf);
        bottomPanel.add(fare);
        bottomPanel.add(fareTf);
        bottomPanel.add(flightId);
        bottomPanel.add(flightIdTf);
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
