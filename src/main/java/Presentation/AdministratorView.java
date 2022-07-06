package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorView extends JFrame{

    public JList listOfItems;
    private JScrollPane menuSP;
    JButton btnNewButton;
    public DefaultListModel listOfItemsModel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JTextField textField_7;
    private JTextField textField_number;
    JButton btnNewButton10;
    JButton btnNewButton_5;
    JButton btnNewButton_11;
    JLabel lblNewLabel_10;
    JLabel lblNewLabel_3;
    JTextArea textArea;
    private JTextField textField_startHour;
    private JTextField textField_endHour;
    JButton btnNewButton_reg1;
    JLabel lblNewLabel_startHour;
    JLabel lblNewLabel_endHour;
    JButton btnNewButton_rap2;
    JButton btnNewButton_rap3;
    private JLabel lblNewLabel_number;
    private JTextField textField_21;
    private JTextField textField_nrrap3;
    private JTextField  textField_amount;
    private JTextField textField_rap4;
    JButton btnNewButton_rap4;
    public AdministratorView()
    {
        initialize();
    }

    public void initialize()
    {

        listOfItemsModel = new DefaultListModel<>();

        listOfItems=new JList();
        listOfItems.setModel(listOfItemsModel);
        menuSP = new JScrollPane(listOfItems);
        listOfItems.setBounds(600, 86, 361, 300);
        btnNewButton = new JButton("IMPORT MENU");
        btnNewButton.setBounds(23, 61, 134, 32);



        JLabel lblNewLabel = new JLabel("FOR ADMINISTRATOR:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(23, 11, 215, 39);
        add(lblNewLabel);



        JLabel lblNewLabel_1 = new JLabel("MENU ITEMS:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(554, 23, 123, 14);
        add(lblNewLabel_1);


        btnNewButton_1 = new JButton("ADD PRODUCT");
        btnNewButton_1.setBounds(10, 418, 134, 39);
        add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(96, 150, 86, 20);
        add(textField);
        textField.setColumns(10);

        // textField_1 = new JTextField();
        // textField_1.setBounds(96, 181, 86, 20);
        // add(textField_1);
        // textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(96, 212, 86, 20);
        add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(96, 243, 86, 20);
        add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(96, 274, 86, 20);
        add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(96, 305, 86, 20);
        add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(96, 336, 86, 20);
        add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Name:");
        lblNewLabel_2.setBounds(40, 153, 46, 14);
        add(lblNewLabel_2);


        JLabel lblNewLabel_4 = new JLabel("Calories:");
        lblNewLabel_4.setBounds(40, 215, 46, 14);
        add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Protein:");
        lblNewLabel_5.setBounds(40, 246, 46, 14);
        add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Fat:");
        lblNewLabel_6.setBounds(40, 277, 46, 14);
        add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Sodium:");
        lblNewLabel_7.setBounds(40, 308, 46, 14);
        add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Price:");
        lblNewLabel_8.setBounds(40, 339, 46, 14);
        add(lblNewLabel_8);

        btnNewButton_2 = new JButton("DELETE PRODUCT");
        btnNewButton_2.setBounds(149, 418, 123, 39);
        add(btnNewButton_2);

        btnNewButton_3 = new JButton("MODIFY PRODUCT");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_3.setBounds(79, 463, 133, 32);
        add(btnNewButton_3);

        btnNewButton_4 = new JButton("CREATE MENU");
        btnNewButton_4.setBounds(660, 475, 123, 32);
        add(btnNewButton_4);

        btnNewButton_5 = new JButton("SELECT PRODUCT");
        btnNewButton_5.setBounds(443, 422, 134, 31);
        add(btnNewButton_5);

        textField_7 = new JTextField();
        textField_7.setBounds(697, 427, 86, 20);
        add(textField_7);
        textField_7.setColumns(10);


        btnNewButton10 = new JButton("Log out");
        btnNewButton10.setBounds(23, 529, 89, 23);
        add(btnNewButton10);



        btnNewButton_reg1 = new JButton("Raport1");
        btnNewButton_reg1.setBounds(30, 569, 109, 37);
        add(btnNewButton_reg1);


        textField_startHour = new JTextField();
        textField_startHour.setBounds(240, 577, 86, 20);
        add(textField_startHour);
        textField_startHour.setColumns(10);

        textField_endHour = new JTextField();
        textField_endHour.setBounds(415, 577, 86, 20);
        add(textField_endHour);
        textField_endHour.setColumns(10);

        lblNewLabel_startHour = new JLabel("Start Hour:");
        lblNewLabel_startHour.setBounds(176, 580, 54, 14);
        add(lblNewLabel_startHour);

        lblNewLabel_endHour = new JLabel("End hour:");
        lblNewLabel_endHour.setBounds(366, 580, 57, 14);
        add(lblNewLabel_endHour);



        JLabel lblNewLabel_9 = new JLabel("Name:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_9.setBounds(644, 430, 46, 14);
        add(lblNewLabel_9);
        setPreferredSize (new Dimension (864, 867));


        btnNewButton_rap2 = new JButton("Raport2");
        btnNewButton_rap2.setBounds(30, 617, 109, 37);
        add(btnNewButton_rap2);


        textField_number = new JTextField();
        textField_number.setBounds(240, 625, 86, 20);
        add(textField_number);
        textField_number.setColumns(10);

        // JLabel lblNewLabel_41 = new JLabel("Number:");
        // lblNewLabel_41.setBounds(176, 628, 46, 14);
        //add(lblNewLabel_41);


        lblNewLabel_number = new JLabel("Number:");
        lblNewLabel_number.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_number.setBounds(153, 620, 134, 27);
        add(lblNewLabel_number);


        btnNewButton_rap3 = new JButton("Raport3");
        btnNewButton_rap3.setBounds(40, 671, 89, 27);
        add(btnNewButton_rap3);

        textField_nrrap3 = new JTextField();
        textField_nrrap3.setBounds(240, 678, 86, 20);
        add(textField_nrrap3);
        textField_nrrap3.setColumns(10);


        textField_amount = new JTextField();
        textField_amount.setBounds(240, 709, 86, 20);
        add( textField_amount);
        textField_amount.setColumns(10);

        JLabel lblNewLabel_rap31 = new JLabel("Number");
        lblNewLabel_rap31.setBounds(173, 677, 57, 14);
        add(lblNewLabel_rap31);

        JLabel lblNewLabel_rap32 = new JLabel("Amount");
        lblNewLabel_rap32 .setBounds(173, 712, 57, 14);
        add(lblNewLabel_rap32 );


        btnNewButton_rap4 = new JButton("Raport4");
        btnNewButton_rap4.setBounds(40, 763, 101, 37);
        add(btnNewButton_rap4);

        textField_rap4 = new JTextField();
        textField_rap4.setBounds(240, 771, 86, 20);
        add(textField_rap4);
        textField_rap4.setColumns(10);

        JLabel lblNewLabel_RAP4 = new JLabel("Date:");
        lblNewLabel_RAP4.setBounds(170, 774, 60, 14);
        add(lblNewLabel_RAP4);



        setLayout (null);


        add (menuSP);
        add(btnNewButton);


        menuSP.setBounds (450, 85, 300, 300);


        pack();

    }


    public void importListener(ActionListener a) {
        btnNewButton.addActionListener(a);
    }

    public void addListener(ActionListener a1)
    {
        btnNewButton_1.addActionListener(a1);
    }

    public void deleteListener(ActionListener a2)
    {
        btnNewButton_2.addActionListener(a2);
    }

    public void modifyListener(ActionListener a3) { btnNewButton_3.addActionListener(a3);}

    public void createCompositeListener(ActionListener a5) { btnNewButton_4.addActionListener(a5);}

    public void selectListener(ActionListener a4) { btnNewButton_5.addActionListener(a4);}

    public void backListener(ActionListener a10) { btnNewButton10.addActionListener(a10);}

    public void raport1Listener(ActionListener a11) { btnNewButton_reg1.addActionListener(a11);}

    public void raport2Listener(ActionListener a12) { btnNewButton_rap2.addActionListener(a12);}

    public void raport3Listener(ActionListener a13) { btnNewButton_rap3.addActionListener(a13);}

    public void raport4Listener(ActionListener a14) { btnNewButton_rap4.addActionListener(a14);}


    public String getUserInput() {
        return textField.getText();
    }
    String getUserInput_1() {
        return textField_1.getText();
    }
    public String getUserInput_2() {
        return textField_2.getText();
    }
    public String getUserInput_3() {
        return textField_3.getText();
    }
    public String getUserInput_4() {
        return textField_4.getText();
    }
    public String getUserInput_5() {
        return textField_5.getText();
    }
    public String getUserInput_6() {
        return textField_6.getText();
    }
    public String getUserInput_7() {
        return textField_7.getText();
    }

    public String getUserInput_startHour() {
        return textField_startHour.getText();
    }
    public String getUserInput_endHour() {
        return textField_endHour.getText();
    }

    public String getUserInput_number() {
        return textField_number.getText();
    }


    public String getUserInput_numberrap3()
    {
        return textField_nrrap3.getText();
    }
    public String getUserInput_amount()
    {
        return textField_amount.getText();
    }

    public String getUserInput_rap4()
    {
        return textField_rap4.getText();
    }

    public void succes(String name)
    {
        JOptionPane.showMessageDialog(getContentPane(),"You have added the product " + name + " successfully! !");
    }
    public void composite(String name)
    {
        JOptionPane.showMessageDialog(getContentPane(),"You have created the compsite product "+ name+ " successfully !");
    }
    public void delete()
    {
        JOptionPane.showMessageDialog(getContentPane(),"You deleted the product successfully!");
    }

    public void update()
    {
        JOptionPane.showMessageDialog(getContentPane(),"You have modified your product successfully!");
    }
}
