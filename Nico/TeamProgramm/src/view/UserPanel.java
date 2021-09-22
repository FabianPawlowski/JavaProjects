package view;

import javax.swing.*;
import java.awt.event.*;

public class UserPanel extends JPanel implements ActionListener, KeyListener {

    TeamView view;
    JTextField namensField;
    JTextField surnameField;
    JTextField ageField;
    JComboBox<String> teamsField;
    JCheckBox isTeamleiter;
    JTextField companyCar;
    JLabel nameLabel;
    JLabel nachnameLabel;
    JLabel alter;
    JLabel team;
    JLabel teamleiter;
    JLabel fahrzeug;
    JButton confirm;
    JButton schliessen;

    public UserPanel(TeamView view) {

        nameLabel = new JLabel("Vorname:");
        nameLabel.setBounds(20, 15, 80, 20);
        add(nameLabel);

        nachnameLabel = new JLabel("Nachname:");
        nachnameLabel.setBounds(20, 40, 80, 20);
        add(nachnameLabel);

        alter = new JLabel("Alter:");
        alter.setBounds(20, 70, 80, 20);
        add(alter);

        team = new JLabel("Team:");
        team.setBounds(20, 100, 80, 20);
        add(team);

        teamleiter = new JLabel("Teamleiter?");
        teamleiter.setBounds(190, 100, 80, 20);
        add(teamleiter);

        fahrzeug = new JLabel("Fahrzeug (Kennzeichen):");
        fahrzeug.setBounds(20, 130, 140, 20);
        add(fahrzeug);

        fahrzeug.setVisible(false);

        isTeamleiter = new JCheckBox();
        isTeamleiter.setBounds(270, 90, 30, 40);
        add(isTeamleiter);
        isTeamleiter.addActionListener(this);

        namensField = new JTextField();
        namensField.setBounds(130, 15, 160, 20);
        add(namensField);
        namensField.addKeyListener(this);

        surnameField = new JTextField();
        surnameField.setBounds(130, 40, 160, 20);
        add(surnameField);
        surnameField.addKeyListener(this);

        ageField = new JTextField();
        ageField.setBounds(130, 70, 50, 20);
        add(ageField);
        ageField.addKeyListener(this);

        companyCar = new JTextField();
        companyCar.setBounds(190, 130, 100, 20);
        add(companyCar);
        companyCar.addKeyListener(this);
        companyCar.setVisible(false);

        teamsField = new JComboBox<String>();
        teamsField.setBounds(70, 100, 110, 20);
        teamsField.addItem("Bitte auswählen");
        teamsField.addActionListener(this);
        add(teamsField);

        confirm = new JButton("Bestätigen");
        confirm.setBounds(160, 170, 130, 30);
        add(confirm);
        confirm.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 170, 130, 30);
        add(schliessen);
        schliessen.addActionListener(this);

        confirm.setEnabled(false);

        setLayout(null);

        /*
         * for (int i = 0; i < labels.length; i++) { JLabel l = new JLabel(labels[i],
         * JLabel.TRAILING); add(l); l.setLabelFor(components[i]); add(components[i]); }
         */
        this.view = view;

    }

    public void addTeam(String teamname) {
        teamsField.addItem(teamname);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == schliessen) {
            System.exit(0);
        }
        if (e.getSource() == this.confirm) {
            view.getController().addMember(namensField.getText(), surnameField.getText(),
                    Integer.parseInt(ageField.getText()), teamsField.getSelectedItem().toString(),
                    isTeamleiter.isSelected(), companyCar.getText());
            namensField.setText("");
            surnameField.setText("");
            ageField.setText("");
            isTeamleiter.setSelected(false);
            companyCar.setText("");

        }
        if (e.getSource() == teamsField) {
            toggleConfirmEnabled();
        }
        if (e.getSource() == isTeamleiter) {
            if (isTeamleiter.isSelected()) {
                companyCar.setVisible(true);
                fahrzeug.setVisible(true);
            } else {
                companyCar.setVisible(false);
                fahrzeug.setVisible(false);
            }

        }
    }

    private void toggleConfirmEnabled() {
        if (namensField.getText().length() > 0 && surnameField.getText().length() > 0 && ageField.getText().length() > 0
                && !teamsField.getSelectedItem().equals("Bitte auswählen")) {
            confirm.setEnabled(true);
        } else {
            confirm.setEnabled(false);
        }
    }

    // sobald irgendeine taste gedrückt wird, soll diese methode durchlaufen
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        toggleConfirmEnabled();
    }
}