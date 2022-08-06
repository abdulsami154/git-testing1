package UI;

import domain.User;
import service.FlightService;

import javax.swing.*;
import java.awt.*;

public class LookUpUi {

    LookUpUi(){
            JFrame f=new JFrame("LookUp Panel");
            Container c = f.getContentPane();

            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();

            panel1.setLayout(null);
            panel2.setLayout(null);

            panel1.setBackground(Color.lightGray);
            panel1.setBounds(10,10,800,100);
            panel2.setBounds(10,110,800,700);



            JTextField source = new JTextField(10);
            source.setText("src");
            source.setBounds(20,10,150,30);

            JTextField destination = new JTextField(10);
            destination.setText("des");
            destination.setBounds(200,10,150,30);

            JButton search = new JButton("Search");
            search.setBounds(400,10,150,30);

            JButton back = new JButton("Back");
            back.setBounds(600,10,150,30);

            back.addActionListener(btn->{
                f.dispose();
                new UserUi();
            });
            panel1.add(source);
            panel1.add(destination);
            panel1.add(search);
            panel1.add(back);


            search.addActionListener(btn->{
             String column[]={"FlightNumber","Date","Source","Destination","Fare"};
             String data[][]= FlightService.getAllFLightsForJTable(column.length, source.getText(),
                     destination.getText());
                    JTable jt=new JTable(data,column);
                    JScrollPane sp=new JScrollPane(jt);
                    sp.setBounds(0,0,800,700);
                    panel2.add(sp);
            });




            c.add(panel1);
            c.add(panel2);
            f.setLayout(null);
            f.setSize(1000,860);
            f.setVisible(true);;
            f.setLocationRelativeTo(null);

            search.doClick();
        }
}
