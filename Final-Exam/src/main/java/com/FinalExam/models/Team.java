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

    @Column(name = "TeamGroup")
    private String teamGroup;

    public Team() {
    }

    public Team(Long id, String teamName, String managerName, String group) {
        this.id = id;
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = group;
    }

    public Team(String teamName, String managerName, String group) {
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = group;
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

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }
}
