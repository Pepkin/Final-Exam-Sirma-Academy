package com.FinalExam.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String teamName;

    @Column(name = "ManagerFullName")
    private String managerName;

    @Column(name = "Group")
    private char group;

    public Team() {
    }

    public Team(String teamName, String managerName, char group) {
        this.teamName = teamName;
        this.managerName = managerName;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }
}
