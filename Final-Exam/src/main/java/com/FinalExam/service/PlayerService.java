package com.FinalExam.service;

import com.FinalExam.models.Player;
import com.FinalExam.readers.PlayersReader;
import com.FinalExam.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements ApplicationRunner {

    @Autowired
    private  PlayerRepository repository;

    @Autowired
    private PlayersReader playersReader;

    public void savePlayer(Player player){
           repository.save(player);
    }

    public List<Player> getAllPlayers(){
        return repository.findAll();
    }

    public Player getById(int id){
        return repository.getPlayerById(id);
    }

    public Player update(Player player, int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return player;
        }else{
            return null;
        }
    }

    public ResponseEntity.HeadersBuilder<?> delete(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            return ResponseEntity.notFound();
        }
        return null;
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
