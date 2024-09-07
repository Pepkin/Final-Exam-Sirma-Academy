package com.FinalExam.readers;

import org.springframework.stereotype.Service;

@Service
public class BomRemover {
    public static String removeBom(String input) {
        if (input != null && input.startsWith("\uFEFF")) {
            input = input.substring(1);
        }
        return input;
    }
}
