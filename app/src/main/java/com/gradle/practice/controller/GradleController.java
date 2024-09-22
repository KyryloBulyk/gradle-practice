package com.gradle.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/gradle")
@RestController
public class GradleController {

    @GetMapping
    public String getHelloFromGradle() {
        return "Hello World";
    }
}
