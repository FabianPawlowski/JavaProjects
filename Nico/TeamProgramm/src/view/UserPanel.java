package view;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSplitPaneUI;
import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Robot;
import java.awt.AWTException;

public class UserPanel extends JPanel implements ActionListener, KeyListener {

    TeamView view;
    JTextField namensField;
    JTextField surnameField;
    JTextField ageField;
    JComboBox<String> teamsField;
    JComboBox<String> userSelect;
    JCheckBox isTeamleiter;
    JTextField companyCar;
    JLabel nameLabel;
    JButton bearbeiten;
    JLabel nachnameLabel;
    JLabel alter;
    JLabel team;
    JLabel teamleiter;
    JLabel fahrzeug;
    JButton confirm;
    JButton schliessen;
    JButton safeChanges;
    JLabel ageFeedback;
    JLabel lengthFeedback;
    JLabel zahlFeedback;
    JLabel personHinzugefuegt;
    JLabel personGeloescht;
    JLabel aenderungGespeichert;
    JButton abbrechen;
    JButton loeschen;

    JLabel linie;
    JLabel linie2;
    boolean hinzufuegenErlauben = true;
    boolean alleFelderErlauben = true;
    boolean changed;

    public UserPanel(TeamView view) {

        linie = new JLabel("_________________________________________");
        linie.setBounds(10, 150, 310, 15);
        add(linie);

        linie2 = new JLabel("_________________________________________");
        linie2.setBounds(10, 213, 310, 15);
        add(linie2);

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

        bearbeiten = new JButton("User bearbeiten");
        bearbeiten.setBounds(20, 170, 130, 20);
        bearbeiten.addActionListener(this);
        add(bearbeiten);

        abbrechen = new JButton("Abbrechen");
        abbrechen.setBounds(20, 170, 130, 20);
        abbrechen.addActionListener(this);
        abbrechen.setVisible(false);
        add(abbrechen);

        loeschen = new JButton("Löschen");
        loeschen.setBounds(20, 200, 90, 20);
        loeschen.addActionListener(this);
        loeschen.setVisible(false);
        loeschen.setEnabled(false);
        add(loeschen);

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

        ageFeedback = new JLabel("Nicht älter als 120!");
        ageFeedback.setBounds(190, 70, 120, 20);
        ageFeedback.setVisible(false);
        add(ageFeedback);

        lengthFeedback = new JLabel("Eingabe zu lang!");
        lengthFeedback.setBounds(190, 70, 120, 20);
        lengthFeedback.setVisible(false);
        add(lengthFeedback);

        zahlFeedback = new JLabel("Bitte nur Zahlen!");
        zahlFeedback.setBounds(190, 70, 120, 20);
        zahlFeedback.setVisible(false);
        add(zahlFeedback);

        personHinzugefuegt = new JLabel("Person hinzugeügt!");
        personHinzugefuegt.setBounds(100, 130, 120, 20);
        personHinzugefuegt.setVisible(false);
        add(personHinzugefuegt);

        personGeloescht = new JLabel("Person gelöscht!");
        personGeloescht.setBounds(100, 130, 120, 20);
        personGeloescht.setVisible(false);
        add(personGeloescht);

        aenderungGespeichert = new JLabel("Änderung gespeichert!");
        aenderungGespeichert.setBounds(90, 130, 140, 20);
        aenderungGespeichert.setVisible(false);
        add(aenderungGespeichert);

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

        userSelect = new JComboBox<String>();
        userSelect.setBounds(160, 170, 130, 20);
        userSelect.addItem("Person auswählen");
        userSelect.addActionListener(this);
        add(userSelect);
        userSelect.setVisible(false);

        safeChanges = new JButton("Änderungen speichern");
        safeChanges.setBounds(120, 200, 170, 20);
        add(safeChanges);
        safeChanges.setVisible(false);
        safeChanges.addActionListener(this);

        confirm = new JButton("Hinzufügen");
        confirm.setBounds(160, 235, 130, 30);
        add(confirm);
        confirm.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 235, 130, 30);
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

    public void addUser(String username) {
        userSelect.addItem(username);
    }

    public void clearComboboxen() {
        userSelect.removeAllItems();
        userSelect.addItem("Person auswählen");
        teamsField.removeAllItems();
        teamsField.addItem("Bitte auswählen");
    }

