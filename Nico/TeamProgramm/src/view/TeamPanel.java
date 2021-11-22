package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;

public class TeamPanel extends JPanel implements ActionListener, KeyListener {

    TeamView view;
    JButton schliessen;
    JButton anlegen;
    JLabel neuesTeam;
    JTextField name;
    JLabel angelegt;
    JButton loeschen;

    JComboBox<String> bearbeiten;
    JLabel teamBearbeiten;
    JButton aenderungSpeichern;
    JTextField neuerName;
    JLabel nameLabel;
    JButton abbrechen;

    JLabel linie;
    JLabel linie2;

    JLabel teamnameGeaendert;
    JLabel teamGeloescht;
    JLabel teamHinzugefuegt;
    JLabel letztesTeam;

    public TeamPanel(TeamView view) {

        setLayout(null);

        linie = new JLabel("_________________________________________");
        linie.setBounds(10, 80, 310, 15);
        add(linie);

        linie2 = new JLabel("_________________________________________");
        linie2.setBounds(10, 213, 310, 15);
        add(linie2);

        abbrechen = new JButton("Abbrechen");
        abbrechen.setBounds(55, 190, 200, 20);
        abbrechen.addActionListener(this);
        abbrechen.setVisible(false);
        add(abbrechen);

        letztesTeam = new JLabel("!");
        letztesTeam.setBounds(295, 120, 5, 20);
        letztesTeam.setVisible(false);
        add(letztesTeam);

        neuesTeam = new JLabel("Neues Team:");
        neuesTeam.setBounds(10, 10, 80, 20);
        add(neuesTeam);

        name = new JTextField();
        name.setBounds(10, 30, 180, 20);
        add(name);
        name.addKeyListener(this);

        teamnameGeaendert = new JLabel("Teamname geändert!");
        teamnameGeaendert.setBounds(80, 150, 160, 20);
        teamnameGeaendert.setVisible(false);
        add(teamnameGeaendert);

        teamGeloescht = new JLabel("Team gelöscht!");
        teamGeloescht.setBounds(80, 150, 160, 20);
        teamGeloescht.setVisible(false);
        add(teamGeloescht);

        teamHinzugefuegt = new JLabel("Team hinzugefügt!");
        teamHinzugefuegt.setBounds(80, 150, 160, 20);
        teamHinzugefuegt.setVisible(false);
        add(teamHinzugefuegt);

        teamBearbeiten = new JLabel("Bearbeiten:");
        teamBearbeiten.setBounds(10, 100, 180, 20);
        add(teamBearbeiten);

        neuerName = new JTextField();
        neuerName.setBounds(10, 160, 130, 20);
        neuerName.setVisible(false);
        neuerName.addKeyListener(this);
        add(neuerName);

        nameLabel = new JLabel("Neuer Name:");
        nameLabel.setBounds(10, 142, 120, 20);
        nameLabel.setVisible(false);
        add(nameLabel);

        loeschen = new JButton("Team löschen");
        loeschen.setBounds(160, 120, 130, 20);
        loeschen.setVisible(false);
        add(loeschen);
        loeschen.addActionListener(this);

        aenderungSpeichern = new JButton("Änderung speichern");
        aenderungSpeichern.setBounds(160, 160, 130, 20);
        aenderungSpeichern.setVisible(false);
        aenderungSpeichern.setEnabled(false);
        aenderungSpeichern.addActionListener(this);
        add(aenderungSpeichern);

        bearbeiten = new JComboBox<String>();
        bearbeiten.setBounds(10, 120, 130, 20);
        bearbeiten.addItem("Team auswählen");
        add(bearbeiten);
        bearbeiten.addKeyListener(this);
        bearbeiten.addActionListener(this);

        anlegen = new JButton("Hinzufügen");
        anlegen.setBounds(160, 60, 130, 30);
        add(anlegen);
        anlegen.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 235, 130, 30);
        add(schliessen);
        schliessen.addActionListener(this);

        anlegen.setEnabled(false);

