package model;

import java.util.ArrayList;

public class Team {

    String teamName;
    ArrayList<String> member;
    String managerID;
    String id;

    public Team(String teamName, String id) {
        this.teamName = teamName;
        this.id = id;
        member = new ArrayList<String>();
    }

    public String getTeamname() {
        return teamName;
    }

    public String getID() {
        return id;
    }

    public void setManager(String managerID) {
        this.managerID = managerID;
    }

    public String getManagerID() {
        return managerID;
    }

    public void addToTeam(String id) {
        member.add(id);
    }
    // Team aufrufen

    public void setID(String id) {
        this.id = id;
    }

    public ArrayList<String> getTeamMembers() {
        return member;
    }

    public void setTeamname(String neuerName) {
        this.teamName = neuerName;
    }

    public void deleteMember(String memberId) {
        // TODO For schleife über Member und Löschen vom übergebenen Member
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).toString().equals(memberId)) {
                member.remove(i);
            }

        }
    }

    public void addMember(String memberId) {
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).toString().equals(memberId)) {
                member.add(memberId);
            }
            // es gibt schon die Methode addToTeam()
        }
    }

}