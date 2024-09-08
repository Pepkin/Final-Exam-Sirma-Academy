package com.FinalExam.controller;

import com.FinalExam.models.Player;
import com.FinalExam.models.Team;
import com.FinalExam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id){
        return service.getTeamById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addTeam")
    public void addTeam(@RequestBody Team team){
        service.saveTeam(team);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Team team){
        service.update(team, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }


}
