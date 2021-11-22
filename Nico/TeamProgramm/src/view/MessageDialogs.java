package view;

import javax.swing.JOptionPane;

public class MessageDialogs {
    public static void showTeamError() {
        JOptionPane.showMessageDialog(null, "Teamname ist bereits vorhanden!", "Teamname vergeben!",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showKennzeichenError() {
        JOptionPane.showMessageDialog(null, "Das eigegebene Kennzeichen existiert bereits!", "Kennzeichen vergeben!",
                JOptionPane.ERROR_MESSAGE);
    }
    public static void showMemberinTeamError() {
        JOptionPane.showMessageDialog(null, "Es befinden sich noch Member in diesem Team!", "Team löschen?",
                JOptionPane.ERROR_MESSAGE);
    }
}