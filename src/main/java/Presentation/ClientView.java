package Presentation;

import Business.DeliveryService;
import Business.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ClientView extends JFrame implements Observer {

    private int ClientID;
    public JList listOfItems;
    private JScrollPane menuSP;
    public DefaultListModel listOfItemsModel;
    private JButton btnNewButton;
    public JComboBox comboBox;
    private JTextField textField_7;
    private JTextField textField;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    public ClientView()
    {
        initialize();
    }


    public void setClientID(int clientID) {
        ClientID = clientID;
    }

    public int getClientID() {
        return ClientID;
    }

    public void initialize() {

        listOfItemsModel = new DefaultListModel<>();

        listOfItems = new JList();
        listOfItems.setModel(listOfItemsModel);
        menuSP = new JScrollPane(listOfItems);
        listOfItems.setBounds(600, 86, 361, 300);
        add (menuSP);

        menuSP.setBounds (450, 85, 300, 300);
        setPreferredSize (new Dimension(800, 800));
        setLayout (null);


        JLabel lblNewLabel_1 = new JLabel("MENU ITEMS:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(625, 21, 123, 14);
        add(lblNewLabel_1);
        String[] str = { "Name", "Rating", "Calories", "Proteins", "Fats", "Sodium", "Price" };

        comboBox = new JComboBox(str);
        comboBox.setBounds(38, 90, 134, 172);
        add(comboBox);

        JLabel lblNewLabel = new JLabel("Criteria:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(76, 65, 78, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Condition:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(251, 65, 107, 14);
        add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(239, 88, 86, 20);
        add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Search");
        btnNewButton.setBounds(227, 145, 117, 31);
        add(btnNewButton);

        btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.setBounds(227, 202, 117, 31);
        add(btnNewButton_1);

        btnNewButton_2 = new JButton("Select Item");
        btnNewButton_2.setBounds(450, 450, 123, 31);
        add(btnNewButton_2);

        btnNewButton_3 = new JButton("Create Order");
        btnNewButton_3.setBounds(600, 450, 128, 31);
        add(btnNewButton_3);

        btnNewButton_10 = new JButton("Log out");
        btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_10.setBounds(30, 480, 134, 37);
        add(btnNewButton_10);

        btnNewButton_11 = new JButton("Bill");
        btnNewButton_11.setBounds(520, 669, 96, 37);
        add(btnNewButton_11);

        pack();
    }

    public void searchListener(ActionListener a) {
        btnNewButton.addActionListener(a);
    }
    public void cancelListener(ActionListener a1) {
        btnNewButton_1.addActionListener(a1);
    }

    public void selectListener(ActionListener a2) {
        btnNewButton_2.addActionListener(a2);
    }
    public void createOrderListener(ActionListener a3) {
        btnNewButton_3.addActionListener(a3);
    }
    public void exitListener(ActionListener a10) {
        btnNewButton_10.addActionListener(a10);
    }
    public void BillListener(ActionListener a12) {
        btnNewButton_11.addActionListener(a12);
    }
    public String getUserInput() {
        return textField.getText();
    }


    @Override
    public void update(Observable o, Object arg) {
        DeliveryService d1= (DeliveryService) o;
        Order order= (Order) arg;

    }
}