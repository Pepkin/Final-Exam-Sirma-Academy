package com.FinalExam.controller;

import com.FinalExam.repository.RecordsRepository;
import com.FinalExam.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private RecordsRepository recordsRepository;

    @Autowired
    private BusinessLogic businessLogic;

    @GetMapping("/")
    public HashMap<String, Integer> output(){
        return businessLogic.method1();
    }
}
