package com.FinalExam.readers;

import com.FinalExam.models.Match;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
                int id = Integer.parseInt(removeBom(data[0]));

                if(id < 0){
                    throw new NumberFormatException("Wrong data input");
                }

                int aTeamID = Integer.parseInt(data[1]);
                int bTeamID = Integer.parseInt(data[2]);

                if ((aTeamID <= 0 || bTeamID <= 0) || aTeamID == bTeamID) {
                    throw new NumberFormatException("Wrong data input");
                }

                String Date = data[3];
                if(!isValidDate(Date)){
                    throw new RuntimeException();
                }

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

    public static boolean isValidDate(String dateString) {

        List<String> dateFormats = Arrays.asList(
                "M/d/yyyy",
                "MM/dd/yyyy",
                "dd/MM/yyyy",
                "yyyy-MM-dd",
                "dd-MMM-yyyy",
                "yyyy/MM/dd"
        );

        // Try to parse the date string with each format
        for (String format : dateFormats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                LocalDate.parse(dateString, formatter);
                return true;
            } catch (DateTimeParseException e) {
                throw new RuntimeException(e);
            }
        }
        return false; // If none of the formats matched, return false
    }
}