        this.view = view;

    }

    public void addTeam(String teamname) {
        bearbeiten.addItem(teamname);
        teamBearbeiten.setEnabled(true);

    }

    public void clearCombobox() {
        bearbeiten.removeAllItems();
        bearbeiten.addItem("Team auswählen");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == schliessen) {
            System.exit(0);
        }

        if (e.getSource() == this.anlegen) {
            view.getController().addTeam(name.getText());
            name.setText("");
            teamHinzugefuegt.setVisible(true);
            int delay = 1500;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    teamHinzugefuegt.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();

        }

        if (e.getSource() == bearbeiten) {
            if (bearbeiten.getModel().getSize() > 0
                    && !bearbeiten.getSelectedItem().toString().equals("Team auswählen")) {
                // enablePersonBearbeiten();
                neuerName.setVisible(true);
                nameLabel.setVisible(true);
                loeschen.setVisible(true);
                aenderungSpeichern.setVisible(true);
                anlegen.setEnabled(false);
                name.setEnabled(false);
                neuesTeam.setEnabled(false);
                schliessen.setEnabled(false);
                abbrechen.setVisible(true);

                if (view.getController().checkTeams()) {
                    letztesTeam.setVisible(true);
                } else {
                    letztesTeam.setVisible(false);
                }
            }
        }
        /*
         * if (e.getSource() == bearbeitenButton) { anlegen.setEnabled(true);
         * name.setEnabled(true); neuerName.setVisible(false);
         * nameLabel.setVisible(false); bearbeitenButton.setVisible(false);
         * loeschen.setVisible(false); neuesTeam.setEnabled(true);
         * schliessen.setEnabled(true); bearbeiten.setSelectedIndex(0);
         * 
         */

        if (e.getSource() == loeschen) {

            if (!view.getController().checkSelectedTeam(bearbeiten.getSelectedItem().toString())) {

                view.getController().deleteMember(bearbeiten.getSelectedItem().toString());
                view.getController().deleteTeam(bearbeiten.getSelectedItem().toString());

                bearbeiten.setSelectedIndex(0);
                anlegen.setEnabled(true);
                name.setEnabled(true);
                neuerName.setVisible(false);
                nameLabel.setVisible(false);
                aenderungSpeichern.setVisible(false);
                loeschen.setVisible(false);
                neuesTeam.setEnabled(true);
                schliessen.setEnabled(true);
                abbrechen.setVisible(false);
                teamGeloescht.setVisible(true);

                letztesTeam.setVisible(false);

                int delay = 1500;

                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        teamGeloescht.setVisible(false);
                    }
                };
                new javax.swing.Timer(delay, taskPerformer).start();

            } else {

                int n = JOptionPane.showConfirmDialog(null,
                        "Dieses Team hat noch Member, soll das gesamte Team inkl. der Member gelöscht werden?",
                        "Member in diesem Team!", JOptionPane.YES_NO_OPTION);

                if (n == 0) {

                    view.getController().deleteMember(bearbeiten.getSelectedItem().toString());
                    view.getController().deleteTeam(bearbeiten.getSelectedItem().toString());

                    bearbeiten.setSelectedIndex(0);
                    anlegen.setEnabled(true);
                    name.setEnabled(true);
                    neuerName.setVisible(false);
                    nameLabel.setVisible(false);
                    aenderungSpeichern.setVisible(false);
                    loeschen.setVisible(false);
                    neuesTeam.setEnabled(true);
                    schliessen.setEnabled(true);
                    abbrechen.setVisible(false);
                    teamGeloescht.setVisible(true);

                    letztesTeam.setVisible(false);

                    int delay = 1500;

                    ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            teamGeloescht.setVisible(false);
                        }
                    };
                    new javax.swing.Timer(delay, taskPerformer).start();
                } else {
                    System.out.println("Nichts passiert!");
                    return;
                }

            }
        }

        if (e.getSource() == abbrechen)

        {
            bearbeiten.setSelectedIndex(0);
            anlegen.setEnabled(true);
            name.setEnabled(true);
            neuerName.setVisible(false);
            nameLabel.setVisible(false);
            aenderungSpeichern.setVisible(false);
            loeschen.setVisible(false);
            neuesTeam.setEnabled(true);
            schliessen.setEnabled(true);
            abbrechen.setVisible(false);
            neuerName.setText("");
            letztesTeam.setVisible(false);

        }
        if (e.getSource() == aenderungSpeichern) {

            view.getController().teamnameAendern(bearbeiten.getSelectedItem().toString(), neuerName.getText());

            bearbeiten.setSelectedIndex(0);
            anlegen.setEnabled(true);
            name.setEnabled(true);
            neuerName.setVisible(false);
            nameLabel.setVisible(false);
            aenderungSpeichern.setVisible(false);
            loeschen.setVisible(false);
            neuesTeam.setEnabled(true);
            schliessen.setEnabled(true);
            abbrechen.setVisible(false);
            neuerName.setText("");
            teamnameGeaendert.setVisible(true);
            int delay = 1500;
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    teamnameGeaendert.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        /*
         * if (name.getText().length() > 0) { anlegen.setEnabled(true); } else {
         * anlegen.setEnabled(false); }
         */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            anlegen.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

        if (name.getText().length() > 0)

        {
            anlegen.setEnabled(true);
        } else {
            anlegen.setEnabled(false);
        }

        if (neuerName.getText().length() > 0) {
            aenderungSpeichern.setEnabled(true);
        } else {
            aenderungSpeichern.setEnabled(false);
        }
    }

    public void modifyTeam(String teamName, String neuerName) {
        for (int i = 0; i < bearbeiten.getItemCount(); i++) {
            if (bearbeiten.getItemAt(i).equals(teamName)) {
                bearbeiten.removeItemAt(i);
                bearbeiten.insertItemAt(neuerName, i);
            }
        }
    }

    public void deleteTeam(String teamname) {
        for (int i = 0; i < bearbeiten.getItemCount(); i++) {
            if (bearbeiten.getItemAt(i).equals(teamname)) {
                bearbeiten.removeItemAt(i);
            }
        }
    }
}
