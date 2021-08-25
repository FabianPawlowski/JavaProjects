package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import control.Controller;

import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainView implements ActionListener, MainViewInterface {

    JFrame frame;
    JButton enter;
    JButton refresh;
    JTextField oben1;
    JTextField oben2;
    JTextField oben3;
    JTextField mitte1;
    JTextField mitte2;
    JTextField mitte3;
    JTextField unten1;
    JTextField unten2;
    JTextField unten3;
    JLabel label;
    JLabel beschreibung;
    JLabel beschreibung2;

    Controller controller;

    public MainView(Controller controller) {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvent) {
                System.exit(1);
            }
        });

        oben1 = new JTextField();
        oben1.setBounds(190, 10, 30, 30);
        oben1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && oben1.getText().length() == 0) {
                    controller.addInputs(0, 0, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        oben2 = new JTextField();
        oben2.setBounds(230, 10, 30, 30);
        oben2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && oben2.getText().length() == 0) {
                    controller.addInputs(0, 1, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        oben3 = new JTextField();
        oben3.setBounds(270, 10, 30, 30);
        oben3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && oben3.getText().length() == 0) {
                    controller.addInputs(0, 2, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        mitte1 = new JTextField();
        mitte1.setBounds(190, 50, 30, 30);
        mitte1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && mitte1.getText().length() == 0) {
                    controller.addInputs(1, 0, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        mitte2 = new JTextField();
        mitte2.setBounds(230, 50, 30, 30);
        mitte2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && mitte2.getText().length() == 0) {
                    controller.addInputs(1, 1, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        mitte3 = new JTextField();
        mitte3.setBounds(270, 50, 30, 30);
        mitte3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && mitte3.getText().length() == 0) {
                    controller.addInputs(1, 2, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });

        unten1 = new JTextField();
        unten1.setBounds(190, 90, 30, 30);
        unten1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && unten1.getText().length() == 0) {
                    controller.addInputs(2, 0, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        unten2 = new JTextField();
        unten2.setBounds(230, 90, 30, 30);
        unten2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && unten2.getText().length() == 0) {
                    controller.addInputs(2, 1, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });
        unten3 = new JTextField();
        unten3.setBounds(270, 90, 30, 30);
        unten3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyChar() == 'X' || e.getKeyChar() == 'O') && unten3.getText().length() == 0) {
                    controller.addInputs(2, 2, Character.toString(e.getKeyChar()));
                } else {
                    e.consume();
                }
            }
        });

        enter = new JButton("Enter");
        enter.setBounds(195, 130, 100, 30);
        refresh = new JButton("Refresh");
        refresh.setBounds(200, 170, 90, 20);

        label = new JLabel("Anleitung:");
        label.setBounds(5, 5, 70, 40);

        beschreibung = new JLabel("Fabian muss den Fehler finden, ");
        beschreibung.setBounds(5, 15, 180, 95);

        beschreibung2 = new JLabel("damit das Spiel funktioniert!");
        beschreibung2.setBounds(5, 40, 170, 80);

        enter.addActionListener(this);
        refresh.addActionListener(this);

        frame.setTitle("TicTacToe by Nico");
        frame.add(oben1);
        frame.add(oben2);
        frame.add(oben3);
        frame.add(mitte1);
        frame.add(mitte2);
        frame.add(mitte3);
        frame.add(unten1);
        frame.add(unten2);
        frame.add(unten3);
        frame.add(enter);
        frame.add(refresh);
        frame.add(label);
        frame.add(beschreibung);
        frame.add(beschreibung2);
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.enter) {
            controller.addInputs(oben1.getText(), oben2.getText(), oben3.getText(), mitte1.getText(), mitte2.getText(),
                    mitte3.getText(), unten1.getText(), unten2.getText(), unten3.getText());
        }
        if (e.getSource() == this.refresh) {
            controller.refresh();
        }
    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub //
        oben1.setText("");
        oben2.setText("");
        oben3.setText("");
        mitte1.setText("");
        mitte2.setText("");
        mitte3.setText("");
        unten1.setText("");
        unten2.setText("");
        unten3.setText("");
    }

    @Override
    public void setWinner(String gewinner) {
        // TODO Auto-generated method stub
        
    }
}