    private void robotMethod() {
        try {
            Robot r = new Robot();

            r.keyPress(KeyEvent.VK_TAB);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyPress(KeyEvent.VK_TAB);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void loadSelectedUser(String username) {

        // member<i>.equals()
        // if Schleife

        // view.getController().loadSelectedUser(username);

        namensField.setText("geladener Vorname");
        surnameField.setText("geladener Nachname");
        ageField.setText("99");
        teamsField.setSelectedItem(1);
        isTeamleiter.setSelected(true);
        companyCar.setText("geladenes Kennzeichen");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == schliessen) {
            System.exit(0);
        }

        if (e.getSource() == this.confirm) {
            if (view.getController().addMember(namensField.getText(), surnameField.getText(), ageField.getText(),
                    teamsField.getSelectedItem().toString(), isTeamleiter.isSelected(), companyCar.getText())) {
                namensField.setText("");
                surnameField.setText("");
                ageField.setText("");
                isTeamleiter.setSelected(false);
                companyCar.setText("");
                companyCar.setVisible(false);
                fahrzeug.setVisible(false);
                confirm.setEnabled(false);
                teamsField.setSelectedIndex(0);
                view.getController().refreshTable();
                personHinzugefuegt.setVisible(true);
                int delay = 1500;
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        personHinzugefuegt.setVisible(false);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();

                alleFelderPruefen();
                changed = false;

            }
        }
        if (e.getSource() == userSelect) {
            if (userSelect.getModel().getSize() > 1
                    && !userSelect.getSelectedItem().toString().equals("Person auswählen")) {
                enablePersonBearbeiten();

                view.getController().loadUserToChange(userSelect.getSelectedItem().toString());
                safeChanges.setEnabled(true);
                loeschen.setEnabled(true);
                toggleConfirmEnabled();
                alleFelderPruefen();

            }
        }
        if (e.getSource() == teamsField) {
            toggleConfirmEnabled();
            if (!namensField.getText().toString().equals("") && !surnameField.getText().toString().equals("")
                    && !ageField.getText().toString().equals("")) {
                if (!teamsField.getSelectedItem().toString().equals("Bitte auswählen")
                        && !teamsField.getSelectedItem().toString().equals("")) {
                    robotMethod();
                    robotMethod();
                    robotMethod();
                    robotMethod();
                    robotMethod();

                    System.out.println("jetzt TAB");

                }
            }
        }
        if (e.getSource() == loeschen) {
            view.getController().deletePerson(userSelect.getSelectedItem().toString());
            abbrechen.doClick();
            userSelect.setSelectedIndex(0);
            teamsField.setSelectedIndex(0);
            namensField.setText("");
            surnameField.setText("");
            ageField.setText("");
            isTeamleiter.setSelected(false);
            companyCar.setText("");
            companyCar.setVisible(false);
            fahrzeug.setVisible(false);
            personGeloescht.setVisible(true);
            changed = false;

            int delay = 1500;
            ActionListener taskPerformer = new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    personGeloescht.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();

            hinzufuegenErlauben = true;
            toggleConfirmEnabled();
            alleFelderErlauben = true;

            alleFelderPruefen();

        }
        if (e.getSource() == abbrechen) {
            safeChanges.setEnabled(false);
            safeChanges.setVisible(false);
            loeschen.setEnabled(false);
            abbrechen.setVisible(false);
            bearbeiten.setVisible(true);
            bearbeiten.setEnabled(true);
            userSelect.setVisible(false);
            loeschen.setVisible(false);
            userSelect.setSelectedIndex(0);
            teamsField.setSelectedIndex(0);
            namensField.setText("");
            surnameField.setText("");
            ageField.setText("");
            isTeamleiter.setSelected(false);
            companyCar.setText("");
            companyCar.setVisible(false);
            fahrzeug.setVisible(false);

            hinzufuegenErlauben = true;
            toggleConfirmEnabled();
            alleFelderErlauben = true;

            alleFelderPruefen();
            changed = false;

        }
        /*
         * if (e.getSource() == userSelect) { if
         * (userSelect.getSelectedItem().toString().equals("Person auswählen")) {
         * System.out.println("nein"); } else {
         * namensField.setText("von der aktuellen Person"); } toggleConfirmEnabled(); }
         */ if (e.getSource() == isTeamleiter) {
            if (isTeamleiter.isSelected()) {
                companyCar.setVisible(true);
                fahrzeug.setVisible(true);
            } else {
                companyCar.setVisible(false);
                fahrzeug.setVisible(false);
            }

        }

        if (e.getSource() == companyCar) {
            changed = true;
        }

        if (e.getSource() == bearbeiten) {

            safeChanges.setVisible(true);
            safeChanges.setEnabled(false);
            userSelect.setVisible(true);
            bearbeiten.setVisible(false);
            abbrechen.setVisible(true);
            loeschen.setVisible(true);
            loeschen.setEnabled(false);

            hinzufuegenErlauben = false;
            toggleConfirmEnabled();
            alleFelderErlauben = false;
            alleFelderPruefen();

        }


        if (e.getSource() == safeChanges) {

            if (view.getController().checkCompanyCarForChanges(companyCar.getText().toString(), changed)) {

                MessageDialogs.showKennzeichenError();


            } else {

                view.getController().safeChangedUser(userSelect.getSelectedItem().toString(), namensField.getText(),
                        surnameField.getText(), ageField.getText(), teamsField.getSelectedItem().toString(),
                        isTeamleiter.isSelected(), companyCar.getText());

                abbrechen.doClick();
                userSelect.setSelectedIndex(0);
                teamsField.setSelectedIndex(0);
                view.getController().refreshTable();

                hinzufuegenErlauben = true;
                toggleConfirmEnabled();
                alleFelderErlauben = true;
                alleFelderPruefen();

                boolean kennzeichenDoppelt = view.getController().checkCompanyCar(companyCar.getText());
                /*
                 * if (kennzeichenDoppelt) { MessageDialogs.showTeamError(); return; }
                 */
                // AB HIER üBERPRÜFUNG OB ÄNDERUNGEN GESPICHERT WERDEN SOLLEN
                safeChanges.setVisible(false);
                userSelect.setVisible(false);
                bearbeiten.setEnabled(true);
                namensField.setText("");
                surnameField.setText("");
                ageField.setText("");
                teamsField.setSelectedItem(1);
                isTeamleiter.setSelected(false);
                companyCar.setText("");
                loeschen.setVisible(false);
                companyCar.setVisible(false);
                fahrzeug.setVisible(false);

                aenderungGespeichert.setVisible(true);
                int delay = 1500;
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        aenderungGespeichert.setVisible(false);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();

            }
            changed = false;
        }
    }

    private void alleFelderPruefen() {
        if (!alleFelderErlauben && userSelect.getSelectedItem().toString().equals("Person auswählen")) {
            nameLabel.setEnabled(false);
            namensField.setEnabled(false);
            nachnameLabel.setEnabled(false);
            surnameField.setEnabled(false);
            ageField.setEnabled(false);
            alter.setEnabled(false);
            teamleiter.setEnabled(false);
            team.setEnabled(false);
            teamsField.setEnabled(false);
            fahrzeug.setEnabled(false);
            isTeamleiter.setEnabled(false);
            companyCar.setEnabled(false);
        } else {
            nameLabel.setEnabled(true);
            namensField.setEnabled(true);
            nachnameLabel.setEnabled(true);
            surnameField.setEnabled(true);
            ageField.setEnabled(true);
            alter.setEnabled(true);
            teamleiter.setEnabled(true);
            team.setEnabled(true);
            teamsField.setEnabled(true);
            fahrzeug.setEnabled(true);
            isTeamleiter.setEnabled(true);
            companyCar.setEnabled(true);
        }
    }

    // HIER WAR DER FEHLER!!!
    private void toggleConfirmEnabled() {
        if (namensField.getText().length() > 0 && surnameField.getText().length() > 0 && ageField.getText().length() > 0
                && hinzufuegenErlauben && !teamsField.getSelectedItem().equals("Bitte auswählen")) {
            confirm.setEnabled(true);
        } else {
            confirm.setEnabled(false);
        }
    }

    private void enablePersonBearbeiten() {
        if (!userSelect.getSelectedItem().equals("User auswählen")) {
            safeChanges.setEnabled(false);
            loeschen.setEnabled(false);
        } else {
            safeChanges.setEnabled(true);
            loeschen.setEnabled(true);
        }
    }

    // sobald irgendeine taste gedrückt wird, soll diese methode durchlaufen
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        char c = e.getKeyChar();

        if (e.getSource() == ageField) {

            if (!Character.isDigit(c)) {
                e.consume();
                System.out.println("Keine Zahl");
                zahlFeedback.setVisible(true);
                int delay = 1500;
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // System.out.println(delay);
                        zahlFeedback.setVisible(false);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();

            } else {
                if ((ageField.getText().length() > 2)) {
                    e.consume();

                    System.out.println("Eingabe zu lang");
                    lengthFeedback.setVisible(true);
                    int delay = 1500;
                    ActionListener taskPerformer = new ActionListener() {

                        public void actionPerformed(ActionEvent evt) {
                            lengthFeedback.setVisible(false);
                        }
                    };
                    new javax.swing.Timer(delay, taskPerformer).start();

                } else {
                    if (ageField.getText().length() > 1) {
                        if (Integer.parseInt(ageField.getText() + c) < 121) {
                            System.out.println("passt");
                        } else {

                            e.consume();
                            System.out.println("älter als 120 geht nicht!");
                            ageFeedback.setVisible(true);

                            int delay = 1500;
                            ActionListener taskPerformer = new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {
                                    ageFeedback.setVisible(false);
                                }
                            };
                            new javax.swing.Timer(delay, taskPerformer).start();
                        }
                    }
                }

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (namensField.getText().length() > 0 && surnameField.getText().length() > 0
                    && ageField.getText().length() > 0) {
                confirm.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        toggleConfirmEnabled();

    }

    public void modifyTeam(String teamName, String neuerName) {
        for (int i = 0; i < teamsField.getItemCount(); i++) {
            if (teamsField.getItemAt(i).equals(teamName)) {
                teamsField.removeItemAt(i);
                teamsField.insertItemAt(neuerName, i);
            }
        }
    }

    public void deleteTeam(String teamname) {

        for (int i = 0; i < teamsField.getItemCount(); i++) {
            if (teamsField.getItemAt(i).equals(teamname)) {
                teamsField.removeItemAt(i);
            }
        }

    }

    public void deleteMemberFromCombobox(String anzeigename) {
        ArrayList<String> zuLoeschen = new ArrayList<>();
        for (int i = 0; i < userSelect.getItemCount(); i++) {
            if (userSelect.getItemAt(i).equals(anzeigename)) {
                zuLoeschen.add(anzeigename);
                break;
            }
        }
        for (int i = 0; i < zuLoeschen.size(); i++) {
            userSelect.removeItem(zuLoeschen.get(i).toString());
        }
    }

    public void loadUserToChange(String vorname, String nachname, String alter2, String teamname, boolean teamleiter2,
            String kennzeichen) {
        namensField.setText(vorname);
        surnameField.setText(nachname);
        ageField.setText(alter2);
        teamsField.setSelectedItem(teamname);
        if (teamleiter2) {
            isTeamleiter.setSelected(true);
            companyCar.setVisible(true);
            fahrzeug.setVisible(true);
        } else {
            isTeamleiter.setSelected(false);
            companyCar.setVisible(false);
            fahrzeug.setVisible(false);
        }
        companyCar.setText(kennzeichen);

    }

    public void safeChangedUser(String anzeigename, String vorname, String nachname) {
        ArrayList<String> zuAendern = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < userSelect.getItemCount(); i++) {
            if (userSelect.getItemAt(i).equals(anzeigename)) {
                zuAendern.add(vorname + " " + nachname);
                userSelect.removeItemAt(i);
                index = i;
                break;
            }

        }

        for (int i = index; i < userSelect.getItemCount(); i++) {
            zuAendern.add(userSelect.getItemAt(i).toString());
        }

        for (int i = 0; i < zuAendern.size(); i++) {
            userSelect.removeItem(zuAendern.get(i).toString());
        }

        for (int i = 0; i < zuAendern.size(); i++) {
            userSelect.addItem(zuAendern.get(i).toString());
        }

    }
}
