package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;

public class MainView implements ActionListener {
    JFrame frame;
    JButton b;
    JButton printButton;
    JTextField nameField;
    JTextField surnameField;
    JTextField ageField;
    JTextArea address;

    Controller controller;

    public MainView(Controller controller) {
        frame = new JFrame();

        nameField = new JTextField();
        nameField.setBounds(10, 10, 200, 50);
        surnameField = new JTextField();
        surnameField.setBounds(10, 70, 200, 50);
        ageField = new JTextField();
        ageField.setBounds(10, 130, 200, 50);
        address = new JTextArea();
        address.setBounds(10, 190, 200, 200);
        b = new JButton("add to list");
        b.setBounds(10, 400, 100, 40);
        printButton = new JButton("get youngest person");
        printButton.setBounds(120, 400, 100, 40);
        
        b.addActionListener(this);
        printButton.addActionListener(this);
        
        frame.add(nameField);
        frame.add(surnameField);
        frame.add(ageField);
        frame.add(address);
        frame.add(b);
        frame.add(printButton);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.b)
        {
            int age = Integer.parseInt(ageField.getText());
            controller.addPerson(nameField.getText(), surnameField.getText(), address.getText(), age);
            b.setText("X");
        }
        if(e.getSource() == this.printButton)
        {
            controller.minAge();
        }
    }
}
