package com.FinalExam.service;

import com.FinalExam.models.Match;
import com.FinalExam.readers.MatchesReader;
import com.FinalExam.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchesRepository repository;

    @Autowired
    private MatchesReader reader = new MatchesReader();

    public Match saveMatch(Match match){
        List<Match> matches = reader.read();

        for (Match entity : matches){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }

        if(!repository.existsById(match.getId())){
            repository.save(match);
        }

        return match;
    }

    public List<Match> getAllMatches(){
        return repository.findAll();
    }
}
