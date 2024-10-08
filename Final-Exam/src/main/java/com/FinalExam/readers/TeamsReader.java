package com.FinalExam.readers;

import com.FinalExam.models.Team;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.FinalExam.readers.BomRemover.removeBom;

@Component
public class TeamsReader {

    private final String filePath = "src/main/resources/static/teams.csv";

    public List<Team> read() {
        List<Team> teams = new ArrayList<>();
        // Reads the file and stores the data for the session
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(removeBom(data[0]));
                if(id < 0){
                    throw new NumberFormatException("Wrong data input");
                }
                String teamName = data[1];
                String managerFullName = data[2];
                String group = data[3];
                Team team = new Team(id, teamName, managerFullName, group);
                teams.add(team);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }
}
