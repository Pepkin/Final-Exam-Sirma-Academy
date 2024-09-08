package com.FinalExam.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TeamNumber")
    private int teamNumber;

    @Column(name = "Position")
    private String position;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "TeamID")
    private Integer teamID;

    public Player() {
    }

    public Player(Integer id, int teamNumber, String position, String fullName, Integer teamID) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.teamID = teamID;
    }

    public Integer getId() {
        return id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }
}
