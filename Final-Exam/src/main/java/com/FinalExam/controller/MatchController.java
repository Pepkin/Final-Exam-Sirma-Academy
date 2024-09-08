package com.FinalExam.controller;

import com.FinalExam.models.Match;
import com.FinalExam.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public Match getAllMatches(@PathVariable int id){
        return service.getMatchById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addMatch")
    public Match addMatch(@RequestBody Match match){
        return service.saveMatch(match);
    }

    @PutMapping("/{id}")
    public Match update(@RequestBody Match match, @PathVariable int id){
        return service.update(match, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
