package org.codejudge.sb.businessObject;

import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.codejudge.sb.entity.Question;
import org.codejudge.sb.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuestionBusinessObject implements IQuestionBusinessObject {
    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public Optional<Question> findQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO) {
        Question question = Question.builder()
                .name(createQuestionDetailsRequestMO.getName())
                .options(createQuestionDetailsRequestMO.getOptions())
                .correct_option(createQuestionDetailsRequestMO.getCorrect_option())
                .quizID(createQuestionDetailsRequestMO.getQuiz())
                .points(createQuestionDetailsRequestMO.getPoints())
                .build();
        return questionRepository.save(question);
    }
}
