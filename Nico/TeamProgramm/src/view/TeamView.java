package view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
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

    public boolean askForOverwriting = false;
    public boolean anyChanges = false;

    Controller controller;

    public TeamView(Controller controller) {
        frame = new JFrame("TeamProgramm - MasterVersion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(700, 80, 10, 20);
        tabbedPane = new TabbedPane(this);
        frame.setPreferredSize(new Dimension(325, 360));
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

    public void modifyTeam(String teamName, String neuerName) {
        tabbedPane.modifyTeam(teamName, neuerName);
    }

    public void addUser(String username) {
        tabbedPane.addUser(username);
    }

    public void refreshTable() {
        tabbedPane.refreshTable();
    }

    public void clearComboboxen() {
        tabbedPane.clearComboboxen();
    }

    public void loadSelectedUser(String username) {
        tabbedPane.loadSelectedUser(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemSave) {
            if (askForOverwriting == false) {

                createSaveDialog();
                askForOverwriting = true;

            } else {
                int z = JOptionPane.showConfirmDialog(null, "Möchten Sie die Datei mit demselben Namen überschreiben?",
                        "Datei überschreiben", JOptionPane.YES_NO_OPTION);

                if (z == 0) {
                    // namen übershreiben
                    controller.saveFile(controller.getPathname());

                }
                if (z == 1) {
                    // namen noch einmal bearbeiten vor dem speichern
                    createSaveDialog();
                }

            }
        }
        if (e.getSource() == menuItemLoad)

        {

            if (anyChanges == false) {

                createLoadDialog();

            } else {
                int y = JOptionPane.showConfirmDialog(null, "Möchten Sie aktuelle Eingaben vorerst speichern??",
                        "Daten speichern?", JOptionPane.YES_NO_OPTION);

                if (y == 0) {
                    // Änderungen speichern
                    menuItemSave.doClick();
                    createLoadDialog();
                }
                if (y == 1) {
                    // Änderungen nicht speichern
                    createLoadDialog();
                }
                anyChanges = false;
            }
        }
    }

    private void createLoadDialog() {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Datei", "csv");
        chooser.setAcceptAllFileFilterUsed(false);

        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
            controller.loadFile(chooser.getSelectedFile().getPath());
            controller.setPathname(chooser.getSelectedFile().getPath());
        }
    }

    private void createSaveDialog() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Datei", "csv");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(filter);

        int returnVal = chooser.showSaveDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
            String pathname;
            if (chooser.getSelectedFile().getName().endsWith(".csv")) {

                pathname = chooser.getSelectedFile().getPath();
            } else {
                pathname = chooser.getSelectedFile().getPath() + ".csv";
            }
            File file = new File(pathname);
            if (file.exists()) {
                // Error Message "Möchtest du überschreiben?"
                // Danach Dialog neu öffnen
                System.out.println("Existiert schon 2");
                menuItemSave.doClick();
            } else {
                controller.saveFile(pathname);
                controller.setPathname(pathname);
            }

        }
    }

    public void deleteTeam(String teamname) {
        tabbedPane.deleteTeam(teamname);
    }

    public void deleteMemberfromCombobox(String anzeigename) {
        tabbedPane.deleteMemberFromCombobox(anzeigename);
    }

    public void loadUserToChange(String vorname, String nachname, String alter, String teamname, boolean teamleiter,
            String kennzeichen) {
        tabbedPane.loadUserToChange(vorname, nachname, alter, teamname, teamleiter, kennzeichen);
    }

    public void safeChangedUser(String anzeigename, String vorname, String nachname) {
        tabbedPane.safeChangedUser(anzeigename, vorname, nachname);
    }
}
