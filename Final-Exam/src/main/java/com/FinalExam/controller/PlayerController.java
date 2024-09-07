package com.FinalExam.controller;

import com.FinalExam.models.Player;
import com.FinalExam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }

    @PostMapping("/addPlayer")
    public void addPlayer(@RequestBody Player player){
        service.savePlayer(player);
    }

}
