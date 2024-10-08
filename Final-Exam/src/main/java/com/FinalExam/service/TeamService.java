package com.FinalExam.service;

import com.FinalExam.models.Player;
import com.FinalExam.models.Team;
import com.FinalExam.readers.TeamsReader;
import com.FinalExam.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ApplicationRunner {

    @Autowired
    private TeamsRepository repository;

    @Autowired
    private TeamsReader TeamsReader;

    public void saveTeam(Team team){
        if(!repository.existsById(team.getId())){
            repository.save(team);
        }
    }

    public Team getTeamById(int id){
        return repository.getTeamById(id);
    }

    public List<Team> getAllTeams(){
        return repository.findAll();
    }

    public Team update(Team team, int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return repository.save(team);
        }else{
            return null;
        }

    }

    public void delete(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Team> teams = TeamsReader.read();

        for (Team entity : teams){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }
    }
}
