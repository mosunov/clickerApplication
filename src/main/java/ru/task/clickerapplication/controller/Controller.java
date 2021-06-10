package ru.task.clickerapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.task.clickerapplication.service.ClickService;

@RestController
@RequiredArgsConstructor
public class Controller{

    private final ClickService clickService;

    @PostMapping(value = "/index")
    public String incrementCounter() {
        return clickService.increment();
    }

    @GetMapping(value ="/index")
    public String getCounter() {
        return clickService.getCounter();
    }
}