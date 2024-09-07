package com.FinalExam.service;

import com.FinalExam.models.Record;
import com.FinalExam.readers.RecordsReader;
import com.FinalExam.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordsRepository repository;

    @Autowired
    private RecordsReader reader;

    public void saveRecords(){
        List<Record> records = reader.read();

        for (Record entity : records){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }
    }
}
