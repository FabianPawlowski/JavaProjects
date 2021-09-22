package model;

import javax.swing.*;
import java.awt.event.*;

public class Person extends JPanel implements ActionListener {

    String id;
    String vorname, nachname;
    int alter;
    boolean isteamleiter;
    String teamname, kennzeichen;

    public Person(String id, String vorname, String nachname, int alter, String teamname, boolean isteamleiter,
            String kennzeichen) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.isteamleiter = isteamleiter;
        this.teamname = teamname;
        this.kennzeichen = kennzeichen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub

    }

    // get Methoden

    public String getID() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getAlter() {
        return alter;
    }

    public String getTeamName() {
        return teamname;
    }

    public boolean getTeamleiter() {
        return isteamleiter;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    // set Methoden

    public void setID(String id) {
        this.id =  id;
    }


    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setTeamName(String teamName) {
        this.teamname = teamName;
    }

    public void setTeamleiter(boolean isTeamleiter) {
        this.isteamleiter = isTeamleiter;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }
}