package com.FinalExam.service;

import com.FinalExam.models.Record;
import com.FinalExam.readers.RecordsReader;
import com.FinalExam.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService implements ApplicationRunner {

    @Autowired
    private RecordsRepository repository;

    @Autowired
    private RecordsReader RecordsReader;

    public List<Record> getAllRecords(){
        return repository.findAll();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Record> records = RecordsReader.read();

        for (Record entity : records){
            if(!repository.existsById(entity.getId())){
                repository.save(entity);
            }
        }
    }
}
