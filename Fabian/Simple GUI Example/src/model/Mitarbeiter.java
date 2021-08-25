package model;

public class Mitarbeiter extends Person {
    String vorgesetzter;

    public Mitarbeiter(String vorname, String nachname, String teamName, int alter) {
        super(vorname, nachname, teamName, alter);
    }
    
    public String getVorgesetzter() {
        return vorgesetzter;
    }

    public void setVorgesetzter(String vorgesetzter) {
        this.vorgesetzter = vorgesetzter;
    }
}
