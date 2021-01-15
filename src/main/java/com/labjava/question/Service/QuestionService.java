package com.labjava.question.Service;

import com.labjava.question.Ex.DuplicateTitle;
import com.labjava.question.Ex.DuplicateUserEx;
import com.labjava.question.Model.Question;
import com.labjava.question.Model.User;
import com.labjava.question.Repo.QuestionRepo;
import com.labjava.question.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {

        this.questionRepo = questionRepo;
    }

    public Question createQuestion(Question question){
        Optional<Question> questionU_id = questionRepo
                .getById(question.getId());
        if(questionU_id.isPresent()){
            throw new DuplicateTitle();
        }
        return questionRepo.createQuestion(question);
    }

    public void postquestion(Question question){
        questionRepo.postquestion(question);
    }
}
