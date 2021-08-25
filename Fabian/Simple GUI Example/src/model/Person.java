package model;

public class Person {
    String vorname, nachname, teamName;
    int alter;

    public Person(String vorname, String nachname, String teamName, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.teamName = teamName;
        this.alter = alter;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getAlter() {
        return alter;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
