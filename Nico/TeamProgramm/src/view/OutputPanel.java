package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;
import model.Team;

import java.awt.event.*;
import java.util.ArrayList;

public class OutputPanel extends JPanel implements ActionListener {

    TeamView view;
    JButton schliessen;
    JTable tabelle;
    ArrayList<Person> member;
    JComboBox<String> teamsField;
    JScrollPane scrollPane;

    public OutputPanel(TeamView view) {
        setLayout(null);
        JLabel filler = new JLabel("Teamübersicht:");
        filler.setBounds(10, 10, 190, 20);
        add(filler);

        teamsField = new JComboBox<String>();
        teamsField.setBounds(150, 10, 110, 20);
        // teamsField.addItem("Rot");
        // teamsField.addItem("Blau");
        // teamsField.addItem("Gelb");
        add(teamsField);
        teamsField.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 170, 130, 30);
        add(schliessen);
        schliessen.addActionListener(this);

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
        if (e.getSource() == teamsField) {
            view.getController().createViewtable(teamsField.getSelectedItem().toString());
        }
    }

    public void createTable(ArrayList<Person> members, Team team) {
        if (scrollPane != null) {
            remove(scrollPane);
        }
        String[] header = { "Vorname", "Nachname", "Alter", "Teamleiter?", " Kennzeichen" };
        Object[][] mitglieder = new Object[team.getTeamMembers().size()][5];
        for (int i = 0; i < team.getTeamMembers().size(); i++) {
            String id = team.getTeamMembers().get(i);
            for (int j = 0; j < members.size(); j++) {
                if (members.get(j).getID().equals(id)) {
                    Person person = members.get(j);
                    mitglieder[i][0] = person.getVorname();
                    mitglieder[i][1] = person.getNachname();
                    mitglieder[i][2] = person.getAlter();
                    mitglieder[i][3] = person.getTeamleiter();
                    mitglieder[i][4] = person.getKennzeichen();
                    break;
                }
            }
        }
        tabelle = new JTable(mitglieder, header);
        // tabelle.setPreferredScrollableViewportSize(new Dimension(500, 50));
        scrollPane = new JScrollPane(tabelle);
        tabelle.setFillsViewportHeight(true);
        scrollPane.setBounds(10, 40, 280, 120);
        add(scrollPane);
    }
}