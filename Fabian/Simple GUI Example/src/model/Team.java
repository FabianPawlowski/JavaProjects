package model;

import java.util.ArrayList;

public class Team {
    String teamName;
    Teamleiter teamleiter;
    ArrayList<Person> mitglieder;

    public Team(String name) {
        this.teamName = name;
        mitglieder = new ArrayList<Person>();
    }

    public String getTeamName() {
        return teamName;
    }

    public Teamleiter getTeamleiter() {
        return teamleiter;
    }

    public ArrayList<Person> getMitglieder() {
        return mitglieder;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public void setTeamName(Teamleiter leiter) {
        this.teamleiter = leiter;
    }

    public void addMitglied(Person mitglied) {
        mitglieder.add(mitglied);
    }

    public void deleteMitglied(Person mitglied) {
        mitglieder.remove(mitglied);
    }
}
