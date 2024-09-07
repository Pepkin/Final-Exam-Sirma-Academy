package com.FinalExam.service;

import com.FinalExam.repository.MatchesRepository;
import com.FinalExam.repository.PlayerRepository;
import com.FinalExam.repository.RecordsRepository;
import com.FinalExam.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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






        return null;
    }
}

