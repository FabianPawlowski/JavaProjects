package view;

import javax.swing.*;
import java.awt.event.*;

public class UserPanel extends JPanel implements ActionListener {

    MainView view;
    JTextField nameField;
    JTextField surnameField;
    JTextField ageField;
    JComboBox<String> teamsField;
    JCheckBox isTeamleiter;
    JTextField companyCar;

    public UserPanel(MainView view) {
        String[] labels = {"Vorname: ", "Nachname: ", "Alter: ", "Team:", "Teamleiter?", "Firmenwagen: "};
        nameField = new JTextField(15);
        surnameField = new JTextField(15);
        ageField = new JTextField(15);
        teamsField = new JComboBox<String>();
        isTeamleiter = new JCheckBox();
        companyCar = new JTextField();
        JComponent[] components = {nameField, surnameField, ageField, teamsField, isTeamleiter, companyCar};

        setLayout(new SpringLayout());

        for (int i = 0; i < labels.length; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            add(l);
            l.setLabelFor(components[i]);
            add(components[i]);
        }

        SpringUtilities.makeCompactGrid(this, 
                                        labels.length, 2,   //rows, cols
                                        6, 6,               //initX, initY
                                        6, 6);              //xPad, yPad

        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
