package com.FinalExam.service;

import com.FinalExam.models.Team;
import com.FinalExam.readers.TeamsReader;
import com.FinalExam.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamsRepository repository;

    @Autowired
    private TeamsReader reader;

    @Bean
    public void saveTeam(Team team){
        List<Team> teams = reader.read();

        for (Team entity : teams){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }

        if(!repository.existsById(team.getId())){
            repository.save(team);
        }
    }

    public List<Team> getAllTeams(){
        return repository.findAll();
    }
}
