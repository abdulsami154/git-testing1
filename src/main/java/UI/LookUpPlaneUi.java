package UI;

import service.ViewPlaneService;

import javax.swing.*;
import java.awt.*;

public class LookUpPlaneUi {
    public LookUpPlaneUi(){
        JFrame frame = new JFrame("FLIGHTS");
        Container c=frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3=new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBounds(10, 10, 750, 100);
        panel2.setBounds(10, 250, 900, 700);
//        panel3.setBounds(700,10,400,200);
//        panel3.setBackground(Color.BLUE);



        JButton btnAdd=new JButton("ADD");
        btnAdd.setBounds(10, 10, 130, 30);




        JButton btnEdit = new JButton("UPDATE");
        btnEdit.setBounds(150, 10, 130, 30);

        btnEdit.addActionListener(bk->{
            frame.dispose();
//            new SearchEditPlaneUi();
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(300, 10, 130, 30);


        JButton back = new JButton("Back");
        back.setBounds(450, 10, 130, 30);

        JButton btnView = new JButton("View Plane");
        btnView.setBounds(600, 10, 130, 30);


//        JLabel planeName=new JLabel("Plane Name");
//        planeName.setBounds(10,10,150,30);
//        JTextField searchTf=new JTextField(10);
//        searchTf.setBounds(10,50,100,30);
//        JButton btnSearch = new JButton("Search");
//        btnSearch.setBounds(10, 100, 100, 30);

        panel1.add(btnAdd);
        panel1.add(btnEdit);
        panel1.add(btnDelete);
        panel1.add(back);
        panel1.add(btnView);

        btnView.addActionListener(btn->{

            String column[]={"Airline Name","Capacity","Airplane Name"};
            String data[][]= ViewPlaneService.getAllAirplane(column.length);

            JTable jt=new JTable(data,column);
            JScrollPane sp =new JScrollPane(jt);
            sp.setBounds(0,0,800,700);
            panel2.add(sp);
        });



        back.addActionListener(bk -> {
            frame.dispose();
            new AdminUi();
        });
        btnAdd.addActionListener(bk->{
            frame.dispose();
//            new AddPlane();
            new AddPlaneUi();

        });
        btnDelete.addActionListener(bk->{
            frame.dispose();
            new DeletePlaneUi();
        });
        btnEdit.addActionListener(btn->{
            frame.dispose();
            new SearchEditPlaneUi();
        });



        c.add(panel1);
        c.add(panel2);
        c.add(panel3);

        frame.setLayout(null);
        frame.setSize(1050,1000);
        frame.setVisible(true);


    }
}
