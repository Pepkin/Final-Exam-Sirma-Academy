package com.FinalExam.repository;

import com.FinalExam.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player getPlayerById(Long id);
    List<Player> getPlayersByTeamNumber();
}
