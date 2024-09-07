package com.FinalExam.readers;

import com.FinalExam.models.Team;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeamsReader {

    private final String filePath = "src/main/resources/static/teams.csv";

    public List<Team> read() {
        List<Team> teams = new ArrayList<>();
        // Reads the file and stores the data for the session
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                //TODO Validation of every value (if needed)
                Long id = Long.valueOf(data[0]);
                String teamName = data[1];
                String managerFullName = data[2];
                char group = data[3].charAt(0);
                Team team = new Team(id, teamName, managerFullName, group);
                teams.add(team);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }
}
