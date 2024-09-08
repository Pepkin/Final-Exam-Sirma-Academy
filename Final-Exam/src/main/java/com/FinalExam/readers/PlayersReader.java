package com.FinalExam.readers;

import com.FinalExam.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.FinalExam.readers.BomRemover.removeBom;

@Service
public class PlayersReader {

    private final String filePath = "src/main/resources/static/players.csv";

    public List<Player> read() {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                //TODO Validation of every value (if needed)
                int playerId = Integer.parseInt(removeBom(data[0]));
                if(playerId < 0){
                    throw new NumberFormatException("Wrong data input");
                }
                int teamNumber = Integer.parseInt(data[1]);
                String position = data[2];
                if(position.length() != 2){
                    throw new NumberFormatException("Wrong data input");
                }
                String fullName = data[3];
                int teamID = Integer.parseInt(data[4]);
                if(teamID < 0){
                    throw new NumberFormatException("Wrong data input");
                }
                Player player = new Player(playerId, teamNumber, position, fullName, teamID);
                players.add(player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    public PlayersReader() {
    }

}
