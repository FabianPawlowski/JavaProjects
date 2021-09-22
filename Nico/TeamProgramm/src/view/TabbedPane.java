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
        return (OutputPanel)outputPanel;
    }

    public void addTeam(String teamname) {
        ((UserPanel) userPanel).addTeam(teamname);
        ((OutputPanel) outputPanel).addTeam(teamname);
    }

}
