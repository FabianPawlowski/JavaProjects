package view;

import javax.swing.JOptionPane;



public class MessageDialogs {
    public static void showTeamError() {
        JOptionPane.showMessageDialog(null, "Teamname ist bereits vorhanden!", "Teamname vergeben!", JOptionPane.ERROR_MESSAGE);
    }
}
