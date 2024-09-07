package com.FinalExam.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TeamNumber")
    private int teamNumber;

    @Column(name = "Position")
    private String position;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "TeamID")
    private Long teamID;

    public Player() {
    }

    public Player(Long id, int teamNumber, String position, String fullName, Long teamID) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.teamID = teamID;
    }

    public Player(int teamNumber, String position, String fullName, Long teamID) {
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.teamID = teamID;
    }

    public Long getId() {
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

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }
}
