package com.quizza.api.service;


import com.quizza.api.entity.Question;
import com.quizza.api.repository.QuestionRepository;
import com.quizza.api.request.QuestionRequest;
import com.quizza.api.util.Result;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    private ModelMapper modelMapper;



    @Transactional
    public Result<Question> postQuestion(QuestionRequest body) {

       /* Question newQuestion = new Question();
        newQuestion.setAnswers(body.getAnswers());
        newQuestion.setQuestionContent(body.getQuestion());

        questionRepository.save(newQuestion);


*/

        Question newQuestion = modelMapper.map(body, Question.class);
        newQuestion.getAnswers().forEach(answer -> answer.setQuestion(newQuestion));
        questionRepository.save(newQuestion);



        return new Result<>(true, "Question creation success.", newQuestion);

    }


}
