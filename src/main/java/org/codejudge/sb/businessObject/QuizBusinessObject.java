package org.codejudge.sb.businessObject;

import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.codejudge.sb.entity.Quiz;
import org.codejudge.sb.repository.IQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuizBusinessObject implements IQuizBusinessObject {
    @Autowired
    private IQuizRepository repository;

    public Optional<Quiz> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Quiz save(CreateQuizDetailsRequestMO createQuizDetailsRequestMO) {
        Quiz quiz = Quiz.builder()
                .name(createQuizDetailsRequestMO.getName())
                .description(createQuizDetailsRequestMO.getDescription())
                .build();
        return repository.save(quiz);
    }

    @Override
    public Optional<Quiz> getQuizWithQuestions(Long id) {
        Optional<Quiz> quiz = repository.findById(id);
        if (quiz.isPresent()) {
            quiz.get().getQuestionList();
        }
        return quiz;
    }
}
