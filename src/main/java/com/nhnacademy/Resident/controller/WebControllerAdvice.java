package com.nhnacademy.Resident.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model m) {
        log.error("", ex);
        m.addAttribute("exception", ex);
        return "error";

    }
}
