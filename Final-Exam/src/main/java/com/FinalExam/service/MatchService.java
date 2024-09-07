package com.FinalExam.service;

import com.FinalExam.models.Match;
import com.FinalExam.models.Player;
import com.FinalExam.readers.MatchesReader;
import com.FinalExam.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements ApplicationRunner {

    @Autowired
    private MatchesRepository repository;

    @Autowired
    private MatchesReader matchesReader;

    public Match saveMatch(Match match){

        if(!repository.existsById(match.getId())){
            repository.save(match);
        }

        return match;
    }

    public List<Match> getAllMatches(){
        return repository.findAll();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Match> matches = matchesReader.read();

        for (Match entity : matches){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }
    }
}
