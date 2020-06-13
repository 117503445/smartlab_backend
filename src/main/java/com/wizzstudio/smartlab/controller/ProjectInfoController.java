package com.wizzstudio.smartlab.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class ProjectInfoController {
    @GetMapping(path = "ver", produces = "application/json")
    public @ResponseBody
    String getAllRecords() {
        return "1.2";
    }
}
