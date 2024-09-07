package com.FinalExam.controller;

import com.FinalExam.models.Team;
import com.FinalExam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public List<Team> getAllTeams(){
        return service.getAllTeams();
    }

    @PostMapping("/addPlayer")
    public void addTeam(@RequestBody Team team){
        service.saveTeam(team);
    }

    //@PutMapping
    //@DeleteMapping


}
