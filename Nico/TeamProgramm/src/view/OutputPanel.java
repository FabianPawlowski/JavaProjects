package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        add(teamsField);
        teamsField.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 235, 130, 30);
        add(schliessen);
        schliessen.addActionListener(this);

        this.view = view;
    }

    public void addTeam(String teamname) {
        teamsField.addItem(teamname);
    }

    public void refresh() {
        String s = teamsField.getSelectedItem().toString();
        teamsField.setSelectedItem(s);
        view.getController().createViewtable(s);
        tabelle.revalidate();
    }

    public void clearCombobox() {
        teamsField.removeAllItems();
        System.out.println("cleared");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == schliessen) {
            System.exit(0);
        }
        if (e.getSource() == teamsField) {
            if ((teamsField.getSelectedItem() != null)) {
                view.getController().createViewtable(teamsField.getSelectedItem().toString());
                tabelle.setVisible(true);
            } else {
                tabelle.setVisible(false);
            }
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
        tabelle.setEnabled(false);

        scrollPane.setBounds(10, 40, 280, 180);
        add(scrollPane);
    }

    public void modifyTeam(String teamName, String neuerName) {
        for (int i = 0; i < teamsField.getItemCount(); i++) {
            if (teamsField.getItemAt(i).equals(teamName)) {
                teamsField.insertItemAt(neuerName, i);
                teamsField.removeItemAt(i + 1);
                teamsField.setSelectedIndex(i);
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

    public void setTableToFirst() {
        if (teamsField.getItemCount() == 0) {

            tabelle.clearSelection();
            tabelle.repaint();

        } else {
            teamsField.setSelectedIndex(0);
        }
    }

    public void safeChangedUser() {
    }

}