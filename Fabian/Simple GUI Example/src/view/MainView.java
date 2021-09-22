package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.Controller;

public class MainView {
    JFrame frame;
    TabbedPane tabbedPane;

    Controller controller;

    public MainView(Controller controller) {
        frame = new JFrame("Nutzerverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new TabbedPane(this);

        frame.add(tabbedPane, BorderLayout.LEFT);
        frame.pack();
        frame.setVisible(true);
    }
}
