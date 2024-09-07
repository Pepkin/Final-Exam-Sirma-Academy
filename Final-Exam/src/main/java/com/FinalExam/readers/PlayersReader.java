package com.FinalExam.readers;

import com.FinalExam.models.Player;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayersReader {

    private final String filePath = "src/main/resources/static/players.csv";

    public List<Player> read() {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                //TODO Validation of every value (if needed)
                Long id = Long.valueOf(data[0]);
                int teamNumber = Integer.parseInt(data[1]);
                String position = data[2];
                String fulLName = data[3];
                Long teamID = Long.valueOf(data[4]);
                Player player = new Player(id, teamNumber, position, fulLName, teamID);
                players.add(player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players;
    }
}
