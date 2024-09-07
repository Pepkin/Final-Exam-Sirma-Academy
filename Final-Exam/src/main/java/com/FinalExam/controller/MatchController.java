package com.FinalExam.controller;

import com.FinalExam.models.Match;
import com.FinalExam.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping
    public List<Match> getAllMatches(){
        return service.getAllMatches();
    }

    @PostMapping("/addMatch")
    public void addMatch(@RequestBody Match match){
        service.saveMatch(match);
    }

    //@PutMapping
    //@DeleteMapping
}
