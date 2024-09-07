package com.FinalExam.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record {

    @Column(name = "ID")
    private Long id;

    @Column(name = "PlayerID")
    private Long playerId;

    @Column(name = "MatchID")
    private Long MatchId;

    @Column(name = "formMinutes")
    private int fromMinutes;

    @Column(name = "toMinutes")
    private int toMinutes;

    public Record() {
    }

    public Record(Long id, Long playerId, Long matchId, int fromMinutes, int toMinutes) {
        this.id = id;
        this.playerId = playerId;
        MatchId = matchId;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getMatchId() {
        return MatchId;
    }

    public void setMatchId(Long matchId) {
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
