package com.FinalExam.service;

import com.FinalExam.models.Player;
import com.FinalExam.readers.PlayersReader;
import com.FinalExam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private PlayersReader playersReader;

    public void savePlayer(Player player){
        List<Player> players = playersReader.read();

        for (Player entity : players) {
            if (!repository.existsById(entity.getId())) {
                repository.save(entity);
            }
        }

        if(!repository.existsById(player.getId())){
           repository.save(player);
        }

    }

    public List<Player> getAllPlayers(){
        return repository.findAll();
    }
}
