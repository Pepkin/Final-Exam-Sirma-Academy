package com.FinalExam.repository;

import com.FinalExam.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Team, Long> {
    Team getTeamById(int id);
}
