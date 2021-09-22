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

public class Controller {

    TeamView view;
    ArrayList<Person> member;
    ArrayList<Team> teams;
    int pIdCount = 1;
    int tIdCount = 1;

    public Controller() {
        view = new TeamView(this);
        member = new ArrayList<Person>();
        teams = new ArrayList<Team>();
    }

    public void createViewtable(String teamname) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamname().equals(teamname)) {
               view.getOutputPanel().createTable(member, teams.get(i));
                
                break;
            }
        }
    }

    public void addMember(String vorname, String nachname, int alter, String teamname, boolean isteamleiter,
            String kennzeichen) {
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
                    int alter = Integer.parseInt(elements[3]);
                    String team = elements[4];
                    boolean isTeamleiter = Boolean.parseBoolean(elements[5]);
                    String kennzeichen = "";
                    if (elements.length == 7) {
                        kennzeichen = elements[6];
                    }
                    Person person = new Person(id, vorname, nachname, alter, team, isTeamleiter, kennzeichen);
                    member.add(person);
                    pIdCount++;

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
                    view.addTeam(teamname);
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
}
