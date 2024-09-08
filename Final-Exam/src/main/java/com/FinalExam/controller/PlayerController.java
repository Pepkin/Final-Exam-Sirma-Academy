package com.FinalExam.controller;

import com.FinalExam.models.Player;
import com.FinalExam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping()
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id){
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addPlayer")
    public void create(@RequestBody Player player){
        service.savePlayer(player);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable int id, @RequestBody Player player){
        return service.update(player, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
