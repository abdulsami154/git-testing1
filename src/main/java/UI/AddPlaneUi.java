package UI;

import service.AddPlaneService;

import javax.swing.*;
import java.awt.*;

public class AddPlaneUi {
    public AddPlaneUi(){
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
        JLabel airplaneName = new JLabel("Airplane Name");
        JTextField airplaneNameTf = new JTextField(10);
        JLabel capacity = new JLabel("Capacity");
        JTextField capacityTf = new JTextField(10);
        JLabel airlineName = new JLabel("Airline Name");
        JTextField airlineNameTf = new JTextField(10);


        JButton addPlane = new JButton("ADD PLANE");

        JButton backButton = new JButton(">");

        airplaneName.setBounds(250, 50, 150, 35);
        airplaneNameTf.setBounds(400, 50, 150, 35);

        capacity.setBounds(250,100,150,35);
        capacityTf.setBounds(400,100,150,35);

        airlineName.setBounds(250, 150, 150, 35);
        airlineNameTf.setBounds(400, 150, 150, 35);


        backButton.setBounds(900,5,50,50);
        addPlane.setBounds(400, 350, 150, 35);

        addPlane.addActionListener(btn->{
            System.out.println(airplaneNameTf.getText());
            System.out.println(capacityTf.getText());
            System.out.println(airlineNameTf.getText());
//            Aeroplane aeroplane=new Aeroplane(airplaneNameTf.getText(), new Integer(capacityTf.getText()),
//                    airlineNameTf.getText(),new ArrayList<>());
            Boolean addingPlane= AddPlaneService.addAeroplane(airplaneNameTf.getText(),
                    (capacityTf.getText()),
                    airlineNameTf.getText());
            if (addingPlane){
                JOptionPane.showMessageDialog(frame,"Booking Confirmed");
            }else {
                JOptionPane.showMessageDialog(frame,"Booking Failed");
            }


        });
        backButton.addActionListener(btn->{
            frame.dispose();
            new LookUpPlaneUi();
        });

        topPanel.add(title);
        bottomPanel.add(airplaneName);
        bottomPanel.add(airplaneNameTf);
        bottomPanel.add(capacity);
        bottomPanel.add(capacityTf);
        bottomPanel.add(airlineName);
        bottomPanel.add(airlineNameTf);

        bottomPanel.add(addPlane);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
