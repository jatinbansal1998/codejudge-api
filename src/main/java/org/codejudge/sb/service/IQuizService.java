package org.codejudge.sb.service;

import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.codejudge.sb.entity.Quiz;

import java.util.Optional;

public interface IQuizService {
    Optional<Quiz> findById(Long id);

    Quiz save(CreateQuizDetailsRequestMO createQuizDetailsRequestMO);

    Optional<Quiz> getQuizWithQuestions(Long id);
}
