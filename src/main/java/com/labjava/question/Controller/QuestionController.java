package com.labjava.question.Controller;

import com.labjava.question.Dto.QuestionDto;
import com.labjava.question.Dto.QuestionPostDto;
import com.labjava.question.Ex.IdNotEq;
import com.labjava.question.MAPPER.QuestionMapper;
import com.labjava.question.Model.Question;
import com.labjava.question.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/intrebare")
public class QuestionController {
    private QuestionService questionService;
    private QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @RequestMapping
    public ResponseEntity<Question> createQuestion(@RequestBody @Valid QuestionDto questionDto) {
        Question question = questionService.createQuestion(questionMapper.questionmapper(questionDto));
        //return null;
        return ResponseEntity.created(null).body(question);
    }

    @PutMapping("/{qId}")
    public void PostQuestion(@PathVariable int qId,
            @RequestBody
            @Valid QuestionPostDto questionPostDto) {
        if(qId != questionPostDto.getId())
            throw  new RuntimeException("Id invalid");
        questionService.postquestion(questionMapper.postQuestionLaQuestion(questionPostDto));
        System.out.println("User update");
    }
}