package view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import control.Controller;
import model.Person;
import model.Team;

public class TeamView implements ActionListener {

    JFrame frame;
    TabbedPane tabbedPane;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem menuItemSave;
    JMenuItem menuItemLoad;

    Controller controller;

    public TeamView(Controller controller) {
        frame = new JFrame("TeamProgramm - Version 1.0.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(700, 80, 10, 20);
        tabbedPane = new TabbedPane(this);
        frame.setPreferredSize(new Dimension(325, 300));
        frame.add(tabbedPane, BorderLayout.CENTER);
        this.controller = controller;

        menuBar = new JMenuBar();
        menuFile = new JMenu("Datei");
        menuBar.add(menuFile);
        menuItemSave = new JMenuItem("Speichern");
        menuFile.add(menuItemSave);
        menuItemSave.addActionListener(this);
        menuItemLoad = new JMenuItem("Öffnen");
        menuItemLoad.addActionListener(this);
        menuFile.add(menuItemLoad);
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setVisible(true);
    }

    public OutputPanel getOutputPanel() {
        return tabbedPane.getOutputPanel();
    }

    public Controller getController() {
        return controller;
    }

    public void addTeam(String teamname) {
        tabbedPane.addTeam(teamname);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemSave) {
            /*
             * FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.SAVE); //
             * fd.setDirectory("C:\\"); // fd.setFile("*.xml"); fd.setFilenameFilter( (dir,
             * name) -> name.endsWith(".csv")); fd.setVisible(true); String filename =
             * fd.getFile(); if (filename == null)
             * System.out.println("You cancelled the choice"); else
             * System.out.println("You chose " + filename);
             */
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Datei", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
                controller.saveFile(chooser.getSelectedFile().getPath());
            }
        }
        if (e.getSource() == menuItemLoad) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Datei", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
                controller.loadFile(chooser.getSelectedFile().getPath());
            }

        }
    }
}
