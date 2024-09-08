package com.FinalExam.models;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ATeamID")
    private int aTeamID;

    @Column(name = "BTeamID")
    private int bTeamID;

    @Column(name = "Date")
    private String date;

    @Column(name = "Score")
    private String score;

    public Match() {
    }

    public Match(int id, int aTeamID, int bTeamID, String date, String score) {
        this.id = id;
        this.aTeamID = aTeamID;
        this.bTeamID = bTeamID;
        this.date = date;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getaTeamID() {
        return aTeamID;
    }

    public void setaTeamID(int aTeamID) {
        this.aTeamID = aTeamID;
    }

    public int getbTeamID() {
        return bTeamID;
    }

    public void setbTeamID(int bTeamID) {
        this.bTeamID = bTeamID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
