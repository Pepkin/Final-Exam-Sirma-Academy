package com.FinalExam.readers;

import com.FinalExam.models.Match;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                if(id < 0){
                    throw new NumberFormatException("Wrong data input");
                }

                Long aTeamID = Long.valueOf(data[1]);
                Long bTeamID = Long.valueOf(data[2]);

                if (aTeamID <= 0 || bTeamID <= 0) {
                    throw new NumberFormatException("Wrong data input");
                }

                String Date = data[3];

                String Score = data[4];
                //Validate Score pattern
                String scorePattern = "^\\d+-\\d+$|^\\d+\\(\\d+\\)-\\d+\\(\\d+\\)$";
                Pattern pattern = Pattern.compile(scorePattern);
                Matcher patternMatcher = pattern.matcher(Score);

                if(!patternMatcher.matches()){
                    throw new NumberFormatException("Wrong input format");
                }

                Match match = new Match(id, aTeamID, bTeamID, Date, Score);
                matches.add(match);
            }
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }
}
