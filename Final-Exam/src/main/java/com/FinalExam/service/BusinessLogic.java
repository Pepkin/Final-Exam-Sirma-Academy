package com.FinalExam.service;

import com.FinalExam.models.*;
import com.FinalExam.models.Record;
import com.FinalExam.repository.MatchesRepository;
import com.FinalExam.repository.PlayerRepository;
import com.FinalExam.repository.RecordsRepository;
import com.FinalExam.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.abs;

@Service
public class BusinessLogic {

    @Autowired
    private RecordsRepository recordsRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MatchesRepository matchesRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    public HashMap<String, Integer> method1(){

        List<Match> matches = matchesRepository.findAll();
        List<Record> records = recordsRepository.findAll();
        List<Player> players = playerRepository.findAll();
        List<Team> teams = teamsRepository.findAll();

        //Find how many matches played each team
        HashMap<Long, Integer> teamsAndTheirMatches = new HashMap<>();

        for (int i = 0; i < teams.size(); i++) {
            ArrayList<Long> matchesForATeam = new ArrayList<>();
            for (Match match : matches){
                if(match.getaTeamID() == teams.get(i).getId()){
                    matchesForATeam.add(match.getId());
                }
            }
            teamsAndTheirMatches.put(teams.get(i).getId(), matchesForATeam.size());
        }

        //Find which team has the most matches
        int mostMatches = 0;
        Long mostPlayedGamesTeam = 0L;
        HashMap<Long, Integer> bestTeam = new HashMap<>();
        for(Map.Entry<Long, Integer> team : teamsAndTheirMatches.entrySet()){
            if (team.getValue() > mostMatches){
                mostMatches = team.getValue();
                mostPlayedGamesTeam = team.getKey();
            }
        }
        bestTeam.put(mostPlayedGamesTeam,mostMatches);

        //find matchID where the best team played
        HashMap<Long,ArrayList<Long>> TeamPerMatchList = new HashMap<>();

        for (Map.Entry<Long, Integer> team : bestTeam.entrySet()){
            ArrayList<Long> matchList = new ArrayList<>();
            for (Match match : matches){
                if(team.getKey() == match.getaTeamID() || team.getKey() == match.getbTeamID()){
                   matchList.add(match.getId());
                }
            }
            TeamPerMatchList.put(team.getKey(), matchList);
        }

        //Find Collective time of the players in all matches individually
        HashMap<Long, Integer> playersAndTheirPlayedTime = new HashMap<>();

        for ( Map.Entry<Long, ArrayList<Long>> team: TeamPerMatchList.entrySet()){
            for (Record record : records){
                if (team.getValue().contains(record.getMatchId())){
                    int timeSpent = record.getToMinutes() - record.getFromMinutes();
                    if(!playersAndTheirPlayedTime.containsKey(record.getPlayerId())){
                        playersAndTheirPlayedTime.put(record.getPlayerId(),timeSpent);
                    }else{
                        int currentTime = playersAndTheirPlayedTime.get(record.getPlayerId());
                        playersAndTheirPlayedTime.put(record.getPlayerId(),timeSpent + currentTime);
                    }
                }
            }
        }

        //Check which of these players are on the same team
        HashMap<Long, Integer> playersFromTheSameTeam = new HashMap<>();

        for (Map.Entry<Long, Integer> playerAndTime : playersAndTheirPlayedTime.entrySet()){
            for (Player player : players){
                for (Team team : teams){
                    if(playerAndTime.getKey() == player.getId() && player.getTeamID() == team.getId()){
                        playersFromTheSameTeam.put(playerAndTime.getKey(), playerAndTime.getValue());
                    }
                }
            }
        }

        //Find the names of the players
        HashMap<String, Integer> namesAndTime = new HashMap<>();

        for (Map.Entry<Long, Integer> player : playersFromTheSameTeam.entrySet()){
            for (Player entity : players){
                if (player.getKey() == entity.getId()){
                    namesAndTime.put(entity.getFullName(), player.getValue());
                }
            }
        }

        //Find Players with most time
        int bestPlaytime = 90;
        HashMap<String, Integer> finalResult = new HashMap<>();

        for (Map.Entry<String, Integer> player1 : namesAndTime.entrySet()){
            for (Map.Entry<String, Integer> player2 : namesAndTime.entrySet()){
                int playtime1 = player1.getValue();
                int playtime2 = player2.getValue();
                int bestPairTime = 45;

                // Determine the lower playtime or same playtime
                if(!player1.getKey().equals(player2.getKey())){
                    bestPairTime = (playtime1 == playtime2) ? playtime1 : Math.min(playtime1, playtime2);
                }

                if (bestPairTime > bestPlaytime) {
                    if(!finalResult.containsKey((player1.getKey() + " and " + player2.getKey())) && !finalResult.containsKey(player2.getKey() + " and " + player1.getKey())){
                        finalResult.put(player1.getKey() + " and " + player2.getKey(), bestPairTime);
                    }
                }
            }
        }

        //Sort the values so they are in descending order
        LinkedHashMap<String, Integer> sortedFinalResult = new LinkedHashMap<>();

        finalResult.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedFinalResult.put(entry.getKey(), entry.getValue()));

        return sortedFinalResult;

    }
}

