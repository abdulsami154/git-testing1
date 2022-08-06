package UI;

import repository.PassengerRepository;
import service.FlightService;
import service.PassengerInquiryService;

import javax.swing.*;
import java.awt.*;

public class PassengerInquiryUi {
    public PassengerInquiryUi() {
        JFrame frame = new JFrame("Passenger Inquiry");
        Container c = frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,150,800,800);

        JTextField passengerContact=new JTextField(10);
        passengerContact.setText("Passenger Contact");
        passengerContact.setBounds(20,10,150,30);

        JButton search =new JButton("SEARCH");
        search.setBounds(400,10,150,30);

        JButton back =new JButton("BACK");
        back.setBounds(600,10,150,30);

        back.addActionListener(btn->{
            frame.dispose();
            new UserUi();
        });

        panel1.add(passengerContact);
        panel1.add(search);
        panel1.add(back);

        search.addActionListener(btn->{
            String column[]={"Name","Contact","Address","Flight_Name"};
            String data[][]= PassengerInquiryService.getAllPassengerByFlightIdJTable(column.length,passengerContact.getText());

            JTable jt=new JTable(data,column);
            JScrollPane sp =new JScrollPane(jt);
            sp.setBounds(0,0,800,700);
            panel2.add(sp);
        });

        c.add(panel1);
        c.add(panel2);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}
