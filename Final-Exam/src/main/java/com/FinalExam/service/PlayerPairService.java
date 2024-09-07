package com.FinalExam.service;

import com.FinalExam.repository.MatchesRepository;
import com.FinalExam.repository.PlayerRepository;
import com.FinalExam.repository.RecordsRepository;
import com.FinalExam.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerPairService {
    @Autowired
    MatchesRepository matchesRepository;
    @Autowired
    RecordsRepository recordsRepository;
    @Autowired
    TeamsRepository teamsRepository;
    @Autowired
    PlayerRepository playerRepository;
}
