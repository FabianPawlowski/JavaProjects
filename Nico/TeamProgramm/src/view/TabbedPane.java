package view;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class TabbedPane extends JPanel {
    JTabbedPane tabbedPane;
    JComponent userPanel;
    JComponent teamPanel;
    JComponent outputPanel;
    JFrame frame;

    TeamView view;

    public TabbedPane(TeamView view) {
        super(new GridLayout(1, 1));

        this.view = view;

        tabbedPane = new JTabbedPane();
        userPanel = new UserPanel(view);
        tabbedPane.addTab("Users", userPanel);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        teamPanel = new TeamPanel(view);
        tabbedPane.addTab("Teams", teamPanel);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        outputPanel = new OutputPanel(view);
        tabbedPane.addTab("Output", outputPanel);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    }

    public OutputPanel getOutputPanel() {
        return (OutputPanel) outputPanel;
    }

    public void addTeam(String teamname) {
        ((UserPanel) userPanel).addTeam(teamname);
        ((OutputPanel) outputPanel).addTeam(teamname);
        ((TeamPanel) teamPanel).addTeam(teamname);
    }

    public void addUser(String username) {
        ((UserPanel) userPanel).addUser(username);

    }

    public void refreshTable() {
        ((OutputPanel) outputPanel).refresh();
    }

    public void clearComboboxen() {
        ((OutputPanel) outputPanel).clearCombobox();
        ((UserPanel) userPanel).clearComboboxen();
        ((TeamPanel) teamPanel).clearCombobox();
    }

    public void loadSelectedUser(String username) {
        ((UserPanel) userPanel).loadSelectedUser(username);
    }

    public void modifyTeam(String teamName, String neuerName) {
        ((UserPanel) userPanel).modifyTeam(teamName, neuerName);
        ((TeamPanel) teamPanel).modifyTeam(teamName, neuerName);
        ((OutputPanel) outputPanel).modifyTeam(teamName, neuerName);
    }

    public void deleteTeam(String teamname) {
        ((UserPanel) userPanel).deleteTeam(teamname);
        ((TeamPanel) teamPanel).deleteTeam(teamname);
        ((OutputPanel) outputPanel).deleteTeam(teamname);
    }

    public void deleteMemberFromCombobox(String anzeigename) {
        ((UserPanel) userPanel).deleteMemberFromCombobox(anzeigename);
        ((OutputPanel) outputPanel).setTableToFirst();
    }

    public void loadUserToChange(String vorname, String nachname, String alter, String teamname, boolean teamleiter,
            String kennzeichen) {
        ((UserPanel) userPanel).loadUserToChange(vorname, nachname, alter, teamname, teamleiter, kennzeichen);
    }

    public void safeChangedUser(String anzeigename, String vorname, String nachname) {
        ((UserPanel) userPanel).safeChangedUser(anzeigename, vorname, nachname);
        ((OutputPanel) outputPanel).safeChangedUser();
    }
}
