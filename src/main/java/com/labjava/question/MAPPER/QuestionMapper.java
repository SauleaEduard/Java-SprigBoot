package com.labjava.question.MAPPER;

import com.labjava.question.Dto.QuestionDto;
import com.labjava.question.Dto.QuestionPostDto;
import com.labjava.question.Model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    public Question questionmapper(QuestionDto questionDto){
        return new Question(questionDto.getU_id(),questionDto.getTitlu(),questionDto.getDesc());
    }

    public Question postQuestionLaQuestion(QuestionPostDto questionPostDto){
        return new Question(questionPostDto.getId(),
                questionPostDto.getTitlu(),
                questionPostDto.getDesc());
    }
    }
