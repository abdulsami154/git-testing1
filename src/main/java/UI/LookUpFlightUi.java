package UI;

import service.FlightService;

import javax.swing.*;
import java.awt.*;

public class LookUpFlightUi {
    public LookUpFlightUi() {
        JFrame frame = new JFrame("FLIGHTS");
        Container c=frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3=new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(10, 10, 650, 100);
        panel2.setBounds(10, 250, 900, 700);
        panel3.setBounds(700,10,400,200);
        panel3.setBackground(Color.BLUE);



        JButton btnAdd=new JButton("ADD");
        btnAdd.setBounds(10, 10, 130, 30);




        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(150, 10, 130, 30);

        btnUpdate.addActionListener(bk->{
            frame.dispose();
//            new SearchEditFlight();
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(300, 10, 130, 30);


        JButton back = new JButton("Back");
        back.setBounds(450, 10, 130, 30);


        JLabel planeName=new JLabel("Plane Name");
        planeName.setBounds(10,10,150,30);
        JTextField searchTf=new JTextField(10);
        searchTf.setBounds(10,50,100,30);
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(10, 100, 100, 30);

        panel1.add(btnAdd);
        panel1.add(btnUpdate);
        panel1.add(btnDelete);
        panel1.add(back);

        panel3.add(planeName);
        panel3.add(searchTf);
        panel3.add(btnSearch);


        btnSearch.addActionListener(btn->{
//            String column[]={"Flight ID","Date","Source","Destination","Fare","Passenger List"};
//            String data[][]= FlightService.getAllAddingFlights(column.length,searchTf.getText());
//
//            JTable jt=new JTable(data,column);
//            JScrollPane sp =new JScrollPane(jt);
//            sp.setBounds(0,0,800,700);
//            panel2.add(sp);
        });

        back.addActionListener(bk -> {
            frame.dispose();
            new AdminUi();
        });
        btnAdd.addActionListener(bk->{
            frame.dispose();
            new AddFlightUi();
        });
        btnDelete.addActionListener(bk->{
            frame.dispose();
//            new DeleteFlights();
        });


        c.add(panel1);
        c.add(panel2);
        c.add(panel3);

        frame.setLayout(null);
        frame.setSize(1050,1000);
        frame.setVisible(true);

        btnSearch.doClick();
    }
}
