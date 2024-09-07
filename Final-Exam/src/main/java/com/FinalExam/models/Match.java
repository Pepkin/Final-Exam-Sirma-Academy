package com.FinalExam.models;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ATeamID")
    private Long aTeamID;

    @Column(name = "BTeamID")
    private Long bTeamID;

    @Column(name = "Date")
    private String date;

    @Column(name = "Score")
    private String score;

    public Match() {
    }

    public Match(Long id, Long aTeamID, Long bTeamID, String date, String score) {
        this.id = id;
        this.aTeamID = aTeamID;
        this.bTeamID = bTeamID;
        this.date = date;
        this.score = score;
    }

    public Match(Long aTeamID, Long bTeamID, String date, String score) {
        this.aTeamID = aTeamID;
        this.bTeamID = bTeamID;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getaTeamID() {
        return aTeamID;
    }

    public void setaTeamID(Long aTeamID) {
        this.aTeamID = aTeamID;
    }

    public Long getbTeamID() {
        return bTeamID;
    }

    public void setbTeamID(Long bTeamID) {
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
