package UI;

import domain.Aeroplane;
import domain.Flight;
import service.EditPlaneService;

import javax.swing.*;

public class EditPlaneUi {
    public EditPlaneUi(Aeroplane aeroplane) {
    JFrame frame = new JFrame("Edit Planes Panel");

    JLabel planeNameLb = new JLabel("Name");
        planeNameLb.setBounds(200,60,150,100);
    JTextField planeNameTf = new JTextField();
        planeNameTf.setBounds(270,100,150,20);
        planeNameTf.setText(aeroplane.getName());

    JLabel planeCapacityLb = new JLabel("Capacity");
        planeCapacityLb.setBounds(200,110,150,100);
    JTextField planeCapacityTf = new JTextField();
        planeCapacityTf.setBounds(270,150,150,20);
        planeCapacityTf.setText(aeroplane.getCapacity().toString());

    JLabel planeAirlineLb = new JLabel("Airline");
        planeAirlineLb.setBounds(200,160,150,100);
    JTextField planeAirlineTf = new JTextField();
        planeAirlineTf.setBounds(270,200,150,20);
        planeAirlineTf.setText(aeroplane.getAirline());

    JButton updatePlaneBtn = new JButton();
        updatePlaneBtn.setBounds(100,300,150,50);
        updatePlaneBtn.setText("Update Plane");

    JButton backBtn = new JButton();
        backBtn.setBounds(300,300,100,50);
        backBtn.setText("Back");


        frame.add(planeNameLb);
        frame.add(planeNameTf);
        frame.add(planeCapacityLb);
        frame.add(planeCapacityTf);
        frame.add(planeAirlineLb);
        frame.add(planeAirlineTf);
        frame.add(updatePlaneBtn);
        frame.add(backBtn);

        updatePlaneBtn.addActionListener(btn->{
        String _name = planeNameTf.getText();
        Integer _capacity = Integer.valueOf(planeCapacityTf.getText());
        String _airline = planeAirlineTf.getText();
        EditPlaneService.updatedPlane(_name,_capacity,_airline,aeroplane.getId());


        JOptionPane.showMessageDialog(frame,"Plane Edited Successfully");
        frame.dispose();
        new LookUpPlaneUi();
    });

        backBtn.addActionListener(btn->{
        frame.dispose();
        new LookUpPlaneUi();
    });

        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

}
}
