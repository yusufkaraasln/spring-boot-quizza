package com.quizza.api.controller;


import com.quizza.api.entity.Question;
import com.quizza.api.request.QuestionRequest;
import com.quizza.api.service.QuestionService;
import com.quizza.api.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/question")
@AllArgsConstructor

public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public Result<Question> postQuestion(@RequestBody QuestionRequest body) {

        return questionService.postQuestion(body);


    }


}
