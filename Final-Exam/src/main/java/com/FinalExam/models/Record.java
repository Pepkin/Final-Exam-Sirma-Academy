package com.FinalExam.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PlayerID")
    private Integer playerId;

    @Column(name = "MatchID")
    private Integer MatchId;

    @Column(name = "formMinutes")
    private int fromMinutes;

    @Column(name = "toMinutes")
    private int toMinutes;

    public Record() {
    }

    public Record(Integer id, Integer playerId, Integer matchId, int fromMinutes, int toMinutes) {
        this.id = id;
        this.playerId = playerId;
        MatchId = matchId;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Integer getMatchId() {
        return MatchId;
    }

    public void setMatchId(Integer matchId) {
        MatchId = matchId;
    }

    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public int getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(int toMinutes) {
        this.toMinutes = toMinutes;
    }
}
