package view;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.Controller;


public class MainViewButtons implements ActionListener, MainViewInterface{

    boolean spieler = true;
    JFrame frame;
    JButton refresh;
    JButton oben1;
    JButton oben2;
    JButton oben3;
    JButton mitte1;
    JButton mitte2;
    JButton mitte3;
    JButton unten1;
    JButton unten2;
    JButton unten3;
    JLabel gewinner;


    Controller controller;
    

    public MainViewButtons(Controller controller) {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvent) {
                System.exit(1);
            }
        });

        oben1 = new JButton();
        oben1.setBounds(10, 10, 50, 50);
        oben2 = new JButton();
        oben2.setBounds(70, 10, 50, 50);
        oben3 = new JButton();
        oben3.setBounds(130, 10, 50, 50);
        mitte1 = new JButton();
        mitte1.setBounds(10, 70, 50, 50);
        mitte2 = new JButton();
        mitte2.setBounds(70, 70, 50, 50);
        mitte3 = new JButton();
        mitte3.setBounds(130, 70, 50, 50);
        unten1 = new JButton();
        unten1.setBounds(10, 130, 50, 50);
        unten2 = new JButton();
        unten2.setBounds(70, 130, 50, 50);
        unten3 = new JButton();
        unten3.setBounds(130, 130, 50, 50);
        
        refresh = new JButton("Reset");
        refresh.setBounds(10, 190, 90, 40);
        oben1.addActionListener(this);
        oben2.addActionListener(this);
        oben3.addActionListener(this);
        mitte1.addActionListener(this);
        mitte2.addActionListener(this);
        mitte3.addActionListener(this);
        unten1.addActionListener(this);
        unten2.addActionListener(this);
        unten3.addActionListener(this);
        refresh.addActionListener(this);
        gewinner = new JLabel();
        gewinner.setBounds(110, 190, 90, 40);

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
        frame.add(refresh);
        frame.add(gewinner);
        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        this.controller = controller;

    }




    @Override
    public void refresh() {
        // TODO Auto-generated method stub
        oben1.setText("");
        oben2.setText("");
        oben3.setText("");
        mitte1.setText("");
        mitte2.setText("");
        mitte3.setText("");
        unten1.setText("");
        unten2.setText("");
        unten3.setText("");

        oben1.setEnabled(true);
        oben2.setEnabled(true);
        oben3.setEnabled(true);
        mitte1.setEnabled(true);
        mitte2.setEnabled(true);
        mitte3.setEnabled(true);
        unten1.setEnabled(true);
        unten2.setEnabled(true);
        unten3.setEnabled(true);

        gewinner.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == oben1) {
            if (spieler) {
                controller.addInputs(0, 0, "X");
                oben1.setText("X");
                spieler = !spieler;
                oben1.setEnabled(false);
            } else {
                controller.addInputs(0, 0, "O");
                spieler = !spieler;
                oben1.setText("O");
                oben1.setEnabled(false);
            }
        }
        if (e.getSource() == oben2) {
            if (spieler) {
                controller.addInputs(0, 1, "X");
                oben2.setText("X");
                spieler = !spieler;
                oben2.setEnabled(false);
            } else {
                controller.addInputs(0, 1, "O");
                spieler = !spieler;
                oben2.setText("O");
                oben2.setEnabled(false);
            }
        }
        if (e.getSource() == oben3) {
            if (spieler) {
                controller.addInputs(0, 2, "X");
                oben3.setText("X");
                spieler = !spieler;
                oben3.setEnabled(false);
            } else {
                controller.addInputs(0, 2, "O");
                spieler = !spieler;
                oben3.setText("O");
                oben3.setEnabled(false);
            }
        }
        if (e.getSource() == mitte1) {
            if (spieler) {
                controller.addInputs(1, 0, "X");
                mitte1.setText("X");
                spieler = !spieler;
                mitte1.setEnabled(false);
            } else {
                controller.addInputs(1, 0, "O");
                spieler = !spieler;
                mitte1.setText("O");
                mitte1.setEnabled(false);
            }
        }
        if (e.getSource() == mitte2) {
            if (spieler) {
                controller.addInputs(1, 1, "X");
                mitte2.setText("X");
                spieler = !spieler;
                mitte2.setEnabled(false);
            } else {
                controller.addInputs(1, 1, "O");
                spieler = !spieler;
                mitte2.setText("O");
                mitte2.setEnabled(false);
            }
        }
        if (e.getSource() == mitte3) {
            if (spieler) {
                controller.addInputs(1, 2, "X");
                mitte3.setText("X");
                spieler = !spieler;
                mitte3.setEnabled(false);
            } else {
                controller.addInputs(1, 2, "O");
                spieler = !spieler;
                mitte3.setText("O");
                mitte3.setEnabled(false);
            }
        }
        if (e.getSource() == unten1) {
            if (spieler) {
                controller.addInputs(2, 0, "X");
                unten1.setText("X");
                spieler = !spieler;
                unten1.setEnabled(false);
            } else {
                controller.addInputs(2, 0, "O");
                spieler = !spieler;
                unten1.setText("O");
                unten1.setEnabled(false);
            }
        }
        if (e.getSource() == unten2) {
            if (spieler) {
                controller.addInputs(2, 1, "X");
                unten2.setText("X");
                spieler = !spieler;
                unten2.setEnabled(false);
            } else {
                controller.addInputs(2, 1, "O");
                spieler = !spieler;
                unten2.setText("O");
                unten2.setEnabled(false);
            }
        }if (e.getSource() == unten3) {
            if (spieler) {
                controller.addInputs(2, 2, "X");
                unten3.setText("X");
                spieler = !spieler;
                unten3.setEnabled(false);
            } else {
                controller.addInputs(2 ,2, "O");
                spieler = !spieler;
                unten3.setText("O");
                unten3.setEnabled(false);
            }
        }
        if (e.getSource() == refresh) {
           controller.refresh();
        }
        
    }




    @Override
    public void setWinner() {
       // TODO Auto-generated method stub
        oben1.setEnabled(false);
        oben2.setEnabled(false);
        oben3.setEnabled(false);
        mitte1.setEnabled(false);
        mitte2.setEnabled(false);
        mitte3.setEnabled(false);
        unten1.setEnabled(false);
        unten2.setEnabled(false);
        unten3.setEnabled(false);

        if (spieler) {
            gewinner.setText("X hat gewonnen!");
        } else {
            gewinner.setText("O hat gewonnen!");
        }
    }
    
}
