package com.example.log.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String generateLog() {
        logger.info("INFO log generated");
        logger.error("ERROR log generated");
        return "Logs generated!";
    }
}

