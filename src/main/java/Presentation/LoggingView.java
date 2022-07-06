package Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoggingView {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    public LoggingView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setAutoRequestFocus(false);
        frame.setBounds(100, 100, 578, 384);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(160, 65, 294, 23);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("USERNAME:");
        lblNewLabel.setBounds(88, 53, 119, 46);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
        lblNewLabel_1.setBounds(88, 99, 94, 23);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(160, 99, 294, 23);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        btnNewButton = new JButton("REGISTER");
        btnNewButton.setBounds(68, 195, 139, 54);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("LOG IN");
        btnNewButton_1.setBounds(303, 195, 146, 54);
        frame.getContentPane().add(btnNewButton_1);
    }
    public void regListener(ActionListener mal) {
        btnNewButton.addActionListener(mal);
    }

    public void logListener(ActionListener cal) {
        btnNewButton_1.addActionListener(cal);

    }

    public void confirm()
    {
        JOptionPane.showMessageDialog(frame, "You have successfully registered. Now log in !");
    }

    public String getUserInput() {
        return textField.getText();
    }

    public String getUserInput1() {
        return textField_1.getText();
    }
}