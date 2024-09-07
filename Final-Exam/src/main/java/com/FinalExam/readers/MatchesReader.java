package com.FinalExam.readers;

import com.FinalExam.models.Match;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.FinalExam.readers.BomRemover.removeBom;

@Component
public class MatchesReader {

    private final String filePath = "src/main/resources/static/matches.csv";

    public List<Match> read() {
        List<Match> matches = new ArrayList<>();
        // Reads the file and stores the data for the session
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                //TODO Validation of every value (if needed)
                String[] data = line.split(",");
                Long id = Long.parseLong(removeBom(data[0]));
                Long aTeamID = Long.valueOf(data[1]);
                Long bTeamID = Long.valueOf(data[2]);
                String Date = data[3];
                String Score = data[4];
                Match match = new Match(id, aTeamID, bTeamID, Date, Score);
                matches.add(match);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }
}
