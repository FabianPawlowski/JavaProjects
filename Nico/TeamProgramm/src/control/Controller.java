package control;

import view.TeamView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Person;
import model.Team;
import view.MessageDialogs;
import view.OutputPanel;

public class Controller {

    TeamView view;
    ArrayList<Person> member;
    ArrayList<Team> teams;
    int pIdCount = 1;
    int tIdCount = 1;
    String pathname;

    public Controller() {
        view = new TeamView(this);
        member = new ArrayList<Person>();
        teams = new ArrayList<Team>();
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public void createViewtable(String teamname) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamname().equals(teamname)) {
                view.getOutputPanel().createTable(member, teams.get(i));

                break;
            }
        }
    }

    public boolean addMember(String vorname, String nachname, String alter, String teamname, boolean isteamleiter,
            String kennzeichen) {
        if (checkCompanyCar(kennzeichen)) {

            MessageDialogs.showKennzeichenError();
            return false;
        } else {

            String id = "P" + pIdCount;
            pIdCount++;

            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamname().equals(teamname)) {
                    teams.get(i).addToTeam(id);
                    if (isteamleiter) {
                        teams.get(i).setManager(id);
                    }
                    break;
                }
            }
            Person newPerson = new Person(id, vorname, nachname, alter, teamname, isteamleiter, kennzeichen);
            member.add(newPerson);
            System.out.println("Person hinzugefügt!");
            view.addUser(vorname + " " + nachname);
            view.anyChanges = true;
            return true;

        }

    }

    public boolean checkCompanyCarForChanges(String neuesKennzeichen, boolean changed) {

        if (changed) {
            for (int j = 0; j < member.size(); j++) {
                if (member.get(j).getKennzeichen().equals(neuesKennzeichen)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            int x = 0;
            for (int j = 0; j < member.size(); j++) {
                if (member.get(j).getKennzeichen().equals(neuesKennzeichen)) {
                    x++;
                }
            }
            if (x > 1) {
                return true;
                
            } else {
                return false;
            }

        }
        
        
        
    }

    public boolean checkCompanyCar(String neuesKennzeichen) {

        for (int j = 0; j < member.size(); j++) {
            if (member.get(j).getKennzeichen().equals(neuesKennzeichen) && !member.get(j).getKennzeichen().equals("")) {
                return true;
            }
        }

        return false;
    }

    public void refreshTable() {
        view.refreshTable();
    }

    public void teamnameAendern(String teamname, String neuerName) {
        for (Team team : teams) {
            if (team.getTeamname().equals(teamname)) {
                team.setTeamname(neuerName);
                view.modifyTeam(teamname, neuerName);
                System.out.println(neuerName);
                break;
            }
        }
    }

    public void deleteTeam(String teamname) {
        for (Team team : teams) {
            if (team.getTeamname().equals(teamname)) {
                teams.remove(team);
                view.deleteTeam(teamname);
                System.out.println("Team " + teamname + " gelöscht!");
                break;
            }
        }
    }

    public void loadSelectedUser(String username) {
        String vorname = username.split(" ")[0];
        String nachname = username.split(" ")[1];
        String id = "-1";
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getVorname().equals(vorname) && member.get(i).getNachname().equals(nachname)) {
                id = member.get(i).getID();
            }
        }
        if (id == "-1") {

        }
        view.loadSelectedUser(vorname);
    }

    public void searchSelectedUser(String username) {
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getName().equals(username)) {

                break;
            }
        }

    }

    public void deleteMember(String teamname) {
        int size = member.size();
        ArrayList<Integer> zuLoeschen = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (member.get(i).getTeamName().toString().equals(teamname)) {

                String s = member.get(i).getVorname() + " " + member.get(i).getNachname();
                view.deleteMemberfromCombobox(s);
                zuLoeschen.add(i);

                System.out.println(s + " aus Team " + teamname + " wurde gelöscht!");

            }
        }
        for (int i = 0; i < zuLoeschen.size(); i++) {

            member.remove(zuLoeschen.get(i));

        }
    }

    public void addTeam(String teamName) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamname().equals(teamName)) {
                MessageDialogs.showTeamError();
                return;
            }
        }
        String id = "T" + tIdCount;
        tIdCount++;

        Team newTeam = new Team(teamName, id);
        teams.add(newTeam);
        System.out.println("Team hinzugefügt!");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i).getTeamname());

        }
        view.addTeam(teamName);
        view.anyChanges = true;
    }

    public void saveFile(String file) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < member.size(); i++) {
                Person user = member.get(i);
                if (user.getKennzeichen().equals("")) {
                    myWriter.append(user.getID() + ";" + user.getVorname() + ";" + user.getNachname() + ";"
                            + user.getAlter() + ";" + user.getTeamName() + ";" + user.getTeamleiter()
                            + System.getProperty("line.separator"));
                } else {
                    myWriter.append(user.getID() + ";" + user.getVorname() + ";" + user.getNachname() + ";"
                            + user.getAlter() + ";" + user.getTeamName() + ";" + user.getTeamleiter() + ";"
                            + user.getKennzeichen() + System.getProperty("line.separator"));
                }
            }
            for (int i = 0; i < teams.size(); i++) {
                Team team = teams.get(i);
                String teamData = team.getID() + ";" + team.getTeamname();
                if (team.getManagerID() != null) {
                    teamData += ";" + team.getManagerID();
                }
                if (team.getTeamMembers().size() > 0) {
                    teamData += ";";
                    for (int j = 0; j < team.getTeamMembers().size(); j++) {
                        if (j != team.getTeamMembers().size() - 1) {
                            teamData += team.getTeamMembers().get(j) + ",";
                        } else {
                            teamData += team.getTeamMembers().get(j);
                        }
                    }
                }
                myWriter.append(teamData + System.getProperty("line.separator"));
            }
            myWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadFile(String file) {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            member.clear();
            teams.clear();

            view.clearComboboxen();
            pIdCount = 1;
            tIdCount = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                String[] elements = data.split(";");
                if (elements[0].startsWith("P")) {
                    String id = elements[0];
                    String vorname = elements[1];
                    String nachname = elements[2];
                    String alter = elements[3];
                    String team = elements[4];
                    boolean isTeamleiter = Boolean.parseBoolean(elements[5]);
                    String kennzeichen = "";
                    if (elements.length == 7) {
                        kennzeichen = elements[6];
                    }
                    Person person = new Person(id, vorname, nachname, alter, team, isTeamleiter, kennzeichen);
                    member.add(person);
                    pIdCount++;
                    String anzeigename = vorname + " " + nachname;
                    view.addUser(anzeigename);

                } else if (elements[0].startsWith("T")) {
                    String id = elements[0];
                    String teamname = elements[1];
                    Team team = new Team(teamname, id);

                    if (elements.length == 4) {
                        team.setManager(elements[2]);
                        String[] member = elements[3].split(",");
                        for (int i = 0; i < member.length; i++) {
                            team.addToTeam(member[i]);
                        }
                    } else if (elements.length == 3) {
                        String[] member = elements[2].split(",");
                        for (int i = 0; i < member.length; i++) {
                            team.addToTeam(member[i]);
                        }
                    }
                    teams.add(team);
                    view.addTeam(teamname); // Hier wird zu den ComboBoxen hinzugefügt
                    view.refreshTable();
                    // Tabelle updaten
                    tIdCount++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setTeamleiter(Person person, Team team, boolean isTeamleiter) {

    }

    public boolean checkTeams() {
        if (teams.size() < 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSelectedTeam(String teamname) {
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getTeamName().equals(teamname)) {

                return true;

            }

        }
        return false;
    }

    public void loadUserToChange(String string) {
        String vorname = string.split(" ")[0];
        String nachname = string.split(" ")[1];

        for (int i = 0; i < member.size(); i++) {

            if (member.get(i).getVorname().equals(vorname) && member.get(i).getNachname().equals(nachname)) {
                view.loadUserToChange(member.get(i).getVorname().toString(), member.get(i).getNachname().toString(),
                        member.get(i).getAlter().toString(), member.get(i).getTeamName().toString(),
                        member.get(i).getTeamleiter(), member.get(i).getKennzeichen().toString());
                break;

            }
        }
    }

    public void safeChangedUser(String anzeigename, String vorname, String nachname, String alter, String teamName,
            boolean isTeamleiter, String kennzeichen) {
        String vor = anzeigename.split(" ")[0];
        String nach = anzeigename.split(" ")[1];

        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getVorname().toString().equals(vor)
                    && member.get(i).getNachname().toString().equals(nach)) {

                for (int j = 0; j < teams.size(); j++) {
                    if (teams.get(j).getTeamname().equals(member.get(i).getTeamName())) {
                        teams.get(j).deleteMember(member.get(i).getID().toString()); // TODO Member übergeben
                    }
                }
                member.get(i).setVorname(vorname);
                member.get(i).setNachname(nachname);
                member.get(i).setAlter(alter);
                member.get(i).setTeamName(teamName);
                member.get(i).setTeamleiter(isTeamleiter);
                member.get(i).setKennzeichen(kennzeichen);
                for (int j = 0; j < teams.size(); j++) {
                    if (teams.get(j).getTeamname().equals(teamName)) {
                        teams.get(j).addToTeam(member.get(i).getID().toString()); // TODO Member ID hinzufügen
                    }
                }
                view.safeChangedUser(anzeigename, vorname, nachname);
                view.refreshTable();
                break;
            }
        }

    }

    public void deletePerson(String anzeigeName) {
        String vor = anzeigeName.split(" ")[0];
        String nach = anzeigeName.split(" ")[1];
        view.deleteMemberfromCombobox(anzeigeName);
        System.out.println("Person " + anzeigeName + " wurde gelöscht!");

        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getVorname().toString().equals(vor)
                    && member.get(i).getNachname().toString().equals(nach)) {

                for (int j = 0; j < teams.size(); j++) {
                    if (member.get(i).getTeamName().equals(teams.get(j).getTeamname())) {
                        teams.get(j).deleteMember(member.get(i).getID());
                    }
                }

                member.remove(i);
                break;
            }

        }
        view.refreshTable();
    }
}
