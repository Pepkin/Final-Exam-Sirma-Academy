package com.FinalExam.service;

import com.FinalExam.models.Player;
import com.FinalExam.readers.PlayersReader;
import com.FinalExam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements ApplicationRunner {

    @Autowired
    private  PlayerRepository repository;

    @Autowired
    private PlayersReader playersReader;

    public void savePlayer(Player player){
        if(!repository.existsById(player.getId())){
           repository.save(player);
        }
    }

    public List<Player> getAllPlayers(){
        return repository.findAll();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Player> players = playersReader.read();

        for (Player entity : players) {
            if (!repository.existsById(entity.getId())) {
                repository.save(entity);
            }
        }
    }
}
