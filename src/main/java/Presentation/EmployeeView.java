package Presentation;

import Business.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class EmployeeView extends JFrame implements Observer {


    JTextArea textArea;
    JScrollPane orderPane;
    private JButton btnNewButton;
    private String username;
    public EmployeeView(String username) {

        this.username=username;
        initialize(username);
    }


    private void initialize(String username) {

        JLabel lblNewLabel_1 = new JLabel("Angajatul " + username);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(30, 30, 236, 27);
        add(lblNewLabel_1);
        setBounds(100, 100, 896, 602);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(30, 140, 812, 399);
        orderPane= new JScrollPane(textArea);
        add(orderPane);
        add(textArea);


        JLabel lblNewLabel = new JLabel("Orders List:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(366, 61, 90, 37);
        add(lblNewLabel);

        btnNewButton = new JButton("Log out");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(681, 25, 134, 37);
        add(btnNewButton);


    }
    public void backEmployeeListener(ActionListener a10) { btnNewButton.addActionListener(a10);}


    public void notify (String s)
    {
        textArea.append(s);
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void update(Observable o, Object arg) {

        DeliveryService d1= (DeliveryService) o;
        String s= (String)arg;
        textArea.append(s);
    }
}
