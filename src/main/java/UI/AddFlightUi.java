package UI;

import domain.Flight;
import service.AddFlightService;
import service.FlightService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddFlightUi{
        public  AddFlightUi() {
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

            JLabel title = new JLabel("ADD PLANE");
            JLabel planeN = new JLabel("Plane Name");
            JTextField planeName = new JTextField(10);
            JLabel date = new JLabel("Date");
            JTextField dateTf = new JTextField(10);
            dateTf.setText("YYYY-MM-DD");
            JLabel source = new JLabel("Source");
            JTextField sourceTf = new JTextField(10);
            JLabel destination = new JLabel("Destination");
            JTextField destinationTf = new JTextField(10);
            JLabel fare = new JLabel("Fare");
            JTextField fareTf = new JTextField(10);

            JLabel flightId = new JLabel("Flight ID");
            JTextField flightIdTf = new JTextField(10);

            JButton book = new JButton("BOOK");

            JButton backButton = new JButton(">");

            planeN.setBounds(250, 50, 150, 35);
            planeName.setBounds(400, 50, 150, 35);

            date.setBounds(250,100,150,35);
            dateTf.setBounds(400,100,150,35);

            source.setBounds(250, 150, 150, 35);
            sourceTf.setBounds(400, 150, 150, 35);

            destination.setBounds(250, 200, 150, 35);
            destinationTf.setBounds(400, 200, 150, 35);

            fare.setBounds(250, 250, 150, 35);
            fareTf.setBounds(400, 250, 150, 35);

            flightId.setBounds(250, 300, 150, 35);
            flightIdTf.setBounds(400, 300, 150, 35);

            backButton.setBounds(900,5,50,50);
            book.setBounds(400, 350, 150, 35);

            book.addActionListener(btn->{
               String _planeName= planeName.getText();
                LocalDate _date= LocalDate.parse(dateTf.getText());
                String src = sourceTf.getText();
                String des = destinationTf.getText();
                Double _fare = Double.valueOf(fareTf.getText());
                String _flightNumber = flightIdTf.getText();
//                Flight flight = new Flight(flightNumber,src,des,_fare,_date,_flightId,new ArrayList<>());
                boolean flightPlane=  AddFlightService.AddingFlights(_planeName,src,des,_fare, _date,_flightNumber);
                if (flightPlane){
                    JOptionPane.showMessageDialog(frame,"Booking Confirmed");
                }else {
                    JOptionPane.showMessageDialog(frame,"Booking Failed");
                }
//     FlightService.AddingFlights(planeName.getText(),dateTf.getText(),
//     sourceTf.getText(),destinationTf.getText(),fareTf.getText(),
//             flightIdTf.getText());

            });
            backButton.addActionListener(btn->{
                frame.dispose();
                new LookUpFlightUi();
            });

            topPanel.add(title);
            bottomPanel.add(planeN);
            bottomPanel.add(planeName);
            bottomPanel.add(date);
            bottomPanel.add(dateTf);
            bottomPanel.add(source);
            bottomPanel.add(sourceTf);
            bottomPanel.add(destination);
            bottomPanel.add(destinationTf);
            bottomPanel.add(fare);
            bottomPanel.add(fareTf);
            bottomPanel.add(flightId);
            bottomPanel.add(flightIdTf);
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
