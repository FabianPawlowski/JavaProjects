package model;

public class Person {
    private String vorname, nachname, adresse;
    private int alter;

    public Person(String vorname, String nachname, String adresse, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.alter = alter;
    }

    public String getAdresse() {
        return adresse;
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
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
}
