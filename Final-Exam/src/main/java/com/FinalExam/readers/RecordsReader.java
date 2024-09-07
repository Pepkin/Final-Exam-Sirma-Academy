package com.FinalExam.readers;

import com.FinalExam.models.Record;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecordsReader {

    private final String filePath = "src/main/resources/static/records.csv";

    public List<Record> read() {
        List<Record> records = new ArrayList<>();
        // Reads the file and stores the data for the session
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                //TODO Validation of every value (if needed)
                Long id = Long.valueOf(data[0]);
                Long playerID = Long.valueOf(data[1]);
                Long matchID = Long.valueOf(data[2]);
                int fromMinutes = Integer.parseInt(data[3]);
                int toMinutes = Integer.parseInt(data[4]);
                Record record = new Record(id, playerID, matchID, fromMinutes, toMinutes);
                records.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
