package view;

import javax.swing.JButton;
import javax.swing.JLabel;
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

    public TeamPanel(TeamView view) {

        setLayout(null);

        neuesTeam = new JLabel("Neues Team:");
        neuesTeam.setBounds(10, 10, 80, 20);
        add(neuesTeam);

        name = new JTextField();
        name.setBounds(10, 30, 180, 20);
        add(name);
        name.addKeyListener(this);

        anlegen = new JButton("Hinzufügen");
        anlegen.setBounds(160, 170, 130, 30);
        add(anlegen);
        anlegen.addActionListener(this);

        schliessen = new JButton("Schließen");
        schliessen.setBounds(20, 170, 130, 30);
        add(schliessen);
        schliessen.addActionListener(this);

        anlegen.setEnabled(false);

        this.view = view;

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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        /*if (name.getText().length() > 0) {
            anlegen.setEnabled(true);
        } else {
            anlegen.setEnabled(false);
        }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if (name.getText().length() > 0) {
            anlegen.setEnabled(true);
        } else {
            anlegen.setEnabled(false);
        }
    }
}
