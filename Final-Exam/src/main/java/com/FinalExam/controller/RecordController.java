package com.FinalExam.controller;

import com.FinalExam.models.Record;
import com.FinalExam.repository.RecordsRepository;
import com.FinalExam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @GetMapping
    public List<Record> getAllRecords(){
        return service.getAllRecords();
    }
}
